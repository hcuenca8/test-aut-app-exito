package com.exito.app.test.automation.e2e.tasks.features.inicio.publicidad;

import com.exito.app.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.features.inicio.publicidad.PublicidadInicialUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class CerrarPublicidad implements Task
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

        Target btnCerrar = PublicidadInicialUI.BTN_CERRAR.getTarget();
        
        actor.attemptsTo(
            Check.whether(btnCerrar.resolveFor(actor).isVisible())
                    .andIfSo(
                        Click.on(PublicidadInicialUI.BTN_CERRAR.getTarget())
                    )
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static CerrarPublicidad inicial()
    {
        return Tasks.instrumented(
            CerrarPublicidad.class
        );
    }
}
