/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jonathandandries
 */
public class FxExample extends Application {

    private ArrayList<Integer> numberList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Example");
        scenetitle.setFont(Font.font(STYLESHEET_CASPIAN, FontPosture.REGULAR, 0));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label numberLabel = new Label("Integer:");
        grid.add(numberLabel, 0, 1);

        TextField numberTextField = new TextField();
        grid.add(numberTextField, 1, 1);

        Label currentNumbers = new Label();
        Label sumEvenLabel = new Label("Sum +Evens:");
        Label sumEven = new Label();
        Label sumNegativeLabel = new Label("Sum Negatives:");
        Label sumNegative = new Label();
        Label sumOddLabel = new Label("Sum +Odd:");
        Label sumOdd = new Label();

        Button addBtn = new Button();
        addBtn.setText("Add Number");
        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                numberList.add(Integer.parseInt(numberTextField.getText()));
                String numberListString = "[";
                for (int i = 0; i < numberList.size(); i++) {
                    numberListString += (numberList.get(i) + " ");
                }
                numberListString = numberListString.trim();
                numberListString += "]";
                currentNumbers.setText(numberListString);
                int sumEvens = 0;
                int sumNegatives = 0;
                int sumOdds = 0;
                for (int i = 0; i < numberList.size(); i++) {
                    int thisNumber = numberList.get(i);
                    if (thisNumber % 2 == 0 && thisNumber > 0) {
                        sumEvens += thisNumber;
                    }
                    if (thisNumber % 2 == 1 && thisNumber > 0) {
                        sumOdds += thisNumber;
                    }
                    if (thisNumber < 0) {
                        sumNegatives += thisNumber;
                    }
                }
                sumEven.setText("" + sumEvens);
                sumNegative.setText("" + sumNegatives);
                sumOdd.setText("" + sumOdds);
            }
        });
        grid.add(addBtn, 0, 2, 2, 1);
        grid.add(currentNumbers, 0, 3, 2, 1);

        grid.add(sumEvenLabel, 0, 5);
        grid.add(sumEven, 1, 5);
        grid.add(sumNegativeLabel, 0, 6);
        grid.add(sumNegative, 1, 6);
        grid.add(sumOddLabel, 0, 7);
        grid.add(sumOdd, 1, 7);

        Scene scene = new Scene(grid, 300, 250);

        primaryStage.setTitle("My App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
