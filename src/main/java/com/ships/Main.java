package com.ships;

import Controllers.LoginWindowController;
//import com.sun.javaws.progress.Progress;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main extends Application{

    public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/loginWindow.fxml"));
        Parent root;
        root=loader.load();
        System.out.println("////////////////////////////////////////////////");
        System.out.println("MAIN root:"+root);
        LoginWindowController mainController = loader.getController();
        mainController.setMainStage(primaryStage);
        primaryStage.setTitle("VCS");
        primaryStage.setScene(new Scene(root, 330, 280));
        primaryStage.setResizable(false);
        primaryStage.show();

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
