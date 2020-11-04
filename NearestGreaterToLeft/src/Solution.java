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

        Stack<Integer> stack = new Stack<>();

        solve(list, stack);

        list.forEach(System.out::println);

    }

    private static void solve(List<Integer> list, Stack<Integer> stack) {

        int removedElement = 0;
        for(int i=0; i < list.size(); i++){
            if(stack.size() == 0){
                removedElement = list.remove(i);
                list.add(i, -1);
            }
            else if(stack.peek() > list.get(i)){
                removedElement = list.remove(i);
                list.add(i, stack.peek());
            }
            else {
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
