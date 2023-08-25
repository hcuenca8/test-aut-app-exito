package com.exito.app.test.automation.e2e.constants.enums.tablasgherkin.javadoc;

import com.exito.app.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import com.exito.app.test.automation.e2e.constants.enums.tablasgherkin.TablasGherkin;
import com.exito.app.test.automation.e2e.utils.GeneralUtil;

/**
 * Clase que centraliza la documentacion asociada al concepto de parametros como objetos en los enunciados gherkin (Tabla Gherkin), dentro de la arquitectura
 */
public class TblGherkinJavaDoc {

    /**
     * Clase que describe la configuracion de una tabla gherkin (tabla de parametros, en los enunciados gherkin),
     * NO OLVIDE REGISTRAR ESTA CLASE EN EL LISTADO DE TABLAS GHERKIN, PARA HABILITAR SU USO
     * @see TablasGherkin
     */
    public static final String CLASE = null;

    /**
     * Metodo que utiliza la configuracion de la tabla gherkin descrita, para crear el objeto de parametros (params)
     * respectivo a esta tabla
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static final String CREAR_PARAMS = null;

    private TblGherkinJavaDoc()
    {
        GeneralUtil.noPermitaInstanciar();
    }

}
