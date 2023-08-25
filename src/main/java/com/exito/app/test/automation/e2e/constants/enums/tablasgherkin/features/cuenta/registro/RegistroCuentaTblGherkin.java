package com.exito.app.test.automation.e2e.constants.enums.tablasgherkin.features.cuenta.registro;

import com.exito.app.test.automation.e2e.constants.enums.tablasgherkin.javadoc.TblGherkinJavaDoc;
import com.exito.app.test.automation.e2e.models.params.PlantillaParams;
import com.exito.app.test.automation.e2e.models.params.features.cuenta.registro.RegistroCuentaParams;
import com.exito.app.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.app.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.exito.app.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;


/**
 * Para mas informacion:
 * @see TblGherkinJavaDoc#CLASE
 */
public enum RegistroCuentaTblGherkin implements ITablaGherkin<RegistroCuentaParams>
{
    NOMBRES("nombres_registro"),
    APELLIDOS("apellidos_registro"),
    TIPO_DOCUMENTO("tipo_documento_registro"),
    DOCUMENTO("documento_registro"),
    FECHA_NACIMIENTO("fecha_nacimiento_registro"),
    CELULAR("celular_registro"),
    CORREO("correo_registro"),
    TERMINOS("terminos_registro"),
    POLITICAS("politicas_registro"),
    ;

    private final String columna;

    RegistroCuentaTblGherkin(String columna)
    {
        this.columna = columna;
    }

    @Override
    public RegistroCuentaParams crearScreen(TablaGherkinUtil deLaTablaGherkin)
    {
        RegistroCuentaParams parametros = RegistroCuentaParams.crearParams(
            deLaTablaGherkin.obtener(NOMBRES),
            deLaTablaGherkin.obtener(APELLIDOS),
            deLaTablaGherkin.obtener(TIPO_DOCUMENTO),
            deLaTablaGherkin.obtener(DOCUMENTO),
            deLaTablaGherkin.obtener(FECHA_NACIMIENTO),
            deLaTablaGherkin.obtener(CELULAR),
            deLaTablaGherkin.obtener(CORREO),
            deLaTablaGherkin.obtener(TERMINOS),
            deLaTablaGherkin.obtener(POLITICAS)
        );

        Protagonista.principal().getLibreto().setParametrosRegistroCuenta(parametros);

        return parametros;
    }

    @Override
    public String getColumna() {
        return columna;
    }
}
