package java.models;

public class Consumo extends Product {
    private String expiracion;

    public String getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }

    @Override
    public String toString() {
        return "{ idProduct=" + this.getIdProduct() + ", nameProduct=" + this.getNameProduct() + ", price=" + this.getPrice() + ", "
                + "status=" + this.isStatus() + ", location=" + this.getLocation() + ", quantity=" + this.getQuantity() + ", " + "expiracion=" + expiracion + '}';
    }

}
