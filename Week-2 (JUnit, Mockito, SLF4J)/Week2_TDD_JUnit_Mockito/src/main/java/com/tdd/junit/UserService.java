package com.tdd.junit;

public class UserService {

    private ExternalApi externalApi;

    public UserService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String getUserData(String userId) {
        return externalApi.getData();
    }

    public String processData(String data) {
        return "Processed: " + data;
    }
}