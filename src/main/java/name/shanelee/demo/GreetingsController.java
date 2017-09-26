package name.shanelee.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping(value = "greetings")
    public ResponseEntity<String> greetings() {
        return ResponseEntity.ok("Hello");

    }
}
