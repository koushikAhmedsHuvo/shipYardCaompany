/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Y2021Controller implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private Button showButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showButtonOnClick(ActionEvent event) {
         ObservableList <PieChart.Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Total Earn",55),
            new PieChart.Data("Production Cost",25),
            new PieChart.Data("Transport Cost",5),
            new PieChart.Data("Employee Cost",10),
            new PieChart.Data("Inventory Cost",5)
        );
        //ObservableList <PieChart.Data> list2 = FXCollections.observableArrayList();
        //list2.add(new PieChart.Data("Java",50));
        //...
        pieChart.setData(list);
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("revenue.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
    }
    
}
