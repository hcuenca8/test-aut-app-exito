package com.exito.app.test.automation.e2e.stepdefinitions.features.inicio.publicidad;

import com.exito.app.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.app.test.automation.e2e.questions.PlantillaQuestion;
import com.exito.app.test.automation.e2e.stepdefinitions.general.app.AppStepDefinition;
import com.exito.app.test.automation.e2e.stepdefinitions.general.app.pantalla.PantallaStepDefinition;
import com.exito.app.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.app.test.automation.e2e.tasks.PlantillaTask;
import com.exito.app.test.automation.e2e.tasks.features.inicio.publicidad.CerrarPublicidad;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class PublicidadInicialStepDefinition
{

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" se encuentra sobre la publicidad emergente, al iniciar.*")
    public static void dadoQueSeEncuentraSobreLaPublicidadEmergerAlIniciar(String actor)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        AppStepDefinition.dadoQueHaIngresadoASuApp(actor);
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^retira la publicidad.*")
    public static void cuandoRetiraLaPublicidad()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            CerrarPublicidad.inicial()
        );
    }



}
