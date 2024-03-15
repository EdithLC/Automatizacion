package com.bdd.api.models;

import com.bdd.api.models.Ability;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class AbilityItem {
    private Ability ability;
    private boolean is_hidden;
    private int slot;

    // Getters y setters
}

