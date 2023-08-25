package com.exito.app.test.automation.e2e.userinterfaces.features.cuenta.registro;

import com.exito.app.test.automation.e2e.userinterfaces.javadoc.app.UIJavaDoc;
import com.exito.app.test.automation.e2e.utils.userinterfaces.app.interfaces.IUserInterface;

/**
 * Para mas informacion:
 * @see UIJavaDoc#CLASE
 */
public enum RegistroCuentaUI implements IUserInterface {


    TXT_NOMBRES(
        "Nombre",
            "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_nombres']//android.widget.EditText",
            "//TODO-xpath-ios"
    ),
    TXT_APELLIDOS(
        "Apellidos",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_apellidos']//android.widget.EditText",
        "//TODO-xpath-ios"
    ),
    LST_TIPO_DOCUMENTO(
        "Lista tipos de documento",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/tipo_documento']//android.widget.Spinner",
        "//TODO-xpath-ios"
    ),
    ITM_TIPO_DOCUMENTO(
        "Item Tipo de documento {0}",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/tipo_documento']//*[@text='{0}']",
        "//TODO-xpath-ios"
    ),
    TXT_DOCUMENTO(
        "Numero de documento",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_numero_doc']//android.widget.EditText",
        "//TODO-xpath-ios"
    ),

    LST_ANYO_NACIMIENTO(
        "Lista año de nacimiento",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_anio']//android.widget.Spinner",
        "//TODO-xpath-ios"
    ),
    ITM_ANYO_NACIMIENTO(
        "Item año de nacimiento: {0}",
        "//*[not(@resource-id='com.exito.appcompania:id/CustomEditText_anio')]//*[@text='{0}']",
        "//TODO-xpath-ios"
    ),

    LST_MES_NACIMIENTO(
        "Lista mes de nacimiento",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_mes']//android.widget.Spinner",
        "//TODO-xpath-ios"
    ),
    ITM_MES_NACIMIENTO(
        "Item mes de nacimiento: {0}",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_mes']//*[@text='{0}']",
        "//TODO-xpath-ios"
    ),

    LST_DIA_NACIMIENTO(
        "Lista mes de nacimiento",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_dia']//android.widget.Spinner",
        "//TODO-xpath-ios"
    ),
    ITM_DIA_NACIMIENTO(
        "Item mes de nacimiento: {0}",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_dia']//*[@text='{0}']",
        "//TODO-xpath-ios"
    ),

    TXT_CELULAR(
        "Celular",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_numero_tel']//android.widget.EditText",
        "//TODO-xpath-ios"
    ),
    TXT_CORREO_ELECTRONICO(
        "Correo electronico",
        "//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_email_register']//android.widget.EditText",
        "//TODO-xpath-ios"
    ),

    CHK_ACEPTO_TERMINOS(
        "Terminos y condiciones",
        "//android.widget.CheckBox[@resource-id='com.exito.appcompania:id/AppCompatTextView_terminos_y_condiciones']",
        "//TODO-xpath-ios"
    ),

    CHK_ACEPTO_POLITICAS(
        "Politicas",
        "//android.widget.CheckBox[@resource-id='com.exito.appcompania:id/AppCompatTextView_politicas_tratamiento']",
        "//TODO-xpath-ios"
    ),
    BTN_CONFIRMAR(
        "Confirmar",
        "//android.widget.Button[@resource-id='com.exito.appcompania:id/AppCompatButton_registrar']",
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
    RegistroCuentaUI(String nombre, String xpathAndroid, String xpathIOS)
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
