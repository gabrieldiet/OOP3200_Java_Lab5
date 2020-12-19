/*
 * @Authors: Gabriel Dietrich (100764733) and Fleur Blanckaert (100747083)
 * @Date: Dec 18, 2020
 * @Program: OOP3200 - Java Lab 5
 * @Description: This application takes the user input for height in meters,
 *               weight in kilos, and calculates the Body Mass Index (BMI).
 *               In addition, it indicates the BMI Scale based on the
 *               result of the calculation
 */


package ca.durhamcollege;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Java Lab 5");

        /************************
         * Creation of controls
         ************************/

        // Height
        Label myHeight = new Label("My Height (meters):");
        TextField heightInput = new TextField();

        // Weight
        Label myWeight = new Label("My Weight (kilos):");
        TextField weightInput = new TextField();

        // BMI
        TextField bmi = new TextField();
        Label bmiScale = new Label("");

        /***********************
         * Control configurations
         ***********************/

        Font font = Font.font("Consolas", 20);
        Button bmiButton = new Button("Calculate BMI");

        // Indicates what happens once button is clicked
        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                double heightEntered;
                double weightEntered;
                double bmiCalculated;

                try
                {
                    // Converts user input into double
                    heightEntered = Double.parseDouble(heightInput.getText());
                    weightEntered = Double.parseDouble(weightInput.getText());

                    // Throws error if out of range
                    if(heightEntered <= 0 || weightEntered <= 0)
                    {
                        throw new java.lang.Exception();
                    }

                    if(heightEntered > 2.5 || weightEntered > 500)
                    {
                        throw new java.lang.Exception();
                    }

                    // Calculates BMI
                    bmiCalculated = Math.round((weightEntered/(heightEntered*heightEntered)));
                    bmi.setText(String.valueOf(bmiCalculated));

                    // BMI Scale
                    if(bmiCalculated < 18.5)
                    {
                        // Underweight
                        bmiScale.setText("BMI Scale:\nYour BMI indicates you are UNDERWEIGHT");
                    }
                    else if (bmiCalculated >= 18.5 && bmiCalculated <= 24.9)
                    {
                        // Normal
                        bmiScale.setText("BMI Scale:\nYour BMI indicates you are NORMAL");
                    }
                    else if (bmiCalculated >= 25 && bmiCalculated <= 29.9)
                    {
                        // Overweight
                        bmiScale.setText("BMI Scale:\nYour BMI indicates you are OVERWEIGHT");
                    }
                    else
                    {
                        // Obese
                        bmiScale.setText("BMI Scale:\nYour BMI indicates you are OBESE");
                    }
                }
                catch (NumberFormatException e)
                {
                    bmiScale.setText("Error: Please enter a number for Height and Weight");
                }
                catch (Exception e)
                {
                    bmiScale.setText("Error:\nHeight must be greater than 0 and less than 2.5\n" +
                                     "Weight must be greater than 0 and less than 500");
                }

            }
        }

        // Actions the button
        bmiButton.setOnAction(new ButtonClickHandler());

        /**********************
         * Creates containers
         **********************/

        // Height
        HBox hboxHeight = new HBox(10, myHeight);
        HBox hboxHeightInput = new HBox(10, heightInput);

        // Weight
        HBox hboxWeight = new HBox(10, myWeight);
        HBox hboxWeightInput = new HBox(10, weightInput);

        // Bmi
        HBox hboxBmiButton = new HBox(10, bmiButton);
        HBox hboxBmiResult = new HBox(10, bmi);
        HBox hboxBmiScale = new HBox(30, bmiScale);


        /*****************
         * Output
         *****************/

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Height
        gridPane.add(hboxHeight, 1, 1);
        gridPane.add(hboxHeightInput, 1, 2);

        // Weight
        gridPane.add(hboxWeight, 1, 3);
        gridPane.add(hboxWeightInput, 1, 4);

        // Bmi
        gridPane.add(hboxBmiButton, 1, 5);
        gridPane.add(hboxBmiResult, 1, 6);
        gridPane.add(hboxBmiScale, 1, 7);


        Scene scene = new Scene(gridPane, 320, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
