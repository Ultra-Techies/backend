package app.ultratechies.api.AppUsers.UserAuth;

import app.ultratechies.api.AppUsers.AppUser;
import app.ultratechies.api.AppUsers.UserDTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/user/email/auth")
public class UserEmailAuthController {

    private final UserEmailAuthService userEmailAuthService;

    @Autowired
    public UserEmailAuthController(UserEmailAuthService userEmailAuthService) {
        this.userEmailAuthService = userEmailAuthService;
    }

    @PostMapping()
    public ResponseEntity<Optional<UserDto>> getUser(@RequestBody AppUser appUser){
        Optional<UserDto> appuser=userEmailAuthService.authUser(appUser.getEmail(), appUser.getPassword());
        return ResponseEntity.ok(appuser);
    }
}
