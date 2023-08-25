package com.exito.app.test.automation.e2e.interactions.app.webview;

import com.exito.app.test.automation.e2e.constants.enums.configuracion.contexts.Contextos;
import com.exito.app.test.automation.e2e.constants.enums.configuracion.serenity.SerenityConf;
import com.exito.app.test.automation.e2e.userinterfaces.general.app.webview.WebViewNavegadorUI;
import com.exito.app.test.automation.e2e.utils.driver.app.AppDriverUtil;
import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.interfaces.IAppDriverPlatform;
import com.exito.app.test.automation.e2e.utils.dom.app.DOMAppUtil;
import com.exito.app.test.automation.e2e.utils.tiempo.constants.enums.UnidadTiempo;
import com.exito.app.test.automation.e2e.utils.tiempo.utils.EsperaUtil;
import com.exito.app.test.automation.e2e.utils.trazas.TrazaUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

@AllArgsConstructor
public class CambiarContexto implements Interaction
{

    private Contextos aContexto;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        IAppDriverPlatform driverPlatform = AppDriverUtil.getDriverPlatform(actor);

        if(   this.aContexto.equals(Contextos.WEBVIEW_BROWSER)  )
        {
            for(int i = 0 ; i<10 ; i++)
            {
                if( driverPlatform.getCurrentPackage().equalsIgnoreCase(SerenityConf.APPIUM_APP_PACKAGE.getValor())
                ){
                    TrazaUtil.informacion("ESPERANDO 1 SEG a que CAMBIE EL APP_PACKAGE A PACKAGE WEBVIEW");
                    EsperaUtil.detenerPor(1, UnidadTiempo.SEGUNDOS);
                }else{
                    break;
                }
            }

            if( !driverPlatform.getCurrentPackage().equalsIgnoreCase(SerenityConf.APPIUM_APP_PACKAGE.getValor())
            ){
                /**
                 * una espera a que termine de cargar la pagina, pq de lo contrario interviene en las acciones sobre la url
                 */
                while(DOMAppUtil.existeEnDOM(WebViewNavegadorUI.CARGANDO.getXpath(),false)){
                    TrazaUtil.informacion("ESPERANDO 2 SEG, A QUE TERMINE DE CARGAR EL WEBVIEW");
                    EsperaUtil.detenerPor(2, UnidadTiempo.SEGUNDOS);
                }
            }
        }

        driverPlatform.toContext(this.aContexto);
    }

    public static CambiarContexto deLaApp(Contextos aContexto)
    {
        return Tasks.instrumented(
            CambiarContexto.class,
            aContexto
        );
    }
}
