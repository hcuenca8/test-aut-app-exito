package com.exito.app.test.automation.e2e.interactions.app.desplazamiento;

import com.exito.app.test.automation.e2e.models.tecnicos.Desplazamiento;
import com.exito.app.test.automation.e2e.utils.dom.app.DOMAppUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

@AllArgsConstructor
public class DeslizarAlTexto implements Interaction
{
    private String texto;
    private int enMenosDe;
    private Desplazamiento desplazamiento;

    public static DeslizarAlTexto enPantalla(String texto, int enMenosDe, Desplazamiento desplazamientos)
    {
        return Tasks.instrumented(
                DeslizarAlTexto.class,
                texto,
                enMenosDe,
                desplazamientos
        );
    }

    public static DeslizarAlTexto enPantalla(String texto, Desplazamiento desplazamientos)
    {
        return Tasks.instrumented(
            DeslizarAlTexto.class,
            texto,
            5,
            desplazamientos
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        for(   int i = 0; i<enMenosDe ; i++ )
        {
            actor.attemptsTo(
                Deslizar.enPantalla(this.desplazamiento)
            );

            if (    DOMAppUtil.existeEnDOM(this.texto, false)   )
            {
                break;
            }
        }
    }
}
