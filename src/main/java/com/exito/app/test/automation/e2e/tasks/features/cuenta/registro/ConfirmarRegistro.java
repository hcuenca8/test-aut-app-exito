package com.exito.app.test.automation.e2e.tasks.features.cuenta.registro;

import com.exito.app.test.automation.e2e.models.params.features.cuenta.registro.RegistroCuentaParams;
import com.exito.app.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.features.cuenta.registro.RegistroCuentaUI;
import com.exito.app.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class ConfirmarRegistro implements Task
{
    private RegistroCuentaParams parametros;

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
            DiligenciarRegistro.deLaCuenta(this.parametros),

            Click.on(RegistroCuentaUI.BTN_CONFIRMAR.getTarget())
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static ConfirmarRegistro deLaCuenta(RegistroCuentaParams parametros)
    {
        return Tasks.instrumented(
            ConfirmarRegistro.class,
            parametros
        );
    }
}
