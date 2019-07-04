package java.minionProject_inventory;

import java.controller.InventoryController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.models.Category;
import java.models.Consumo;
import java.models.Duradero;
import java.models.Mark;
import java.models.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static InventoryController homeController;

    public static void main(String[] args) {
        homeController = new InventoryController();
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
            printOut("2.- Add Durable Product");
            printOut("3.- Add Non-Durable Product");
            printOut("4.- Update Product");
            printOut("5.- Delete Product");
            printOut("6.- Add Category");
            printOut("7.- Show Categories");
            printOut("8.- Update Category");
            printOut("9.- Delete Category");
            printOut("10.- Add Mark");
            printOut("11.- Show Marks");
            printOut("12.- Update Mark");
            printOut("13.- Delete Mark");
            printOut("14.- Salir");
            printOut("");
            op = readNumber();
            switch(op){
                case 1:{
                    printOut("[ SHOW PRODUCTS ]");
                    List<Product> durederos = homeController.showProducts();
                    for(int i = 0; i < durederos.size() ; i++){
                        System.out.println("* " + durederos.get(i).toString());
                    }
                    readKey();
                    break;
                }
                case 2:{
                    printOut("[ ADD DURABLE PRODUCT ]");
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Quantity:");
                    int quantity = readNumber();
                    printOut("Enter a Price:");
                    double price = readDouble();
                    printOut("Enter a Location:");
                    String location = readString();
                    printOut("Enter a Size:");
                    int size = readNumber();
                    printOut("Enter a Weigth:");
                    int weight = readNumber();
                    Duradero item = new Duradero();
                    item.setNameProduct(name);
                    item.setQuantity(quantity);
                    item.setPrice(price);
                    item.setLocation(location);
                    item.setStatus(true);
                    item.setPeso(weight);
                    item.setTamano(size);
                    homeController.saveProduct(item);
                    readKey();
                    break;
                }
                case 3:{
                    printOut("[ ADD NON-DURABLE PRODUCT ]");
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Quantity:");
                    int quantity = readNumber();
                    printOut("Enter a Price:");
                    double price = readDouble();
                    printOut("Enter a Location:");
                    String location = readString();
                    printOut("Enter an expiration Date, (yyyy-MM-dd):");
                    String exp = readString();
                    try {
                        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(exp);
                    } catch (ParseException ex) {
                        break;
                    }
                    Consumo item = new Consumo();
                    item.setNameProduct(name);
                    item.setQuantity(quantity);
                    item.setPrice(price);
                    item.setLocation(location);
                    item.setStatus(true);
                    item.setExpiracion(exp);
                    homeController.saveProduct(item);
                    readKey();
                    break;
                }
                case 4:{
                    printOut("[ EDIT PRODUCT ]");
                    List<Product> durederos = homeController.showProducts();
                    for(int i = 0; i < durederos.size() ; i++){
                        System.out.println("* " + durederos.get(i).toString());
                    }
                    printOut("");
                    printOut("Enter an ID:");
                    int id = readNumber();
                    Product ca = homeController.retrieveProduct(id);
                    printOut("");
                    printOut(ca.toString());
                    printOut("");
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Quantity:");
                    int quantity = readNumber();
                    printOut("Enter a Price:");
                    double price = readDouble();
                    printOut("Enter a Location:");
                    String location = readString();
                    ca.setNameProduct(name);
                    ca.setQuantity(quantity);
                    ca.setPrice(price);
                    ca.setLocation(location);
                    ca.setStatus(true);
                    homeController.editProduct(ca, id);
                    readKey();
                    break;
                }
                case 5:{

                    printOut("[ DELETE PRODUCT ]");
                    List<Product> durederos = homeController.showProducts();
                    for(int i = 0; i < durederos.size() ; i++){
                        System.out.println("* " + durederos.get(i).toString());
                    }
                    printOut("");
                    printOut("Enter an ID:");
                    int id = readNumber();
                    homeController.deleteProduct(id);
                    readKey();
                    break;
                }
                case 6:{
                    printOut("[ ADD CATEGORY ]");
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Measure Unit:");
                    String unit = readString();
                    Category ca = new Category();
                    ca.setName(name);
                    ca.setUnidadDeMedida(unit);
                    homeController.saveCategory(ca);
                    readKey();
                    break;
                }
                case 7:{
                    printOut("[ SHOW CATEGORIES ]");
                    List<Category> categories = homeController.showCategories();
                    for(int i = 0; i < categories.size() ; i++){
                        System.out.println("* ID: " +  i + " " + categories.get(i).toString());
                    }
                    printOut("");
                    readKey();
                    break;
                }
                case 8:{
                    printOut("[ EDIT CATEGORY ]");
                    List<Category> categories = homeController.showCategories();
                    for(int i = 0; i < categories.size() ; i++){
                        System.out.println("* ID: " +  i + " " + categories.get(i).toString());
                    }
                    printOut("");
                    printOut("Enter an ID:");
                    int id = readNumber();
                    Category ca = homeController.retrieveCategory(id);
                    printOut("");
                    printOut(ca.toString());
                    printOut("");
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter a Measure Unit:");
                    String unit = readString();
                    ca.setName(name);
                    ca.setUnidadDeMedida(unit);
                    homeController.editCategory(ca, id);
                    readKey();
                    break;
                }
                case 9:{
                    printOut("[ DELETE CATEGORY ]");
                    List<Category> categories = homeController.showCategories();
                    for(int i = 0; i < categories.size() ; i++){
                        System.out.println("* ID: " +  i + " " + categories.get(i).toString());
                    }
                    printOut("");
                    printOut("Enter an ID:");
                    int id = readNumber();
                    homeController.deleteCategory(id);
                    readKey();
                    break;
                }
                case 10:{
                    printOut("[ ADD MARK ]");
                    printOut("Enter a name:");
                    String name = readString();
                    printOut("Enter an origin");
                    String origin = readString();
                    Mark mk = new Mark();
                    mk.setNameMark(name);
                    mk.setOriginMark(origin);
                    homeController.saveMark(mk);
                    readKey();
                    break;
                }
                case 11:{
                    printOut("[ SHOW MARKS ]");
                    List<Mark> mrks = homeController.showMarks();
                    for(int i = 0; i < mrks.size() ; i++){
                        System.out.println("* ID: " +  i + " " + mrks.get(i).toString());
                    }
                    printOut("");
                    readKey();
                    break;
                }
                case 12:{
                    break;
                }
                case 13:{
                    break;
                }
                case 14:{
                    break;
                }
                default:{
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
