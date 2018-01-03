package com.jaksiemasz.gui;

import com.jaksiemasz.company_struct.CompanyFactory;
import com.jaksiemasz.company_struct.PrintEmployees;
import com.jaksiemasz.employee.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller{

    @FXML AddNewEmployeeController addNewEmployeeController;

    public static TeamMenager ceo = new TeamMenager.TeamManagerBuilder().name("Jakub Kowalski").role(EEmployeeRole.CEO).setLimitOfEmployees(2).build();




    public void handleButtonClickAddNewEmplyee() throws IOException {
        if(ceo.canHire()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addNewEmployeeScene.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.getIcons().add(new Image("sphere.png"));
            stage.setResizable(false);
            stage.show();
        }else
        {
            AlertBox.display("No more free menagers","You can't add new employees.");
        }

    }



    @FXML
    public ListView<IEmployee> tableOfEmployees;

    public void handleButtonClickAddNewTask(){
        //CompanyFactory comp1 = new CompanyFactory();
        //comp1.print(2);
        tableOfEmployees.getItems().addAll(ceo.getEmployeeList());

      //  fillStruct(ceo);
    }

    private void fillStruct(TeamMenager menager){
        int i = 0;
        while (menager.canHire()){
            if(menager.getEmployeeList().get(i).getRole() == EEmployeeRole.Manager){
                fillStruct((TeamMenager) menager.getEmployeeList().get(i));
            }else{

            }

            i++;
        }

    }

    @FXML
    public Text reportText;

    public void handleListClick(){
        if(ceo.getEmployeeList().size() != 0) {
            tableOfEmployees.getSelectionModel().getSelectedItem().reportWork().show();
            reportText.setText("to be continued");
        }
    }

    @FXML
    private Button addEmployee;

    @FXML
    private Button addTask;

    DropShadow shadow = new DropShadow();

    public void setShadowaddEmployee() {
        addEmployee.setEffect(shadow);
    }

    public void setNotShadowaddEmployee() {
        addEmployee.setEffect(null);
    }

    public void setShadowaddTask() {
        addTask.setEffect(shadow);
    }

    public void setNotShadowaddTask() {
        addTask.setEffect(null);
    }


    //CO BY NIE ZGUBIC TEGO KURESTWA
    /*

        chooseMenager.getItems().add(ceo);
        chooseMenager.getSelectionModel().selectFirst();

        chooseRole.getItems().addAll(EEmployeeRole.Developer, EEmployeeRole.Manager, EEmployeeRole.Contributor, EEmployeeRole.TeamLeader, EEmployeeRole.Tester);
        chooseRole.getSelectionModel().selectFirst();

        chooseSex.getItems().addAll(Sex.MALE, Sex.FEMALE);
        chooseSex.getSelectionModel().selectFirst();


    List<IMenager> listOfMenagers = new ArrayList<>();
    List<IEmployee> listOfDevelopers = new ArrayList<>();

    int whichDeveloper = 0;
    private int whichMenager = 0;

    if(chooseRole.getSelectionModel().getSelectedItem() == EEmployeeRole.Manager) {
            listOfMenagers.add(new TeamMenager.TeamManagerBuilder().name(getNameField.getText()).role(EEmployeeRole.Manager).setLimitOfEmployees(2).build());
            chooseMenager.getItems().add(listOfMenagers.get(whichMenager));
            chooseMenager.getSelectionModel().getSelectedItem().hire(listOfMenagers.get(whichMenager));
            whichMenager++;
        }else{
            listOfDevelopers.add(new Developer.DeveloperBuilder().name(getNameField.getText()).role(chooseRole.getSelectionModel().getSelectedItem()).build());
            chooseMenager.getSelectionModel().getSelectedItem().hire(listOfDevelopers.get(whichDeveloper));
            whichDeveloper++;
        }

        if(!chooseMenager.getSelectionModel().getSelectedItem().canHire()){
            chooseMenager.getItems().remove(chooseMenager.getSelectionModel().getSelectedItem());
            chooseMenager.getSelectionModel().selectFirst();
        }*/
}



