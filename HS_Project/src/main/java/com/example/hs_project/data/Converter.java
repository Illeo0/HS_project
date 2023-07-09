package com.example.hs_project.data;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Converter {
    /**
     * This function is used to convert minion type(int) to its corresponding minion type(string)
     * @param number is the int that refers to a specific type
     * @return is the string that resulted from the corresponding int type
     */
    private static String numberToType(int number){
        return switch (number) {
            case 11 -> "undead";
            case 14 -> "murloc";
            case 15 -> "demon";
            case 17 -> "robot";
            case 18 -> "elemental";
            case 20 -> "beast";
            case 23 -> "pirate";
            case 24 -> "dragon";
            case 26 -> "all";
            case 43 -> "quillboar";
            case 92 -> "naga";
            default -> "";
        };
    }

    /**
     * This function based on the hero that is passed returns the tier of that hero
     * @param name is the name of the hero that is passed
     * @return is the tier of the hero
     */
    private static int toTier(String name) {
        return switch (name) {
            case "Inge, l'Inno di Ferro", "Dolcetto il Cuoco", "Lich Baz'hial", "E.T.C., il Manager", "Ciciazampa", "Principe Gallywix", "Murloc Holmes", "Akazamzarak il Grande", "Tamsin Roame", "Regina Cobalda", "Sghigno il Pirata" ->
                    1;
            case "Maestro Nguyen", "Piramatta", "Drek'thar", "Elise Cercastelle", "Teron Malacarne", "Sneed", "Alamorte", "Re dei Lich", "Scabb Tranciaburro", "Sire Denathrius", "Sire Jaraxxus", "Bigliettus", "Y'shaarj", "Rakanishu", "Xyrella", "Malygos", "Edwin VanCleef", "Mutanus il Divoratore", "Millhouse Manalampo", "Nozdormu", "Regina Azshara", "Maestro del Rook Voone", "Millefica Manalampo", "Dama Vashj", "Kurtrus Domacenere", "Bru'kan", "Vanndar Piccatonante", "Oratore della Morte Spinanera", "Vol'Jin", "Varden Ghermiluce", "Ramogrigio", "Arcicattivo Rafaam", "Jandice Barov", "Ysera", "Re dei Ratti", "Ozumat" ->
                    2;
            case "C'thun", "Ragnaros", "Toki dell'Infinito", "Gran Capitano Kragg", "Guardiana Omu", "Silas Lunacupa", "A. F. Kappa", "Ambasciatore Faelin", "Al'Akir", "Re Mukla", "Reno Jackson", "Tavish Piccatonante", "N'zoth", "Ser Barov", "Guff Totem Runico", "Curatore", "Il Carceriere", "Fungomante Flurgl", "Sylvanas Ventolesto", "Ser Pinnus Mrrgglton", "Sfrl lo Sfrenato", "Capitano Eudora", "Maiev Cantombroso", "Onyxia", "Rokara", "Aranna Cercastelle", "Professor Putricidio", "Sindragosa", "Potenziabot", "Domasauri Brann", "Tess Mantogrigio", "Signor Bigolo", "Paolo il Caduto", "Yogg-Saron", "Ini Spiralampo" ->
                    3;
            default -> 4;
        };
    }

    /**
     * This fucntion is used to get all the heroes from the API and load them in a list
     * @param jsonNode is the node passed in order to access the JsonNode cards to retrieve the heroes
     * @return a list with all the heroes taken from the API
     * if there are no heroes found the list returned will be empty
     */
    public static List<Hero> getAllHeroes(JsonNode jsonNode){
        List<Hero> heroes = new ArrayList<>();

        JsonNode cards = jsonNode.get("cards");
        if(cards.isArray()){
            for(JsonNode cardNode : cards){
                if(cardNode.get("battlegrounds").get("hero").asBoolean()) {
                    String id = cardNode.get("id").asText();
                    int health = cardNode.get("health").asInt();
                    int armor = 0;
                    if(cardNode.get("armor") != null){
                        armor = cardNode.get("armor").asInt();
                    }
                    String name = cardNode.get("name").asText();
                    String image = cardNode.get("image").asText();
                    int tier = toTier(name);
                    //Add new Hero to list heroes
                    heroes.add(new Hero(id, health, armor, name, image, tier));
                }
            }
        }
        return heroes;
    }

    /**
     * This function returns a List of all the Minion that are in the API, and consequently all the Minion that are in
     * the game
     * @param jsonNode is the node passed in order to access the JsonNode cards to retrieve the minions
     * @return all the minion that are in the game as a List of Minion
     */
    public static List<Minion> getAllMinions(JsonNode jsonNode){
        List<Minion> minions = new ArrayList<>();
        JsonNode cards = jsonNode.get("cards");
        if(cards.isArray()){
            for(JsonNode cardNode : cards){
                if(!cardNode.get("battlegrounds").get("hero").asBoolean()) {
                    Set<String> type = new HashSet<>();

                    String id = cardNode.get("id").asText();
                    int health = cardNode.get("health").asInt();
                    int attack = cardNode.get("attack").asInt();
                    int tier = cardNode.get("battlegrounds").get("tier").asInt();
                    String name = cardNode.get("name").asText();
                    String image = cardNode.get("image").asText();
                    if(cardNode.get("minionTypeId") != null){
                        type.add(numberToType(cardNode.get("minionTypeId").asInt()));

                        if(cardNode.get("multiTypeIds") != null){
                            for(JsonNode objNode : cardNode.get("multiTypeIds")){
                                type.add(numberToType(objNode.asInt()));
                            }
                        }
                    }else{
                        type.add("No type");
                    }
                    minions.add(new Minion(id, health, attack, tier, name, type, image));
                }
            }
        }
        return minions;
    }
}