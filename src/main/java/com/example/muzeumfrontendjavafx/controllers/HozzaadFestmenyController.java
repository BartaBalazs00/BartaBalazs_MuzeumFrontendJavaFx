package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Controller;
import com.example.muzeumfrontendjavafx.Painting;
import com.example.muzeumfrontendjavafx.PaintingApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HozzaadFestmenyController extends Controller {
    @FXML
    private TextField inputTitle;
    @FXML
    private CheckBox inputOnDisplay;
    @FXML
    private Spinner<Integer> inputYear;

    @FXML
    public void onHozzaadasButtonClick(ActionEvent actionEvent) {
        String title = inputTitle.getText().trim();
        boolean onDisplay = inputOnDisplay.isSelected();
        int year;
        if (title.isEmpty()){
            alert("Cím megadása kötelező");
            return;
        }
        try {
            year = inputYear.getValue();
        } catch (NullPointerException ex){
            alert("Az év megadása kötelező");
            return;
        } catch (Exception ex){
            alert("Az év csak -30000 és 2022 közötti szám lehet");
            return;
        }

        try {
            Painting ujFestmeny = new Painting(0, title, year, onDisplay);
            Painting letrehozott = PaintingApi.addPainting(ujFestmeny);
            if (letrehozott != null){
                alert("Sikeres módosítás");
            } else {
                alert("Sikertelen módosítás");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
