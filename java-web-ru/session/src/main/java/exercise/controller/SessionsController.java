package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Generator;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void create(Context context) {
        var name = context.formParam("name");
        var encryptPassword = Security.encrypt(context.formParam("password"));
        var user = UsersRepository.findByName(name);

        if (user != null && user.getPassword().equals(encryptPassword)) {
            context.sessionAttribute("currentUser", name);
            var page = new MainPage(name);
            context.render("index.jte", model("page",page));
        } else {
            String error = "Wrong username or password.";
            var page = new LoginPage(name, error);
            context.render("build.jte", model("page",page));
        }
    }

    public static void build(Context context) {
        context.render("build.jte");
    }

    public static void delete(Context context) {
        context.sessionAttribute("currentUser", null);
        context.redirect(NamedRoutes.rootPath());
    }
    // END
}
