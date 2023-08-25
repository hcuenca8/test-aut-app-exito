package com.exito.app.test.automation.e2e.interactions.app.textos.cajas;

import com.exito.app.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

@AllArgsConstructor
public class DigitarEnCajaTexto implements Interaction
{
    private Target elemento;

    private String dato;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
            Check.whether(TablaGherkinUtil.campoNoNull(this.dato))
                .andIfSo(
                    Enter.keyValues(this.dato)
                        .into(this.elemento)
                )
        );
    }

    public static DigitarEnCajaTexto elDato(String dato, Target elemento)
    {
        return Tasks.instrumented(
            DigitarEnCajaTexto.class,
            elemento,
            dato
        );
    }



}
