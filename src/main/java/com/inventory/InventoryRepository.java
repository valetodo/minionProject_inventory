package com.inventory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {

    @PersistenceContext(unitName = "ccinventory")
    private EntityManager entityManager;

    private String specialCharacter = "\\";

    private List<Category> categories;
    private List<Mark> marks;
    private List<Inventory> productos;

    public InventoryRepository(){
        categories = new ArrayList<>();
        marks = new ArrayList<>();
        productos = new ArrayList<>();
        //entityManager = Persistence.;
    }

    public List<Inventory> showProducts(){
        return productos;
    }

    public boolean saveCategory(Category value){
        categories.add(value);
        return categories.contains(value);
    }


    public List<Category> showCategories(){
        return categories;
    }


    public Category retrieveCategory(int id){
        Category ca = null;
        for(int i = 0; i < categories.size() ; i++){
            if(i == id){
                ca = categories.get(i);
            }
        }
        return ca;
    }


    public Inventory retrieveProduct(int id){
        Inventory ca = null;
        for(Inventory i : productos){
            if(i.getIdProduct() == id){
                ca = i;
            }
        }
        return ca;
    }


    public boolean editCategory(Category val, int id){
        boolean res = false;
        for(int i = 0; i < categories.size() ; i++){
            if(i == id){
                categories.get(i).setName(val.getName());
                categories.get(i).setUnidadDeMedida(val.getUnidadDeMedida());
                res = true;
            }
        }
        return res;
    }


    public boolean deleteCategory(int id){
        List<Category> cat = new ArrayList<>();
        boolean res = true;
        for(int i = 0; i < categories.size() ; i++){
            if(i == id){
                cat.add(categories.get(i));
            }
        }
        categories = cat;
        return res;
    }

    public boolean saveMark(Mark value) {
        marks.add(value);
        return marks.contains(value);
    }

    public List<Mark> showMarks() {
        return marks;
    }

    public boolean saveProduct(Inventory duradero) {
        productos.add(duradero);
        /*
        try{
            entityManager.persist(duradero.getProduct());
            entityManager.persist(duradero);
        }catch(Exception ex){
            int r = 0;
        }
        */
        return categories.contains(duradero);
    }

    public boolean editProduct(Inventory val, int id) {
        boolean res = false;
        for(int i = 0; i < productos.size() ; i++){
            if(i == id){
                productos.get(i).setNameProduct(val.getNameProduct());
                productos.get(i).setPrice(val.getPrice());
                productos.get(i).setStatus(val.isStatus() ? "T" : "F");
                productos.get(i).getProduct().setLocation(val.getProduct().getLocation());
                productos.get(i).getProduct().setQuantity(val.getProduct().getQuantity());
                res = true;
            }
        }
        return res;
    }

    public boolean deleteProduct(int id){
        List<Inventory> cat = new ArrayList<>();
        boolean res = true;
        for(int i = 0; i < productos.size() ; i++){
            if(i == id){
                cat.add(productos.get(i));
            }
        }
        productos = cat;
        return res;
    }
}
