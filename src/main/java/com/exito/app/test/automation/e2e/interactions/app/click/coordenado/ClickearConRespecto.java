package com.exito.app.test.automation.e2e.interactions.app.click.coordenado;

import com.exito.app.test.automation.e2e.interactions.Detener;
import com.exito.app.test.automation.e2e.models.tecnicos.Coordenada;
import com.exito.app.test.automation.e2e.models.tecnicos.Desplazamiento;
import com.exito.app.test.automation.e2e.userinterfaces.features.cuenta.registro.RegistroCuentaUI;
import com.exito.app.test.automation.e2e.utils.driver.app.AppDriverUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

@AllArgsConstructor
public class ClickearConRespecto implements Interaction
{
    private Target elemento;

    private Point coordenada;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
            MoveMouse.to(this.elemento)
                .andThen(actions ->
                    actions.moveByOffset(
                        this.coordenada.getX(),
                        this.coordenada.getY()
                    ).click()
                )
        );
    }

    public static ClickearConRespecto al(Target elemento, Point coordenada)
    {
        return Tasks.instrumented(
            ClickearConRespecto.class,
            elemento,
            coordenada
        );
    }

    public static ClickearConRespecto al(Target elemento, boolean sobreEjeX, boolean positivo,int distancia)
    {
        int signo = positivo ? 1 : -1;

        Point coordenada = sobreEjeX
            ?   new Point(signo*distancia,0)
            :   new Point(0,distancia*signo);

        return ClickearConRespecto.al(elemento, coordenada);
    }

    public static ClickearConRespecto alEjeXPosDel(Target elemento, int distancia)
    {
        return ClickearConRespecto.al(
            elemento,
            true,
            true,
            distancia
        );
    }

    public static ClickearConRespecto alEjeXNegDel(Target elemento, int distancia)
    {
        return ClickearConRespecto.al(
            elemento,
            true,
            false,
            distancia
        );
    }

    public static ClickearConRespecto alEjeYNegDel(Target elemento, int distancia)
    {
        return ClickearConRespecto.al(
            elemento,
            false,
            true,
            distancia
        );
    }

    public static ClickearConRespecto alEjeYPosDel(Target elemento, int distancia)
    {
        return ClickearConRespecto.al(
            elemento,
            false,
            false,
            distancia
        );
    }

}
