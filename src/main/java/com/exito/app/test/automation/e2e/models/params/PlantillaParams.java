package com.exito.app.test.automation.e2e.models.params;

import com.exito.app.test.automation.e2e.utils.models.params.interfaces.IParam;
import com.exito.app.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import lombok.Builder;
import lombok.Data;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class PlantillaParams implements IParam
{

    private String parametro1;

    private String parametro2;

    private boolean parametro3;

    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static PlantillaParams crearParams(String parametro1, String parametro2, String parametro3)
    {
        return PlantillaParams.builder()
                .parametro1(parametro1)
                .parametro2(parametro2)
                .parametro3(parametro3.equalsIgnoreCase("S"))
                .build();
    }
}
