package com.insightfullogic.honest_profiler.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import org.picocontainer.MutablePicoContainer;

import java.io.IOException;

public class PicoFXLoader {

    private final MutablePicoContainer pico;

    public PicoFXLoader(MutablePicoContainer pico) {
        this.pico = pico;
    }

    public Parent load(String fxml, Class<?> controllerClass) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        loader.setControllerFactory(pico::getComponent);
        try {
            return loader.load();
        } catch (IOException e) {
            throw new UserInterfaceConfigurationException(e);
        }
    }

}
