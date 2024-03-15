package com.bdd.api.tasks.Search;

import io.restassured.http.ContentType;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class SearchPokemon implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchPokemon.class);
    EnvironmentVariables environmentVariables;
    private final String nombrePokemon;

    public SearchPokemon(String nombre){
        this.nombrePokemon = nombre;
    }
    public static Performable search(String nombrePokemon){
        return Tasks.instrumented(SearchPokemon.class,nombrePokemon);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url");
        LOGGER.info("ENDPOINT: "+url);
        actor.attemptsTo(
                Get.resource("pokemon/"+this.nombrePokemon)
                        .with(request -> request
                                .relaxedHTTPSValidation()
                                .header("Accept","*/*")
                                //.contentType(ContentType.JSON)
                                .log().all()
                )
        );
        LOGGER.info("Resultado");
        System.out.println(SerenityRest.lastResponse().getStatusCode());
        if(SerenityRest.lastResponse().getStatusCode() == 200) {
            System.out.println(SerenityRest.lastResponse().body().prettyPrint());
        }
    }
}
