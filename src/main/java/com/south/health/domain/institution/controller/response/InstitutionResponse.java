package com.south.health.domain.institution.controller.response;

public class InstitutionResponse {
    private final String name;
    private final String cnpj;


    public InstitutionResponse(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }
}
