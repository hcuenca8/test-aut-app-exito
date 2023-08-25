package com.exito.app.test.automation.e2e.runners.features.inicio.publicidad;

import com.exito.app.test.automation.e2e.runners.RunnerConstants;
import com.exito.app.test.automation.e2e.runners.javadoc.RunnersJavaDoc;
import com.exito.app.test.automation.e2e.utils.GeneralUtil;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


/**
 * Para mas informacion:
 * @see RunnersJavaDoc#CLASE
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    features = RunnerConstants.PACKAGE_FEATURES+"/inicio/publicidad/publicidad_inicial.feature",
    glue = {RunnerConstants.PACKAGE_STEP_DEFINITIONS,RunnerConstants.PACKAGE_SETUPS},
    tags = "@PublicidadInicial",
    dryRun = false //Desactive, despues de comprobar la existencia/relacion entre enunciado gherkin y StepDefinition
)
public class TestPublicidadInicialRunner
{
    /**
     * Para mas informacion:
     * @see RunnersJavaDoc#CONSTRUCTOR
     */
    private TestPublicidadInicialRunner()
    {
        GeneralUtil.noPermitaInstanciar();
    }
}
