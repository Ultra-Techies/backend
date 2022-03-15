package app.ultratechies.api.AppUsers.UserAuth;


import app.ultratechies.api.AppUsers.AppUser;
import app.ultratechies.api.AppUsers.UserDTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user/name/auth")
public class UserNameAuthController {

    private final UserNameAuthService userNameAuthService;

    @Autowired
    public UserNameAuthController(UserNameAuthService userAuthService) {
        this.userNameAuthService = userAuthService;
    }

    @GetMapping()
    public ResponseEntity<Optional<UserDto>> getUser(@RequestBody AppUser appUser){
        Optional<UserDto> appuser=userNameAuthService.authUser(appUser.getUsername(), appUser.getPassword());
        return ResponseEntity.ok(appuser);
    }
}

