package com.exito.app.test.automation.e2e.setups.datadefinitions;

import com.exito.app.test.automation.e2e.models.scena.Libreto;
import com.exito.app.test.automation.e2e.models.scena.screenplay.Protagonista;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class LibretoDataDefinition {

    @DataTableType
    public Libreto libreto(Map<String, String> tblGherkin)
    {
        Protagonista.principal().ensayarLibreto(tblGherkin);
        return Protagonista.principal().getLibreto();
    }

}
