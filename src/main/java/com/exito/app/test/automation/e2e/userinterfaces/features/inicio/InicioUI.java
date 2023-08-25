package com.exito.app.test.automation.e2e.userinterfaces.features.inicio;

import com.exito.app.test.automation.e2e.userinterfaces.javadoc.app.UIJavaDoc;
import com.exito.app.test.automation.e2e.utils.userinterfaces.app.interfaces.IUserInterface;

/**
 * Para mas informacion:
 * @see UIJavaDoc#CLASE
 */
public enum InicioUI implements IUserInterface {


    BTN_REGISTRARSE(
        "Registrarse",
            "//android.widget.Button[@resource-id='com.exito.appcompania:id/AppCompatButton_registrarse']",
            "//TODO-xpath-ios"
    ),
    ;

    private final String nombre;
    private final String xpathAndroid;
    private final String xpathIOS;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    InicioUI(String nombre, String xpathAndroid, String xpathIOS)
    {
        this.nombre = nombre;
        this.xpathAndroid = xpathAndroid;
        this.xpathIOS = xpathIOS;
    }

    @Override
    public String getXpathIOS() {
        return xpathIOS;
    }

    @Override
    public String getXpathAndroid() {
        return xpathAndroid;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
