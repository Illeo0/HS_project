package com.example.hs_project.controllers;

import com.example.hs_project.data.Hero;
import com.example.hs_project.MainApplication;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;

public class HeroSelectionController implements Initializable {

    private final String[] names = MainApplication.getDataManagement().getHeroes().stream().map(Hero::getName).toArray(String[]::new);
    private final String[] images = MainApplication.getDataManagement().getHeroes().stream().map(Hero::getImage).toArray(String[]::new);
    private final Integer[] tiers = MainApplication.getDataManagement().getHeroes().stream().map(Hero::getTier).toArray(Integer[]::new);
    private final String[] previousName = new String[4];
    private final ObservableList<String> observableList = FXCollections.observableArrayList(names);
    private final ListProperty<String> selectableElementsProperty = new SimpleListProperty<>(observableList);
    public static String finalHeroChoice;

    @FXML
    private ChoiceBox<String> heroAvailable1;
    @FXML
    private ChoiceBox<String> heroAvailable2;
    @FXML
    private ChoiceBox<String> heroAvailable3;
    @FXML
    private ChoiceBox<String> heroAvailable4;

    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private RadioButton radioButton3;
    @FXML
    private RadioButton radioButton4;
    @FXML
    private Label selectedHero;
    @FXML
    private Label firstLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Label thirdLabel;
    @FXML
    private Label fourthLabel;

    /**
     * This method shows an image of the hero selected from the choice-box
     * @param imageNumber is used as index to select one of the 4 choices
     */
    private void heroChoice(int imageNumber){
        ImageView[] iv = new ImageView[] {imageView1, imageView2, imageView3, imageView4};
        ChoiceBox[] cb = new ChoiceBox[] {heroAvailable1, heroAvailable2, heroAvailable3, heroAvailable4};
        Label[] l = new Label[] {firstLabel, secondLabel, thirdLabel, fourthLabel};
        previousName[imageNumber] = (String)cb[imageNumber].getValue();
        for (int i = 0; i < names.length; i++){
            if (names[i].equals(previousName[imageNumber])) {
                iv[imageNumber].setImage(new Image(images[i]));
                l[imageNumber].setText("Tier " + tiers[i]);
                break;
            }
        }
    }

    /**
     * This 4 methods call the method above, they are used in order to not repeat the code
     * @param event is the click on the button
     */
    private void heroChoice1(ActionEvent event){
        heroChoice(0);
    }
    private void heroChoice2(ActionEvent event){
        heroChoice(1);
    }
    private void heroChoice3(ActionEvent event){
        heroChoice(2);
    }
    private void heroChoice4(ActionEvent event){
        heroChoice(3);
    }

    /**
     * This method is needed in order to prevent the user from selecting more than one radio-button
     * @param heroNumber is used as index to select one of the 4 choices
     */
    private void selectHero(int heroNumber) {
        ChoiceBox[] cb = new ChoiceBox[] {heroAvailable1, heroAvailable2, heroAvailable3, heroAvailable4};
        RadioButton[] rb = new RadioButton[] {radioButton1, radioButton2, radioButton3, radioButton4};
        String name;
        if (rb[heroNumber].isSelected()) {
            name = (String)cb[heroNumber].getValue();
            for (int i = 0; i < rb.length; i++) {
                if (rb[i].isSelected() && i != heroNumber) {
                    rb[i].setSelected(false);
                }
            }
        } else {
            name = "Selected Hero:";
        }

        selectedHero.setText(name);
    }

    /**
     * This 4 methods call the method above, they are used in order to not repeat the code
     * @param event is the click on the button
     */
    private void selectHero1(ActionEvent event){
        selectHero(0);
    }
    private void selectHero2(ActionEvent event){
        selectHero(1);
    }
    private void selectHero3(ActionEvent event){
        selectHero(2);
    }
    private void selectHero4(ActionEvent event){
        selectHero(3);
    }

    /**
     * This method is used to load texts and images before launching the application
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        heroAvailable1.getItems().addAll(names);
        heroAvailable2.getItems().addAll(names);
        heroAvailable3.getItems().addAll(names);
        heroAvailable4.getItems().addAll(names);
        heroAvailable1.setOnAction(this::heroChoice1);
        heroAvailable2.setOnAction(this::heroChoice2);
        heroAvailable3.setOnAction(this::heroChoice3);
        heroAvailable4.setOnAction(this::heroChoice4);
        radioButton1.setOnAction(this::selectHero1);
        radioButton2.setOnAction(this::selectHero2);
        radioButton3.setOnAction(this::selectHero3);
        radioButton4.setOnAction(this::selectHero4);
    }

    /**
     This method closes the heroSelectionStage and passes the hero selected
     to the mainStage in order to use it in the BestBuild
     **/
    @FXML
    private void onClickConfirmButton(){
        try{
            finalHeroChoice = selectedHero.getText();
            MainController.heroSelectionStage.close();
        }catch(Exception e){
            System.out.println("error");
        }
    }
}