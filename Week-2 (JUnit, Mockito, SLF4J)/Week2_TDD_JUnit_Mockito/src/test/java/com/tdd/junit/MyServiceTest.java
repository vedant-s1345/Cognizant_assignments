package com.tdd.junit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testMockingAndStubbing() {
        // Arrange — create mock and stub its method
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act — use mock in service
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert — verify stubbed value returned
        assertEquals("Mock Data", result);
        System.out.println("testMockingAndStubbing passed: result = " + result);
    }

    @Test
    public void testMockReturnsDefaultWhenNotStubbed() {
        // Arrange — create mock WITHOUT stubbing
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Act
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert — unstubbed mock returns null by default
        assertNull(result);
        System.out.println("testMockReturnsDefaultWhenNotStubbed passed: result is null");
    }

    @Test
    public void testStubbingWithDifferentValues() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");

        // Act and Assert
        MyService service = new MyService(mockApi);
        assertEquals("First Call",  service.fetchData());
        assertEquals("Second Call", service.fetchData());
        assertEquals("Third Call",  service.fetchData());
        System.out.println("testStubbingWithDifferentValues passed");
    }
}