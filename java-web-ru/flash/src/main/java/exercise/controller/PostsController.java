package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import static org.eclipse.jetty.util.StringUtil.startsWithIgnoreCase;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void create(Context context) {
        try {
            var name = context.formParamAsClass("name", String.class)
                    .check(val -> val.length() > 2, "The name cannot be less than two characters long")
                    .get();
            var body = context.formParamAsClass("body", String.class)
                    .check(val -> val.length() > 10, "The body cannot be less than ten characters long")
                    .get();
            context.sessionAttribute("flash", "Пост был успешно создан!");
            var post = new Post(name, body);
            PostRepository.save(post);
            context.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            var name = context.formParam("name");
            var body = context.formParam("body");
            var page = new BuildPostPage(name, body, e.getErrors());
            context.render("posts/build.jte", model("page", page));
        }
    }

    public static void index(Context context) {
        var term = context.queryParam("term");
        List<Post> posts;
        if (term != null) {
            posts = PostRepository.getEntities()
                    .stream()
                    .filter(p -> startsWithIgnoreCase(p.getName(), term))
                    .toList();
        } else {
            posts = PostRepository.getEntities();
        }
        var page = new PostsPage(term, posts);
        page.setFlash(context.consumeSessionAttribute("flash"));
        context.render("posts/index.jte", model("page", page));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
