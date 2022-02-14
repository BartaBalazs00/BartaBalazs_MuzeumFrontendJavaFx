package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Controller;
import com.example.muzeumfrontendjavafx.Painting;
import com.example.muzeumfrontendjavafx.PaintingApi;
import com.example.muzeumfrontendjavafx.Statue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.IOException;

public class ModositFestmenyController extends Controller {

    @FXML
    private TextField inputTitle;
    @FXML
    private CheckBox inputOnDisplay;
    @FXML
    private Spinner<Integer> inputYear;
    private Painting modositando;
    @FXML
    public void onModositButtonClick(ActionEvent actionEvent) {
        /*String title = inputTitle.getText().trim();
        boolean onDisplay = inputOnDisplay.isSelected();
        int year = inputYear.getValue();
        if (title.isEmpty()){
            alert("Cím megadása kötelező");
            return;
        }
        if (year == null){
            alert("Kategória megadása kötelező");
            return;
        }
        try {
            hossz = inputHossz.getValue();
        } catch (NullPointerException ex){
            alert("A hossz megadása kötelező");
            return;
        } catch (Exception ex){
            alert("A hossz csak 1 és 999 közötti szám lehet");
            return;
        }
        if (hossz < 1 || hossz > 999) {
            alert("A hossz csak 1 és 999 közötti szám lehet");
            return;
        }
        if (ertekelesIndex == -1){
            alert("Értékelés kiválasztása köztelező");
            return;
        }
        int ertekeles = inputErtekeles.getValue();

        modositando.setTitle(title);
        modositando.setYear(year);
        modositando.setOn_display(onDisplay);

        try {
            Painting modositott = PaintingApi.updatePainting(modositando);
            if (modositott != null){
                alertWait("Sikeres módosítás");
                this.stage.close();
            } else {
                alert("Sikertelen módosítás");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    public Painting getModositando() {
        return modositando;
    }

    public void setModositando(Painting modositando) {
        this.modositando = modositando;
        ertekekBeallitasa();
    }

    private void ertekekBeallitasa() {
        inputTitle.setText(modositando.getTitle());
        inputYear.getValueFactory().setValue(modositando.getYear());
        inputOnDisplay.setSelected(modositando.isOn_display());
    }
}
