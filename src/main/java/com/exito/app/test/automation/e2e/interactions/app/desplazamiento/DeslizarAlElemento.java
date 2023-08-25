package com.exito.app.test.automation.e2e.interactions.app.desplazamiento;

import com.exito.app.test.automation.e2e.models.tecnicos.Desplazamiento;
import com.exito.app.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.lang3.ArrayUtils;

@AllArgsConstructor
public class DeslizarAlElemento implements Interaction
{
    private Target elemento;
    private int enMenosDe;
    private Desplazamiento desplazamiento;

    private EstadoElemento[] estados;

    public static DeslizarAlElemento enPantalla(Target elemento, int enMenosDe, Desplazamiento desplazamientos,EstadoElemento estado,  EstadoElemento ... estados)
    {
        return Tasks.instrumented(
                DeslizarAlElemento.class,
                elemento,
                enMenosDe,
                desplazamientos,
                DeslizarAlElemento.getEstados(estado,estados)
        );
    }

    public static DeslizarAlElemento enPantalla(Target elemento, Desplazamiento desplazamientos, EstadoElemento estado, EstadoElemento ... estados)
    {
        return Tasks.instrumented(
            DeslizarAlElemento.class,
            elemento,
            3,
            desplazamientos,
            DeslizarAlElemento.getEstados(estado,estados)
        );
    }

    private static EstadoElemento[] getEstados(EstadoElemento estado, EstadoElemento ... estados)
    {
        return estados == null
            ?   new EstadoElemento[]{estado}
            :   ArrayUtils.add(estados,estado);
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        boolean encontrado;
        for(   int i = 0; i<enMenosDe ; i++ )
        {
            actor.attemptsTo(
                Deslizar.enPantalla(this.desplazamiento)
            );

            encontrado = true;
            for(EstadoElemento estado : this.estados)
            {
                if( !estado.esCuando(actor,this.elemento) )
                {
                    encontrado = false;
                    break;
                }
            }
            if(encontrado){
                break;
            }
        }
    }
}
