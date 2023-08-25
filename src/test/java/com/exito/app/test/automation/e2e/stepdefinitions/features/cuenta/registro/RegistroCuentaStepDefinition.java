package com.exito.app.test.automation.e2e.stepdefinitions.features.cuenta.registro;

import com.exito.app.test.automation.e2e.models.scena.Libreto;
import com.exito.app.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.app.test.automation.e2e.stepdefinitions.features.inicio.InicioStepDefinition;
import com.exito.app.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.app.test.automation.e2e.tasks.features.cuenta.registro.ConfirmarRegistro;
import com.exito.app.test.automation.e2e.tasks.features.cuenta.registro.DiligenciarRegistro;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class RegistroCuentaStepDefinition
{

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" se encuentra registrando su cuenta.*")
    public static void dadoQueSeEncuentraRegistrandoSuCuenta(String actor)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        InicioStepDefinition.dadoQueSeEncuentraSobreLaPortadaInicial(actor);
        InicioStepDefinition.cuandoSeDirigeParaRegistrarse();
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^diligencia el registro de su cuenta.*")
    public static void cuandoDiligenciaElRegistroDeSuCuenta(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            DiligenciarRegistro.deLaCuenta(libreto.getParametrosRegistroCuenta())
        );
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^confirma el registro de su cuenta.*")
    public static void cuandoConfirmaElRegistroDeSuCuenta(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            ConfirmarRegistro.deLaCuenta(libreto.getParametrosRegistroCuenta())
        );
    }



}
