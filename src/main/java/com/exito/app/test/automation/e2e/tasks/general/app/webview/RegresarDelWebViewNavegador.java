package com.exito.app.test.automation.e2e.tasks.general.app.webview;

import com.exito.app.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.app.test.automation.e2e.utils.driver.app.AppDriverUtil;
import com.exito.app.test.automation.e2e.utils.trazas.TrazaUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class RegresarDelWebViewNavegador implements Task
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

        //Target cerrarWebViewUI = WebViewUI.CERRAR.getTarget();

//        actor.attemptsTo(
//            /*
//            Esperar.hastaQue(cerrarWebViewUI)
//                .este(EstadoElemento.CLICKABLE)
//                .porNoMasDe(Esperas.GENERAL.getTiempo()).segundos(),
//             */
//
//            Click.on(cerrarWebViewUI)
//        );

        TrazaUtil.informacion("Cerrar WebView embebido");

        AppDriverUtil.getDriverAppium(actor)
            .navigate().back();

    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static RegresarDelWebViewNavegador deLaApp()
    {
       return Tasks.instrumented(
               RegresarDelWebViewNavegador.class
       );
    }
}
