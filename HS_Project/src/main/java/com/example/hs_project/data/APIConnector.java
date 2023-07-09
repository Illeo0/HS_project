package com.example.hs_project.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The class APIConnector is used to create a connection with the official Hearthstone API
 **/
public class APIConnector {
    String clientId;
    String clientSecret;
    private String token;

    /**
     * This function fetches the access token in orden to create a connection to the API
     * @param clientId is a string needed to create a connection to the API
     * @param clientSecret is a string needed to create a connection to the API
     * @return a string representing the access token to the API
     * otherwise it returns null
     */
    private String fetchToken(String clientId, String clientSecret) {
        String credentials = clientId + ":" + clientSecret;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        try {
            //URL and parameters
            String tokenUrl = "https://oauth.battle.net/token";
            String grantType = "client_credentials";

            //Create URL object with parameters
            URL url = new URL(tokenUrl);
            String params = "grant_type=" + grantType;
            byte[] postData = params.getBytes(StandardCharsets.UTF_8);

            //Create connection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //Set request method
            connection.setRequestMethod("POST");

            //Set basic authentication header
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);

            //Enable output and set content type
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            //Write post data to connection
            connection.getOutputStream().write(postData);

            //Get response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode responseJson = mapper.readTree(response.toString());

            return responseJson.get("access_token").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This function fetches the cards from the API
     * @param tiers is an optional string that filters minions based on their tavern tier
     * @param minionType is an optional string that filters minions based on their type
     * @param sort is an optional string that sorts minions based on their tavern tier
     * @param hero is an optional string that filters only the hero cards
     * @param pageNumber is an optional string that helps to get all the cards from all the API pages
     * @return a JSONNode needed to get the cards from the API in the Converter class
     * otherwise it returns null
     */
    public JsonNode fetchCards(String tiers, String minionType, String sort, String hero, String pageNumber){
        String endPoint = "https://eu.api.blizzard.com/hearthstone/cards?locale=it_IT&gameMode=battlegrounds&access_token=" + token;
        if(!tiers.isBlank()){
            endPoint += "&tier=" + tiers;
        }
        if (!minionType.isBlank()) {
            endPoint += "&minionType=" + minionType;
        }
        if(!sort.isBlank()){
            endPoint += "&sort=" + sort;
        }
        if(!hero.isBlank()){
            endPoint += "&hero=" + hero;
        }
        if(!pageNumber.isBlank()){
            endPoint += "&page=" + pageNumber;
        }
        try{
            URL url = new URL(endPoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int respondeCode = connection.getResponseCode();

            //Check if connection is correct
            if(respondeCode != 200){
                throw new RuntimeException("HttpRespondseCode: " + respondeCode);
            }else{
                StringBuilder cardString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while(scanner.hasNext()){
                    cardString.append(scanner.nextLine());
                }
                scanner.close();
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readTree(cardString.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Constructor of the class
     * @param clientId is a string needed to create a connection to the API
     * @param clientSecret clientId is a string needed to create a connection to the API
     */
    public APIConnector(String clientId, String clientSecret) {
        this.token = fetchToken(clientId, clientSecret);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
}