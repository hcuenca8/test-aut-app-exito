package com.exito.app.test.automation.e2e.tasks.features.inicio;

import com.exito.app.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.features.inicio.InicioUI;
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
public class IrARegistrarse implements Task
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
            Click.on(InicioUI.BTN_REGISTRARSE.getTarget())
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static IrARegistrarse desdeElInicio()
    {
        return Tasks.instrumented(
            IrARegistrarse.class
        );
    }
}
