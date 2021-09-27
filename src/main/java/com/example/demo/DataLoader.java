package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataLoader {

    private static ObservableList<Data> data;
    Path path = Paths.get("C:\\Users\\moeri\\IdeaProjects\\TTTGui\\demo\\src\\main\\java\\com\\example\\demo\\DataFile");

    public DataLoader() {

        data = FXCollections.observableArrayList();
    }

    public void addData(Data d) {
        data.add(d);
        saveData();
    }

    public void saveData() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\moeri\\IdeaProjects\\TTTGui\\demo\\src\\main\\java\\com\\example\\demo\\DataFile");
            for (Data a : data) {
                fw.write(a.getWeight() + "\n");
                fw.write(a.getDate() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadItems() {
        try {
            Scanner scan = new Scanner(new FileReader(String.valueOf(path)));

            while (scan.hasNext()) {
                double weight = scan.nextDouble();
                String date = scan.next();
                data.add(new Data(weight, date));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }

    }

    public ObservableList<Data> getList() {
        return this.data;
    }
}
