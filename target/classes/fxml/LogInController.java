/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.xappia.hibernate.util.HibernateUtil;
import com.xappia.repositories.UsuarioR;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    private MenuItem menuNew;
    @FXML
    private MenuItem menuExit;
    @FXML
    private MenuItem helpAbout;
    @FXML
    private TextField userText;
    @FXML
    private Button logInButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logIn(ActionEvent event) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        UsuarioR ur= new UsuarioR(session);
        if (ur.checkUserPass(userText.getText(),passText.getText())) {
            //Ingresar a vista de carritos con usuario
        }else{
            labelPass.setText("Incorrect Username/Password");
        }
        session.close();
        sf.close();
    }

    @FXML
    private void createNewUser(ActionEvent event){
        //Ingresar a creacion de nuevo usuario
    }



}