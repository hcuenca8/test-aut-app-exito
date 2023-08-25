package com.exito.app.test.automation.e2e.utils.driver.app.plataformas.interfaces;

import com.exito.app.test.automation.e2e.constants.enums.configuracion.contexts.Contextos;
import com.exito.app.test.automation.e2e.utils.GeneralUtil;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Set;

public interface IAppDriverPlatform {

    String CONTEXT_WEBVIEW = "WEBVIEW";

    default void reset(){
        GeneralUtil.operacionNoSoportada();
    }

    default Set<String> getContextHandles(){
        GeneralUtil.operacionNoSoportada();
        return null;
    }

    default WebDriver context(String context){
        GeneralUtil.operacionNoSoportada();
        return null;
    }

    default String getContext(){
        GeneralUtil.operacionNoSoportada();
        return null;
    }

    default WebDriver toContext(Contextos contexto){
        GeneralUtil.operacionNoSoportada();
        return null;
    }

    default String getCurrentPackage(){
        GeneralUtil.operacionNoSoportada();
        return null;
    }

    default void runAppInBackground(Duration duracion){
        GeneralUtil.operacionNoSoportada();
    }

    default String getCurrentUrl(){
        GeneralUtil.operacionNoSoportada();
        return null;
    }
}
