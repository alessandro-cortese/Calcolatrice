package com.example.calcolatrice;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    private double firstOperand = 0.0;
    private double result = 0.0;
    private double previousResult = 0.0;
    private String operand = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonEight;

    @FXML
    private Button buttonFive;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonNine;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonSeven;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonThree;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonZero;

    @FXML
    private Button cancButton;

    @FXML
    private Label txtInput;

    @FXML
    private Label txtResult;

    @FXML
    void handleButtonAction(ActionEvent event){
        String local = txtInput.getText();
        if(local.isEmpty()){
            firstOperand = Double.parseDouble(((Button)event.getSource()).getText());
            txtInput.setText(((Button)event.getSource()).getText() + " " );
        }else{
            double secondOperand = Double.parseDouble(((Button) event.getSource()).getText());
            txtInput.setText(local + " "  + ((Button)event.getSource()).getText());
            result = calculate(firstOperand, secondOperand, operand);
            previousResult = result;
        }
    }



    private double calculate(double firstNumber, double secondNumber, String operation){
        double localResult = 0.0;
        switch(operation){

            case "+":
                localResult = firstNumber + secondNumber;
                break;

            case "-":
                localResult = firstNumber - secondNumber;
                break;

            case "*":
                localResult = firstNumber * secondNumber;
                break;

            case "/":
                if(secondNumber != 0){
                    localResult = firstNumber / secondNumber;
                    break;
                }else{
                    txtResult.setText("Math Error!");
                    break;
                }

            case "%":
                localResult = firstNumber % secondNumber;
                break;

            default:
                txtResult.setText("Invalid Operation");
                break;

        }

        return localResult;
    }

    @FXML
    void handleCancEvent(ActionEvent event) {
        txtInput.setText("");
        txtResult.setText("");
    }
    @FXML
    void handleGetOperand(ActionEvent event){
        operand = ((Button)event.getSource()).getText();
        String local = txtInput.getText();
        txtInput.setText(local + " " + operand);
    }

    @FXML
    void handleEqualButton(ActionEvent event) {
        txtInput.setText("");
        txtResult.setText(Double.toString(result));
    }

    @FXML
    void handleAnsButton(ActionEvent event){
        firstOperand = previousResult;
        txtInput.setText(Double.toString(firstOperand) + " ");
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
