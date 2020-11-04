import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(11,13,21,3);
        getResult(list);
    }

    private static void getResult(List<Integer> list){

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[list.size()];

        stack.push(list.get(0));

        for(int i=1; i < list.size(); i++){

            int next = list.get(i);

            if(!stack.isEmpty()){

                int element = stack.pop();
                while (element < next){
                    arr[list.indexOf(element)] = next;
                    if(stack.isEmpty()){
                        break;
                    }
                    element = stack.pop();
                }

                if(element > next)
                  stack.push(element);
            }
            stack.push(next);
        }

        if(!stack.isEmpty()){
            for(Integer num : stack) {
                arr[list.indexOf(num)] = -1;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
