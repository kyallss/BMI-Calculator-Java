package org.example.bmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class BMICalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bmi_calculator.fxml"));
        GridPane root = loader.load();

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BMI Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
