import java.util.*;

public class CountryRepository extends Repository<Country> {

    private List<Country> list;

    public CountryRepository(List<Country> list) {
        this.list = list;
    }

    public CountryRepository() {
        this.list = new ArrayList<>();
    }

    final Comparator<Country> ORDER_BY_NAME = (country1, country2) -> country1.getName()
            .compareToIgnoreCase(country2.getName());

    final Comparator<Country> ORDER_BY_ISO_CODE = (country1, country2) -> country1.getISOCode()
            .compareToIgnoreCase(country2.getISOCode());

    @Override
    public void save(Country element) {
        if (validate(element)) {
            list.add(element);
        }
    }

    @Override
    public List<Country> getAllSortedBy(String field) {
        List<Country> newList = new ArrayList<>(list);
        field = field.toLowerCase();
        if (field.equals("name")) {
            newList.sort(ORDER_BY_NAME);
        } else if (field.equals("isocode")) {
            newList.sort(ORDER_BY_ISO_CODE);
        }

        return newList;
    }

    private boolean isIsoCodeUsed(Country country) {
        return this.list.contains(country);
    }

    @Override
    protected boolean validate(Country country) {
        return !isIsoCodeUsed(country);
    }

    @Override
    public int count() {
        return this.list.size();
    }

    @Override
    public Country find(int index) {
        return this.list.get(index);
    }

    @Override
    public void printList() {
        System.out.println("Countries in this list:");
        for (Country country : list) {
            System.out.println(country);
        }
    }
}
