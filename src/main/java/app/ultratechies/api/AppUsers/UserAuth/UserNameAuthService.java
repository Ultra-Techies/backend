package app.ultratechies.api.AppUsers.UserAuth;

import app.ultratechies.api.AppUsers.AppUser;
import app.ultratechies.api.AppUsers.UserDTO.UserDto;
import app.ultratechies.api.AppUsers.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserNameAuthService {

    @Autowired
    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserNameAuthService(UserRepository userRepository){
        this.userRepository=userRepository;
        this.passwordEncoder= new BCryptPasswordEncoder();
    }

    public Optional<UserDto> authUser(String username, String password){
        Optional<AppUser> userByUsername= userRepository.findAppUserByUsername(username);

        if (userByUsername.isPresent()) {
            if ((Objects.equals(username, userByUsername.get().getUsername())) &&
                    (passwordEncoder.matches(password, userByUsername.get().getPassword()))) {

                return userByUsername.map(this::convertUserDto);
            }
            else {
                throw new IllegalStateException("Username and password do not match!");
            }
        }
        else {
            throw  new IllegalStateException("User with username "+username+" does not exist!");
        }
    }

    public Optional<UserDto> getUserByUsername(String username) {

        return userRepository.findAppUserByUsername(username).map(this::convertUserDto);
    }

    private UserDto convertUserDto(AppUser appUser){
        UserDto userdto = new UserDto();
        userdto.setId(appUser.getId());
        userdto.setUsername(appUser.getUsername());
        userdto.setName(appUser.getName());
        userdto.setEmail(appUser.getEmail());
        userdto.setPhoto(appUser.getPhoto());

        return userdto;
    }
}
