package app.ultratechies.api.AppUsers.UserAuth;


import app.ultratechies.api.AppUsers.AppUser;
import app.ultratechies.api.AppUsers.UserDTO.UserDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/user/name/auth")
public class UserNameAuthController {

    private final UserNameAuthService userNameAuthService;

    @Autowired
    public UserNameAuthController(UserNameAuthService userAuthService) {
        this.userNameAuthService = userAuthService;
    }

    @ApiOperation("Authenticate User by Username and Password")
    @PostMapping()
    public ResponseEntity<Optional<UserDto>> getUser(@RequestBody AppUser appUser){
        Optional<UserDto> appuser=userNameAuthService.authUser(appUser.getUsername(), appUser.getPassword());
        return ResponseEntity.ok(appuser);
    }
}

