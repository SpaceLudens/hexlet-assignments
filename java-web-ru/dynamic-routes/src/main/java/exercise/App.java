package exercise;

import io.javalin.Javalin;


import java.util.List;
import java.util.Map;
import java.util.Objects;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("companies/{id}", context -> {
           var companyId = context.pathParam("id");
           boolean find = false;
           for (Map<String, String> company : COMPANIES) {
               if (company.containsKey("id") && company.get("id").equals(companyId)) {
                  var jsonObject = context.json(company);
                  find = true;
               }
           }
            if(!find) {
                throw new NotFoundResponse("Company not found");
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
