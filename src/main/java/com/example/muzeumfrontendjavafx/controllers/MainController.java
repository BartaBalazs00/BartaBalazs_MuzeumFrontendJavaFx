package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class MainController extends Controller {
    @FXML
    public TableView<Statue> statuesTable;
    @FXML
    public TableColumn<Statue, String> colPerson;
    @FXML
    public TableColumn<Statue, Integer> colHeight;
    @FXML
    public TableColumn<Statue, Integer> colPrice;
    @FXML
    public TableView<Painting> paintingsTable;
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
        colOnDisplay.setCellValueFactory(new PropertyValueFactory<>("on_display"));
        statueListaFeltolt();
        paintingListaFeltolt();
    }
    public void onSzoborHozzaadButtonClick(ActionEvent actionEvent) {
        try {
            Controller hozzadas = ujAblak("hozzaadasSzobor-view.fxml", "Szobor hozzáadása",
                    320, 400);
            hozzadas.getStage().setOnCloseRequest(event -> statueListaFeltolt());
            hozzadas.getStage().show();
        } catch (Exception e) {
            hibaKiir(e);
        }
    }

    public void onSzoborModositasButtonClick(ActionEvent actionEvent) {
        int selectedIndex = statuesTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            alert("A módosításhoz előbb válasszon ki egy elemet a táblázatból");
            return;
        }
        Statue modositando = statuesTable.getSelectionModel().getSelectedItem();
        try {
            ModositSzoborController modositas = (ModositSzoborController) ujAblak("modositasSzobor-view.fxml",
                    "Szobor módosítása", 320, 400);
            modositas.setModositando(modositando);
            modositas.getStage().setOnHiding(event -> statuesTable.refresh());
            modositas.getStage().show();
        } catch (IOException e) {
            hibaKiir(e);
        }
    }

    public void onSzoborTorlesButtonClick(ActionEvent actionEvent) {
        int selectedIndex = statuesTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1){
            alert("A törléshez előbb válasszon ki egy elemet a táblázatból");
            return;
        }
        Statue torlendo = statuesTable.getSelectionModel().getSelectedItem();
        if (!confirm("Biztos hogy törölni szeretné az alábbi szobrot?: "+torlendo.getPerson())){
            return;
        }
        try {
            boolean sikeres = StatueApi.deleteStatue(torlendo.getId());
            alert(sikeres ? "Sikeres törlés": "Sikertele törlés");
            statueListaFeltolt();
        } catch (IOException e) {
            hibaKiir(e);
        }
    }

    public void onFestmenyHozzaadasButtonClick(ActionEvent actionEvent) {
        try {
            Controller hozzadas = ujAblak("hozzaadasFestmeny-view.fxml", "Festmény hozzáadása",
                    320, 400);
            hozzadas.getStage().setOnCloseRequest(event -> paintingListaFeltolt());
            hozzadas.getStage().show();
        } catch (Exception e) {
            hibaKiir(e);
        }
    }

    public void onFestmenyModositasButtonClick(ActionEvent actionEvent) {
        int selectedIndex = paintingsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            alert("A módosításhoz előbb válasszon ki egy elemet a táblázatból");
            return;
        }
        Painting modositando = paintingsTable.getSelectionModel().getSelectedItem();
        try {
            ModositFestmenyController modositas = (ModositFestmenyController) ujAblak("modositasFestmeny-view.fxml",
                    "Festmény módosítása", 320, 400);
            modositas.setModositando(modositando);
            modositas.getStage().setOnHiding(event -> paintingsTable.refresh());
            modositas.getStage().show();
        } catch (IOException e) {
            hibaKiir(e);
        }
    }

    public void onFestmenyTorlesButtonClick(ActionEvent actionEvent) {
        int selectedIndex = paintingsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1){
            alert("A törléshez előbb válasszon ki egy elemet a táblázatból");
            return;
        }
        Painting torlendo = paintingsTable.getSelectionModel().getSelectedItem();
        if (!confirm("Biztos hogy törölni szeretné az alábbi festményt?: "+torlendo.getTitle())){
            return;
        }
        try {
            boolean sikeres = PaintingApi.deletePainting(torlendo.getId());
            alert(sikeres ? "Sikeres törlés": "Sikertele törlés");
            paintingListaFeltolt();
        } catch (IOException e) {
            hibaKiir(e);
        }
    }
    private void statueListaFeltolt() {
        try {
            List<Statue> statueList = StatueApi.getStatues();
            statuesTable.getItems().clear();
            for (Statue statue : statueList) {
                statuesTable.getItems().add(statue);
            }
        } catch (IOException e) {
            hibaKiir(e);
        }
    }
    private void paintingListaFeltolt() {
        try {
            List<Painting> paintingList = PaintingApi.getPaintings();
            paintingsTable.getItems().clear();
            for (Painting painting : paintingList) {
                paintingsTable.getItems().add(painting);
            }
        } catch (IOException e) {
            hibaKiir(e);
        }
    }
}