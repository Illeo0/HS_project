package com.example.hs_project.controllers;

import com.example.hs_project.MainApplication;
import com.example.hs_project.data.Minion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class BestBuildController implements Initializable {
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView5;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;

    private final String[] names = MainApplication.getDataManagement().getMinions().stream().map(Minion::getName).toArray(String[]::new);
    private final String[] images = MainApplication.getDataManagement().getMinions().stream().map(Minion::getImage).toArray(String[]::new);

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
        String hero = HeroSelectionController.finalHeroChoice;
        loadMinions(hero);
    }
    /**
     This method shows an image of the top 7 minions based on the hero passed as a parameter
     @param hero is the name of the hero that is needed to show its best build
     **/
    private void loadMinions(String hero){
        ImageView[] iv = new ImageView[] {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7};
        switch (hero) {
            case "Ysera", "Alexstrasza" -> {
                for (int i = 0; i < names.length; ++i) {
                    switch (names[i]) {
                        case "Nadina la Rossa" -> iv[0].setImage(new Image(images[i]));
                        case "Kalecgos, Aspetto Arcano" -> iv[1].setImage(new Image(images[i]));
                        case "Brann Barbabronzea" -> iv[2].setImage(new Image(images[i]));
                        case "Generale Drakkisath" -> iv[3].setImage(new Image(images[i]));
                        case "Leeroy l'Avventato" -> iv[4].setImage(new Image(images[i]));
                        case "Guardiano di Bronzo" -> iv[5].setImage(new Image(images[i]));
                        case "Tarecgosa" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            case "N'zoth", "Re dei Lich", "Re Mukla", "Ramogrigio", "Teron Malacarne" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Ratto delle Fogne" -> iv[0].setImage(new Image(images[i]));
                        case "Raptor Furbo" -> iv[1].setImage(new Image(images[i]));
                        case "Mamma Orsa" -> iv[2].setImage(new Image(images[i]));
                        case "Banane per Tutti" -> iv[3].setImage(new Image(images[i]));
                        case "Octosari, Dio Avvolgente" -> iv[4].setImage(new Image(images[i]));
                        case "Manafiera" -> iv[5].setImage(new Image(images[i]));
                        case "Titus Fieramorte" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }

                }
            }
            case "Fungomante Flurgl", "Domasauri Brann" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Brann Barbabronzea" -> iv[0].setImage(new Image(images[i]));
                        case "Calcamaree Appestato" -> iv[1].setImage(new Image(images[i]));
                        case "Mrrrglr Corale" -> iv[2].setImage(new Image(images[i]));
                        case "Branchiabbasso" -> iv[3].setImage(new Image(images[i]));
                        case "Leeroy l'Avventato" -> iv[4].setImage(new Image(images[i]));
                        case "Regina dei Mantid" -> iv[5].setImage(new Image(images[i]));
                        case "Murloc Ragioniere" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            case "Capitano Boccalarrrga", "Sghigno il Pirata" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Peggy Ossasolide" -> iv[0].setImage(new Image(images[i]));
                        case "Collezionista di Lame" -> iv[1].setImage(new Image(images[i]));
                        case "Mercante Subdola" -> iv[2].setImage(new Image(images[i]));
                        case "Ammiraglio Tethys" -> iv[3].setImage(new Image(images[i]));
                        case "Trafficante di Polvere da Sparo" -> iv[4].setImage(new Image(images[i]));
                        case "Brann Barbabronzea" -> iv[5].setImage(new Image(images[i]));
                        case "Leeroy l'Avventato" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            case "Professor Putricidio" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Sorella Soffiamorte" -> iv[0].setImage(new Image(images[i]));
                        case "Evocatrice Eterna" -> iv[1].setImage(new Image(images[i]));
                        case "Colosso del Sole" -> iv[2].setImage(new Image(images[i]));
                        case "Fendianime" -> iv[3].setImage(new Image(images[i]));
                        case "Reietta della Mano" -> iv[4].setImage(new Image(images[i]));
                        case "Leeroy l'Avventato" -> iv[5].setImage(new Image(images[i]));
                        case "Regina dei Mantid" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            case "Chenvaala" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Elementale del Fuocobrado" -> iv[0].setImage(new Image(images[i]));
                        case "Presenza Riciclante" -> iv[1].setImage(new Image(images[i]));
                        case "Magmaloc" -> iv[2].setImage(new Image(images[i]));
                        case "Trombettiere Ventoso" -> iv[3].setImage(new Image(images[i]));
                        case "Roccia Rock" -> iv[4].setImage(new Image(images[i]));
                        case "Leeroy l'Avventato" -> iv[5].setImage(new Image(images[i]));
                        case "Regina dei Mantid" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            case "Ini Spiralampo" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Devia-Bot" -> iv[0].setImage(new Image(images[i]));
                        case "Riciclarottami" -> iv[1].setImage(new Image(images[i]));
                        case "Drone d'Utilità" -> iv[2].setImage(new Image(images[i]));
                        case "Fastidiotroupe" -> iv[3].setImage(new Image(images[i]));
                        case "Percossionista Polarizzante" -> iv[4].setImage(new Image(images[i]));
                        case "Mietinemici 4000" -> iv[5].setImage(new Image(images[i]));
                        case "Incantatrice Drakkari" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            case "Lich Baz'hial", "Sire Jaraxxus" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Riavvolgianima" -> iv[0].setImage(new Image(images[i]));
                        case "Malchezaar, Principe del Ballo" -> iv[1].setImage(new Image(images[i]));
                        case "Ur'zul Insaziabile" -> iv[2].setImage(new Image(images[i]));
                        case "Tichondrius" -> iv[3].setImage(new Image(images[i]));
                        case "Tessitore dell'Ira" -> iv[4].setImage(new Image(images[i]));
                        case "Vilpipistrello Famelico" -> iv[5].setImage(new Image(images[i]));
                        case "Sicurezza Dietro le Quinte" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            case "Oratore della Morte Spinanera" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Cornamusona" -> iv[0].setImage(new Image(images[i]));
                        case "Jazzista Tintarella di Luna" -> iv[1].setImage(new Image(images[i]));
                        case "Suonatrice di Bongo" -> iv[2].setImage(new Image(images[i]));
                        case "Incantatrice Drakkari" -> iv[3].setImage(new Image(images[i]));
                        case "Johann Sebastian Verro" -> iv[4].setImage(new Image(images[i]));
                        case "Charlga" -> iv[5].setImage(new Image(images[i]));
                        case "Rylak Metallaro" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            case "Regina Azshara", "Dama Vashj" -> {
                for(int i = 0; i < names.length; ++i){
                    switch(names[i]){
                        case "Scuotimaracas" -> iv[0].setImage(new Image(images[i]));
                        case "Neomelodico Blu Profondo" -> iv[1].setImage(new Image(images[i]));
                        case "Scagliabrillante" -> iv[2].setImage(new Image(images[i]));
                        case "Mandriana dei Fondali" -> iv[3].setImage(new Image(images[i]));
                        case "Signora delle Maree Athissa" -> iv[4].setImage(new Image(images[i]));
                        case "Tronfiaspina" -> iv[5].setImage(new Image(images[i]));
                        case "Leeroy l'Avventato" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
            default -> {
                for (int i = 0; i < names.length; ++i) {
                    switch (names[i]) {
                        case "Regina dei Mantid" -> iv[0].setImage(new Image(images[i]));
                        case "Aggem Malaspina" -> iv[1].setImage(new Image(images[i]));
                        case "Brann Barbabronzea" -> iv[2].setImage(new Image(images[i]));
                        case "Charlga" -> iv[3].setImage(new Image(images[i]));
                        case "Leeroy l'Avventato" -> iv[4].setImage(new Image(images[i]));
                        case "Guardiano di Bronzo" -> iv[5].setImage(new Image(images[i]));
                        case "Colosso del Sole" -> iv[6].setImage(new Image(images[i]));
                        default -> {
                        }
                    }
                }
            }
        }
    }
}