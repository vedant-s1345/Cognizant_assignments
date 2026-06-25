package com.tdd.junit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArgumentMatchingTest {

    @Test
    public void testAnyStringMatcher() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        UserService service = new UserService(mockApi);

        // Act
        String result = service.getUserData("any-user-id");

        // Assert
        assertEquals("Mock Data", result);
        verify(mockApi).getData();
        System.out.println("testAnyStringMatcher passed: result = " + result);
    }

    @Test
    public void testExactArgumentMatcher() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("User Data");

        UserService service = new UserService(mockApi);

        // Act
        String result = service.getUserData("user123");

        // Assert
        assertEquals("User Data", result);
        verify(mockApi, times(1)).getData();
        System.out.println("testExactArgumentMatcher passed: result = " + result);
    }

    @Test
    public void testProcessData() {
        // Arrange
        UserService service = new UserService(Mockito.mock(ExternalApi.class));

        // Act
        String result = service.processData("Hello");

        // Assert
        assertEquals("Processed: Hello", result);
        System.out.println("testProcessData passed: result = " + result);
    }
}