package com.exito.app.test.automation.e2e.interactions.app.listas.desplegables;

import com.exito.app.test.automation.e2e.interactions.app.click.coordenado.ClickearConRespecto;
import com.exito.app.test.automation.e2e.interactions.app.textos.cajas.DigitarEnCajaTexto;
import com.exito.app.test.automation.e2e.interactions.app.textos.cajas.EscribirEnCajaTexto;
import com.exito.app.test.automation.e2e.userinterfaces.features.cuenta.registro.RegistroCuentaUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

@AllArgsConstructor
public class ElegirDeListaDesplegable implements Interaction
{
    private Target elemento;

    private String filtro;

    @Override
    public <T extends Actor> void performAs(T actor) {

        Dimension dimension = this.elemento.resolveFor(actor).getSize();

        actor.attemptsTo(
            EscribirEnCajaTexto.elDato(
                this.filtro,
                this.elemento
            ).then(Click.on(this.elemento)
                .then(ClickearConRespecto.alEjeYNegDel(
                        this.elemento,
                        dimension.getHeight())
                )
            )
        );
    }

    public static ElegirDeListaDesplegable elItem(String filtro, Target elemento)
    {
        return Tasks.instrumented(
            ElegirDeListaDesplegable.class,
            elemento,
            filtro
        );
    }



}
