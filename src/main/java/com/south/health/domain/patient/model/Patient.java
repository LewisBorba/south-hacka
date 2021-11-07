package com.south.health.domain.patient.model;

import com.south.health.domain.user.model.User;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    /**
     * @deprecated (should be used only by frameworks)
     */
    @Deprecated(since = "0")
    public Patient() {
    }

    public Patient(String name, User user) {
        this.name = name;
        this.user = user;
    }

    private Patient(User user) {
        this.name = user.getUsername();
        this.user = user;
    }

    public static Patient of(User user) {
        if (user == null) return null;
        return new Patient(user);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }
}
