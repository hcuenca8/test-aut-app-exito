package com.exito.app.test.automation.e2e.tasks.features.cuenta.registro;

import com.exito.app.test.automation.e2e.interactions.app.cajas.verificacion.CheckearCaja;
import com.exito.app.test.automation.e2e.interactions.app.click.coordenado.ClickearConRespecto;
import com.exito.app.test.automation.e2e.interactions.app.listas.desplegables.ElegirDeListaDesplegable;
import com.exito.app.test.automation.e2e.interactions.app.textos.cajas.EscribirEnCajaTexto;
import com.exito.app.test.automation.e2e.models.params.features.cuenta.registro.RegistroCuentaParams;
import com.exito.app.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.features.cuenta.registro.RegistroCuentaUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class DiligenciarRegistro implements Task
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

        Dimension dim = RegistroCuentaUI.CHK_ACEPTO_POLITICAS.getTarget().resolveFor(actor).getSize();

        actor.attemptsTo(

            EscribirEnCajaTexto.elDato(
                this.parametros.getNombres(),
                RegistroCuentaUI.TXT_NOMBRES.getTarget()
            ),

            EscribirEnCajaTexto.elDato(
                this.parametros.getApellidos(),
                RegistroCuentaUI.TXT_APELLIDOS.getTarget()
            ),

            ElegirDeListaDesplegable.elItem(
                this.parametros.getTipoDocumento(),
                RegistroCuentaUI.LST_TIPO_DOCUMENTO.getTarget()
            ),

            EscribirEnCajaTexto.elDato(
                this.parametros.getDocumento(),
                RegistroCuentaUI.TXT_DOCUMENTO.getTarget()
            ),

            ElegirDeListaDesplegable.elItem(
                this.parametros.getAnyoNacimiento(),
                RegistroCuentaUI.LST_ANYO_NACIMIENTO.getTarget()
            ),

            ElegirDeListaDesplegable.elItem(
                this.parametros.getMesNacimiento(),
                RegistroCuentaUI.LST_MES_NACIMIENTO.getTarget()
            ),

            ElegirDeListaDesplegable.elItem(
                this.parametros.getDiaNacimiento(),
                RegistroCuentaUI.LST_DIA_NACIMIENTO.getTarget()
            ),

            EscribirEnCajaTexto.elDato(
                this.parametros.getCelular(),
                RegistroCuentaUI.TXT_CELULAR.getTarget()
            ),

            EscribirEnCajaTexto.elDato(
                this.parametros.getCorreo(),
                RegistroCuentaUI.TXT_CORREO_ELECTRONICO.getTarget()
            ),

            CheckearCaja.deVerificacion(RegistroCuentaUI.CHK_ACEPTO_TERMINOS.getTarget()),

            ClickearConRespecto.al(
                RegistroCuentaUI.CHK_ACEPTO_POLITICAS.getTarget(),
                new Point(dim.getWidth()/-2,dim.getHeight()/-2)
            )
        );

    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static DiligenciarRegistro deLaCuenta(RegistroCuentaParams parametros)
    {
        return Tasks.instrumented(
            DiligenciarRegistro.class,
            parametros
        );
    }
}
