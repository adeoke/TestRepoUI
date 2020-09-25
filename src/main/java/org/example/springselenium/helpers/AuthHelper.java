package org.example.springselenium.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthHelper {
    private final String apiHost;
    private final String apiPath;
    private final int apiPort;
    private final String userName;
    private final String password;

    public AuthHelper(@Value("${api.host}") String apiHost, @Value("${api.port}") int apiPort, @Value("${api.path}") String apiPath,
                      @Value("${username}") String userName, @Value("${pass}") String password) {
        this.apiHost = apiHost;
        this.apiPath = apiPath;
        this.apiPort = apiPort;
        this.userName = userName;
        this.password = password;
    }

    public String getDetailsForUser() {
        Response response = RestAssured.given().log().all()
                .queryParam("userName", userName)
                .queryParam("password", password)
                .port(apiPort)
                .get(apiHost + apiPath);
        return response.path("token");
    }
}
