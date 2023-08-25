package com.exito.app.test.automation.e2e.tasks.general.app.webview;

import com.exito.app.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.general.app.webview.WebViewEmbebidoUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class RegresarDelWebViewEmbebido implements Task
{

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * Para mas informacion:
         * @see TasksJavaDoc#ENLAZAR_ACCIONES
         */
        actor.attemptsTo(

            Click.on(WebViewEmbebidoUI.CERRAR.getTarget()),

            Click.on(WebViewEmbebidoUI.CONFIRMAR_CERRAR.getTarget())
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static RegresarDelWebViewEmbebido deLaApp()
    {
       return Tasks.instrumented(
               RegresarDelWebViewEmbebido.class
       );
    }
}
