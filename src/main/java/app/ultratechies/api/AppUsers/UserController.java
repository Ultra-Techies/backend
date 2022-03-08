package app.ultratechies.api.AppUsers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}")
    public ResponseEntity <Optional<AppUser>>getUser(@PathVariable Long userId){

       var appuser= userService.getUsersById(userId);
       return  ResponseEntity.ok(appuser);
    }

    @PostMapping
    public ResponseEntity <Optional<AppUser>> registerNewUser(@RequestBody AppUser appUser){

        userService.addNewUser(appUser);
        var appuser= userService.getUserByUsername(appUser.getUsername());

        return ResponseEntity.ok(appuser);
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId){

        userService.deleteUser(userId);
        JSONObject deleteMessage= new JSONObject();
        deleteMessage.put("message","deleted successfully!");
        return ResponseEntity.status(HttpStatus.OK).body(deleteMessage.toString());
    }

    @PutMapping(path = "{userId}")
    public ResponseEntity<Optional<AppUser>> updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String username,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String photo,
                           @RequestParam(required = false) String password){

                            userService.updateUser(userId,username,name,email,photo,password);
                            var appuser= userService.getUsersById(userId);
                            return ResponseEntity.ok(appuser);
    }
}
