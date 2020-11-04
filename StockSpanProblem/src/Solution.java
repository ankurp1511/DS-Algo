import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(80);
        list.add(60);
        list.add(70);
        list.add(60);
        list.add(75);
        list.add(85);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        solve(list, stack1, stack2);

        list.forEach(System.out::println);

    }

    private static void solve(List<Integer> list, Stack<Integer> stack1, Stack<Integer> stack2) {

        int removedElement = 0;
        for(int i = 0; i < list.size(); i++) {
            if (stack1.size() == 0) {
                removedElement = list.remove(i);
                list.add(i, 1);
            }
            else if(stack1.peek() > list.get(i)){
                removedElement = list.remove(i);
                list.add(i, 1);
            }
            else {
                int count = 1;
                while (stack1.size() != 0 && stack1.peek() <= list.get(i)){
                    stack2.push(stack1.pop());
                    count++;
                }
                while (stack2.size() != 0){
                    stack1.push(stack2.pop());
                }
                removedElement = list.remove(i);
                list.add(i, count);
            }
            stack1.push(removedElement);
        }
    }
}
