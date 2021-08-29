package com.cybertek.day10;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class FormulaOneXmlTest {

    @BeforeAll
    public static void setUp(){
        //http://ergast.com/api/f1/drivers/alonso
        baseURI = "http://ergast.com";
        basePath ="/api/f1";

    }

    @Test
    public void test1(){

        Response response = given()
                .pathParam("driver", "alonso")
                .when()
                .get("/drivers/{driver}")
                .then().statusCode(200).log().all()
                .extract().response();

        XmlPath xmlPath =response.xmlPath();

        String givenName = xmlPath.getString("MRData.DriverTable.Driver.GivenName");
        System.out.println("givenName = " + givenName);

        String familyName= xmlPath.getString("MRData.DriverTable.Driver.FamilyName");
        System.out.println("familyName = " + familyName);



    }
}