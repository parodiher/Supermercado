package com.xappia.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    Scene logIn,carritos,productos;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/fxml/LogIn.fxml"));
        logIn= new Scene(root);
        primaryStage.setScene(logIn);
        primaryStage.show();

    }
}
