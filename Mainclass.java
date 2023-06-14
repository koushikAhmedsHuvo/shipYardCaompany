/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class Mainclass extends Application {
    
    @Override
     public void start(Stage stg) throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource("Login.fxml")
        );
        //Parent root = FXMLLoader.load(getClass().getResource("FileChooserView.fxml"));
        
        Scene scene = new Scene(root);
        
        stg.setTitle("Main Stage");
        stg.setScene(scene);
        stg.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
