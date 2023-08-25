package com.exito.app.test.automation.e2e.utils.dom.app;

import com.exito.app.test.automation.e2e.utils.GeneralUtil;
import com.exito.app.test.automation.e2e.utils.driver.app.AppDriverUtil;
import com.exito.app.test.automation.e2e.utils.javadoc.JavaDocUtil;

import java.util.regex.Pattern;

/**
 * Utilidades relacionadas con el DOM (arbol de componentes de la app)
 */
public class DOMAppUtil
{
    /**
     * Para mas informacion:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private DOMAppUtil(){
        GeneralUtil.noPermitaInstanciar();
    }

    public static String getDOM()
    {
        return AppDriverUtil.getDriverAppium().getPageSource();
    }

    public static boolean existeEnDOM(String regex)
    {
        return existeEnDOM(regex,true);
    }

    public static boolean existeEnDOM(String regex, boolean esRegex)
    {
        if(!esRegex){
            regex = Pattern.quote(regex);
        }

        return Pattern.compile(regex)
            .matcher(DOMAppUtil.getDOM())
            .find();
    }
}
