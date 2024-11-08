package exercise.controller.users;

import java.util.List;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    List<Post> data = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> index(@PathVariable Integer id) {
        return data.stream()
                .filter(post -> post.getUserId() == id)
                .toList();
    }

    @PatchMapping("/users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable Integer id,
                                       @RequestParam("slug") String slug,
                                       @RequestParam("title") String title,
                                       @RequestParam("body") String body) {

        var status = HttpStatus.CREATED;

        var post = new Post();
        post.setUserId(id);
        post.setSlug(slug);
        post.setTitle(title);
        post.setBody(body);

        data.add(post);
        return ResponseEntity.status(status)
                .body(post);
    }
}
// END
