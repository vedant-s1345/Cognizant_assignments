package com.ecommerce;

public class Main {
    public static void main(String[] args) {

        // Array sorted by productId — required for binary search
        Product[] products = {
                new Product(1, "Laptop",     "Electronics"),
                new Product(2, "Phone",      "Electronics"),
                new Product(3, "Shirt",      "Clothing"),
                new Product(4, "Book",       "Education"),
                new Product(5, "Shoes",      "Footwear")
        };

        int searchId = 3;

        // Linear Search
        Product result1 = SearchUtil.linearSearch(products, searchId);
        System.out.println("=== Linear Search ===");
        if (result1 != null) {
            System.out.println("Found: " + result1.productName + " | Category: " + result1.category);
        } else {
            System.out.println("Product not found");
        }

        // Binary Search
        Product result2 = SearchUtil.binarySearch(products, searchId);
        System.out.println("\n=== Binary Search ===");
        if (result2 != null) {
            System.out.println("Found: " + result2.productName + " | Category: " + result2.category);
        } else {
            System.out.println("Product not found");
        }

        // Analysis
        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Linear Search  : O(n) - checks every element, works on unsorted arrays");
        System.out.println("Binary Search  : O(log n) - faster, but needs sorted array");
        System.out.println("For large product catalogs, Binary Search is preferred");
    }
}