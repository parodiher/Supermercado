/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xappia.gui;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import com.xappia.hibernate.util.HibernateUtil;
import com.xappia.repositories.UsuarioR;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * FXML Controller class
 *
 * @author XAPPIA
 */
/**
 * FXML Controller class
 *
 * @author XAPPIA
 */
public class LogInController implements Initializable {

    @FXML
    private PasswordField passText;
    @FXML
    private Label labelPass;
    @FXML
    private TextField userText;
    @FXML
    private Button logInButton;
    @FXML
    private MenuItem menuAbout;
    @FXML
    private MenuItem menuRemove;
    @FXML
    private MenuItem menuExit;
    @FXML
    private Button registerButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session session;


    // Login button
    @FXML
    private void logIn(ActionEvent event) throws IOException{

        String user=userText.getText();
        String pass=passText.getText();
        Main.sf=HibernateUtil.getSessionFactory();
        Main.session=sf.openSession();
        UsuarioR ur= new UsuarioR(com.xappia.gui.Main.session);
        String check=ur.checkUserPass(user,pass);
        if (check=="true") {
            System.out.println("Nice, falta crear la vista principal");
        }else{
            labelPass.setText("Incorrect Username/Password");
        }

        System.out.println(user);
        System.out.println(pass);
        Main.session.close();
        Main.sf.close();

    }

    //Open user removal window
    @FXML
    private void goRemove(ActionEvent event) {
    }

    //Exit program
    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    // Visit xappia website
    @FXML
    private void goXappia(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("http://www.xappia.com"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    //Open user creation window
    @FXML
    private void goRegister(ActionEvent event) throws Exception,IOException {
        Parent createUserParent= FXMLLoader.load(getClass().getResource("/fxml/CreateUser.fxml"));
        Scene createUserScene= new Scene(createUserParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(createUserScene);
        window.setTitle("Sign Up");
        window.show();
    }





}