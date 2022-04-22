package nextstep.helloworld.mvc.mapping;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uri-pattern")
public class UriPatternController {

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> pathVariable(@PathVariable Long id) {
        User user = new User(id, "이름", "email");
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/patterns/?", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> pattern() {
        return ResponseEntity.ok().body("pattern");
    }

    @GetMapping(path = "/patterns/**", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> patternStars() {
        return ResponseEntity.ok().body("pattern-multi");
    }
}