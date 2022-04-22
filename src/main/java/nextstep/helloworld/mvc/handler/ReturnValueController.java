package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @GetMapping(path = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> string() {
        return ResponseEntity.ok().body("message");
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> responseBodyForUser() {
        return ResponseEntity.ok().body( new User("name", "email"));
    }

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> responseEntity(@PathVariable Long id) {
        return ResponseEntity.ok(new User("name", "email"));
    }

    @GetMapping(path = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }
}