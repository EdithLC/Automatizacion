package com.bdd.api.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class InicioServicioStepdefs {

    private static final Logger LOGGER = LoggerFactory.getLogger(InicioServicioStepdefs.class);

    EnvironmentVariables environmentVariables;

    @Before
    public void prepararEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Dado("^que (.*)* accede al servicio$")
    public void inicioServicioStepdefs(String usuario) {
        theActorCalled(usuario).whoCan(CallAnApi.at(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url")));
        LOGGER.info("Inicio del servicio");
        LOGGER.info("Dominio "+EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url"));
    }

}
