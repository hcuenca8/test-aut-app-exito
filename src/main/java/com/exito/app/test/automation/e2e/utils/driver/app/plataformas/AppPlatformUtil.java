package com.exito.app.test.automation.e2e.utils.driver.app.plataformas;

import com.exito.app.test.automation.e2e.constants.enums.configuracion.serenity.SerenityConf;
import com.exito.app.test.automation.e2e.utils.GeneralUtil;
import com.exito.app.test.automation.e2e.utils.javadoc.JavaDocUtil;

/**
 * Utilidades relacionadas con las plataformas / sistemas operativos mobiles (Android/iOS)
 */
public class AppPlatformUtil
{
    private static final String PLATFORM_ANDROID = "android";

    /**
     * Para mas informacion:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private AppPlatformUtil(){
        GeneralUtil.noPermitaInstanciar();
    }

    /**
     * Permite observar y determinar si la plataforma o S.O con el que se espera ejecutar la prueba es android segun las
     * capabilities configuradas
     * @return true: si es android, false: en caso contrario
     */
    public static boolean isPlatformAndroid()
    {
        return SerenityConf.APPIUM_PLATFORM_NAME.getValor()
            .equalsIgnoreCase(PLATFORM_ANDROID);
    }
}
