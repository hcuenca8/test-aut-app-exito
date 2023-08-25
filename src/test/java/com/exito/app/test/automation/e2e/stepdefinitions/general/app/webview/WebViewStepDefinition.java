package com.exito.app.test.automation.e2e.stepdefinitions.general.app.webview;

import com.exito.app.test.automation.e2e.questions.general.app.webview.LaUrlWebViewEmbebido;
import com.exito.app.test.automation.e2e.questions.general.app.webview.LaUrlWebViewNavegador;
import com.exito.app.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.app.test.automation.e2e.tasks.general.app.webview.RegresarDelWebViewEmbebido;
import com.exito.app.test.automation.e2e.tasks.general.app.webview.RegresarDelWebViewNavegador;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class WebViewStepDefinition
{

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    @Entonces("^debería presentarse como vista web de navegador, el contenido relacionado: \"(.*)\".*")
    public static void entoncesDeberiaPresentarseComoVistaWebDeNavegadorElContenidoRelacionado(String urlEsperada)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        OnStage.theActorInTheSpotlight().should(
            GivenWhenThen.seeThat(
                LaUrlWebViewNavegador.correspondeA(urlEsperada)
            )
        );
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    @Entonces("^debería presentarse como vista web embebida, el contenido relacionado: \"(.*)\".*")
    public static void entoncesDeberiaPresentarseComoVistaWebEmbebidaElContenidoRelacionado(String urlEsperada)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        OnStage.theActorInTheSpotlight().should(
            GivenWhenThen.seeThat(
                LaUrlWebViewEmbebido.correspondeA(urlEsperada)
            )
        );
    }

    @Y("^al regresar de la vista web en navegador.*")
    public static void yAlRegresarDeLaVistaWebEnNavegador()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        OnStage.theActorInTheSpotlight().attemptsTo(
            RegresarDelWebViewNavegador.deLaApp()
        );
    }

    @Y("^al regresar de la vista web embebida.*")
    public static void yAlRegresarDeLaVistaWebEmbebida()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        OnStage.theActorInTheSpotlight().attemptsTo(
            RegresarDelWebViewEmbebido.deLaApp()
        );
    }
}
