package com.south.health.domain.user.model;


import com.south.health.domain.medic.controller.request.MedicRequest;
import com.south.health.domain.patient.controller.request.PatientRequest;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String username;



    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private UserType type;

    /**
     * @deprecated (should be used only by frameworks)
     */
    @Deprecated(since = "0")
    public User() {
    }

    private User(String username, String email, String password, UserType type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
    }



    public static User of(PatientRequest patientRequest){
        return new User(patientRequest.getUsername(), patientRequest.getEmail(), patientRequest.getPassword(), UserType.PATIENT);
    }

    public static User of(MedicRequest medicRequest){
        return new User(medicRequest.getName(), medicRequest.getEmail(), medicRequest.getPassword(), UserType.MEDIC);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username)  && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password);
    }
}
