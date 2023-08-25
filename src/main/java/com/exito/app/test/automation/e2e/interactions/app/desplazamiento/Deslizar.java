package com.exito.app.test.automation.e2e.interactions.app.desplazamiento;

import com.exito.app.test.automation.e2e.interactions.Detener;
import com.exito.app.test.automation.e2e.models.tecnicos.Desplazamiento;
import com.exito.app.test.automation.e2e.utils.driver.app.AppDriverUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

@AllArgsConstructor
public class Deslizar implements Interaction
{
    private Desplazamiento desplazamiento;
    private int veces;
    private static final int TIEMPO_ML_DURACION_DEL_EVENTO = 500;

    private static final Duration DURACION_DEL_EVENTO = Duration.ofMillis(TIEMPO_ML_DURACION_DEL_EVENTO);

    public static Deslizar enPantalla(Desplazamiento desplazamiento, int veces)
    {
        return Tasks.instrumented(
            Deslizar.class,
            desplazamiento,
            veces
        );
    }

    public static Deslizar enPantalla(Desplazamiento desplazamiento)
    {
        return Deslizar.enPantalla(desplazamiento,1);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        /**
         * W3C Actions
         * https://appium.io/docs/en/commands/interactions/actions/
         */

        for(int i = 0; i< this.veces ;i++)
        {
            actor.attemptsTo(
                Detener.por(1).segundos()
            );

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence dragNDrop = new Sequence(finger, 1);

            dragNDrop.addAction(
                finger.createPointerMove(
                    Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), desplazamiento.getCoordenadaOrigen().getPunto()
                )
            ).addAction(
                finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())
            ).addAction(
                finger.createPointerMove(
                    DURACION_DEL_EVENTO,
                    PointerInput.Origin.viewport(),
                    desplazamiento.getCoordenadaDestino().getPunto()
                )
            ).addAction(
                finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())
            );

            AppDriverUtil.getDriverAppium(actor).perform(Arrays.asList(dragNDrop));
        }

        actor.attemptsTo(
            Detener.por(2).segundos()
        );
    }
}
