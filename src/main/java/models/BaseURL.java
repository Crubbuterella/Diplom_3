package models;

import apis.EndpointsAPI;
import io.restassured.RestAssured;

public class BaseURL {
    protected static void setUp(){
        RestAssured.baseURI = EndpointsAPI.BURGER_URL;
    }
}
