package com.exito.app.test.automation.e2e.models.tecnicos;

import com.exito.app.test.automation.e2e.utils.trazas.TrazaUtil;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Desplazamiento
{

    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;

    public static final Desplazamiento DESLIZA_ADELANTE = Desplazamiento.crearDesplazamiento(
            Coordenada.crearCoordenada(90,50),
            Coordenada.crearCoordenada(10,50)
    );
    public static final Desplazamiento DESLIZA_ATRAS = Desplazamiento.crearDesplazamiento(
            Coordenada.crearCoordenada(10,50),
            Coordenada.crearCoordenada(90,50)
    );

    public static final Desplazamiento DESLIZA_ARRIBA_MEDIA_PAGINA = Desplazamiento.crearDesplazamiento(
            Coordenada.crearCoordenada(50,50),
            Coordenada.crearCoordenada(50,10)
    );

    public static final Desplazamiento DESLIZA_ARRIBA_NUEVA_PAGINA = Desplazamiento.crearDesplazamiento(
        Coordenada.crearCoordenada(50,80),//90
        Coordenada.crearCoordenada(50,10)
    );

    public static Desplazamiento crearDesplazamiento(Coordenada coordenadaOrigen, Coordenada coordenadaDestino)
    {
        TrazaUtil.informacion("DESPLAZAMIENTO: {0} - {1}", coordenadaOrigen.getPunto().toString(), coordenadaDestino.getPunto().toString());
        return Desplazamiento.builder()
                .coordenadaOrigen(coordenadaOrigen)
                .coordenadaDestino(coordenadaDestino)
                .build();
    }
}
