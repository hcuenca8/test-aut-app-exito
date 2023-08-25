package com.exito.app.test.automation.e2e.utils.driver.app.plataformas;

import com.exito.app.test.automation.e2e.constants.enums.configuracion.contexts.Contextos;
import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.interfaces.IAppDriverPlatform;
import com.exito.app.test.automation.e2e.utils.tiempo.constants.enums.UnidadTiempo;
import com.exito.app.test.automation.e2e.utils.tiempo.utils.EsperaUtil;
import com.exito.app.test.automation.e2e.utils.trazas.TrazaUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Set;

/**
 * Comandos utilitarios adaptados para el controlador de plataforma/S.O Android
 */

public class DriverAndroidUtil implements IAppDriverPlatform
{

    private final AndroidDriver androidDriver;
    private final String sesionId;

    private static DriverAndroidUtil instance;

    private DriverAndroidUtil(AppiumDriver driver){
        this.androidDriver = (AndroidDriver) driver;
        this.sesionId = androidDriver.getSessionId().toString();
    }

    public static DriverAndroidUtil getInstance(AppiumDriver driver)
    {
        if( DriverAndroidUtil.instance == null
            ||  !instance.getSesionId()
                    .equalsIgnoreCase(driver.getSessionId().toString())
        ){
            DriverAndroidUtil.instance = new DriverAndroidUtil(driver);
        }

        return DriverAndroidUtil.instance;
    }

    public String getSesionId() {
        return sesionId;
    }

    public void reset(){
        this.androidDriver.execute("reset");
    }

    public Set<String> getContextHandles(){
        return this.androidDriver.getContextHandles();
    }

    public WebDriver context(String context){
        return this.androidDriver.context(context);
    }

    public String getContext(){
        return this.androidDriver.getContext();
    }

    public WebDriver toContext(Contextos contexto)
    {
        WebDriver webDriver = null;
        TrazaUtil.informacion("Inicia la preparacion para cambiar contexto a: {0}",contexto.getRegex());

        for(int i = 0 ; i<5 ; i++)
        {
            for(String context : this.getContextHandles())
            {
                if( context.matches(contexto.getRegex())
                ){
                    TrazaUtil.informacion("cambiando a contexto: {0}",context);
                    webDriver = this.context(context);
                    TrazaUtil.informacion("esperando 2 seg, despues del cambio de contexto: {0}",context);
                    EsperaUtil.detenerPor(2, UnidadTiempo.SEGUNDOS);
                    break;
                }
            }
            if( webDriver==null    )
            {
                TrazaUtil.informacion("Esperando 5 seg, pq HIZO EL RECORRIDO DE CONTEXTOS DISPONIBLES Y NO ENCONTRO EL CONTEXTO Q BUSCABA");
                EsperaUtil.detenerPor(5, UnidadTiempo.SEGUNDOS);
            }else{
                break;
            }
        }

        TrazaUtil.informacion("Finalizo el cambio de contexto: {0}",contexto.getRegex());

        return webDriver;
    }

    public String getCurrentUrl(){
        return androidDriver.getCurrentUrl();
    }

    public String getCurrentPackage(){
        return androidDriver.getCurrentPackage();
    }

    public void runAppInBackground(Duration duracion){
        androidDriver.runAppInBackground(duracion);
    }

}
