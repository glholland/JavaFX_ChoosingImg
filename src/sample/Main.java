package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        FlowPane root = new FlowPane();



        ToggleGroup tg = new ToggleGroup();
        RadioButton radio1 = new RadioButton("Moe");
        radio1.setSelected(true);
        radio1.setToggleGroup(tg);
        RadioButton radio2 = new RadioButton("Larry");
        radio2.setToggleGroup(tg);
        RadioButton radio3 = new RadioButton("Curly");
        radio3.setToggleGroup(tg);



        VBox radioPane = new VBox();
        root.getChildren().addAll(radio1,radio2,radio3, image, radioPane);
        radioPane.setSpacing(5);

        radio1.setOnAction(e -> {image.setImage(moe);});
        radio2.setOnAction(e -> {image.setImage(larry);});
        radio3.setOnAction(e -> {image.setImage(curly);});

        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 600, 375);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
