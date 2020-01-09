package com.xappia.gui;

import com.xappia.hibernate.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main extends Application {

    public static SessionFactory sf;
    public static Session session;

    public static void main(String[] args) {
        launch(args);
    }




    public void start(Stage primaryStage) throws Exception{
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try {
            primaryStage.setResizable(false);
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LogIn.fxml").toURI().toURL());
            Scene logIn= new Scene(root);
            primaryStage.setScene(logIn);
            primaryStage.setTitle("Log In");
            primaryStage.show();
        } finally {
            sf.close();
        }



    }
}
