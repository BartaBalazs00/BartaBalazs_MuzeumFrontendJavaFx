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
        }
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
