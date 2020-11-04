import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(5);

        Stack<Integer> stack = new Stack<>();

        solve(list, stack);

        list.forEach(System.out::println);

    }

    private static void solve(List<Integer> list, Stack<Integer> stack) {

        int removedElement = 0;
        for(int i = list.size()-1; i>=0 ; i--){
            if(stack.size() == 0){
                removedElement = list.remove(i);
                list.add(i, -1);
            }
            else if(stack.peek() > list.get(i)){
                removedElement = list.remove(i);
                list.add(i, stack.peek());
            }else {
                while (stack.size() != 0 && stack.peek() <= list.get(i)){
                    stack.pop();
                }
                removedElement = list.remove(i);
                if(stack.size() == 0){
                    list.add(i, -1);
                }else {
                    list.add(i, stack.peek());
                }
            }
            stack.push(removedElement);
        }
    }
}
