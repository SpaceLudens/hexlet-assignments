package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }

    // BEGIN
    @Test
    public void testShow() throws Exception {
        var task = Instancio.of(Task.class)
                .set(Select.field(Task::getTitle), faker.lorem().word())
                .set(Select.field(Task::getDescription), faker.lorem().sentence(10))
                .create();
        taskRepository.save(task);

        var result = mockMvc.perform(get("/tasks/" + task.getId()))
                .andExpect(status().isOk())
                .andReturn();
        var body = result.getResponse().getContentAsString();

        assertThatJson(body).and(
                a -> a.node("id").isEqualTo(task.getId()),
                a -> a.node("title").isEqualTo(task.getTitle()),
                a -> a.node("description").isEqualTo(task.getDescription())
        );
    }

    @Test
    public void testUpdate() throws Exception {
        var task = Instancio.of(Task.class)
                .set(Select.field(Task::getTitle), faker.lorem().word())
                .set(Select.field(Task::getDescription), faker.lorem().sentence(10))
                .create();
        taskRepository.save(task);

        var data = new HashMap<>();
        var updatedTitle = faker.lorem().word();
        var updatedDescription = faker.lorem().sentence(10);
        data.put("title", updatedTitle);
        data.put("description", updatedDescription);

        var request = put("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        task = taskRepository.findById(task.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        assertThat(task.getDescription()).isEqualTo(updatedDescription);
        assertThat(task.getTitle()).isEqualTo(updatedTitle);
    }

    @Test
    public void testCreate() throws Exception {
        var title = faker.lorem().word();
        var description = faker.lorem().sentence(10);

        var data = new HashMap<>();
        data.put("title", title);
        data.put("description", description);

        var request = mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"" + title + "\", \"description\":\"" + description + "\"}"))
                .andExpect(status().isCreated())
                .andReturn();

        var body = request.getResponse().getContentAsString();

        assertThatJson(body).and(
          a -> a.node("title").isEqualTo(title),
                a -> a.node("description").isEqualTo(description)
        );
    }

    @Test
    public void testDelete() throws Exception {
        var task = Instancio.of(Task.class)
                .set(Select.field(Task::getTitle), faker.lorem().word())
                .set(Select.field(Task::getDescription), faker.lorem().sentence(10))
                .create();
        taskRepository.save(task);

        mockMvc.perform(delete("/tasks/" + task.getId()))
                .andExpect(status().isOk());

        assertThat(taskRepository.findById(task.getId())).isNotPresent();
    }
    // END
}
