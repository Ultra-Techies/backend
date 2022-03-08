package app.ultratechies.api.AppUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

       var appuser= userService.getUsers(userId);
       return  ResponseEntity.ok(appuser);
    }

    @PostMapping
    public void registerNewUser(@RequestBody AppUser appUser){
        userService.addNewUser(appUser);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String username,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String photo,
                           @RequestParam(required = false) String password){

                            userService.updateUser(userId,username,name,email,photo,password);
    }
}
