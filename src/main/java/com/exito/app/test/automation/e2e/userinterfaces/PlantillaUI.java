package com.exito.app.test.automation.e2e.userinterfaces;

import com.exito.app.test.automation.e2e.userinterfaces.javadoc.app.UIJavaDoc;
import com.exito.app.test.automation.e2e.utils.userinterfaces.app.interfaces.IUserInterface;

/**
 * Para mas informacion:
 * @see UIJavaDoc#CLASE
 */
public enum PlantillaUI implements IUserInterface {

    /*
    {{NOMBRE_CORTO_ELEMENTO}}(
        "{{descripcion/nombre del elemeto}}",
            "//TODO-xpath-android",
            "//TODO-xpath-ios"
    )
    */,
    ;

    private final String nombre;
    private final String xpathAndroid;
    private final String xpathIOS;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    PlantillaUI(String nombre, String xpathAndroid, String xpathIOS)
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
