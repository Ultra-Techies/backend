package app.ultratechies.api.AppUsers;


import app.ultratechies.api.AppUsers.UserDTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user/auth")
public class UserAuthController {

    private final UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping()
    public ResponseEntity<Optional<UserDto>> getUser(@RequestBody AppUser appUser){
        Optional<UserDto> appuser=userAuthService.authUser(appUser.getUsername(), appUser.getPassword());
        return ResponseEntity.ok(appuser);
    }
}

