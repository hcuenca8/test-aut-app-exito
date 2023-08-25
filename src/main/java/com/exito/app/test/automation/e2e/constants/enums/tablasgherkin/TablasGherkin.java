package com.exito.app.test.automation.e2e.constants.enums.tablasgherkin;


import com.exito.app.test.automation.e2e.constants.enums.tablasgherkin.features.cuenta.registro.RegistroCuentaTblGherkin;
import com.exito.app.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.exito.app.test.automation.e2e.utils.models.params.interfaces.IParam;

public enum TablasGherkin
{
    REGISTRO_CUENTA(RegistroCuentaTblGherkin.values()),
    ;

    private final ITablaGherkin<? extends IParam>[] tablaGherkin;

    TablasGherkin(ITablaGherkin<? extends IParam>[] tablaGherkin)
    {
        this.tablaGherkin = tablaGherkin;
    }

    public ITablaGherkin<? extends IParam>[] getTablaGherkin() {
        return tablaGherkin;
    }
}
