package java.models;

public class Stock {
    private int maxQuantity;
    private int minQuantity;

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public boolean isQuantity(){
        return minQuantity > 0;
    }
}
