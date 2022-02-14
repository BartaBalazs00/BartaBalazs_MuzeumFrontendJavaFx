package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Painting;
import com.example.muzeumfrontendjavafx.Statue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML
    public TableView<Statue> szobrokTable;
    @FXML
    public TableColumn<Statue, String> colPerson;
    @FXML
    public TableColumn<Statue, Integer> colHeight;
    @FXML
    public TableColumn<Statue, Integer> colPrice;
    @FXML
    public TableView<Painting> festmenyekTable;
    @FXML
    public TableColumn<Painting, String> colTitle;
    @FXML
    public TableColumn<Painting, Integer> colYear;
    @FXML
    public TableColumn<Painting, Boolean> colOnDisplay;

    public void initialize(){
        colPerson.setCellValueFactory(new PropertyValueFactory<>("person"));
        colHeight.setCellValueFactory(new PropertyValueFactory<>("height"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colOnDisplay.setCellValueFactory(new PropertyValueFactory<>("onDisplay"));

    }
    public void onSzoborHozzaadButtonClick(ActionEvent actionEvent) {
    }

    public void onSzoborModositasButtonClick(ActionEvent actionEvent) {
    }

    public void onSzoborTorlesButtonClick(ActionEvent actionEvent) {
    }

    public void onFestmenyHozzaadasButtonClick(ActionEvent actionEvent) {
    }

    public void onFestmenyModositasButtonClick(ActionEvent actionEvent) {
    }

    public void onFestmenyTorlesButtonClick(ActionEvent actionEvent) {
    }
}