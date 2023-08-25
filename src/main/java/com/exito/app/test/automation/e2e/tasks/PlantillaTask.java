package com.exito.app.test.automation.e2e.tasks;

import com.exito.app.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class PlantillaTask implements Task
{
    //private {{Pantalla}}Params parametros

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
            /*
             * UTILICE ESTE COMENTARIO SOLO PARA GUIA, AL COMPRENDER
             * REMUEVA ESTE COMENTARIO DE SU TASK
             *
             * //Algunos ejemplos:
             *
             * Esperar.hastaQue({{Pantalla}}UI.{{GUI_COMPONENTE}})
             *      .este(EstadoElemento.{{ESTADO}})
             *      .porNoMasDe(Esperas.General.getTiempo()).{{tipoTiempo}}(),
             *
             * Enter.theValue("ingresar texto en")
             *      .into({{Pantalla}}UI.TXT_CAJA_TEXTO),
             *
             * Click.on({{Pantalla}}UI.BTN_SUBMIT),
             */
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static PlantillaTask enlace(/*{{Pantalla}}Params parametros*/)
    {
        return Tasks.instrumented(
            PlantillaTask.class/*,
               parametros
               */
        );
    }
}
