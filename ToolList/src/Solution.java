public class Solution {

    public static void main(String[] args) {


        String[] arr = new String[]{"ballendmill","fecemill","keywaycutter","something","slotdrill"};

        int k = 1;

        String reqTool = "slotdrill";
        int reqIndex = 0;
        int moves = 0;

        for(int i=0 ; i < arr.length; i++){
            if(reqTool.equals(arr[i]) && i > k){
                reqIndex = i;
                if(reqIndex - k < (arr.length - reqIndex) + k){
                    moves = reqIndex - k;
                }else {
                    moves = (arr.length - reqIndex) + k;
                }
            }else if(reqTool.equals(arr[i])){
                if((arr.length - k) + reqIndex < k - reqIndex ){
                    moves = arr.length - k;
                }else {
                    moves = k - reqIndex;
                }
            }
        }
        System.out.println(moves);
    }
}
