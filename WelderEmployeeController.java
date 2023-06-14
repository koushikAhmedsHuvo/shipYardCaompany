/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class WelderEmployeeController implements Initializable {

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, LocalDate> dobColumn;
    @FXML
    private TableColumn<Person, String> userIdcolumn;
    @FXML
    private TableColumn<Person, String> genderColumn;
    @FXML
    private TableColumn<Person, String> salaryColumn;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextfield;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField userIdTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
     private ToggleGroup tg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);    
        maleRadioButton.setSelected(true);
        
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
         userIdcolumn.setCellValueFactory(new PropertyValueFactory<Person,String>("id"));
          salaryColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("salary"));
          genderColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("gender"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<Person,LocalDate>("birthday"));
        
        //load dummy data
        tableView.setItems(getPeople());
       
        
        //Allow first and last name to be edittable
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        userIdcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        salaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // TODO
    }   
     public ObservableList<Person> getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();
        
        people.add(new Person("Shakib", "Khan", LocalDate.of(1998, Month.AUGUST, 12),"123","10000","male"));
        people.add(new Person("Abir", "Rahman", LocalDate.of(2000, Month.JUNE, 30),"124","20000","male"));
        people.add(new Person("Abrar", "Uddin", LocalDate.of(2001, Month.APRIL, 17),"125","30000","male"));
        return people;
    } 

    @FXML
    private void addEmployeeButtonOnClick(ActionEvent event) {
         Person newPerson = new Person(firstNameTextField.getText(),
                                       lastNameTextfield.getText(),
                                       dobDatePicker.getValue(),
                                        userIdTextField.getText(),
                                         salaryTextField.getText(),
                                        (maleRadioButton.isSelected()?"Male":"Female")
                                        
                       
                                       
                                    );
        tableView.getItems().add(newPerson);
    }

    @FXML
    private void backButtonOnclick(ActionEvent event) throws IOException {
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("employeeCatagory.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(scene2);
        window.show(); 
    }
    
}
