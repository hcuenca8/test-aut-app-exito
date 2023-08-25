package com.exito.app.test.automation.e2e.questions.general.app.webview;

import com.exito.app.test.automation.e2e.interactions.Detener;
import com.exito.app.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.general.app.webview.WebViewEmbebidoUI;
import com.exito.app.test.automation.e2e.utils.trazas.TrazaUtil;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.regex.Pattern;

/**
 * Para mas informacion:
 * @see QuestionsJavaDoc#CLASE
 */
@Builder
public class LaUrlWebViewEmbebido implements Question<Boolean>
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

        actor.attemptsTo(
            Detener.por(5).segundos()
        );

        String urlWebView =
            WebViewEmbebidoUI.URL_ABSOLUTA.getTarget().resolveFor(actor).getText();

        TrazaUtil.informacion("INTERACTION-urlWebView: {0}",urlWebView);

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
    public static LaUrlWebViewEmbebido correspondeA(String urlEsperada)
    {
        return LaUrlWebViewEmbebido.builder()
            .urlEsperada(urlEsperada)
            .build();
    }
}
