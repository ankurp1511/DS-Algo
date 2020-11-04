public class Solution {

    public static void main(String[] args) {

        int[] wheels = new int[]{2,4,5,6,8,16,20};
        int[] output = new int[wheels.length];

        for(int i=0 ; i< wheels.length ; i++){
            if(wheels[i] % 2 == 0){
                output[i] = wheels[i]/4 + 1;
            }
        }

        for(Integer num: output){
            System.out.print(num + " ");
        }
    }
}
