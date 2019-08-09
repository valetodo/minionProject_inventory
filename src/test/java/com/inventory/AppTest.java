package com.inventory;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    private Inventory inventory;
    private InventoryRepository inventoryRepository;
    private Category category;

    public AppTest(){
        inventory = new Inventory();
        inventoryRepository = new InventoryRepository();
        category = new Category();
    }

    @Test
    public void testAppHasAGreeting() {
        assertNotNull("app should have a greeting", Inventory.getGreeting());
    }

    @Test
    public void testSaveCategory() {
        boolean actual = inventoryRepository.saveCategory(category);
        assertEquals(true,actual);
    }

    @Test
    public void testRetrieveCategory() {
        int idCategory = 1;
        Category retrieveCategory = inventoryRepository.retrieveCategory(idCategory);
        assertNull(retrieveCategory);
    }

    @Test
    public void testEditProduct() {
        int idProduct = 12;
        boolean actual = inventoryRepository.editProduct(inventory, idProduct);
        assertEquals(false, actual);
    }
}
