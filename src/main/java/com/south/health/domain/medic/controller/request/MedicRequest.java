package com.south.health.domain.medic.controller.request;

public class MedicRequest {

    private final String name;

    private final String crp;

    private final String type;
    private final String email;
    private final String password;

    public MedicRequest(String name, String crp, String type, String email, String password) {
        this.name = name;
        this.crp = crp;
        this.type = type;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getCrp() {
        return crp;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }
}
