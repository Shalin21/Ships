package com.ships;

import Controllers.LoginWindowController;
//import com.sun.javaws.progress.Progress;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main extends Application{
    public static Boolean btnBool = false;
    public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public static HostServices services;
    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/loginWindow.fxml"));
        Parent root;
        root=loader.load();
        LoginWindowController mainController = loader.getController();
        mainController.setMainStage(primaryStage);
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 330, 280));
        primaryStage.setResizable(false);
        primaryStage.show();
        services = getHostServices();
    }

    @Override
    public void stop() throws Exception
    {
        //super.stop();
        //Platform.exit();
       // System.exit(0);
        sessionFactory.close();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
