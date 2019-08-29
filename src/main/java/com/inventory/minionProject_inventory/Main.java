package com.inventory.minionProject_inventory;


import com.inventory.models.dbentities.*;
import com.inventory.controller.InventoryController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static InventoryController inventoryController;

    public static void main(String[] args) {
        inventoryController = new InventoryController();
        executeProgram();

    }

    private static void executeProgram(){
        Scanner scanner;
        printOut("");
        printOut("==== INVENTARY SYSTEM ====");
        printOut("");
        int op = 0;
        do{
            printOut("[ MAIN MENU ]");
            printOut("");
            printOut("1.- Show Products");
            printOut("2.- Add Product");
            printOut("3.- Update Product");
            printOut("4.- Delete Product");
            printOut("5.- Add Category");
            printOut("6.- Show Categories");
            printOut("7.- Update Category");
            printOut("8.- Delete Category");
            printOut("9.- Add Mark");
            printOut("10.- Show Marks");
            printOut("11.- Update Mark");
            printOut("12.- Delete Mark");
            printOut("13.- Salir");
            printOut("");
            op = readNumber();
            switch(op){
                case 1:{
                    printOut("[ SHOW PRODUCTS ]");
                    List<Inventory> products = inventoryController.showInventories();
                    System.out.println("estoooo" + products);
                    for(Inventory i : products){
                        System.out.println("* " + i.printInfo());
                    }
                    readKey();
                    break;
                }
                case 2:{
                    printOut("[ ADD PRODUCT ]");
                    printOut("Enter a Mark Id:");
                    int markId = readNumber();
                    Productbrand brand = inventoryController.retrieveProductBrand(markId);
                    if(brand == null){
                        printOut("Cannot find Mark");
                        break;
                    }
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Quantity:");
                    int quantity = readNumber();
                    printOut("Enter a Max Quantity:");
                    int maxQuantity = readNumber();
                    printOut("Enter a Min Quantity:");
                    int minQuantity = readNumber();
                    printOut("Enter a Price:");
                    double price = readDouble();
                    printOut("Enter a Location:");
                    String location = readString();
                    printOut("Enter a Size:");
                    int size = readNumber();
                    printOut("Enter a Weigth:");
                    int weight = readNumber();

                    printOut("Enter an expiration Date, (yyyy-MM-dd):");
                    String exp = readString();
                    Date fecha;
                    try {
                        fecha = new SimpleDateFormat("yyyy-MM-dd").parse(exp);
                    } catch (ParseException ex) {
                        printOut("Cannot parse date.");
                        break;
                    }

                    Durable item = new Durable();
                    item.setWeighDurable(weight);
                    item.setSizeDurable(size);
                    Consume item2 = new Consume();
                    item2.setExpiration(fecha);
                    Stock stk = new Stock();
                    stk.setMaxQuantity(maxQuantity);
                    stk.setMinQuantity(minQuantity);
                    Product prd = new Product();
                    prd.setStatus("true");
                    prd.setNameProduct(name);
                    prd.setQuantity(quantity);
                    prd.setLocation(location);
                    prd.setPrice(BigDecimal.valueOf(price));
                    prd.setIdBrand(brand);
                    prd.setIdStock(stk);
                    prd.setIdDurable(item);
                    prd.setIdConsume(item2);
                    Inventory inv = new Inventory();
                    inv.setIdProduct(prd);
                    inv.setAvailableQuatity(quantity);
                    inv.setIniQuantity(quantity);
                    inv.setProducts(1);

                    boolean result = inventoryController.saveInventoryProduct(inv);
                    if(result){
                        printOut("Inventory Product created.");
                    } else {

                        printOut("Inventory Product not created.");
                    }
                    readKey();

                    break;

                }
                case 3:{
                    printOut("[ EDIT PRODUCT ]");

                    List<Inventory> products = inventoryController.showInventories();
                    for(Inventory i : products){
                        System.out.println("* " + i.printInfo());
                    }
                    printOut("");
                    printOut("Enter an InventoryId:");
                    int productId = readNumber();
                    Inventory item = inventoryController.retrieveInventory(productId);
                    if(item == null){
                        break;
                    }
                    printOut("");
                    printOut(item.printInfo());
                    printOut("");
                    printOut("Enter a Mark Id:");
                    int markId = readNumber();
                    Productbrand brand = inventoryController.retrieveProductBrand(markId);
                    if(brand == null){
                        printOut("Cannot find Mark");
                        break;
                    }
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Quantity:");
                    int quantity = readNumber();
                    printOut("Enter a Max Quantity:");
                    int maxQuantity = readNumber();
                    printOut("Enter a Min Quantity:");
                    int minQuantity = readNumber();
                    printOut("Enter a Price:");
                    double price = readDouble();
                    printOut("Enter a Location:");
                    String location = readString();
                    printOut("Enter a Size:");
                    int size = readNumber();
                    printOut("Enter a Weigth:");
                    int weight = readNumber();

                    printOut("Enter an expiration Date, (yyyy-MM-dd):");
                    String exp = readString();
                    Date fecha;
                    try {
                        fecha = new SimpleDateFormat("yyyy-MM-dd").parse(exp);
                    } catch (ParseException ex) {
                        printOut("Cannot parse date.");
                        break;
                    }
                    item.getIdProduct().getIdDurable().setWeighDurable(weight);
                    item.getIdProduct().getIdDurable().setSizeDurable(size);
                    item.getIdProduct().getIdConsume().setExpiration(fecha);
                    item.getIdProduct().getIdStock().setMinQuantity(minQuantity);
                    item.getIdProduct().getIdStock().setMaxQuantity(maxQuantity);
                    item.getIdProduct().setNameProduct(name);
                    item.getIdProduct().setQuantity(quantity);
                    item.getIdProduct().setLocation(location);
                    item.getIdProduct().setPrice(BigDecimal.valueOf(price));
                    item.getIdProduct().setIdBrand(brand);
                    item.setAvailableQuatity(quantity);
                    item.setIniQuantity(quantity);

                    boolean result = inventoryController.editInventory(item);
                    if(result){
                        printOut("Inventory Product edited.");
                    } else {

                        printOut("Inventory Product not edited.");
                    }
                    readKey();
                    break;
                }
                case 4:{

                    printOut("[ DELETE PRODUCT ]");

                    List<Inventory> products = inventoryController.showInventories();
                    for(Inventory i : products){
                        System.out.println("* " + i.printInfo());
                    }
                    printOut("");
                    printOut("Enter an InventoryId:");
                    int productId = readNumber();
                    Inventory item = inventoryController.retrieveInventory(productId);
                    if(item == null){
                        break;
                    }
                    boolean result = inventoryController.deleteInventory(item);
                    if(result){
                        printOut("Inventory Product deleted.");
                    } else {

                        printOut("Inventory Product not deleted.");
                    }

                    break;
                }
                case 5:{
                    printOut("[ ADD CATEGORY ]");

                    List<Inventory> products = inventoryController.showInventories();
                    for(Inventory i : products){
                        System.out.println("* " + i.printInfo());
                    }
                    printOut("");
                    printOut("Enter an InventoryId:");
                    int productId = readNumber();
                    Inventory item = inventoryController.retrieveInventory(productId);
                    if(item == null){
                        break;
                    }
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Measure Unit:");
                    String unit = readString();
                    Category ca = new Category();
                    ca.setNameCategory(name);
                    ca.setMeasurement(unit);
                    ca.setIdProduct(item.getIdProduct());
                    boolean result = inventoryController.saveCategory(ca);
                    if(result){
                        printOut("Category created");
                    } else {

                        printOut("Category Not created");
                    }
                    readKey();
                    break;
                }
                case 6:{
                    printOut("[ SHOW CATEGORIES ]");
                    List<Category> categories = inventoryController.showCategories();
                    for(Category i : categories){
                        System.out.println("* " + i.printInfo());
                    }
                    printOut("");
                    readKey();
                    break;
                }
                case 7:{
                    printOut("[ EDIT CATEGORY ]");

                    List<Category> categories = inventoryController.showCategories();
                    for(Category i : categories){
                        System.out.println("* " + i.printInfo());
                    }
                    printOut("");
                    printOut("Enter an CategoryId:");
                    int productId = readNumber();
                    Category item = inventoryController.retrieveCategory(productId);
                    if(item == null){
                        break;
                    }
                    printOut("");
                    printOut("Enter an InventoryId:");
                    int product2Id = readNumber();
                    Inventory item2 = inventoryController.retrieveInventory(product2Id);
                    if(item2 == null){
                        break;
                    }
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Measure Unit:");
                    String unit = readString();
                    item.setNameCategory(name);
                    item.setMeasurement(unit);
                    item.setIdProduct(item2.getIdProduct());
                    boolean result = inventoryController.editCategory(item);
                    if(result){
                        printOut("Category edited");
                    } else {

                        printOut("Category Not edited");
                    }
                    readKey();
                    break;
                }
                case 8:{
                    printOut("[ DELETE CATEGORY ]");

                    List<Category> categories = inventoryController.showCategories();
                    for(Category i : categories){
                        System.out.println("* " + i.printInfo());
                    }
                    printOut("");
                    printOut("Enter an CategoryId:");
                    int productId = readNumber();
                    Category item = inventoryController.retrieveCategory(productId);
                    if(item == null){
                        break;
                    }
                    printOut("");
                    boolean result = inventoryController.deleteCategory(item);
                    if(result){
                        printOut("Category Deleted");
                    } else {

                        printOut("Category Not Deleted");
                    }
                    readKey();
                    break;
                }
                case 9:{
                    printOut("[ ADD MARK ]");
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter an origin");
                    String origin = readString();
                    Productbrand mk = new Productbrand();
                    mk.setNameBrand(name);
                    mk.setOriginBrand(origin);
                    boolean result = inventoryController.saveProductBrand(mk);
                    if(result){
                        printOut("Mark created.");
                    } else {
                        printOut("Mark not created.");
                    }
                    readKey();
                    break;
                }
                case 10:{
                    printOut("[ SHOW MARKS ]");
                    List<Productbrand> mrks = inventoryController.showProductBrands();
                    for(int i = 0; i < mrks.size() ; i++){
                        System.out.println("* " + mrks.get(i).printInfo());
                    }
                    printOut("");
                    readKey();
                    break;
                }
                case 11:{
                    printOut("[ EDIT MARK ]");
                    printOut("Enter a MarkId:");
                    int markId = readNumber();
                    Productbrand item = inventoryController.retrieveProductBrand(markId);
                    if(item != null){
                        printOut("");
                        printOut(item.printInfo());
                        printOut("");
                        printOut("Enter a name:");
                        String name = readString();
                        printOut("Enter an origin");
                        String origin = readString();
                        item.setNameBrand(name);
                        item.setOriginBrand(origin);
                        boolean result = inventoryController.updateProductBrand(item);
                        if(result){
                            printOut("Mark updated.");
                        } else {
                            printOut("Mark not updated.");
                        }
                    } else{
                        printOut("Cannot find Mark");
                    }
                    readKey();
                    break;
                }
                case 12:{
                    printOut("[ DELETE MARK ]");
                    printOut("Enter a MarkId:");
                    int markId = readNumber();
                    Productbrand item = inventoryController.retrieveProductBrand(markId);
                    if(item != null){
                        printOut("");
                        printOut(item.printInfo());
                        printOut("");
                        boolean result = inventoryController.deleteProductBrand(item);
                        if(result){
                            printOut("Mark deleted.");
                        } else {
                            printOut("Mark not deleted.");
                        }
                    } else{
                        printOut("Cannot find Mark");
                    }
                    readKey();
                    break;
                }
                case 13:{
                    printOut("[ CLOSING... ]");
                    break;
                }
                default:{
                    printOut("[ INVALID OPTION... ]");
                    break;
                }
            }
            printOut("");
        }while(op != 14);
        printOut("");
    }

    private static void printOut(String cnt){
        System.out.println(cnt);
    }


    private static int readNumber(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String val = br.readLine();
            return Integer.parseInt(val);
        }catch(Exception ex){
            return 0;
        }
    }

    private static double readDouble(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String val = br.readLine();
            return Double.parseDouble(val);
        }catch(Exception ex){
            return 0;
        }
    }

    private static String readString(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String val = br.readLine();
            return val;
        }catch(Exception ex){
            return "";
        }
    }


    private static void readKey(){

        try {
            System.out.println("");
            System.out.println("[ PRESS ENTER TO CONTINUE. ]");
            System.in.read();
        } catch (IOException e) {

        }
    }

}

