package com.exito.app.test.automation.e2e.models.params.features.cuenta.registro;

import com.exito.app.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import com.exito.app.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;
import com.exito.app.test.automation.e2e.utils.models.params.interfaces.IParam;
import lombok.Builder;
import lombok.Data;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class RegistroCuentaParams implements IParam
{

    private String nombres;

    private String apellidos;

    private String tipoDocumento;

    private String documento;

    private String fechaNacimiento;

    private String diaNacimiento;

    private String mesNacimiento;

    private String anyoNacimiento;

    private String celular;

    private String correo;

    private Boolean terminos;

    private Boolean politicas;

    private static final String ACEPTO_CONDICIONES = "S";

    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static RegistroCuentaParams crearParams(String nombres, String apellidos, String tipoDocumento, String documento, String fechaNacimiento, String celular, String correo, String terminos, String politicas )
    {
        RegistroCuentaParamsBuilder builder = RegistroCuentaParams.builder()
            .nombres(nombres)
            .apellidos(apellidos)
            .tipoDocumento(tipoDocumento)
            .documento(documento)
            .fechaNacimiento(fechaNacimiento)
            .celular(celular)
            .correo(correo)
            .terminos(TablaGherkinUtil.campoNull(terminos)?null:ACEPTO_CONDICIONES.equalsIgnoreCase(terminos))
            .politicas(TablaGherkinUtil.campoNull(terminos)?null:ACEPTO_CONDICIONES.equalsIgnoreCase(politicas));

        if(fechaNacimiento.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
            String[] arrFechaNacimiento = fechaNacimiento.split("/");

            builder
                .diaNacimiento(arrFechaNacimiento[0])
                .mesNacimiento(arrFechaNacimiento[1])
                .anyoNacimiento(arrFechaNacimiento[2]);
        }

        return builder.build();
    }
}
