package fi.haagahelia.courses.course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int role;
    private String username,
        password,
        email;

    public EndUser(){

    }

    public EndUser(String username, String password, String email, int role){
        super();
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setRole(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}