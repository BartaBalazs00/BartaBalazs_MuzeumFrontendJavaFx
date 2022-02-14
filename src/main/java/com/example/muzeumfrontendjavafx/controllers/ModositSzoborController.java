package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Controller;
import com.example.muzeumfrontendjavafx.Statue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class ModositSzoborController extends Controller {
    @FXML
    private TextField inputPerson;
    @FXML
    private Spinner<Integer> inputHeight;
    @FXML
    private Spinner<Integer> inputPrice;
    private Statue modositando;
    @FXML
    public void onModositButtonClick(ActionEvent actionEvent) {

    }
    public Statue getModositando() {
        return modositando;
    }

    public void setModositando(Statue modositando) {
        this.modositando = modositando;
        ertekekBeallitasa();
    }

    private void ertekekBeallitasa() {
        inputPerson.setText(modositando.getPerson());
        inputHeight.getValueFactory().setValue(modositando.getHeight());
        inputPrice.getValueFactory().setValue(modositando.getPrice());
    }
}
