package com.example.fortunetelling;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.util.Random;

public class FortuneTellingController {

    @FXML
    private ListView<String> fortuneListView;

    @FXML
    private TextField fortuneInput;

    private final ObservableList<String> fortunes = FXCollections.observableArrayList(
            "You will have a great day!",
            "A surprise is waiting for you.",
            "Happiness is coming your way.",
            "Beware of unexpected changes.",
            "Your patience will be rewarded.",
            "You will meet someone interesting.",
            "Take a chance today!",
            "Good news is on the horizon.",
            "Be kind to yourself.",
            "Stay confident and strong."
    );

    @FXML
    public void initialize() {
        fortuneListView.setItems(fortunes);
    }

    @FXML
    private void handleRevealFortune() {
        if (fortunes.isEmpty()) {
            showAlert(AlertType.INFORMATION, "No fortunes available to reveal.");
        } else {
            String randomFortune = fortunes.get(new Random().nextInt(fortunes.size()));
            showAlert(AlertType.INFORMATION, "Your Fortune", randomFortune);
        }
    }

    @FXML
    private void handleAddFortune() {
        String newFortune = fortuneInput.getText().trim();
        if (newFortune.isEmpty()) {
            showAlert(AlertType.ERROR, "Cannot add empty fortune.");
            return;
        }
        fortunes.add(newFortune);
        fortuneInput.clear();
    }

    @FXML
    private void handleDeleteFortune() {
        String selected = fortuneListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(AlertType.ERROR, "No fortune selected to delete.");
            return;
        }
        fortunes.remove(selected);
    }

    @FXML
    private void handleEditFortune() {
        String selected = fortuneListView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert(AlertType.ERROR, "No fortune selected to edit.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog(selected);
        dialog.setTitle("Edit Fortune");
        dialog.setHeaderText("Editing Selected Fortune");
        dialog.setContentText("Enter new fortune:");

        dialog.showAndWait().ifPresent(newFortune -> {
            newFortune = newFortune.trim();
            if (newFortune.isEmpty()) {
                showAlert(AlertType.ERROR, "Cannot update to an empty fortune.");
            } else {
                int index = fortunes.indexOf(selected);
                fortunes.set(index, newFortune);
            }
        });
    }


    private void showAlert(AlertType type, String message) {
        showAlert(type, "Fortune App", message);
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
