package app.ultratechies.api.index;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
public class indexController {

    @GetMapping
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("Welcome");
    }

}
