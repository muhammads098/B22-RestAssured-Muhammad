package com.cybertek.day5;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JSONtoJAVATest extends SpartanTestBase {
    @Test
    public void oneSpartanToMap(){
       Response response =  given().pathParam("id",15).when().get("/api/spartans/{id}").then()
               .statusCode(200).extract().response();

        Map<String,Object>jsonMap = response.as(Map.class);
    }
}
