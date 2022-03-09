package app.ultratechies.api.AppUsers;

import app.ultratechies.api.tasks.Task;

import javax.persistence.*;
import java.util.List;


@Entity
 @Table
public class AppUser {
    @Id
     @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="users_sequence"
    )
    private Long id;
    private String username;
    private String name;
    private String email;
    private String photo;
    private String password;
    @OneToMany
    private List<Task> tasks;



    public AppUser() {
    }

    public AppUser(Long id, String username, String name, String email, String photo, String password,List<Task> tasks) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.tasks = tasks;
    }

    public AppUser(String username, String name, String email, String photo, String password,List<Task> tasks) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}


