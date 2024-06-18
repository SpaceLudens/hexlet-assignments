package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class PostsController {

    // BEGIN
    public static void show(Context context) {
        var id = context.pathParam("id");
        var post = PostRepository
               .find(Long.valueOf(id))
               .orElseThrow(() -> new NotFoundResponse("Page not found"));
        context.status(404);
        var page = new PostPage((post));
        context.render("posts/show.jte", model("page", page));
    }

    public static void index(Context context) {
        var page = context.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var pageSize = 5;
        List<Post> posts =  PostRepository.findAll(page, pageSize);
        var currentPage = new PostsPage(posts, page);
        context.render("posts/index.jte", model("page", currentPage));
    }
    // END
}
