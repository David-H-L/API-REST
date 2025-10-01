package com.project.cine.application.dto;

import java.io.Serializable;

public class PositionDto implements Serializable {

    private final Long idPosition;
    private final String name;
    private final String description;

    public PositionDto(Long idPosition, String name, String description) {
        this.idPosition = idPosition;
        this.name = name;
        this.description = description;
    }

    public Long getIdPosition() {
        return this.idPosition;
    }

    public String getNamePosition() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}