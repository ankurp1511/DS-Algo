import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(3);
        sort(list);

        list.forEach(System.out::println);
    }

    private static void sort(List<Integer> list){

        if(list.size() == 1){
            return;
        }else {
            int temp = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            sort(list);
            insert(list, temp);
        }
    }

    private static void insert(List<Integer> list, int temp){

        if(list.size() == 0 || list.get(list.size() - 1) <= temp){
            list.add(temp);
            return;
        }else {
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            insert(list, temp);
            list.add(val);
        }
    }
}
