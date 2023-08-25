package com.exito.app.test.automation.e2e.interactions.app.cajas.verificacion;

import com.exito.app.test.automation.e2e.interactions.app.click.coordenado.ClickearConRespecto;
import com.exito.app.test.automation.e2e.userinterfaces.features.cuenta.registro.RegistroCuentaUI;
import com.exito.app.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Dimension;

@AllArgsConstructor
public class CheckearCaja implements Interaction
{
    private Target elemento;

    private int veces;

    @Override
    public <T extends Actor> void performAs(T actor) {

        Dimension dimension = this.elemento.resolveFor(actor).getSize();

        for(;this.veces>0;this.veces--)
        {
            actor.attemptsTo(
                ClickearConRespecto.alEjeXNegDel(
                    this.elemento,
                    dimension.getWidth()/2
                )
            );
        }
    }

    public static CheckearCaja deVerificacion(int veces, Target elemento)
    {
        return Tasks.instrumented(
            CheckearCaja.class,
            elemento,
            veces
        );
    }

    public static CheckearCaja deVerificacion(Target elemento)
    {
        return Tasks.instrumented(
            CheckearCaja.class,
            elemento,
            1
        );
    }



}
