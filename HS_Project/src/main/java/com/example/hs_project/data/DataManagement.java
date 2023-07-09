package com.example.hs_project.data;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * The class DataManagement is used in order to create a stable connection to the official Hearthstone API,
 * to get the full minions list
 * and to get the full heroes list
 **/
public class DataManagement {
    private static APIConnector apiConnector;
    private final List<Hero> heroes = new ArrayList<>();
    private final List<Minion> minions = new ArrayList<>();

    /**
     * This constructor is used to get the apiConnector using the clientID and the clientSecret
     */
    public DataManagement() {
        apiConnector = new APIConnector("aa55003f713245148147086d3c009181", "Lb2773I7r77cVUoVe7x1pNhCgldmebxV");
    }

    /**
     * This method loads the data from the official API using JSON as type retrieved from the API
     */
    public void loadData(){
        for(int pageNumber = 1; pageNumber <= 8; ++pageNumber){
            JsonNode jsonNode = apiConnector.fetchCards("", "", "", "", String.valueOf(pageNumber));
            minions.addAll(Converter.getAllMinions(jsonNode));
            heroes.addAll(Converter.getAllHeroes(jsonNode));
        }
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public List<Minion> getMinions() {
        return minions;
    }
}