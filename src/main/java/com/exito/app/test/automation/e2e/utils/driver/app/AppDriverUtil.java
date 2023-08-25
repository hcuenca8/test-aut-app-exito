package com.exito.app.test.automation.e2e.utils.driver.app;


import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.AppPlatformUtil;
import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.DriverAndroidUtil;
import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.DriverIOSUtil;
import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.interfaces.IAppDriverPlatform;
import com.exito.app.test.automation.e2e.utils.driver.web.WebDriverUtil;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class AppDriverUtil
{
    private AppDriverUtil(){
        throw new UnsupportedOperationException();
    }

    public static AppiumDriver getDriverAppium(Actor actor)
    {
        return (AppiumDriver) WebDriverUtil.getDriverProxy(actor);
    }

    public static AppiumDriver getDriverAppium()
    {
        return (AppiumDriver) WebDriverUtil.getDriverProxy(OnStage.theActorInTheSpotlight());
    }

    public static IAppDriverPlatform getDriverPlatform()
    {
        return AppPlatformUtil.isPlatformAndroid()
            ? DriverAndroidUtil.getInstance(AppDriverUtil.getDriverAppium())
            : DriverIOSUtil.getInstance(AppDriverUtil.getDriverAppium())
        ;
    }

    public static IAppDriverPlatform getDriverPlatform(Actor actor)
    {
        return AppPlatformUtil.isPlatformAndroid()
            ? DriverAndroidUtil.getInstance(AppDriverUtil.getDriverAppium(actor))
            : DriverIOSUtil.getInstance(AppDriverUtil.getDriverAppium())
            ;
    }

}
