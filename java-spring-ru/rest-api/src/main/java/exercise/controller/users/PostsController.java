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
                                       @RequestBody Post post) {

        var status = HttpStatus.CREATED;

        if (id != null) {
            post.setUserId(id);
            data.add(post);
        }

        return ResponseEntity.status(status)
                .body(post);
    }
}
// END
