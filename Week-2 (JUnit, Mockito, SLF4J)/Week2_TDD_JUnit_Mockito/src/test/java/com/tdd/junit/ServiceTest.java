package com.tdd.junit;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        // Arrange — mock the repository
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData()).thenReturn("Mock Data");

        // Act
        Service service = new Service(mockRepository);
        String result = service.processData();

        // Assert
        assertEquals("Processed Mock Data", result);
        verify(mockRepository).getData();
        System.out.println("testServiceWithMockRepository passed: " + result);
    }

    @Test
    public void testServiceWithMultipleRepositoryCalls() {
        // Arrange
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");

        Service service = new Service(mockRepository);

        // Act
        String first  = service.processData();
        String second = service.processData();

        // Assert
        assertEquals("Processed First Mock Data",  first);
        assertEquals("Processed Second Mock Data", second);
        verify(mockRepository, times(2)).getData();
        System.out.println("testServiceWithMultipleRepositoryCalls passed");
        System.out.println("First: " + first);
        System.out.println("Second: " + second);
    }

    @Test
    public void testServiceWhenRepositoryThrowsException() {
        // Arrange
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData()).thenThrow(new RuntimeException("Database connection failed"));

        Service service = new Service(mockRepository);

        // Act and Assert
        RuntimeException ex = assertThrows(
            RuntimeException.class,
            () -> service.processData()
        );
        assertEquals("Database connection failed", ex.getMessage());
        System.out.println("testServiceWhenRepositoryThrowsException passed: " + ex.getMessage());
    }
}