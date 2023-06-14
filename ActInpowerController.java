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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ActInpowerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eliminatedEmployeeButtonOnClick(ActionEvent event) throws IOException {
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("employeeCatagory.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
    }

    @FXML
    private void appointedEmployeeButtonOnClick(ActionEvent event) throws IOException {
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("employeeCatagory.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
    }

    @FXML
    private void noticeButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void promotionEmployeeButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void meetingButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("meeting.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show();
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
