package java.models;

public class Duradero extends Product{
    private int tamano;
    private int peso;

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "{ idProduct=" + this.getIdProduct() + ", nameProduct=" + this.getNameProduct() + ", price=" + this.getPrice() + ", "
                + "status=" + this.isStatus() + ", location=" + this.getLocation() + ", quantity=" + this.getQuantity() + ", "
                + "tamano=" + tamano + ", peso=" + peso + '}';
    }
}
