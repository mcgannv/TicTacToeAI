package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(Main.class.getClassLoader().getResource("tictactoeUI.fxml"));
        Parent root = loader1.load();
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(root));

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(Main.class.getClassLoader().getResource("StartupChoice.fxml"));
        Parent root2 = loader2.load();
        Stage stage2 = new Stage();
        stage2.setTitle("What would you like to play?");
        stage2.setScene(new Scene(root2));

        TicTacToeController mainController = loader1.getController();
        StartUpController startUpController = loader2.getController();
        startUpController.setMainController(mainController, stage2);
        mainController.setSecondStage(stage2);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
