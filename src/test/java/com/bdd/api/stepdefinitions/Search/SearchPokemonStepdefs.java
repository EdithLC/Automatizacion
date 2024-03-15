package com.bdd.api.stepdefinitions.Search;

import com.bdd.api.questions.Pokemon.Habilities;
import com.bdd.api.tasks.Search.SearchPokemon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.javafx.fxml.expression.Expression;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.apache.xpath.operations.NotEquals;
import org.hamcrest.text.IsEmptyString;

import static com.google.common.base.CharMatcher.isNot;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.mockito.AdditionalMatchers.not;

public class SearchPokemonStepdefs {
    @Cuando("^realizo busqueda de (.*)$")
    public void buscoPokemon(String nombrePokemon) {
        theActorInTheSpotlight().attemptsTo(
                SearchPokemon.search(nombrePokemon)
        );
    }

    @Entonces("valido que la busqueda sea exitoso")
    public void validoQueLaBusquedaSeaExitoso() {
        theActorInTheSpotlight().should(
            seeThatResponse(response -> response.statusCode(200))
        );
    }

    @Y("valido que tenga habilidades")
    public void validoQueTengaHabilidades(){
        theActorInTheSpotlight().should(
                seeThat("Tiene habilidades",Habilities.haveHabilities(),equalTo(true))
        );
    }
}
