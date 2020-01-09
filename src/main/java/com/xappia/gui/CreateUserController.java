/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xappia.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.xappia.entities.Usuario;
import com.xappia.hibernate.util.HibernateUtil;
import com.xappia.repositories.UsuarioR;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XAPPIA
 */
public class CreateUserController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private TextField nameTxt;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField passTxt;
    @FXML
    private TextField confirmPassTxt;
    @FXML
    private Button signUpButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Label checkPassLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource()==signUpButton)signUp();
    }

    @FXML
    private boolean checkPass() {
        boolean result;
        if (!(passTxt.getText().equals(confirmPassTxt.getText()))){
            checkPassLabel.setText("Passwords don't match");
            //System.out.println(passTxt.getText() + "   " + confirmPassTxt.getText());
            System.out.println(passTxt.getText());
            System.out.println(confirmPassTxt.getText());
            result= false;
        }else{
            checkPassLabel.setText("");
            System.out.println(passTxt.getText() + "   " + confirmPassTxt.getText());
            result=true;
        }
        return result;
    }

    @FXML
    private void signUp() {
        boolean validator=checkPass();
        System.out.println(validator);
        if (validator==true) {
            Main.sf= HibernateUtil.getSessionFactory();
            Main.session=Main.sf.openSession();
            UsuarioR ur= new UsuarioR(Main.session);
            Usuario user= new Usuario();
            user.setNombre(nameTxt.getText());
            user.setApellido(lastNameTxt.getText());
            user.setEmail(emailTxt.getText());
            user.setPassword(passTxt.getText());
            ur.save(user);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create new user");
            alert.setHeaderText(null);
            alert.setContentText("User created succesfully!");

            alert.showAndWait();

            Main.session.close();
            Main.sf.close();


        }


    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent createUserParent= FXMLLoader.load(getClass().getResource("/fxml/LogIn.fxml"));
        Scene createUserScene= new Scene(createUserParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(createUserScene);
        window.setTitle("Log In");
        window.show();
    }


}
