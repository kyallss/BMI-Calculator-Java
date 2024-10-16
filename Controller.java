package org.example.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField weightInput;

    @FXML
    private TextField heightInput;

    @FXML
    private ChoiceBox<String> unitChoice;

    @FXML
    private Button calculateButton;

    @FXML
    private Label bmiResultLabel;

    @FXML
    private Label bmiStatusLabel;

    @FXML
    public void initialize() {
        unitChoice.getItems().addAll("Metric", "English");
        unitChoice.setValue("Metric");

        calculateButton.setOnAction(e -> calculateBMI());
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightInput.getText());
            double height = Double.parseDouble(heightInput.getText());
            String unit = unitChoice.getValue();

            double bmi = calculateBMIValue(weight, height, unit);
            bmiResultLabel.setText(String.format("Your BMI: %.2f", bmi));
            bmiStatusLabel.setText(determineStatus(bmi));
        } catch (NumberFormatException ex) {
            bmiResultLabel.setText("Error");
        }
    }

    private double calculateBMIValue(double weight, double height, String unit) {
        if (unit.equals("Metric")) {
            return weight / (height * height);
        } else {
            return (weight / (height * height)) * 703;
        }
    }

    private String determineStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
