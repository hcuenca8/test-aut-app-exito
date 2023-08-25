package com.exito.app.test.automation.e2e.interactions.app.webview;

import com.exito.app.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.exito.app.test.automation.e2e.interactions.Esperar;
import com.exito.app.test.automation.e2e.userinterfaces.general.app.webview.WebViewNavegadorUI;
import com.exito.app.test.automation.e2e.utils.driver.app.AppDriverUtil;
import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.interfaces.IAppDriverPlatform;
import com.exito.app.test.automation.e2e.utils.dom.app.DOMAppUtil;
import com.exito.app.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import com.exito.app.test.automation.e2e.utils.tiempo.constants.enums.UnidadTiempo;
import com.exito.app.test.automation.e2e.utils.tiempo.utils.EsperaUtil;
import com.exito.app.test.automation.e2e.utils.trazas.TrazaUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

@AllArgsConstructor
public class InspeccionarURL implements Interaction
{

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        IAppDriverPlatform driverPlatform = AppDriverUtil.getDriverPlatform(actor);

        TrazaUtil.informacion("Inicio interaction");

        Target conexionSeguraUI = WebViewNavegadorUI.CONEXION_SEGURA.getTarget();

        Target urlDominioUI = WebViewNavegadorUI.URL_DOMINIO.getTarget();

        actor.attemptsTo(
            Esperar.hastaQue(conexionSeguraUI)
                .este(EstadoElemento.VISIBLE)
                .porNoMasDe(Esperas.GENERAL.getTiempo()).segundos()
        );

        /**
         * una espera a que termine de cargar la pagina, pq de lo contrario interviene en las acciones sobre la url
         */
        while(DOMAppUtil.existeEnDOM(WebViewNavegadorUI.CARGANDO.getXpath(),false))
        {
            TrazaUtil.informacion("Esperando 500 mlseg, A QUE TERMINE DE CARGAR EL WEBVIEW");
            EsperaUtil.detenerPor(500, UnidadTiempo.MILISEGUNDOS);
        }

        TrazaUtil.informacion("WEBVIEW cargado, intentara inspeccionar la url de manera manual");

        actor.attemptsTo(
            Esperar.hastaQue(conexionSeguraUI)
                .este(EstadoElemento.VISIBLE)
                .porNoMasDe(Esperas.GENERAL.getTiempo()).segundos(),

            Click.on(conexionSeguraUI),

            Click.on(urlDominioUI)
        );

        TrazaUtil.informacion("FIN interaction");
    }

    public static InspeccionarURL delWebView()
    {
        return Tasks.instrumented(
            InspeccionarURL.class
        );
    }
}
