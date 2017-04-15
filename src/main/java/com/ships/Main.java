package com.ships;

import com.ships.Controllers.LoginWindowController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by admin on 04.04.17.
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/loginWindow.fxml"));
        Parent root = loader.load();
        LoginWindowController mainController = loader.getController();
        mainController.setMainStage(primaryStage);
        primaryStage.setTitle("VCS");
        primaryStage.setScene(new Scene(root, 330, 280));
        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
               // mainController.session.close();
                System.out.println("closing");
                //Platform.exit();
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

}
