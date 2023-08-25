package com.exito.app.test.automation.e2e.stepdefinitions.general.app.pantalla;

import com.exito.app.test.automation.e2e.questions.general.app.pantalla.SeObservaTexto;
import com.exito.app.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.general.app.pantalla.ContenidoAppUI;
import com.exito.app.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import com.exito.app.test.automation.e2e.utils.questions.estadoelementos.questions.ElEstado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class PantallaStepDefinition {

    @Entonces("^debería mostrarse en el app: \"(.*)\".*")
    public static void deberiaMostrarseEnElApp(String textos)
    {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        SeObservaTexto.enPantalla(EstadoElemento.VISIBLE,false,textos)
                )
        );
    }

    @Entonces("^debería mostrarse en el app, exactamente: \"(.*)\".*")
    public static void deberiaMostrarseEnElAppExactamente(String textos)
    {
        OnStage.theActorInTheSpotlight().should(
            GivenWhenThen.seeThat(
                SeObservaTexto.enPantalla(EstadoElemento.VISIBLE,true,textos)
            )
        );
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    @Entonces("^debería indicarse \"(.*)\" la opción \"(.*)\", para dar continuidad al proceso.*")
    public static void entoncesIndicarseLaOpcionParaDarContinuidadAlProceso(String estado, String opcion)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        OnStage.theActorInTheSpotlight().should(
            GivenWhenThen.seeThat(
                ElEstado.deLosElementos(
                    ContenidoAppUI.BTN_OPCION.getTarget(opcion)
                ).sea(EstadoElemento.valueOf(estado.toUpperCase()))
            )
        );
    }
}
