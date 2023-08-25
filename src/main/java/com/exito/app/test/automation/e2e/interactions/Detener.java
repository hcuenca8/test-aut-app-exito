package com.exito.app.test.automation.e2e.interactions;


import com.exito.app.test.automation.e2e.utils.tiempo.constants.enums.UnidadTiempo;
import com.exito.app.test.automation.e2e.utils.tiempo.utils.EsperaUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Detener
{
    private long tiempo;

    private Detener(long tiempo)
    {
        this.tiempo = tiempo;
    }

    private class DetenerPor implements Interaction
    {
        private long milisegundos;
        private UnidadTiempo unidad;

        private DetenerPor(long milisegundos, UnidadTiempo unidad){
            this.milisegundos = milisegundos;
            this.unidad = unidad;
        }

        @Override
        public <T extends Actor> void performAs(T actor)
        {
            EsperaUtil.detenerPor(this.milisegundos,this.unidad);
        }
    }

    public static Detener por(long tiempo)
    {
        return new Detener(tiempo);
    }

    public DetenerPor segundos()
    {
        return new DetenerPor(this.tiempo,UnidadTiempo.SEGUNDOS);
    }

    public DetenerPor minutos()
    {
        return new DetenerPor(this.tiempo,UnidadTiempo.MINUTOS);
    }

    public DetenerPor milisegundos()
    {
        return new DetenerPor(this.tiempo,UnidadTiempo.MILISEGUNDOS);
    }

}
