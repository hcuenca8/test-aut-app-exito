package com.exito.app.test.automation.e2e.utils.driver.app.plataformas;

import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.interfaces.IAppDriverPlatform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Comandos utilitarios adaptados para el controlador de plataforma/S.O iOS
 */
public class DriverIOSUtil implements IAppDriverPlatform
{

    private final IOSDriver iOSDriver;

    private static DriverIOSUtil instance;

    private DriverIOSUtil(AppiumDriver driver){
        this.iOSDriver = (IOSDriver) driver;
    }

    public static DriverIOSUtil getInstance(AppiumDriver driver)
    {
        if( DriverIOSUtil.instance == null
            ||  !instance.getIOSDriver().getSessionId().toString()
            .equalsIgnoreCase(driver.getSessionId().toString())
        ){
            DriverIOSUtil.instance = new DriverIOSUtil(driver);
        }

        return DriverIOSUtil.instance;
    }

    public IOSDriver getIOSDriver() {
        return iOSDriver;
    }
}
