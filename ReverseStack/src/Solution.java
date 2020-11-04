import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse(stack);

        stack.forEach(System.out::println);

    }

    private static void reverse(Stack<Integer> stack) {

        if(stack.size() == 0){
            return;
        }else {
            int temp = stack.pop();
            reverse(stack);
            insert(stack, temp);
        }
    }

    private static void insert(Stack<Integer> stack, int temp) {
        if(stack.size() == 0){
            stack.push(temp);
            return;
        }else {
            int val = stack.pop();
            insert(stack, temp);
            stack.push(val);
        }

    }
}
