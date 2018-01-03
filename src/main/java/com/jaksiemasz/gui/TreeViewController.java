package com.jaksiemasz.gui;

import com.jaksiemasz.employee.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class TreeViewController{

    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<IEmployee> root = new TreeItem<>(new TeamMenager.TeamManagerBuilder().name("Jakub").role(EEmployeeRole.CEO).build());

        TreeItem<IEmployee> nodeA = new TreeItem<>(new TeamMenager.TeamManagerBuilder().name("Bartek").role(EEmployeeRole.Manager).setSex(Sex.MALE).build());
        TreeItem<IEmployee> nodeB = new TreeItem<>(new Developer.DeveloperBuilder().name("Tomek").role(EEmployeeRole.Developer).build());
        TreeItem<IEmployee> nodeC = new TreeItem<>(new Developer.DeveloperBuilder().name("Jacek").role(EEmployeeRole.Developer).build());
        TreeItem<IEmployee> nodeD = new TreeItem<>(new Developer.DeveloperBuilder().name("Piotrek").role(EEmployeeRole.Developer).build());
        root.getChildren().add(nodeA);
        root.getChildren().add(nodeB);
        root.getChildren().add(nodeC);
        nodeA.getChildren().add(nodeD);
        companyTreeView.setRoot(root);
    }*/

}
