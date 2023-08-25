package com.exito.app.test.automation.e2e.utils.tiempo.constants.enums;

public enum UnidadTiempo {

    SEGUNDOS(1000L),
    MINUTOS(1000L*60),
    MILISEGUNDOS(1L),
    ;

    private final long escalaMilisegundos;

    UnidadTiempo(long escalaMilisegundos){
        this.escalaMilisegundos = escalaMilisegundos;
    }

    public long getEscalaMilisegundos(){
        return this.escalaMilisegundos;
    }

}
