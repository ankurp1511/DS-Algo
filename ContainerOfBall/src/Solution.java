import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] container = new int[][]{{1,3,1},{2,1,2},{3,3,3}};

        int[] ballsInContainer = new int[container.length];
        int[] distinctBalls = new int[container.length];

        for(int i = 0; i < container.length; i++){
            ballsInContainer[i] = Arrays.stream(container[i]).sum();
        }

        for(int j=0; j < container.length ; j++){
            int sum = 0;
            for (int[] ints : container) {
                sum += ints[j];
            }
            distinctBalls[j] = sum;
        }

        String out = "Possible";

        Arrays.sort(ballsInContainer);
        Arrays.sort(distinctBalls);

        for(int i=0; i < container.length; i++){
            if(ballsInContainer[i] != distinctBalls[i]){
                out = "Impossible";
                break;
            }
        }
        System.out.println(out);

    }
}
