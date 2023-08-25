package com.exito.app.test.automation.e2e.utils.userinterfaces.app.interfaces;

import com.exito.app.test.automation.e2e.userinterfaces.javadoc.app.UIJavaDoc;
import com.exito.app.test.automation.e2e.utils.driver.app.plataformas.AppPlatformUtil;
import com.exito.app.test.automation.e2e.utils.parametros.ParamsUtil;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public interface IUserInterface {

    /**
     * Para mas informacion:
     * @see UIJavaDoc#TARGET
     */
    default Target getTarget(String ... parametros)
    {
        String nombreTmp = ParamsUtil.procesarParametros(this.getNombre(),parametros);;
        String xpathAndroidTmp = ParamsUtil.procesarParametros(this.getXpathAndroid(),parametros);
        String xpathIOSTmp = ParamsUtil.procesarParametros(this.getXpathIOS(),parametros);

        return Target.the(nombreTmp)
            .locatedForAndroid(By.xpath(xpathAndroidTmp))
            .locatedForIOS(By.xpath(xpathIOSTmp));
    }

    default String getXpath(String ... parametros)
    {
        return AppPlatformUtil.isPlatformAndroid()
            ? this.getXpathAndroid()
            : this.getXpathIOS()
        ;

    }

    /**
     * Para mas informacion:
     * @see UIJavaDoc#XPATH_IOS
     */
    String getXpathIOS();

    /**
     * Para mas informacion:
     * @see UIJavaDoc#XPATH_ANDROID
     */
    String getXpathAndroid();

    /**
     * Para mas informacion:
     * @see UIJavaDoc#NOMBRE
     */
    String getNombre();
}
