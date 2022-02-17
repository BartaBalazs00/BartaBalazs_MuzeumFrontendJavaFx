package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Controller;
import com.example.muzeumfrontendjavafx.Statue;
import com.example.muzeumfrontendjavafx.StatueApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HozzaadSzoborController extends Controller {
    @FXML
    private TextField inputPerson;
    @FXML
    private Spinner<Integer> inputHeight;
    @FXML
    private Spinner<Integer> inputPrice;

    @FXML
    public void onHozaadasButtonClick(ActionEvent actionEvent) {
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

        try {
            Statue ujSzobor = new Statue(0, person, height, price);
            Statue hozzaadott = StatueApi.addStatue(ujSzobor);
            if (hozzaadott != null){
                alert("Sikeres módosítás");
            } else {
                alert("Sikertelen módosítás");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
