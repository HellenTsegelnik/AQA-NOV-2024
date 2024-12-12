package org.prog.testng;



// TODO: write simple test that will:
// TODO: - include location to query params
// TODO: - assert location.city != null
// TODO: - print timezone.description

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class RestHomework {
    @Test
    public void testRandomUserApiLocation() {
        // Указываем базовый URL API Random User
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("no-info");
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");

        Response response = requestSpecification.get();
        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.contentType(ContentType.JSON);
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");


        String city = response.path("results[0].location.city");
        String timezoneDescription = response.path("results[0].location.timezone.description");


        Assert.assertNotNull(city, "City should not be null");
        System.out.println("City: " + city);


        System.out.println("Timezone description: " + timezoneDescription);
    }
}

