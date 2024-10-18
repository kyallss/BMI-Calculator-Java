package org.example.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMICalculatorController {

    @FXML
    private TextField weightField;
    @FXML
    private TextField heightField;
    @FXML
    private ComboBox<String> unitComboBox;
    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {

        unitComboBox.getItems().add("Metric");
        unitComboBox.getItems().add("English");
    }

    @FXML
    private void handleCalculate() {
        String weightText = weightField.getText();
        String heightText = heightField.getText();
        String selectedUnit = unitComboBox.getValue();

        if (weightText.isEmpty() || heightText.isEmpty() || selectedUnit == null) {
            resultLabel.setText("Please fill in all fields!");
            return;
        }

        double weight = Double.parseDouble(weightText);
        double height = Double.parseDouble(heightText);

        double bmi;
        if (selectedUnit.equals("Metric")) {
            bmi = weight / (height * height);
        } else {
            bmi = (weight / (height * height)) * 703;
        }

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        resultLabel.setText(String.format("Your BMI: %.2f (%s)", bmi, status));
    }

    @FXML
    private void handleExit() {
        javafx.application.Platform.exit();
    }

    @FXML
    private void handleClear() {
        weightField.clear();
        heightField.clear();
        unitComboBox.getSelectionModel().clearSelection();
        resultLabel.setText("Your BMI will be shown here");
    }

    @FXML
    private void handleAbout() {
        System.out.println("This is a BMI Calculator App.");
    }
}
