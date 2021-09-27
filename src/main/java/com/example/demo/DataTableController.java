package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;


public class DataTableController {

    @FXML
    private TableView<Data> dataTableView;

    DataLoader loader = new DataLoader();

    public void initialize() {
        loader.loadItems();
        dataTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        dataTableView.getItems().setAll(loader.getList());
    }

    public TableView<Data> getDataTableView() {
        return dataTableView;
    }
}
