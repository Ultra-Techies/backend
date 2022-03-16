package app.ultratechies.api.AppUsers;

import app.ultratechies.api.AppUsers.UserDTO.UserDto;
import app.ultratechies.api.exceptions.AppUserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void addNewUser(AppUser appUser) {

        Optional<AppUser> userByUsername = userRepository.findAppUserByUsername(appUser.getUsername());
        Optional<AppUser> userByEmail = userRepository.findAppUserByEmail(appUser.getEmail());

        if (userByUsername.isPresent()) {
            throw new IllegalStateException("User with username "+ appUser.getUsername()+" already exists!");
        }
        else if (userByEmail.isPresent()){
            throw new IllegalStateException("User with email "+ appUser.getEmail()+" already exists");
        }
        else {userRepository.save(appUser);}

    }


    public void deleteUser(Long userId) {
       boolean exists= userRepository.existsById(userId);
       if (!exists){
           throw new IllegalStateException("user with userId:"+ userId +" does not exist!");
       }
       userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String username, String name, String email, String photo, String password) {

        AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with userId: " + userId + " does not exist!"));

        if (username != null &&
                username.length() > 0 &&
                !Objects.equals(appUser.getUsername(), username)) {
            Optional<AppUser> userByUsername = userRepository.findAppUserByUsername(username);
            if (userByUsername.isPresent()) {
                throw new IllegalStateException("User with username " + username + " already exists!");
            } else {
                appUser.setUsername(username);
            }
        }

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(appUser.getName(), name)) {

            appUser.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(appUser.getEmail(), email)) {
            Optional<AppUser> userByEmail = userRepository.findAppUserByEmail(email);
            if (userByEmail.isPresent()) {
                throw new IllegalStateException("User with email " + appUser.getEmail() + " already exists");
            } else {
                appUser.setEmail(email);
            }

            if (password != null &&
                    password.length() > 0 &&
                    !Objects.equals(appUser.getPassword(), password)) {

                appUser.setPassword(password);
            }

            if (photo != null &&
                    photo.length() > 0 &&
                    !Objects.equals(appUser.getPhoto(), photo)) {

                appUser.setPhoto(photo);
            }
        }
    }
    public Optional<UserDto> getUsersById(Long id) {
        boolean exists= userRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("user with userId:"+ id +" does not exist!");
        }
        return (Optional<UserDto>) userRepository.findById(id).map(this::convertUserDto);
    }

    public AppUser getAppUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new AppUserNotFoundException("User does not exist"));
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
