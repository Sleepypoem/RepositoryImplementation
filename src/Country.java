import java.util.Objects;

public class Country {

    private String name;
    private String ISOCode;

    public Country(String name, String ISOCode) {
        this.name = name;
        this.ISOCode = ISOCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISOCode() {
        return ISOCode;
    }

    public void setISOCode(String ISOCode) {
        this.ISOCode = ISOCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(getISOCode(), country.getISOCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getISOCode());
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + "ISO Code: " + this.ISOCode + "\n";
    }
}
