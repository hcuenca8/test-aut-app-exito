package com.exito.app.test.automation.e2e.questions.general.app.webview;

import com.exito.app.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.exito.app.test.automation.e2e.constants.enums.configuracion.contexts.Contextos;
import com.exito.app.test.automation.e2e.interactions.Esperar;
import com.exito.app.test.automation.e2e.interactions.app.webview.CambiarContexto;
import com.exito.app.test.automation.e2e.interactions.app.webview.InspeccionarURL;
import com.exito.app.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.general.app.webview.WebViewNavegadorUI;
import com.exito.app.test.automation.e2e.utils.driver.app.AppDriverUtil;
import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.interfaces.IAppDriverPlatform;
import com.exito.app.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import com.exito.app.test.automation.e2e.utils.trazas.TrazaUtil;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Para mas informacion:
 * @see QuestionsJavaDoc#CLASE
 */
@Builder
public class LaUrlWebViewNavegador implements Question<Boolean>
{
    private String urlEsperada;
    private static final String RGX_PARAMETROS = "/?\\?.*";
    private static final String RGX_INICIO = "^";
    private static final String ID_URL_ESPERADA = "[[URL_ESPERADA]]";
    private static final String FRM_RGX_URL = RGX_INICIO+ ID_URL_ESPERADA +RGX_PARAMETROS;

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ANSWERED_BY
     */
    @Override
    public Boolean answeredBy(Actor actor)
    {
        /**
         * Para mas informacion:
         * @see QuestionsJavaDoc#ENLAZAR_VALIDACIONES_VERIFICACIONES
         */
        String urlWebView = StringUtils.EMPTY;
        IAppDriverPlatform driverPlatform = AppDriverUtil.getDriverPlatform(actor);

        actor.attemptsTo(
            CambiarContexto.deLaApp(Contextos.WEBVIEW_BROWSER)
        );

        if( driverPlatform.getContext().matches(Contextos.WEBVIEW_BROWSER.getRegex())    )
        {
            TrazaUtil.informacion("CONTEXTO-cambio a WebView_BROWSER");
            urlWebView = driverPlatform.getCurrentUrl();
            TrazaUtil.informacion("CONTEXTO-urlWebView: {0}",urlWebView);

            actor.attemptsTo(
                CambiarContexto.deLaApp(Contextos.NATIVE)
            );
        }else {
            TrazaUtil.informacion("CONTEXTO-NO cambio a WebView_BROWSER");
            if( !driverPlatform.getContext().matches(Contextos.NATIVE.getRegex())    )
            {
                actor.attemptsTo(
                    CambiarContexto.deLaApp(Contextos.NATIVE)
                );
            }

            if( driverPlatform.getContext().matches(Contextos.NATIVE.getRegex())    )
            {
                TrazaUtil.informacion("CONTEXTO-ESTA EN NATIVO, intentara inspeccionar manualmente");

                Target urlAbsoluta = WebViewNavegadorUI.URL_ABSOLUTA.getTarget();

                actor.attemptsTo(
                    InspeccionarURL.delWebView(),

                    Esperar.hastaQue(urlAbsoluta)
                        .este(EstadoElemento.VISIBLE)
                        .porNoMasDe(Esperas.GENERAL.getTiempo()).segundos()
                );

                urlWebView = urlAbsoluta.resolveFor(actor).getText();

                TrazaUtil.informacion("INTERACTION-urlWebView: {0}",urlWebView);

                AppDriverUtil.getDriverAppium(actor)
                    .navigate().back();

                TrazaUtil.informacion("REGRESA A PAGINA WEBVIEW");
            }
        }

        TrazaUtil.informacion("url esperado: {0}",this.urlEsperada);

        TrazaUtil.informacion("resultado matches: {0}",String.valueOf(urlWebView.matches(
            FRM_RGX_URL.replace(
                ID_URL_ESPERADA,
                Pattern.quote(this.urlEsperada)
            )
        )));

        return urlWebView.matches(
            FRM_RGX_URL.replace(
                ID_URL_ESPERADA,
                Pattern.quote(this.urlEsperada)
            )
        );
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static LaUrlWebViewNavegador correspondeA(String urlEsperada)
    {
        return LaUrlWebViewNavegador.builder()
            .urlEsperada(urlEsperada)
            .build();
    }
}
