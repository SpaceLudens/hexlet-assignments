package exercise.controller;

import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context context) {
        var firstName = context.formParam("firstName");
        var lastName = context.formParam("lastName");
        var email = context.formParam("email");
        var password = context.formParam("password");
        var token = Security.generateToken();
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        var id = user.getId();
        context.cookie("token", token);
        context.redirect(NamedRoutes.userPath(id));
    }

    public static void show(Context context) {
        var id = context.pathParamAsClass("id", Long.class).get();
        var token = context.cookie("token");
        if (token != null) {
            var user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity nt found"));
            if (token.equals(user.getToken())) {
                var page = new UserPage(user);
                context.render("users/show.jte", model("page", page));
            } else {
                context.redirect(NamedRoutes.buildUserPath());
            }
        }
    }
}
    // END
