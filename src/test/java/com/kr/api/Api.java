package com.kr.api;

import com.kr.Data;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class Api {
    @BeforeMethod
    public void setup() {
        Awaitility.reset();
        Awaitility.setDefaultPollDelay(100, MILLISECONDS);
        Awaitility.setDefaultPollInterval(3, SECONDS);
        Awaitility.setDefaultTimeout(7, SECONDS);
    }

    @Test
    public void getTradeStream() {
        await().untilAsserted(() -> given()
                .get(Data.baseTradeUrl + Data.uriTradeStream)
                .then()
                .statusCode(Data.positiveresponseCode)
                .assertThat().contentType(ContentType.JSON)
                .body(Data.apiParameterNonce, Matchers.notNullValue())
                .body(Data.apiParameterToken, Matchers.notNullValue()));
    }

    @Test
    public void postSignIn() {
        Response response = given().
                queryParam(Data.apiParameterUsername, Data.username).
                queryParam(Data.apiParameterPassword, Data.password).
                when().
                post(Data.baseUrl + Data.uriSignIn).
                then().contentType(ContentType.HTML).extract().response();
        System.out.println(response.asString());
        response.then().statusCode(302).assertThat().contentType(ContentType.HTML);


    }

}
