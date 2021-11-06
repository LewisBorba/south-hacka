package com.south.health.domain.medic.model;

import com.south.health.domain.medic.controller.request.MedicRequest;
import com.south.health.domain.user.model.User;

import javax.persistence.*;

@Entity
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String crp;

    @Column
    private String type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;


    /**
     * @deprecated (should be used only by frameworks)
     */
    @Deprecated(since = "0")
    public Medic() {
    }


    private Medic(String name, String crp, String type, User user) {
        this.name = name;
        this.crp = crp;
        this.type = type;
        this.user = user;
    }

    public static Medic of(User user, MedicRequest medicRequest) {
        if (user == null) return null;
        return new Medic(medicRequest.getName(), medicRequest.getCrp(), medicRequest.getType(), user);

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCrp() {
        return crp;
    }

    public String getType() {
        return type;
    }

    public User getUser() {
        return user;
    }
}
