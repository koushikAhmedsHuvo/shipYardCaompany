/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ProjectListController implements Initializable {

    @FXML
    private TextArea outputTextArea;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private DatePicker delivaryDateDatePicker;
    @FXML
    private DatePicker OderDateDatePicker;
    private ArrayList<project>pro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pro=new ArrayList<project>();
    }    

    @FXML
    private void nameTextFieldMouseButtonOnClick(MouseEvent event) {
        nameTextField.setText(null);
    }

    @FXML
    private void amountTextFieldmouseButtonOnClick(MouseEvent event) {
        amountTextField.setText(null);
    }

    @FXML
    private void svaeInformationButtonOnClick(ActionEvent event) {
             pro.add(
            new project(  nameTextField.getText(),
                                      Integer.parseInt(amountTextField.getText()),
                                      OderDateDatePicker.getValue(),
                                      delivaryDateDatePicker.getValue()
                                     
            )
                   
                   
             
                );
    }

    @FXML
    private void saveTxtFileButtonOnClick(ActionEvent event) {
          try {
                //write code to dump studArr in Stud.txt
                //use FileWriter
                File f = new File("ProjectList.txt");
                FileWriter fw;
                //FileWriter fw = new FileWriter(f);
                if(f.exists())
                    fw = new FileWriter(f,true);
                else 
                    fw = new FileWriter(f);
                String str="";
                for(project s: pro){
                    
                    //str+= TableView.getItems();
                   str += s.getName()+" Project was taken up on "+s.oder_date+" and it should be delivered on "  
                           +s.delivery_date+" and the amount of this project is "+s.getAmount()+"\n";
                            
                    //str += s; 
                    //if toString is overridden to return
                    //return id+","+name+","+cgpa+"\n"
                }
                fw.write(str);
                fw.close();
            } catch (IOException ex) {
                
                //SHOW ex.toString() IN AN ALERT
            }
        
    }

    @FXML
    private void showInformationButtonOnClick(ActionEvent event) {
             File file = new File("ProjectList.txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            outputTextArea.setText(null);
            while(sc.hasNextLine()){
                str=sc.nextLine();
                outputTextArea.appendText(str+"\n");
                //outputTxtArea.appendText("\n");               
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProjectListController.class.getName()).log(Level.SEVERE, null, ex);
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
