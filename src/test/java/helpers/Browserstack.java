package helpers;

import config.BrowserstackConfig;
import config.BrowserstackCredentials;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        return given()
                //.auth().basic("olga_ouHam9", "iDs7wY8LzQqGhHiJ1369") // log-pass
                .auth().basic(BrowserstackCredentials.config.user(), BrowserstackCredentials.config.password()) // log-pass
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}