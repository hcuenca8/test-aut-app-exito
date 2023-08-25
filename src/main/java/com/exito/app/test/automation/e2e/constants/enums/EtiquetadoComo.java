package com.exito.app.test.automation.e2e.constants.enums;


public enum EtiquetadoComo
{
    //Etiquetas en Pantalla

    ;

    private final String etiqueta;

    EtiquetadoComo(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    public String enPantalla()
    {
        return this.etiqueta;
    }
}
