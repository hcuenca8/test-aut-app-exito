package com.exito.app.test.automation.e2e.userinterfaces.general.app.webview;

import com.exito.app.test.automation.e2e.utils.userinterfaces.app.interfaces.IUserInterface;

public enum WebViewEmbebidoUI implements IUserInterface {

    URL_ABSOLUTA(
        "url de webview",
        "//*/android.widget.TextView[@resource-id='webview-url']",
        ""
    ),
    CERRAR(
        "cerrar",
        "//*/android.widget.Button[@resource-id='close']",
        ""
    ),
    CONFIRMAR_CERRAR(
        "confirmar cerrar",
        "//*/android.widget.Button[@resource-id='android:id/button1']",
        ""
    )
    ;

    private final String nombre;
    private final String xpathAndroid;
    private final String xpathIOS;

    WebViewEmbebidoUI(String nombre, String xpathAndroid, String xpathIOS)
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
