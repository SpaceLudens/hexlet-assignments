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
    List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> index(@PathVariable Integer id) {

        return posts.stream()
                .filter(post -> post.getUserId() == id)
                .toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> create(@PathVariable String slug,
                                       @PathVariable String title,
                                       @PathVariable String body,
                                       @PathVariable Integer id) {
        var newPost = new Post();
        newPost.setUserId(id);
        newPost.setSlug(slug);
        newPost.setTitle(title);
        newPost.setBody(body);
        posts.add(newPost);
       return ResponseEntity.ok()
               .body(newPost);
    }
}
// END
