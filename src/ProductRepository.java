import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository extends Repository<Product>{

    public ProductRepository(List<Product> list) {
        super(list);
    }

    final Comparator<Product> SORT_BY_NAME = (product1, product2) -> product1.getName().compareToIgnoreCase(product2.getName());
    final Comparator<Product> SORT_BY_STOCK = Comparator.comparingInt(Product::getStock);

    @Override
    public void save(Product element) {
        if (validate(element)){
            list.add(element);
        }else{
            Product product = list.get(list.indexOf(element));
            product.setStock(element.getStock());
        }
    }

    @Override
    public List<Product> getAllSortedBy(String field) {
        field = field.toLowerCase();
        List<Product> newList= new ArrayList<>(list);
        switch (field){
            case "name" :
                newList.sort(SORT_BY_NAME);
                break;
            case "stock" :
                newList.sort(SORT_BY_STOCK);
                break;
        }
        return newList;
    }

    private boolean isNameUsed(Product product){
        return list.contains(product);
    }

    @Override
    protected boolean validate(Product product) {
        return !isNameUsed(product);
    }
}
