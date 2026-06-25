package com.tdd.junit;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // Arrange — mock the REST client
        RestClient mockRestClient = mock(RestClient.class);
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Act
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        // Assert
        assertEquals("Fetched Mock Response", result);
        verify(mockRestClient).getResponse();
        System.out.println("testServiceWithMockRestClient passed: " + result);
    }

    @Test
    public void testApiServiceWhenRestClientFails() {
        // Arrange — simulate API failure
        RestClient mockRestClient = mock(RestClient.class);
        when(mockRestClient.getResponse())
            .thenThrow(new RuntimeException("API unavailable"));

        ApiService apiService = new ApiService(mockRestClient);

        // Act and Assert
        RuntimeException ex = assertThrows(
            RuntimeException.class,
            () -> apiService.fetchData()
        );
        assertEquals("API unavailable", ex.getMessage());
        System.out.println("testApiServiceWhenRestClientFails passed: " + ex.getMessage());
    }

    @Test
    public void testApiServiceWithMultipleResponses() {
        // Arrange — simulate multiple API calls
        RestClient mockRestClient = mock(RestClient.class);
        when(mockRestClient.getResponse())
            .thenReturn("First Response")
            .thenReturn("Second Response");

        ApiService apiService = new ApiService(mockRestClient);

        // Act
        String first  = apiService.fetchData();
        String second = apiService.fetchData();

        // Assert
        assertEquals("Fetched First Response",  first);
        assertEquals("Fetched Second Response", second);
        verify(mockRestClient, times(2)).getResponse();
        System.out.println("testApiServiceWithMultipleResponses passed");
        System.out.println("First: " + first + " | Second: " + second);
    }
}