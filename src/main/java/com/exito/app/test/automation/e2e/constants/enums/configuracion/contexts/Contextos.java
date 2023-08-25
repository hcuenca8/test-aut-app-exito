package com.exito.app.test.automation.e2e.constants.enums.configuracion.contexts;

public enum Contextos {

    //WEBVIEW_BROWSER("WEBVIEW_"),
    //WEBVIEW_APP("WEBVIEW_com.appcarroya"),
    WEBVIEW_BROWSER("WEBVIEW_(chrome|safari)"),
    NATIVE("NATIVE_APP"),
    ;

    private final String regex;

    Contextos(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
