package gameboard;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Main extends Application {

    //TODO try .clear on connections table so it doesn't null out

//
//    public void start(Stage stage) throws Exception {

    static Scale scale;
    static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
//            Parent root = FXMLLoader.load(getClass().getResource("gui/FarmOverview.fxml"));
//            stage.setScene(new Scene(root,1600 , 900));
//            stage.setResizable(false);
//            stage.show();
//        }


        final int initWidth = 1600;      //initial width
        final int initHeight = 900;    //initial height
        final Pane root = new Pane();   //necessary evil


        Pane controller = FXMLLoader.load(getClass().getResource("/gui/GameBoard.fxml"));   //initial view
        controller.setPrefWidth(initWidth);     //if not initialized
        controller.setPrefHeight(initHeight);   //if not initialized
        root.getChildren().add(controller);     //necessary evil


        scale = new Scale(1, 1, 0, 0);
        scale.xProperty().bind(root.widthProperty().divide(initWidth));     //must match with the one in the controller
        scale.yProperty().bind(root.heightProperty().divide(initHeight));   //must match with the one in the controller
        root.getTransforms().add(scale);

        final Scene scene = new Scene(root, initWidth, initHeight);
        stage.setScene(scene);
        stage.setResizable(true);
        this.stage = stage;

        stage.show();
//        add listener for the use of scene.setRoot()
        scene.rootProperty().addListener(new ChangeListener<Parent>() {
            @Override
            public void changed(ObservableValue<? extends Parent> arg0, Parent oldValue, Parent newValue) {
                scene.rootProperty().removeListener(this);
                scene.setRoot(root);
                ((Region) newValue).setPrefWidth(initWidth);     //make sure is a Region!
                ((Region) newValue).setPrefHeight(initHeight);   //make sure is a Region!
                root.getChildren().clear();
                root.getChildren().add(newValue);
                scene.rootProperty().addListener(this);
            }

        });
    }




    public static void main(String[] args) throws InterruptedException {
        launch(args);

    }

    public static Scale getScale() {
        return scale;

    }
    public static Stage getStage() {
        return stage;

    }



}
