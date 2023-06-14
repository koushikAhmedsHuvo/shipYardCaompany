/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RevenueController implements Initializable {

    @FXML
    private BorderPane borderpane;
    @FXML
    private MenuBar chartSceneMenuBar;
    @FXML
    private Button y2021;
    @FXML
    private Button y2020;
    @FXML
    private Button y2019;
    @FXML
    private Button y2018;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            borderpane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void y2021ButtonOnClick(ActionEvent event) {
        loadUI("y2021");
    }

    @FXML
    private void y2020ButtonOnClick(ActionEvent event) {
         loadUI("y2020");
    }

    @FXML
    private void y2019ButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void y2018ButtonOnClick(ActionEvent event) {
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
