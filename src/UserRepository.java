import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class UserRepository extends Repository<User> {

    public UserRepository(List<User> list) {
        super(list);
    }

    final Comparator<User> SORT_BY_USERNAME = (User user1, User user2) -> user1.getUsername().compareToIgnoreCase(user2.getUsername());
    final Comparator<User> SORT_BY_FIRST_NAME = (User user1, User user2) -> user1.getFirstName().compareToIgnoreCase(user2.getFirstName());
    final Comparator<User> SORT_BY_LAST_NAME = (User user1, User user2) -> user1.getLastName().compareToIgnoreCase(user2.getLastName());

    public @NotNull List<String> getDomains() {
        List<String> domainList = new ArrayList<>();
        for (User o : list) {
            String userName = o.getUsername();
            if (userName.contains("@")) {
                String domain = userName.substring(userName.indexOf('@') + 1);
                domainList.add(domain);
            } else {
                domainList.add(userName);
            }


        }
        return domainList;
    }


    @Override
    public void save(User element) {
        if (validate(element)) {
            this.list.add(element);
        }

    }

    @Override
    public List<User> getAllSortedBy(String field) {

        List<User> newList = new ArrayList<>(list);
        field = field.toLowerCase();
        switch (field) {
            case "username" -> newList.sort(SORT_BY_USERNAME);
            case "firstname" -> newList.sort(SORT_BY_FIRST_NAME);
            case "lastname" -> newList.sort(SORT_BY_LAST_NAME);
        }
        return newList;
    }

    private boolean isEmailUsed(User user) {
        return list.contains(user);
    }

    @Override
    protected boolean validate(User user) {
        return !isEmailUsed(user);
    }
}
