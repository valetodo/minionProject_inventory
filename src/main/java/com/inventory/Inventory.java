package com.inventory;

import com.sun.istack.internal.NotNull;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
        , @NamedQuery(name = "Inventory.findByIdproduct", query = "SELECT i FROM Inventory i WHERE i.idproduct = :idproduct")
        , @NamedQuery(name = "Inventory.findByNameProduct", query = "SELECT i FROM Inventory i WHERE i.nameProduct = :nameProduct")
        , @NamedQuery(name = "Inventory.findByPrice", query = "SELECT i FROM Inventory i WHERE i.price = :price")
        , @NamedQuery(name = "Inventory.findByStatus", query = "SELECT i FROM Inventory i WHERE i.status = :status")
        , @NamedQuery(name = "Inventory.findByCantidadInicial", query = "SELECT i FROM Inventory i WHERE i.cantidadInicial = :cantidadInicial")
        , @NamedQuery(name = "Inventory.findByCantidadDisponible", query = "SELECT i FROM Inventory i WHERE i.cantidadDisponible = :cantidadDisponible")
        , @NamedQuery(name = "Inventory.findByTypeProduct", query = "SELECT i FROM Inventory i WHERE i.typeProduct = :typeProduct")})
public class Inventory implements Serializable {
    public static InventoryController homeController;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduct")
    private Long idproduct;
    @Size(max = 255)
    @Column(name = "nameProduct")
    private String nameProduct;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Size(max = 2)
    @Column(name = "status")
    private String status;
    @Column(name = "cantidadInicial")
    private Integer cantidadInicial;
    @Column(name = "cantidadDisponible")
    private Integer cantidadDisponible;
    @Size(max = 2)
    @Column(name = "typeProduct")
    private String typeProduct;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inventory")
    private Product product;

    public Inventory() {
    }

    public Inventory(Long idproduct) {
        this.idproduct = idproduct;
    }

    public Long getIdProduct() {
        return idproduct;
    }

    public void setIdProduct(Long idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCantidadInicial() {
        return cantidadInicial;
    }


    public boolean isStatus() {
        return status.equals("T");
    }

    public void setCantidadInicial(Integer cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduct != null ? idproduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.idproduct == null && other.idproduct != null) || (this.idproduct != null && !this.idproduct.equals(other.idproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.repository.Inventory[ idproduct=" + idproduct + " ]";
    }

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
                    List<Inventory> durederos = homeController.showProducts();
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
                    item.setQuantity(quantity);
                    item.setLocation(location);
                    item.setPeso(weight);
                    item.setTamano(size);
                    Inventory inv = new Inventory();
                    inv.setIdProduct(new Date().getTime());
                    inv.setNameProduct(name);
                    inv.setPrice(price);
                    inv.setStatus("T");
                    inv.setProduct(item);
                    homeController.saveProduct(inv);
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
                    Date fecha;
                    try {
                        fecha = new SimpleDateFormat("yyyy-MM-dd").parse(exp);
                    } catch (ParseException ex) {
                        break;
                    }
                    Consumo item = new Consumo();
                    item.setQuantity(quantity);
                    item.setLocation(location);
                    item.setExpiracion(fecha);
                    Inventory inv = new Inventory();
                    inv.setIdProduct(new Date().getTime());
                    inv.setNameProduct(name);
                    inv.setPrice(price);
                    inv.setStatus("T");
                    inv.setProduct(item);
                    homeController.saveProduct(inv);
                    readKey();
                    break;
                }
                case 4:{
                    printOut("[ EDIT PRODUCT ]");
                    List<Inventory> durederos = homeController.showProducts();
                    for(int i = 0; i < durederos.size() ; i++){
                        System.out.println("* " + durederos.get(i).toString());
                    }
                    printOut("");
                    printOut("Enter an ID:");
                    int id = readNumber();
                    Inventory ca = homeController.retrieveProduct(id);
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
                    ca.getProduct().setQuantity(quantity);
                    ca.getProduct().setLocation(location);
                    Inventory inv = new Inventory();
                    inv.setIdProduct(new Date().getTime());
                    inv.setNameProduct(name);
                    inv.setPrice(price);
                    inv.setStatus("T");
                    homeController.editProduct(inv, id);
                    readKey();
                    break;
                }
                case 5:{

                    printOut("[ DELETE PRODUCT ]");
                    List<Inventory> durederos = homeController.showProducts();
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

    public static String readString() {
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

    protected static String getGreeting(){
        String greeting = "Hello world";
        return greeting;
    }
}
