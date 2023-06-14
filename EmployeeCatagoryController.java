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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EmployeeCatagoryController implements Initializable {

    @FXML
    private ComboBox<String> selectDeptComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         selectDeptComboBox.getItems().addAll(
                "Manager","Welder","It Officer",
                "Engineer"
        );
        // TODO
    }    

    @FXML
    private void serchButtonOnClick(ActionEvent event) throws IOException {
        if(selectDeptComboBox.getValue().equals("Manager")==true){
            
           Parent scene2Parent = FXMLLoader.load(getClass().getResource("managerEmployee.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
        }
             else if(selectDeptComboBox.getValue().equals("Welder")==true){
            
           Parent scene2Parent = FXMLLoader.load(getClass().getResource("welderEmployee.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
        }
        
         else if(selectDeptComboBox.getValue().equals("Engineer")==true){
            
           Parent scene2Parent = FXMLLoader.load(getClass().getResource("engineerEmployee.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
        }
        
                 else if(selectDeptComboBox.getValue().equals("It Officer")==true){
            
           Parent scene2Parent = FXMLLoader.load(getClass().getResource("itOfficerEmployee.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
        }
       
        
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("director.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show();
            
        
    }
    
}
