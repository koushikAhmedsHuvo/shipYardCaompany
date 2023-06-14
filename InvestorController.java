/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InvestorController implements Initializable {

    @FXML
    private TextArea outputTextArea;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private TextField perTextField;
    private ArrayList<investor>inv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inv=new ArrayList<investor>();
        // TODO
    }    

    @FXML
    private void nameMouseOnClick(MouseEvent event) {
         nameTextField.setText(null);
    }

    @FXML
    private void amountMouseOnClick(MouseEvent event) {
         amountTextField.setText(null);
    }

    @FXML
    private void perMouseOnClick(MouseEvent event) {
        perTextField.setText(null);
    }

    @FXML
    private void saveInformationButtonOnClick(ActionEvent event) {
          inv.add(
            new investor(  
                   
                    nameTextField.getText(),
                    Integer.parseInt(amountTextField.getText()),
                    Float.parseFloat( perTextField.getText())  
                )
        );
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

    @FXML
    private void showInformationButtonOnClick(ActionEvent event) {
         ObjectInputStream ois=null;
         try {
             investor s;
             //FileInputStream fis = new FileInputStream("stud2.bin");
             //ois = new ObjectInputStream(fis);
             ois = new ObjectInputStream(new FileInputStream("InvObjects.bin"));
             
             outputTextArea.setText(null);
            
            //int[] arr={1,2,3};
            //System.out.println(arr[3]);
            while(true){
                s = (investor) ois.readObject();
                //studArr.add((Student) ois.readObject());
                outputTextArea.appendText(s.toString()+"\n");
                //outputTxtArea.appendText(s+"\n");
            }
             } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    }

    @FXML
    private void saveAsBinaryButtonOnClick(ActionEvent event) {
         try{
                FileOutputStream fos = new FileOutputStream("InvData.bin", true);
                DataOutputStream dos = new DataOutputStream(fos);
                for(investor s: inv){
                     dos.writeUTF(s.getName());
                    dos.writeInt(s.getAmount());
                   
                    dos.writeFloat(s.getPer());
                }
                dos.close();
            }
            catch(Exception e){
                //SHOW e.toString() IN AN ALERT
            } 
           try{
                FileOutputStream fos = new FileOutputStream("InvObjects.bin",true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for(investor s: inv)
                    oos.writeObject(s);
                oos.close();
            }
            catch(Exception e){
                //SHOW e.toString() IN AN ALERT
            }
    }
    
}
