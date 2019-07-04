package java.controller;

import java.models.Category;
import java.models.Mark;
import java.models.Product;
import java.repository.InventoryRepository;
import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    private final InventoryRepository repository;

    public InventoryController() {
        repository = new InventoryRepository();
    }

    public void saveCategory(Category value){
        try{
            boolean res = repository.saveCategory(value);
            int t = 0;
        }catch(Exception ex){

        }
    }


    public List<Category> showCategories(){
        List<Category> categories = new ArrayList<>();
        try{
            categories = repository.showCategories();
        }catch(Exception ex){

        }
        return categories;
    }


    public Category retrieveCategory(int id){
        Category result = null;
        try{
            result = repository.retrieveCategory(id);
        }catch(Exception ex){

        }
        return result;
    }


    public void editCategory(Category val, int id){
        try{
            boolean res = repository.editCategory(val, id);
            int t = 0;
        }catch(Exception ex){

        }
    }


    public void deleteCategory(int id){
        try{
            boolean res = repository.deleteCategory(id);
            int t = 0;
        }catch(Exception ex){

        }
    }


    public void saveMark(Mark value){
        try{
            boolean res = repository.saveMark(value);
            int t = 0;
        }catch(Exception ex){

        }
    }

    public List<Mark> showMarks() {
        List<Mark> marks = new ArrayList<>();
        try{
            marks = repository.showMarks();
        }catch(Exception ex){

        }
        return marks;
    }



    public List<Product> showProducts() {
        List<Product> categories = new ArrayList<>();
        try{
            categories = repository.showProducts();
        }catch(Exception ex){

        }
        return categories;
    }


    public void saveProduct(Product value){
        try{
            repository.saveProduct(value);
            int t = 0;
        }catch(Exception ex){

        }
    }


    public Product retrieveProduct(int id){
        Product result = null;
        try{
            result = repository.retrieveProduct(id);
        }catch(Exception ex){

        }
        return result;
    }

    public void editProduct(Product ca, int id) {
        try{
            boolean res = repository.editProduct(ca, id);
            int t = 0;
        }catch(Exception ex){

        }
    }

    public void deleteProduct(int id) {
        try{
            boolean res = repository.deleteProduct(id);
            int t = 0;
        }catch(Exception ex){

        }
    }

}
