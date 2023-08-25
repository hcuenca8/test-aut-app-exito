package com.exito.app.test.automation.e2e.userinterfaces.general.app.pantalla;

import com.exito.app.test.automation.e2e.utils.userinterfaces.app.interfaces.IUserInterface;


public enum ContenidoAppUI implements IUserInterface {

    LBL_TEXTO(
        "texto",
        "//*[contains(@text,'{0}')][@displayed='true']",
        "//TODO-xpath-ios"
    ),
    LBL_TEXTO_EXACTO(
        "texto exacto",
        "//*[@text='{0}'][@displayed='true']",
        "//TODO-xpath-ios"
    ),

    BTN_OPCION(
        "opción {0}",
        "//android.widget.Button[.//*[@text='{0}']]",
        ""
    ),
    ;

    private final String nombre;
    private final String xpathAndroid;
    private final String xpathIOS;

    ContenidoAppUI(String nombre, String xpathAndroid, String xpathIOS)
    {
        this.nombre = nombre;
        this.xpathAndroid = xpathAndroid;
        this.xpathIOS = xpathIOS;
    }

    @Override
    public String getXpathIOS() {
        return this.xpathIOS;
    }

    @Override
    public String getXpathAndroid() {
        return this.xpathAndroid;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
//}
