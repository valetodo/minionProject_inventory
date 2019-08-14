package com.inventory.controller;


import com.inventory.models.dbentities.*;
import com.inventory.repository.InventoryPersistence;

import java.util.ArrayList;
import java.util.List;

public class InventoryController {

    private final InventoryPersistence repository;


    public InventoryController() {
        repository = new InventoryPersistence();
    }



    public List<Productbrand> showProductBrands() {
        List<Productbrand> marks = new ArrayList<>();
        try{
            marks = repository.showProductBrands();
        }catch(Exception ex){
            System.out.println("Exception - showProductBrands : " + ex.getMessage() + " / " + ex.getCause().getMessage());
        }
        return marks;
    }


    public Productbrand retrieveProductBrand(int id){
        try{
            Productbrand result = repository.retrieveProductBrand(id);
            return result;
        }catch(Exception ex){
            System.out.println("Exception - retrieveProductBrand : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return null;
    }


    public boolean saveProductBrand(Productbrand value){
        try{
            repository.saveProductBrand(value);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - saveProductBrand : " + ex.getMessage() + " / " + ex.getCause().getMessage());
        }
        return false;
    }


    public boolean updateProductBrand(Productbrand value){
        try{
            repository.updateProductBrand(value);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - saveProductBrand : " + ex.getMessage() + " / " + ex.getCause().getMessage());
        }
        return false;
    }


    public boolean deleteProductBrand(Productbrand value){
        try{
            repository.removeProductBrand(value);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - saveProductBrand : " + ex.getMessage() + " / " + ex.getCause().getMessage());
        }
        return false;
    }


    public List<Category> showCategories(){
        List<Category> categories = new ArrayList<>();
        try{
            categories = repository.showCategories();
        }catch(Exception ex){
            System.out.println("Exception - showCategories : " + ex.getMessage() + " / " + ex.getCause().getMessage());
        }
        return categories;
    }

    public boolean saveCategory(Category value){
        try{
            repository.saveCategory(value);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - saveCategory : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return false;
    }

    public boolean editCategory(Category val){
        try{
            repository.updateCategory(val);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - editCategory : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return false;
    }

    public boolean deleteCategory(Category id){
        try{
            repository.removeCategory(id);
            return true;
        }catch(Exception ex) {
            System.out.println("Exception - deleteCategory : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return false;
    }


    public List<Product> showProducts() {
        List<Product> result = new ArrayList<>();
        try{
            result = repository.showProducts();
        }catch(Exception ex){
            System.out.println("Exception - showProducts : " + ex.getMessage() + " / " + ex.getCause().getMessage());
        }
        return result;
    }

    public boolean saveInventoryProduct(Inventory value){
        try{
            repository.saveStock(value.getIdProduct().getIdStock());
            repository.saveConsume(value.getIdProduct().getIdConsume());
            repository.saveDurable(value.getIdProduct().getIdDurable());
            repository.saveProduct(value.getIdProduct());
            repository.saveInventory(value);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - saveProduct : " + ex.getMessage() + " / " + ex.getCause().getMessage());
        }
        return false;
    }

    public Product retrieveProduct(int id){
        try{
            Product result = repository.retrieveProduct(id);
            return result;
        }catch(Exception ex){
            System.out.println("Exception - retrieveProduct : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return null;
    }

    public boolean editProduct(Product ca) {
        try{
            repository.updateProduct(ca);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - editProduct : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return false;
    }

    public boolean deleteProduct(Product id) {
        try{
            repository.removeProduct(id);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - deleteProduct : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return false;
    }

    public List<Inventory> showInventories() {
        List<Inventory> result = new ArrayList<>();
        try{
            result = repository.showInventories();
        }catch(Exception ex){
            System.out.println("Exception - showProducts : " + ex.getMessage() + " / " + ex.getCause().getMessage());
        }
        return result;
    }


    public Inventory retrieveInventory(int id){
        try{
            Inventory result = repository.retrieveInventory(id);
            return result;
        }catch(Exception ex){
            System.out.println("Exception - retrieveProduct : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return null;
    }

    public boolean editInventory(Inventory ca) {
        try{
            Product prd = ca.getIdProduct();
            Consume cs = ca.getIdProduct().getIdConsume();
            Durable dr = ca.getIdProduct().getIdDurable();
            Stock stk = ca.getIdProduct().getIdStock();
            repository.updateStock(stk);
            repository.updateConsume(cs);
            repository.updateDurable(dr);
            repository.updateProduct(prd);
            repository.updateInventory(ca);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - editProduct : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return false;
    }

    public boolean deleteInventory(Inventory ca) {
        try{
            Product prd = ca.getIdProduct();
            Consume cs = ca.getIdProduct().getIdConsume();
            Durable dr = ca.getIdProduct().getIdDurable();
            Stock stk = ca.getIdProduct().getIdStock();
            repository.removeStock(stk);
            repository.removeConsume(cs);
            repository.removeDurable(dr);
            repository.removeProduct(prd);
            repository.removeInventory(ca);
            return true;
        }catch(Exception ex){
            System.out.println("Exception - deleteProduct : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return false;
    }


    public Category retrieveCategory(int id){
        try{
            Category result = repository.retrieveCategory(id);
            return result;
        }catch(Exception ex){
            System.out.println("Exception - retrieveCategory : " + ex.getMessage() + " / " + ex.getCause().getMessage());

        }
        return null;
    }


}
