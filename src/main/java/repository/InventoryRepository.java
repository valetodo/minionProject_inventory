package java.repository;

import java.models.Category;
import java.models.Inventory;
import java.models.Mark;
import java.models.Product;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {
    private final Inventory inventory;
    private List<Category> categories;
    private List<Mark> marks;
    private List<Product> productos;

    public InventoryRepository(){
        this.inventory = new Inventory();
        categories = new ArrayList<>();
        marks = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public List<Product> showProducts(){
        for(int i = 0; i < productos.size() ; i++){
            productos.get(i).setIdProduct(i);
        }
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


    public Product retrieveProduct(int id){
        Product ca = null;
        for(Product i : productos){
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

    public boolean saveProduct(Product duradero) {
        productos.add(duradero);

        for(int i = 0; i < productos.size() ; i++){
            productos.get(i).setIdProduct(i);
        }
        return categories.contains(duradero);
    }

    public boolean editProduct(Product val, int id) {
        boolean res = false;
        for(int i = 0; i < productos.size() ; i++){
            if(i == id){
                productos.get(i).setNameProduct(val.getNameProduct());
                productos.get(i).setLocation(val.getLocation());
                productos.get(i).setPrice(val.getPrice());
                productos.get(i).setQuantity(val.getQuantity());
                productos.get(i).setStatus(val.isStatus());
                res = true;
            }
        }
        for(int i = 0; i < productos.size() ; i++){
            productos.get(i).setIdProduct(i);
        }
        return res;
    }

    public boolean deleteProduct(int id){
        List<Product> cat = new ArrayList<>();
        boolean res = true;
        for(int i = 0; i < productos.size() ; i++){
            if(i == id){
                cat.add(productos.get(i));
            }
        }
        productos = cat;
        for(int i = 0; i < productos.size() ; i++){
            productos.get(i).setIdProduct(i);
        }
        return res;
    }
}
