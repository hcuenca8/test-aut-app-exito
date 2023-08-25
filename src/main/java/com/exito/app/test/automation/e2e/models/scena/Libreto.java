package com.exito.app.test.automation.e2e.models.scena;


import com.exito.app.test.automation.e2e.models.params.PlantillaParams;
import com.exito.app.test.automation.e2e.models.params.features.cuenta.registro.RegistroCuentaParams;
import lombok.Data;

@Data
public class Libreto {

    private PlantillaParams parametrosPlantilla;

    private RegistroCuentaParams parametrosRegistroCuenta;

}

