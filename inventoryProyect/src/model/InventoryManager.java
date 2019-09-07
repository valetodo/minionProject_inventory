/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CategoryJpaController;
import controller.ConsumeJpaController;
import controller.DurableJpaController;
import controller.ProductBrandJpaController;
import controller.ProductJpaController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.exp;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pruebas.terminalHistory;

/**
 *
 * @author Alberto Vargas
 */
public class InventoryManager {
     public static void executeProgram(){
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("ejemploPU");
          
        ProductJpaController productController = new ProductJpaController(emf);
        DurableJpaController durableController = new DurableJpaController(emf);
        ConsumeJpaController consumeController = new ConsumeJpaController(emf);
        CategoryJpaController categoryController = new CategoryJpaController(emf);
        ProductBrandJpaController productBrandController = new ProductBrandJpaController(emf);       
         
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("==== INVENTARY SYSTEM ====");
        System.out.println("");
        int op;
        do{
            System.out.println("[ MAIN MENU ]");
            System.out.println("");
            System.out.println("1.- Show Products");
            System.out.println("2.- Add Product");
            System.out.println("3.- Update Product");
            System.out.println("4.- Delete Product");
            System.out.println("5.- Add Category");
            System.out.println("6.- Show Categories");
            System.out.println("7.- Update Category");
            System.out.println("8.- Delete Category");
            System.out.println("9.- Add Brand");
            System.out.println("10.- Show Brand");
            System.out.println("11.- Update Brand");
            System.out.println("12.- Delete Brand");
            System.out.println("13.- History");
            System.out.println("14.- Salir");
            System.out.println("");
            
            System.out.println("select option menu:");
            op = scanner.nextInt();
            
            Product product = new Product();
            Durable durable = new Durable();
            Consume consume = new Consume();
            Category category = new Category();
            ProductBrand productBrand = new ProductBrand();
            
            switch(op){
                case 1:{             
                    List<Product> listProduct = productController.findProductEntities();
                    System.out.println("[ SHOW PRODUCTS ]"); 
                    
                    for(Product p : listProduct) {
                        System.out.println(p.getIdProduct() +" "+ p.getNameProduct() +" "+ p.getPrice() +" "+ p.getStatus() +" "+ p.getLocation() +" "+ p.getQuantity());
                    }
                    break;
                }
                case 2:{
                    System.out.println("[ ADD PRODUCT ]");
                    //System.out.println("Enter a Mark Id:");
                    //int markId = scanner.nextInt();
                    
                    try {
                        //productBrandController.findProductBrand(markId).getIdBrand();
//                        if(productBrandController.findProductBrand(markId) == null){
//                            System.out.println("Cannot find Mark");
//                            break;
//                        }

                        System.out.println("Enter location:");
                        String location = scanner.next();

                        System.out.println("Enter name product:");
                        String nameProduct = scanner.next();

                        System.out.println("Enter price:");
                        int price = scanner.nextInt();

                        System.out.println("Enter Quantity:");
                        int quantity = scanner.nextInt();

                        System.out.println("Enter status:");
                        String status = scanner.next();

                        System.out.println("Enter size:");
                        int size = scanner.nextInt();

                        System.out.println("Enter Weigth:");
                        int weigth = scanner.nextInt();

                        System.out.println("Enter expiration Date, (yyyy-MM-dd):");
                        String expiration = scanner.next();

                        Date date;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd").parse(expiration);
                        } catch (ParseException ex) {
                            System.out.println("Cannot parse date.");
                            break;
                        }

                        product.setLocation(location);
                        product.setNameProduct(nameProduct);
                        product.setPrice(price);
                        product.setQuantity(quantity);
                        product.setStatus(status);

                        durable.setSizeDurable(size);
                        durable.setWeighDurable(weigth);

                        consume.setExpiration(date);
                        
                        productController.create(product);
                        durableController.create(durable);
                        consumeController.create(consume);
                        System.out.println("Product created successfully");
                        
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                    break;
                }
                case 3:{
                    System.out.println("[ EDIT PRODUCT ]");

//                    List<Inventory> products = inventoryController.showInventories();
//                    for(Inventory i : products){
//                        System.out.println("* " + i.printInfo());
//                    }
                    System.out.println("");
                    
                    try {
                        System.out.println("Enter an Product Id:");
                        int productId = scanner.nextInt();
                        //System.out.println("HEREEE" + productController.findProduct(productId).getLocation());
                        product = productController.findProduct(productId);
                        
                        System.out.println("Edit location:");
                        String location = scanner.next();

                        System.out.println("Edit name product:");
                        String nameProduct = scanner.next();

                        System.out.println("Edit price:");
                        int price = scanner.nextInt();

                        

                        System.out.println("Edit status:");
                        String status = scanner.next();

                        System.out.println("Edit size:");
                        int size = scanner.nextInt();

                        System.out.println("Edit Weigth:");
                        int weigth = scanner.nextInt();

                        System.out.println("Edit expiration Date, (yyyy-MM-dd):");
                        String expiration = scanner.next();

                        Date date;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd").parse(expiration);
                        } catch (ParseException ex) {
                            System.out.println("Cannot parse date.");
                            break;
                        }

                        product.setLocation(location);
                        product.setNameProduct(nameProduct);
                        product.setPrice(price);
                        
                        System.out.println("Edit Quantity:");
                        int quantity = scanner.nextInt();
                        System.out.println("do you want to reduce the introduced quantity? YES/NO?");
                        String response = scanner.next();
                        if (response.equals("yes")) {
                            product.decreaseQuantity(quantity);
                        }
                        if(response.equals("no")){
                            System.out.println("do you want to increase quantity product?");
                            product.increaseQuantity(quantity);
                        }
                        //product.setQuantity(quantity);
                        
                        product.setStatus(status);

                        durable.setSizeDurable(size);
                        durable.setWeighDurable(weigth);

                        consume.setExpiration(date);

                        productController.edit(product);
                        durableController.edit(durable);
                        consumeController.edit(consume);
                        
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                    break;
                }
                case 4:{
                    try {
                        System.out.println("[ DELETE PRODUCT ]");
                        System.out.println("");
                        System.out.println("Enter Product Id");
                        int productId = scanner.nextInt();
                        System.out.println("Product to be deleted : " +" "+ productController.findProduct(productId).getIdProduct() +" "+ productController.findProduct(productId).getNameProduct());
                        productController.destroy(productId);
                        System.out.println("");
                        System.out.println("Product deleted successfully");
                        System.out.println("");
                    
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:{
                    try {
                        System.out.println("[ ADD CATEGORY ]");
                        System.out.println("");
                        System.out.println("Enter Name category");
                        String nameCategory = scanner.next();
                        
                        System.out.println("Enter unit of measure;");
                        String measurement = scanner.next();
                        
                        category.setNameCategory(nameCategory);
                        category.setMeasurement(measurement);
                        
                        categoryController.create(category);
                        System.out.println("Category created successfully");
                        
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                    break;
                }
                case 6: {
                    List<Category> listCategory = categoryController.findCategoryEntities();
                    System.out.println("[ SHOW CATEGORIES ]"); 
                    
                    for(Category c : listCategory) {
                        System.out.println(c.getIdCategory() +" "+ c.getNameCategory() +" "+ c.getMeasurement());
                    }
                    break;
                }
                case 7: {
                    System.out.println("[ EDIT CATEGORY ]");
                    System.out.println("");
                    
                    try {
                        System.out.println("Enter Category Id:");
                        int categoryId = scanner.nextInt();
                        //System.out.println(categoryController.findCategory(categoryId));
                        category = categoryController.findCategory(categoryId);
                        
                        System.out.println("Edit name category:");
                        String nameCategory = scanner.next();

                        System.out.println("Edit unit of measure:");
                        String measurement = scanner.next();

                        category.setNameCategory(nameCategory);
                        category.setMeasurement(measurement);

                        categoryController.edit(category);
                        
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                    break;
                }
                case 8: {
                    try {
                        System.out.println("[ DELETE CATEGORY ]");
                        System.out.println("");
                        System.out.println("Enter Category Id");
                        int categoryId = scanner.nextInt();
                        System.out.println("Category to be deleted : " +" "+ categoryController.findCategory(categoryId).getIdCategory() +" "+ categoryController.findCategory(categoryId).getNameCategory() +" "+ categoryController.findCategory(categoryId).getMeasurement());
                        categoryController.destroy(categoryId);
                        System.out.println("");
                        System.out.println("Category deleted successfully");
                        System.out.println("");
                    
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                    break;
                }
                case 9: {
                    try {
                        System.out.println("[ ADD BRAND ]");
                        System.out.println("");
                        
                        System.out.println("Enter Name brand:");
                        String nameBrand = scanner.next();
                        
                        System.out.println("Enter origin brand:");
                        String originBrand = scanner.next();
                        
                        productBrand.setNameBrand(nameBrand);
                        productBrand.setOriginBrand(originBrand);
                        
                        productBrandController.create(productBrand);
                        System.out.println("Brand created successfully");
                        
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                }
                case 10: {
                    List<ProductBrand> listProductBrand = productBrandController.findProductBrandEntities();
                    System.out.println("[ SHOW BRANDS ]"); 
                    
                    for(ProductBrand pb : listProductBrand) {
                        System.out.println(pb.getIdBrand() +" "+ pb.getNameBrand() +" "+ pb.getOriginBrand());
                    }
                    break;
                }
                case 11: {
                    System.out.println("[ EDIT BRAND ]");
                    System.out.println("");
                    
                    try {
                        System.out.println("Enter brand Id:");
                        int brandId = scanner.nextInt();
                        //System.out.println(categoryController.findCategory(categoryId));
                        productBrand = productBrandController.findProductBrand(brandId);
                        
                        System.out.println("Edit name brand:");
                        String nameBrand = scanner.next();

                        System.out.println("Edit origin brand:");
                        String originBrand = scanner.next();

                        productBrand.setNameBrand(nameBrand);
                        productBrand.setOriginBrand(originBrand);

                        productBrandController.edit(productBrand);
                        
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                    break;
                }
                case 12: {
                    try {
                        System.out.println("[ DELETE BRAND ]");
                        System.out.println("");
                        System.out.println("Enter Brand Id");
                        int brandId = scanner.nextInt();
                        System.out.println("Brand to be deleted : " +" "+ productBrandController.findProductBrand(brandId).getIdBrand() +" "+ productBrandController.findProductBrand(brandId).getNameBrand() +" "+ productBrandController.findProductBrand(brandId).getOriginBrand());
                        productBrandController.destroy(brandId);
                        System.out.println("");
                        System.out.println("Brand deleted successfully");
                        System.out.println("");
                    
                    } catch(Exception e){
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                    break;
                }
                case 13: {
                    terminalHistory history = new terminalHistory();
                    history.showTerminalHistory();
                }
                case 14: {
                    System.out.println("[ CLOSING... ]");
                    break;
                }
            }
            System.out.println("");
        }while(op != 14);
        System.out.println("");
    }
}     



//                case 11:{
//                    printOut("[ EDIT MARK ]");
//                    printOut("Enter a MarkId:");
//                    int markId = readNumber();
//                    Productbrand item = inventoryController.retrieveProductBrand(markId);
//                    if(item != null){
//                        printOut("");
//                        printOut(item.printInfo());
//                        printOut("");
//                        printOut("Enter a name:");
//                        String name = readString();
//                        printOut("Enter an origin");
//                        String origin = readString();
//                        item.setNameBrand(name);
//                        item.setOriginBrand(origin);
//                        boolean result = inventoryController.updateProductBrand(item);
//                        if(result){
//                            printOut("Mark updated.");
//                        } else {
//                            printOut("Mark not updated.");
//                        }
//                    } else{
//                        printOut("Cannot find Mark");
//                    }
//                    readKey();
//                    break;
//                }   
