package com.cybertek.day10;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class govXmtTest {
    @BeforeAll
    public static void setUp() {

        baseURI = "https://data.ct.gov/api/views/qm34-pq7e/rows.xml";

    }
    @Test
    public void test1(){
       Response response = given().get("https://data.ct.gov/api/views/qm34-pq7e/rows.xml")
               .then().statusCode(200).extract().response();


        XmlPath xmlPath = response.xmlPath();
        List<Integer>years=xmlPath.getList("response.row.row.year");
        System.out.println("years = " + years);
    }
}
