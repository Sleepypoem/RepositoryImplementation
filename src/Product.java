import java.util.Objects;

public class Product {

    private final String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock > 0){
            this.stock += stock;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getName().toLowerCase(), product.getName().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + "Stock: " + this.stock + "\n";
    }
}
