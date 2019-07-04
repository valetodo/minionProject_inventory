package java.models;

public class Category {

    private String name;
    private String unidadDeMedida;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    @Override
    public String toString() {
        return "{ name=" + name + ", unidadDeMedida=" + unidadDeMedida + '}';
    }
}
