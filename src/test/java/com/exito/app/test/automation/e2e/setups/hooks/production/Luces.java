package com.exito.app.test.automation.e2e.setups.hooks.production;

import com.exito.app.test.automation.e2e.constants.enums.configuracion.system.SystemProperties;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValue;
import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Luces implements BeforeAWebdriverScenario {

    private static final String ID_VARIABLE = "VARIABLE";
    private static final String INI_VARIABLE = "#{";
    private static final String FIN_VARIABLE = "}";
    private static final String RGX_INI_VARIABLE_ESC = Pattern.quote(INI_VARIABLE);
    private static final String RGX_FIN_VARIABLE_ESC = Pattern.quote(FIN_VARIABLE);
    private static final String FRM_VARIABLE = RGX_INI_VARIABLE_ESC +ID_VARIABLE+ RGX_FIN_VARIABLE_ESC;
    private static final String RGX_LIMPIAR_VALOR = "\"";
    private static final String RGX_CAPABILITY = "([^" + FIN_VARIABLE + "]+)";
    private static final String PREFIJO_CAPABILITIY_APPIUM = "appium.";
    private static final SimpleDateFormat FRM_HORA_RODAJE = new SimpleDateFormat("yy/MM/dd-HH:mm:ss ");

    @Override
    public boolean isActivated(EnvironmentVariables environmentVariables) {
        return BeforeAWebdriverScenario.super.isActivated(environmentVariables);
    }

    @Override
    public MutableCapabilities apply(EnvironmentVariables environmentVariables, SupportedWebDriver driver, TestOutcome testOutcome, MutableCapabilities capabilities)
    {
        this.prepararNombreLanzamiento(capabilities);
        this.reasignarDispositivo(environmentVariables,capabilities);
        this.prepararNombreEscenario(testOutcome,capabilities);

        System.err.println("------ CAPABILITIES ------ ");
        for (Map.Entry<String, Object> entry : capabilities.asMap().entrySet()) {
            System.err.println(entry.getValue().getClass().getSimpleName()+": "+entry.getKey() + " : " + entry.getValue().toString());
        }

        return capabilities;
    }

    private void prepararNombreLanzamiento(MutableCapabilities capabilities)
    {
        capabilities.setCapability("build",
            FRM_HORA_RODAJE.format(new Date(Long.valueOf(SystemProperties.CURRENT_TIME_MILLIS_DEPLOY.getValor())))
                +   capabilities.getCapability("build")
        );
    }

    private void prepararNombreEscenario(TestOutcome testOutcome, MutableCapabilities capabilities)
    {
        boolean conEjemplos = testOutcome.getDataTable()!=null;

        String titulo = (conEjemplos
            ?   "Ej # "+testOutcome.getTestSteps().get(testOutcome.getTestSteps().size()-1).getDescription().replaceAll("\\(\\{.+$",StringUtils.EMPTY)
            :   testOutcome.getTitle()).trim();

        String deviceName = capabilities.getCapability("deviceName").toString();
        String frmDeviceName = "["+deviceName+"] - ";

        if( !titulo.contains(frmDeviceName)    )
        {
            titulo = frmDeviceName+titulo;
            testOutcome.setTitle(titulo);

            if(conEjemplos){
                testOutcome.getTestSteps().get(testOutcome.getTestSteps().size()-1).setDescription(titulo);
            }
        }

        try {
            FieldUtils.writeField(testOutcome, "id", testOutcome.getId()+"-"+deviceName.replaceAll("\\s+","-"), true);
            FieldUtils.writeField(testOutcome, "name", testOutcome.getTitle(), true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        capabilities.setCapability("name",
            //testOutcome.getStoryTitle()+" \\ "+
            testOutcome.getTitle().replace(frmDeviceName,StringUtils.EMPTY)
        );
    }

    private void reasignarDispositivo(EnvironmentVariables environmentVariables, MutableCapabilities capabilities)
    {
        String tomaNumero;

        if( (tomaNumero = SystemProperties.TOMA_NUMERO.getValor())!=null  )
        {
            Config conf = ConfigFactory.parseResources(
                    SystemProperties.URL_PACKAGE_BASE.getValor()
                        +   tomaNumero
                ).resolve();

            capabilities.merge(
                this.procesarCapabilitiesReasignadas(environmentVariables,capabilities,conf)
            );
        }
    }

    private DesiredCapabilities procesarCapabilitiesReasignadas(EnvironmentVariables environmentVariables, MutableCapabilities capabilities, Config conf)
    {
        DesiredCapabilities tomaNumeroCapabilities = new DesiredCapabilities();

        for(    Map.Entry<String, ConfigValue> map : conf.entrySet()    )
        {
            Object valor = map.getValue().unwrapped();

            if(map.getValue().render().contains(INI_VARIABLE))
            {
                valor = resolverCapabilitieDependiente(
                    environmentVariables,
                    capabilities,
                    map.getValue().unwrapped()
                );
            }

            tomaNumeroCapabilities.setCapability(map.getKey(), valor);
        }

        return tomaNumeroCapabilities;
    }

    private Object resolverCapabilitieDependiente(EnvironmentVariables environmentVariables, MutableCapabilities capabilities, Object valor)
    {
        do {
            Matcher m = Pattern.compile(FRM_VARIABLE.replace(ID_VARIABLE, RGX_CAPABILITY))
                .matcher(valor.toString());

            if( m.find()    )
            {
                String capability = m.group(1).replace(PREFIJO_CAPABILITIY_APPIUM, StringUtils.EMPTY);

                Object valorCapability = capabilities.getCapability(capability) == null
                    ? environmentVariables.getProperty(capability)
                    : capabilities.getCapability(capability);

                valor = valor.toString().replaceAll(
                    FRM_VARIABLE.replace(
                        ID_VARIABLE, Pattern.quote(m.group(1))
                    ), valorCapability == null
                        ? StringUtils.SPACE
                        : valorCapability.toString()
                );
            }
        } while (valor.toString().contains(INI_VARIABLE));

        return valor;
    }
}


