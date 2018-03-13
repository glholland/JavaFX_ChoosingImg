package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Create image object using FileInputStream of the choosen file.
        //Create an ImageView of each Image object to be viewed.
        Image moe = new Image(new FileInputStream("moe.jpg"));
        Image larry = new Image(new FileInputStream("larry.jpg"));
        Image curly = new Image(new FileInputStream("curly.jpg"));
        ImageView image = new ImageView(moe);
        //Create FlowPane and set to center in the scene
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        //Create VBox to hold radio buttons
        VBox radioPane = new VBox();
        //Create toggle group to hold radio buttons.
        ToggleGroup tg = new ToggleGroup();
        RadioButton radio1 = new RadioButton("Moe");
        radio1.setSelected(true);
        radio1.setToggleGroup(tg);
        RadioButton radio2 = new RadioButton("Larry");
        radio2.setToggleGroup(tg);
        RadioButton radio3 = new RadioButton("Curly");
        radio3.setToggleGroup(tg);
        //Set the radio buttons as children of radioPane - set spacing for the VBox
        radioPane.getChildren().addAll(radio1,radio2,radio3);
        radioPane.setSpacing(10);
        //Set radioPane and the imageview as children of the root (FlowPane)
        root.getChildren().addAll(radioPane,image);
        //Set lambdas to handle clicking actions
        radio1.setOnAction(e -> {image.setImage(moe);});
        radio2.setOnAction(e -> {image.setImage(larry);});
        radio3.setOnAction(e -> {image.setImage(curly);});
        //Set the title of the window
        primaryStage.setTitle("¡The Three Stooges!");
        //Pull the scene together with the FlowPane containing all other nodes and panes
        Scene scene = new Scene(root, 300, 375);
        //Put the scene on the stage
        primaryStage.setScene(scene);
        //Set the stage to show on launch
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
