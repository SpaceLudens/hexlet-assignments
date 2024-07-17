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
        var user = Generator.getUsers()
                .stream()
                .filter(u -> u.getName().equals(name) && u.getPassword().equals(encryptPassword))
                .toList();

        if (user != null) {
            context.sessionAttribute("currentUser", name);
            context.redirect("/");
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

    }
    // END
}
