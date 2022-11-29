import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CountryRepository countries = new CountryRepository(new ArrayList<>());
        countries.save(new Country("New Zealand", "NZ"));
        countries.save(new Country("United States", "EU"));
        countries.save(new Country("China", "CN"));
        countries.save(new Country("Australia", "AU"));
        countries.save(new Country("Australia", "AU"));

        // countries.printList();
        List<Country> sorted = countries.getAllSortedBy("isocode");
        // showList(sorted);

        UserRepository users = new UserRepository(new ArrayList<>());
        users.save(new User("ggjuan@gmail.com", "Juan", "Ortiz"));
        users.save(new User("hugo@yahoo.com", "Hugo", "Martinez"));
        users.save(new User("fran@mail.com", "Francisco", "Garcia"));
        users.save(new User("goodgame", "Gonzalo", "Guevara"));
        users.save(new User("goodgame", "Gonzalo", "Guevara"));
        users.save(new User("justMoni@yahoo.com", "Monika", "Doki"));

        // showList(users.getAllSortedBy("lastname"));
        List<String> domains = users.getDomains();
        // showList(domains);

        ProductRepository products = new ProductRepository(new ArrayList<>());
        products.save(new Product("Milk", 45));
        products.save(new Product("Eggs", 5));
        products.save(new Product("Beans", 15));
        products.save(new Product("milk", 45));

        products.printList();

        List<Product> sortedProducts = products.getAllSortedBy("stock");
        // showList(sortedProducts);
    }

    private static <T> void showList(@NotNull List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

}