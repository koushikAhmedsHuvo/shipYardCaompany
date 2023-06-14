/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private PasswordField passTextField;
    @FXML
    private Label wrong;
    @FXML
    private ComboBox<String> dessigComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         dessigComboBox.getItems().addAll(
                "Director","Manager"
        );
        // TODO
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
          if(idTextField.getText().equals("2022552")==true && passTextField.getText().equals("123")==true){
              if(dessigComboBox.getValue().equals("Director")==true){
            
           Parent scene2Parent = FXMLLoader.load(getClass().getResource("director.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
        }
             else if(dessigComboBox.getValue().equals("Manager")==true){
            
           Parent scene2Parent = FXMLLoader.load(getClass().getResource("manager.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
        }
        
        
    }
          else{
            wrong.setText("Wrong userid or password please try again!!");
            idTextField.clear();
            passTextField.clear();
       }
    }
    
}
