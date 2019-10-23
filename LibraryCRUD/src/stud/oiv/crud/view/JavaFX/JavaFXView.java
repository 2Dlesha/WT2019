package stud.oiv.crud.view.JavaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFXView extends Application {

    @FXML
    private Button ButtonSave;

    public static void main(String[] args) {
        //ConsoleView consoleView = new ConsoleView();
        //consoleView.ShowCreateWindow();
        launch(args);
        Platform.exit();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene MainScene = new Scene(root, 300, 275);

        Node nodeToFind = MainScene.lookup("#ButtonSave");
        ButtonSave = (Button)nodeToFind;
        ButtonSave.setText("LL");

        stage.setScene(MainScene);
        stage.setTitle("Hello World");
        stage.show();
    }
}
