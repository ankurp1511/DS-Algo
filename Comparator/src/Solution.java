import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Rishu", 1000.0));
        users.add(new User("Saani", 5000.0));
        users.add(new User("Me", 50000.0));

        users.sort(Comparator.comparingDouble(User::getSalary));

        users.forEach(System.out::println);
    }
}
