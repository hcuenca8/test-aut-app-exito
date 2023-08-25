
package com.exito.app.test.automation.e2e.models.tecnicos;

import com.exito.app.test.automation.e2e.utils.driver.app.AppDriverUtil;
import com.exito.app.test.automation.e2e.utils.trazas.TrazaUtil;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

@Builder
@Data
public class Coordenada
{
    private Point punto;

    /**
     * Interpreta las coordenadas en terminos de porcentajes,
     * la interseccion del Plano [0,0], se ubica en la esquina superior izquierda del dispositivo
     * x,y solo toman valores positivos (+Z), y se expresan en terminos de porcentajes
     * @param ejeX punto en el eje x, su valor esta en terminos del porcentaje de ancho de la pantalla/screen del
     *             dispositivo
     * @param ejeY punto en el eje y, su valor esta en terminos del porcentaje de alto de la pantalla/screen del
     *             dispositivo
     * @return Coordenada objeto que describe el punto en el plano x,y a traves de PointOption
     */
    public static Coordenada crearCoordenada(int ejeX, int ejeY)
    {
        if(ejeX>100 || ejeX<0 || ejeY>100 || ejeY<0)
        {
            throw new UnsupportedOperationException(
                    "las coordenadas de ejeX o ejeY deben estar en funcion del porcentaje (0-100) de ancho/alto de la pantalla/screen del dispositivo"
            );
        }

        Dimension dimension = AppDriverUtil.getDriverAppium(OnStage.theActorInTheSpotlight()).manage().window().getSize();
        TrazaUtil.informacion("DIMENSION PANTALLA: {0},{1}", dimension.getWidth(), dimension.getHeight());

        TrazaUtil.informacion("COORDENADA %: {0},{1}", ejeX, ejeY);

        int totalAncho = dimension.getWidth()-10;
        int totalAlto = dimension.getHeight();

        ejeX = totalAncho*ejeX/100;
        ejeY = totalAlto*ejeY/100;

        TrazaUtil.informacion("REALMENTE: {0},{1}", ejeX, ejeY);

        return Coordenada.builder()
                .punto(new Point(ejeX,ejeY))
                .build();
    }
}
