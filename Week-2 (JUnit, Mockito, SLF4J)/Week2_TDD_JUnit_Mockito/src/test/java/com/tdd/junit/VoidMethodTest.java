package com.tdd.junit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VoidMethodTest {

    @Test
    public void testVoidMethodCalled() {
        // Arrange — mock the notification service
        NotificationService mockService = Mockito.mock(NotificationService.class);

        // Act — call the void method
        mockService.sendNotification("Hello World");

        // Verify — method was called with correct argument
        verify(mockService).sendNotification("Hello World");
        System.out.println("testVoidMethodCalled passed: sendNotification was called");
    }

    @Test
    public void testVoidMethodThrowsException() {
        // Arrange
        NotificationService mockService = Mockito.mock(NotificationService.class);

        // Stub void method to throw exception
        doThrow(new RuntimeException("Notification failed"))
            .when(mockService).sendNotification("bad message");

        // Act and Assert
        RuntimeException ex = assertThrows(
            RuntimeException.class,
            () -> mockService.sendNotification("bad message")
        );

        assertEquals("Notification failed", ex.getMessage());
        System.out.println("testVoidMethodThrowsException passed: " + ex.getMessage());
    }

    @Test
    public void testVoidMethodDoesNothing() {
        // Arrange
        NotificationService mockService = Mockito.mock(NotificationService.class);

        // Stub void method to do nothing (default behavior for mocked void methods)
        doNothing().when(mockService).sendNotification(anyString());

        // Act
        mockService.sendNotification("Test Message");

        // Verify
        verify(mockService, times(1)).sendNotification("Test Message");
        System.out.println("testVoidMethodDoesNothing passed: void method stubbed successfully");
    }

    @Test
    public void testVoidMethodCalledMultipleTimes() {
        // Arrange
        NotificationService mockService = Mockito.mock(NotificationService.class);

        // Act
        mockService.sendNotification("Message 1");
        mockService.sendNotification("Message 2");
        mockService.sendNotification("Message 3");

        // Verify — called exactly 3 times
        verify(mockService, times(3)).sendNotification(anyString());
        System.out.println("testVoidMethodCalledMultipleTimes passed: called 3 times");
    }
}