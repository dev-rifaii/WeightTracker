package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainWindowController {

    @FXML
    private HBox leftBox;

    @FXML
    private HBox rightBox;

    @FXML
    private Spinner<Double> weightSpinner;

    @FXML
    private DatePicker datePicker;

    DataLoader loader = new DataLoader();

    public void initialize() {
        datePicker.setValue(LocalDate.now());

    }

    @FXML
    public void handleEnterButton() {
        loader.addData(new Data(weightSpinner.getValue(), datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))));

        System.out.println("item added !");
    }

    public void handleTableButton() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DataTable.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Data Table");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root, 700, 300));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}