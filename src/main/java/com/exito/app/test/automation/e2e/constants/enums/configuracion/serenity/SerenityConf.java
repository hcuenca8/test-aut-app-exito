package com.exito.app.test.automation.e2e.constants.enums.configuracion.serenity;


import com.exito.app.test.automation.e2e.utils.serenity.conf.SerenityConfUtil;

public enum SerenityConf implements SerenityConfUtil.ISerenityConf
{

    APPIUM_HUB("appium.hub"),
    APPIUM_PLATFORM_NAME("appium.platformName"),
    APPIUM_APP_PACKAGE("appium.appPackage"),

    URL_BASE("webdriver.base.url"),
    ;

    private final String propiedad;

    SerenityConf(String propiedad)
    {
        this.propiedad = propiedad;
    }

    @Override
    public String getPropiedad()
    {
        return this.propiedad;
    }

}
