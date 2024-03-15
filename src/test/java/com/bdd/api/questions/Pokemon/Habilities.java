package com.bdd.api.questions.Pokemon;

import com.bdd.api.models.Ability;
import com.bdd.api.models.AbilityList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Habilities {

    public static Question<Boolean> haveHabilities(){
        String habilidades = SerenityRest.lastResponse().jsonPath().getString("abilities");
        return Question.about("Habilidades del pokemon").
                answeredBy(
                        actor -> !habilidades.isEmpty()
                );
    }
}
