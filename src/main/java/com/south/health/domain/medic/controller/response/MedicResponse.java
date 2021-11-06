package com.south.health.domain.medic.controller.response;

import com.south.health.domain.medic.model.Medic;
import io.swagger.annotations.ApiModelProperty;

public class MedicResponse {


    @ApiModelProperty(example = "4")
    private final Integer id;

    @ApiModelProperty(example = "south-hacka")
    private final String name;

    private final String type;

    private final String email;

    private final String crp;


    private MedicResponse(Integer id, String name, String type, String email, String crp) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.email = email;
        this.crp = crp;
    }

    public static MedicResponse of(Medic medic) {
        if (medic == null) return null;
        return new MedicResponse(medic.getId(), medic.getName(), medic.getType(), medic.getUser().getEmail(), medic.getCrp());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getCrp() {
        return crp;
    }
}
