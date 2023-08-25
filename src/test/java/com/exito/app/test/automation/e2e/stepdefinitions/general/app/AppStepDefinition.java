package com.exito.app.test.automation.e2e.stepdefinitions.general.app;


import com.exito.app.test.automation.e2e.interactions.Depurar;
import com.exito.app.test.automation.e2e.models.scena.screenplay.Protagonista;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class AppStepDefinition {

    @Managed
    static WebDriver suNavegador;

    @Dado("^que \"(.*)\" ha ingresado a su app.*")
    public static void dadoQueHaIngresadoASuApp(String actor)
    {
        Protagonista.haActuadoPreviamente(actor);
        Protagonista.entraEnEscena(actor)
            .whoCan(BrowseTheWeb.with(suNavegador))
            .attemptsTo(
                Depurar.enConsola("Inicio del Test")
            );
    }
}
