package com.tdd.junit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VerifyInteractionTest {

    @Test
    public void testVerifyMethodCalled() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Verify — getData() was called exactly once
        verify(mockApi).getData();
        System.out.println("testVerifyMethodCalled passed: getData() was called");
    }

    @Test
    public void testVerifyMethodCalledTimes() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        // Act — call fetchData 3 times
        service.fetchData();
        service.fetchData();
        service.fetchData();

        // Verify — getData() was called exactly 3 times
        verify(mockApi, times(3)).getData();
        System.out.println("testVerifyMethodCalledTimes passed: getData() called 3 times");
    }

    @Test
    public void testVerifyMethodNeverCalled() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Act — don't call fetchData at all

        // Verify — getData() was never called
        verify(mockApi, never()).getData();
        System.out.println("testVerifyMethodNeverCalled passed: getData() never called");
    }

    @Test
    public void testVerifyAtLeastOnce() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();
        service.fetchData();

        // Verify — getData() was called at least once
        verify(mockApi, atLeastOnce()).getData();
        System.out.println("testVerifyAtLeastOnce passed: getData() called at least once");
    }
}