package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@SpringBootApplication
@RestController
public class Application {
    @GetMapping("/about")
    String home() {
        return "Welcome to the Jungle!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
// END
