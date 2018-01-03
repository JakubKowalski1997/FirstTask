package com.jaksiemasz.gui;

import com.jaksiemasz.employee.*;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddNewEmployeeController implements Initializable{

    @FXML
    public ChoiceBox<IMenager> chooseMenager;

    @FXML
    public ChoiceBox<EEmployeeRole> chooseRole;

    @FXML
    public ChoiceBox<Sex> chooseSex;

    @FXML
    public Button buttonAdd;

    @FXML
    public Button buttonClear;

    @FXML
    public TextField getNameField;

    @FXML
    public TextField getEmployeeLimitField;

    @FXML
    public TextField getEmailField;

    @FXML
    public TextField getOriginCountryField;

    @FXML
    public TextField getUniversityField;



    public AddNewEmployeeController() {

    }

    private List<IMenager> listOfFreeMenagers = new ArrayList<>();
    private List<IMenager> listOfMenagers = new ArrayList<>();
    private List<IEmployee> listOfDevelopers = new ArrayList<>();


    int whichMenager = 0;
    int whichDeveloper = 0;


    public void handleButtonClickAddNewEmp(){
        if(chooseRole.getSelectionModel().getSelectedItem() == EEmployeeRole.Manager) {
            listOfMenagers.add(new TeamMenager.TeamManagerBuilder().name(getNameField.getText()).role(EEmployeeRole.Manager).setLimitOfEmployees(2).build());
            chooseMenager.getItems().add(listOfMenagers.get(whichMenager));
            chooseMenager.getSelectionModel().getSelectedItem().hire(listOfMenagers.get(whichMenager));
            //Controller.treeOfEmployees.getRoot().getChildren().add(new TeamMenager.TeamManagerBuilder().name(getNameField.getText()).role(EEmployeeRole.Manager).setLimitOfEmployees(2).build());
            whichMenager++;
        }else{
            listOfDevelopers.add(new Developer.DeveloperBuilder().name(getNameField.getText()).role(chooseRole.getSelectionModel().getSelectedItem()).build());
            chooseMenager.getSelectionModel().getSelectedItem().hire(listOfDevelopers.get(whichDeveloper));
            //Controller.setTreeItem(listOfDevelopers.get(whichDeveloper));
            whichDeveloper++;
        }


        if(!chooseMenager.getSelectionModel().getSelectedItem().canHire()){
            chooseMenager.getItems().remove(chooseMenager.getSelectionModel().getSelectedItem());
            chooseMenager.getSelectionModel().selectFirst();
        }

        AlertBox.display("New Employee!!!", "You have just added a new employee!!!");

        handleButtonClear();
    }

    public void handleButtonClear(){
        getNameField.setText("");
        getEmailField.setText("");
        getUniversityField.setText("");
        getOriginCountryField.setText("");
        getEmployeeLimitField.setText("");
        buttonAdd.setDisable(true);
        buttonClear.setDisable(true);
    }


    public void handleNoInfo(){
        boolean disableButton = getNameField.getText().isEmpty() || getNameField.getText().trim().isEmpty() ||
                getEmailField.getText().isEmpty() || getEmailField.getText().trim().isEmpty() ||
                getOriginCountryField.getText().isEmpty() || getOriginCountryField.getText().trim().isEmpty() ||
                getUniversityField.getText().isEmpty() || getUniversityField.getText().trim().isEmpty();
        if(chooseMenager.getSelectionModel().isEmpty()){
            AlertBox.display("Menagers lack", "You have no more menagers :(");
            disableButton = true;
        }

        if (!getNameField.getText().matches("[a-z A-Z]+")) {
            disableButton = true;
        }

        if(!getEmailField.getText().contains("@")){
            disableButton = true;
        }
        buttonAdd.setDisable(disableButton);
        buttonClear.setDisable(disableButton);
    }
    // Trzeba gdzieś zapisywać te listy z wolnymi menagerami itd


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        chooseMenager.getItems().add(Controller.ceo);
        chooseMenager.getSelectionModel().selectFirst();

        chooseRole.getItems().addAll(EEmployeeRole.Developer, EEmployeeRole.Manager, EEmployeeRole.Contributor, EEmployeeRole.TeamLeader, EEmployeeRole.Tester);
        chooseRole.getSelectionModel().selectFirst();

        chooseSex.getItems().addAll(Sex.MALE, Sex.FEMALE);
        chooseSex.getSelectionModel().selectFirst();

        buttonAdd.setDisable(true);
        buttonClear.setDisable(true);

        // mozna stworzyc funkcje ktora fikcyjnie zrobi sobie taki tree view jaki bym chcial
    }


}


