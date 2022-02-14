package com.uldemy.gui;

import com.uldemy.application.Main;
import com.uldemy.gui.util.Alerts;
import com.uldemy.model.services.DepartmentService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController  implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    private void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    private void onMenuItemDepartmentAction(){
        loadView2("DepartmentList.fxml");
    }

    @FXML
    private void onMenuItemAboutAction(){
       loadView("About.fxml");
    }

    @Override
    public void initialize(URL uri, ResourceBundle resourceBundle) {

    }

    private synchronized void loadView(String absoluteName){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(absoluteName));
        try {
            VBox newBox = loader.load();
            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newBox.getChildren());

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private synchronized void loadView2(String absoluteName){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(absoluteName));
        try {
            VBox newBox = loader.load();
            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newBox.getChildren());

            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.upadateTableView();

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}