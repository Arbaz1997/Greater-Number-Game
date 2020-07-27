package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

   Controller controller;

   Scene scene1,scene2;


    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("HomePage.fxml"));

        GridPane gridPane = loader.load();
        VBox vBox = loader1.load();

        scene2 = new Scene(gridPane);

        controller = loader.getController();
        controller.setRandomNumber();
        controller.resetButton();


        Button button1= new Button("Lets Play");
        button1.setTranslateX(450);
        button1.setTranslateY(-100);
        button1.setPrefSize(150,100);
        button1.setOnAction(e -> primaryStage.setScene(scene2));
        vBox.getChildren().addAll(button1);
        scene1= new Scene(vBox);




        primaryStage.setTitle("Welcome to My Game");
        primaryStage.setScene(scene1);
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}
