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
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EngineerEmployeeController implements Initializable {

    @FXML
    private AnchorPane isbinaryFileChkBox;
    @FXML
    private TableView<Person> TableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, LocalDate> dobColumn;
    @FXML
    private TableColumn<Person, String> userIdColumn;
    @FXML
    private TableColumn<Person, String> genderColumn;
    @FXML
    private TableColumn<Person, String> salaryColumn;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField userIdtextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private CheckBox isTextFileChkBox;
    @FXML
    private TextArea outputTextArea;
     private ToggleGroup tg;
     private ArrayList<Person>perArr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        perArr=new ArrayList<Person>();
        
         tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);    
        maleRadioButton.setSelected(true);
        
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
         userIdColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("id"));
          salaryColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("salary"));
          genderColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("gender"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<Person,LocalDate>("birthday"));
        
        //load dummy data
        TableView.setItems(getPeople());
       
        
        //Allow first and last name to be edittable
        TableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        userIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        salaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //allow the table to select multiple rows at once
        TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // TODO
        
        // TODO
        // TODO
    } 
     public ObservableList<Person> getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();
        
        people.add(new Person("Ahsan", "Habib", LocalDate.of(1998, Month.AUGUST, 12),"123","10000","male"));
        people.add(new Person("Lisa", "Rahman", LocalDate.of(2000, Month.JUNE, 30),"124","20000","male"));
        people.add(new Person("Farid", "Uddin", LocalDate.of(2001, Month.APRIL, 17),"125","30000","male"));
        return people;
        // TODO
    }    

    @FXML
    private void addEmployeeButtonOnClick(ActionEvent event) {
         
             Person newPerson= new Person(firstNameTextField.getText(),
                                       lastNameTextField.getText(),
                                       dobDatePicker.getValue(),
                                         userIdtextField.getText(),
                                         salaryTextField.getText(),
                                        (maleRadioButton.isSelected()?"Male":"Female")
                                        
                       
          
                                    );
        TableView.getItems().add( newPerson);
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        if(!isTextFileChkBox.isSelected() )
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Oops! No fileType Selected. \nCan't save to file.");
            a.showAndWait();
        }
        if(isTextFileChkBox.isSelected()){
            
               perArr.add(
            new Person(  firstNameTextField.getText(),
                                       lastNameTextField.getText(),
                                       dobDatePicker.getValue(),
                                         userIdtextField.getText(),
                                         salaryTextField.getText(),
                                        (maleRadioButton.isSelected()?"Male":"Female")
            )
                   
                   
                     
                    
                  
                   
                    
                    
                );
             
            try {
                //write code to dump studArr in Stud.txt
                //use FileWriter
                File f = new File("EngineerEmployee.txt");
                FileWriter fw;
                //FileWriter fw = new FileWriter(f);
                if(f.exists())
                    fw = new FileWriter(f,true);
                else 
                    fw = new FileWriter(f);
                String str="";
                for(Person s: perArr){
                    
                    //str+= TableView.getItems();
                   str += s.getFirstName()+", "+s.getLastName()+" ,"+s.getBirthday()+","+s.getId()+","+","+
                            s.getGender()+","+s.getSalary()+"\n";
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
        
    }

    @FXML
    private void txtFileButtonOnClick(ActionEvent event) {
         File file = new File("EngineerEmployee.txt");
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
            Logger.getLogger(EngineerEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void binaryFileButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("employeeCatagory.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
    }
    
}
