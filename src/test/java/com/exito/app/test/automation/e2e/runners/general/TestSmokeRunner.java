package com.exito.app.test.automation.e2e.runners.general;


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
        features = RunnerConstants.PACKAGE_FEATURES,
        glue = {RunnerConstants.PACKAGE_STEP_DEFINITIONS,RunnerConstants.PACKAGE_DATA_DEFINITIONS,RunnerConstants.PACKAGE_SETUPS},
        tags = "@Smoke",
        dryRun = false
)
public class TestSmokeRunner
{
    /**
     * Para mas informacion:
     * @see RunnersJavaDoc#CONSTRUCTOR
     */
    private TestSmokeRunner()
    {
        GeneralUtil.noPermitaInstanciar();
    }
}
