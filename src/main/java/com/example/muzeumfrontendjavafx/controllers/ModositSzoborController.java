package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

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
        String person = inputPerson.getText().trim();
        int height, price;
        if (person.isEmpty()){
            alert("A személy megadása kötelező");
            return;
        }
        try {
            height = inputHeight.getValue();
        } catch (NullPointerException ex){
            alert("A magasság megadása kötelező");
            return;
        } catch (Exception ex){
            alert("A magasság csak 1 és 999999999 közötti szám lehet");
            return;
        }
        try {
            price = inputPrice.getValue();
        } catch (NullPointerException ex){
            alert("Az ár megadása kötelező");
            return;
        } catch (Exception ex){
            alert("Az ár csak 1 és 999999999 közötti szám lehet");
            return;
        }
        modositando.setPerson(person);
        modositando.setHeight(height);
        modositando.setPrice(price);

        try {
            Statue modositott = StatueApi.updateStatue(modositando);
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
