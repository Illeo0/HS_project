package com.example.hs_project.controllers;

import com.example.hs_project.MainApplication;
import com.example.hs_project.data.Minion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MinionFilterController implements Initializable{
    private final Minion[] minions = MainApplication.getDataManagement().getMinions().toArray(Minion[]::new);

    @FXML
    private ImageView imageView;
    @FXML
    private Button tier1;
    @FXML
    private Button tier2;
    @FXML
    private Button tier3;
    @FXML
    private Button tier4;
    @FXML
    private Button tier5;
    @FXML
    private Button tier6;
    @FXML
    private Label tribe1;
    @FXML
    private Label tribe2;
    @FXML
    private Label tribe3;
    @FXML
    private Label tribe4;
    @FXML
    private Label tribe5;
    @FXML
    private Label tribe6;
    @FXML
    private ListView<String> tribeMinion1 = new ListView<>();
    @FXML
    private ListView<String> tribeMinion2 = new ListView<>();
    @FXML
    private ListView<String> tribeMinion3 = new ListView<>();
    @FXML
    private ListView<String> tribeMinion4 = new ListView<>();
    @FXML
    private ListView<String> tribeMinion5 = new ListView<>();
    @FXML
    private ListView<String> tribeMinion6 = new ListView<>();

    /**
     This method is a filter for minions, and it uses three parameters
     @param tribe as the tribe needed for the minion
     @param tier as the tier needed for the minion
     @param shownMinions as a list where we add minions we need to show
     **/
    private void filterMinions (String tribe, int tier, List<String> shownMinions) {
        for (Minion minion : minions) {
            if (minion.getType().contains(tribe) && tier + 1 == minion.getTier()) {
                shownMinions.add(minion.getName());
            }
        }
    }

    /**
     This method shows minions based on their tribe and tier, and it uses one parameter
     @param tierNumber as the tier needed for the minion
    **/
    private void showMinions (int tierNumber) {
        imageView.setImage(null);
        ListView[] lv = new ListView[] {tribeMinion1, tribeMinion2, tribeMinion3, tribeMinion4, tribeMinion5, tribeMinion6};
        Label[] l = new Label[] {tribe1, tribe2, tribe3, tribe4, tribe5, tribe6};
        for (int i = 0; i < lv.length; i++) {
            List<String> shownMinions = new ArrayList<>();
            filterMinions(l[i].getText(), tierNumber, shownMinions);
            ObservableList<String> observableList = FXCollections.observableArrayList(shownMinions);
            lv[i].setItems(observableList);
        }
    }
    private void showMinions1 (ActionEvent event) {
        showMinions(0);
    }
    private void showMinions2 (ActionEvent event) {
        showMinions(1);
    }
    private void showMinions3 (ActionEvent event) {
        showMinions(2);
    }
    private void showMinions4 (ActionEvent event) {
        showMinions(3);
    }
    private void showMinions5 (ActionEvent event) {
        showMinions(4);
    }
    private void showMinions6 (ActionEvent event) {
        showMinions(5);
    }

    /**
     * This method gets the image of a specified minion
     * @param name is the name of the minion passed
     * @return the string image of the minion
     * if the minion is not in the array the function return an empty string
     */
    private String imageMinion (String name) {
        for (Minion minion : minions) {
            if (name != null && name.equals(minion.getName())) {
                return minion.getImage();
            }
        }
        return "";
    }

    /**
     * This method is used to load texts and images before launching the application Listeners are used to show the
     * image of the minion that is clicked on the corresponding tribe list
     *
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tribe1.setText(MainController.selectedTribes[0]);
        tribe2.setText(MainController.selectedTribes[1]);
        tribe3.setText(MainController.selectedTribes[2]);
        tribe4.setText(MainController.selectedTribes[3]);
        tribe5.setText(MainController.selectedTribes[4]);
        tribe6.setText("No type");
        tier1.setOnAction(this::showMinions1);
        tier2.setOnAction(this::showMinions2);
        tier3.setOnAction(this::showMinions3);
        tier4.setOnAction(this::showMinions4);
        tier5.setOnAction(this::showMinions5);
        tier6.setOnAction(this::showMinions6);
        tribeMinion1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String image = imageMinion(tribeMinion1.getSelectionModel().getSelectedItem());
            if (!image.equals("")) {
                imageView.setImage(new Image(image));
            }
        });
        tribeMinion2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String image = imageMinion(tribeMinion2.getSelectionModel().getSelectedItem());
            if (!image.equals("")) {
                imageView.setImage(new Image(image));
            }
        });
        tribeMinion3.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String image = imageMinion(tribeMinion3.getSelectionModel().getSelectedItem());
            if (!image.equals("")) {
                imageView.setImage(new Image(image));
            }
        });
        tribeMinion4.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String image = imageMinion(tribeMinion4.getSelectionModel().getSelectedItem());
            if (!image.equals("")) {
                imageView.setImage(new Image(image));
            }
        });
        tribeMinion5.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String image = imageMinion(tribeMinion5.getSelectionModel().getSelectedItem());
            if (!image.equals("")) {
                imageView.setImage(new Image(image));
            }
        });
        tribeMinion6.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String image = imageMinion(tribeMinion6.getSelectionModel().getSelectedItem());
            if (!image.equals("")) {
                imageView.setImage(new Image(image));
            }
        });
    }
}