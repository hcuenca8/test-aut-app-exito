package com.exito.app.test.automation.e2e.stepdefinitions.features.inicio;

import com.exito.app.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.app.test.automation.e2e.stepdefinitions.features.inicio.publicidad.PublicidadInicialStepDefinition;
import com.exito.app.test.automation.e2e.stepdefinitions.general.app.AppStepDefinition;
import com.exito.app.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.app.test.automation.e2e.tasks.features.inicio.IrARegistrarse;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class InicioStepDefinition
{

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" se encuentra sobre la portada inicial.*")
    public static void dadoQueSeEncuentraSobreLaPortadaInicial(String actor)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        AppStepDefinition.dadoQueHaIngresadoASuApp(actor);
        PublicidadInicialStepDefinition.cuandoRetiraLaPublicidad();
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^Se dirige para registrarse.*")
    public static void cuandoSeDirigeParaRegistrarse()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            IrARegistrarse.desdeElInicio()
        );
    }



}
