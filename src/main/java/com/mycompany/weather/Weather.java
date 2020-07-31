/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weather;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author Petra Furkes, 28th June, 2020
 */
@Path("/city") public class Weather {
    @GET
    @Path("/{param}")
    //curl -vi -X GET -G "http://localhost:49000/api/city/Zagreb" 
    
    //5 day / 3 hour forecast data in JSON format and temperature in Celsius, search by city name
    public Response GetWeather(@PathParam("param") String city) { 
        
        String APIKey = "0ad772426765aba1251c2fd24ec2384c";
        String URL = "https://api.openweathermap.org/data/2.5/forecast?q=" +city 
                + "&units=metric&&mode=json&appid=" + APIKey;
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL).request().get();
        return response;
    }
    
    
    @GET
    @Path("/{param1}/{param2}")
    //curl -vi -X GET -G "http://localhost:49000/api/city/Dublin/IE"
    
    //5 day / 3 hour forecast data in JSON format, temperature in Celsius, search by city name and country code
    public Response GetWeather1(@PathParam("param1") String city, @PathParam("param2") String countrycode) { 
        
        String APIKey = "0ad772426765aba1251c2fd24ec2384c";
        String URL = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "," 
                +countrycode+ "&units=metric&mode=json&appid="+APIKey;
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL).request().get();
        return response;
    }
    
    @GET
    @Path("/details/{param3}/{param4}")
    //curl -vi -X GET -G "http://localhost:49000/api/city/details/53.350140/-6.266155"
    
    //current weather data in JSON format, temperature in Celsius, hourly and daily data excluded
    //search by city latitude and longitude (Dublin 53.350140, -6.266155)
    public Response GetWeather2(@PathParam("param3") double latitude, @PathParam("param4") double longitude) { 
        
        String APIKey = "0ad772426765aba1251c2fd24ec2384c";
        String URL = "https://api.openweathermap.org/data/2.5/onecall?lat=" 
                + latitude + "&lon=" +longitude+ "&units=metric&exclude=hourly,daily&appid=" + APIKey;
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL).request().get();
        return response;
    }
    
    
    @GET
    @Path("/language/{param5}/{param6}/{param7}")
    //curl -vi -X GET -G "http://localhost:49000/api/city/language/45.8150/15.9819/HR"
    
    //current weather data in JSON format, temperature in Celsius, hourly data excluded
    //search by city latitude, longitude and language (Croatian - HR) output
    public Response GetWeather3(@PathParam("param5") double latitude, 
            @PathParam("param6") double longitude, @PathParam("param7") String language) { 
        
        String APIKey = "0ad772426765aba1251c2fd24ec2384c";
        String URL = "https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude 
                + "&lon=" +longitude+ "&lang=" +language 
                + "&units=metric&exclude=hourly&appid=" + APIKey;
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL).request().get();
        return response;
    }
    
    @GET
    @Path("/html/{param8}/{param9}")
    //curl -vi -X GET -G "http://localhost:49000/api/city/html/Dublin/IE"
    
    //current weather data in html format, temperature in Celsius, search by city name and country code
    public Response GetWeather4(@PathParam("param8") String city, @PathParam("param9") String countrycode) { 
        
        String APIKey = "0ad772426765aba1251c2fd24ec2384c";
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "," 
                +countrycode+ "&units=metric&mode=html&appid="+APIKey;
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL).request().get();
        return response;
    }
}