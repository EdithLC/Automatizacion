package com.bdd.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityList {
    private List<AbilityItem> abilities;

    // Getter y setter

    public List<AbilityItem> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityItem> abilities) {
        this.abilities = abilities;
    }
}
