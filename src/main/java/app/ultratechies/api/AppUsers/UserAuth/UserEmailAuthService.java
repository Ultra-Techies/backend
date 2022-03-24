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
public class UserEmailAuthService {
    @Autowired
    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserEmailAuthService(UserRepository userRepository){
        this.userRepository=userRepository;
        this.passwordEncoder= new BCryptPasswordEncoder();
    }

    public Optional<UserDto> authUser(String email, String password){
        Optional<AppUser> userByEmail= userRepository.findAppUserByEmail(email);


        if (userByEmail.isPresent()) {
            if ((Objects.equals(email, userByEmail.get().getEmail())) &&
                    (passwordEncoder.matches(password, userByEmail.get().getPassword()))) {

                return userByEmail.map(this::convertUserDto);
            }
            else {
                throw new IllegalStateException("Email and password do not match!");
            }
        }
        else {
            throw  new IllegalStateException("User with email "+email+" does not exist!");
        }
    }

    public Optional<UserDto> getUserByEmail(String email) {

        return userRepository.findAppUserByEmail(email).map(this::convertUserDto);
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
