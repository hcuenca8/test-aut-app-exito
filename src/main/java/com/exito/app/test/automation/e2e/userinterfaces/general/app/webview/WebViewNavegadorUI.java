package com.exito.app.test.automation.e2e.userinterfaces.general.app.webview;

import com.exito.app.test.automation.e2e.utils.userinterfaces.app.interfaces.IUserInterface;

public enum WebViewNavegadorUI implements IUserInterface {

    CARGANDO(
        "barra de progreso",
        "android.widget.ProgressBar",
        ""
    ),
    CONEXION_SEGURA(
        "conexion segura (candado)",
        "//*[@resource-id='com.android.chrome:id/security_button']",
        "//*[@resource-id='com.android.chrome:id/security_button']"
    ),
    URL_DOMINIO(
        "URL de dominio",
        "//*[@resource-id='com.android.chrome:id/page_info_truncated_url']",
        "//*[@resource-id='com.android.chrome:id/page_info_url_wrapper']"
    ),
    URL_ABSOLUTA(
        "URL absoluta",
        "//*[@resource-id='com.android.chrome:id/page_info_url']",
        "//*[@resource-id='com.android.chrome:id/page_info_url']"
    ),
    CERRAR(
        "cerrar",
        "//*[@resource-id='com.android.chrome:id/close_button']",
        "//*[@resource-id='com.android.chrome:id/close_button']"
    ),
    ;

    private final String nombre;
    private final String xpathAndroid;
    private final String xpathIOS;

    WebViewNavegadorUI(String nombre, String xpathAndroid, String xpathIOS)
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
