package com.south.health.domain.institution.controller.request;

public class InstitutionRequest {
    private final String name;
    private final String cnpj;
    private final String email;
    private final String password;

    public InstitutionRequest(String name, String cnpj, String email, String password) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
