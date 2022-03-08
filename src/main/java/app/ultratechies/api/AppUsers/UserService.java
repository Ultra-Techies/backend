package app.ultratechies.api.AppUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void addNewUser(AppUser appUser) {

        Optional<AppUser> userByUsername = userRepository.findAppUserByUsername(appUser.getUsername());

        if (userByUsername.isPresent()) {
            throw new IllegalStateException("username already exists!");
        }
        userRepository.save(appUser);

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

                AppUser appUser= userRepository.findById(userId)
                        .orElseThrow(()-> new IllegalStateException("user with userId: "+ userId+" does not exist!"));

                        if (username!= null &&
                                username.length()>0 &&
                                !Objects.equals(appUser.getUsername(),username)){
                            Optional<AppUser> userByUsername= userRepository.findAppUserByUsername(username);
                            if (userByUsername.isPresent()){
                                throw new IllegalStateException("username already exists!");
                            }
                            appUser.setUsername(username);
                        }

                        if (name!= null &&
                                name.length()>0 &&
                                !Objects.equals(appUser.getName(),name)){

                            appUser.setName(name);
                        }

                        if (email!= null &&
                                email.length()>0 &&
                                !Objects.equals(appUser.getEmail(),email)){
                            Optional<AppUser> userByEmail = userRepository.findAppUserByEmail(email);
                            if (userByEmail.isPresent()) {
                                throw new IllegalStateException("email taken!");
                            }
                            appUser.setEmail(email);
                        }

                        if (password!= null &&
                                password.length()>0 &&
                                !Objects.equals(appUser.getPassword(),password)){

                            appUser.setPassword(password);
                        }

                        if (photo!= null &&
                                photo.length()>0 &&
                                !Objects.equals(appUser.getPhoto(),photo)){

                            appUser.setPhoto(photo);
                        }
    }
}
