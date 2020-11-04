import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        ImmutableClass immutableClass = new ImmutableClass("Ankur", list);

        List<Integer> list1 = immutableClass.getList();
        list1.add(3);

    }
}
