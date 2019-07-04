package java.models;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private boolean status;
    private String location;
    private int quantity;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean decreaseProduct(int cant){
        return true;
    }

    public boolean increaseProduct(int cant){
        return true;
    }

    @Override
    public String toString() {
        return "{" + "idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", price=" + price + ", status=" + status + ", location=" + location + ", quantity=" + quantity + '}';
    }
}
