package com.cybertek.day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class CsvSourceParametrizedTest {

    // Test first number + second number = third number
//            1, 3 , 4
//            2, 3 , 5
//            8, 7 , 15
//            10, 9 , 19

    @ParameterizedTest
    @CsvSource({"1, 3 , 4",
            "2, 3 , 5",
            "8, 7 , 15",
            "10, 9 , 19"})
    public void testAddition(int num1,int num2, int sum){

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("sum = " + sum);
        //assert num1+ num2 equalsto sum

        assertThat(num1+num2,equalTo(sum));
    }

    // Write a parameterized test for this request
    // GET https://api.zippopotam.us/us/{state}/{city}
    /*
        "NY, New York",
        "CO, Denver",
        "VA, Fairfax",
        "VA, Arlington",
        "MA, Boston",
        "NY, New York",
        "MD, Annapolis"
     */
    //verify place name contains your city name
    //print number of places for each request


}