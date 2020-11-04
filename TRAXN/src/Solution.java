import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numberOfDays = in.nextInt();
        for (int i = 0; i < numberOfDays; i++) {
            String ingredient = in.next();
            solve(ingredient, map);
        }
    }

    private static void solve(String ingredient, Map<String, Integer> map){

        if(ingredient.contains("FAT")){
            map.merge("FAT", 1, Integer::sum);
        }else if(ingredient.contains("FIBER")){
            map.merge("FIBER", 1, Integer::sum);
        }else{
            map.merge("CARB", 1, Integer::sum);
        }
        checkAndPrint(map);
    }

    private static void checkAndPrint(Map<String, Integer> map){

        boolean flag = true;
        if(map.get("FAT") != null && map.get("FAT") >= 2) {
            if(map.get("FAT") == 2 && map.get("FIBER") != null && map.get("FIBER") == 2){
                System.out.println("X");
                map.remove("FAT");
                map.remove("FIBER");
                flag = false;
            }else if(map.get("FAT") == 3 && map.get("FIBER") != null && map.get("FIBER") == 1){
                System.out.println("X");
                map.remove("FAT");
                map.remove("FIBER");
                flag = false;
            }else if(map.get("FAT") == 4){
                System.out.println("X");
                map.remove("FAT");
                flag = false;
            }
        }
        if(map.get("FIBER") != null && map.get("CARB") != null){
            if(map.get("FIBER") == 3 && map.get("CARB") == 1 ||
                    map.get("FIBER") == 2 && map.get("CARB") == 2 ||
                    map.get("FIBER") == 1 && map.get("CARB") == 3){

                System.out.print("Y");
                map.remove("FIBER");
                map.remove("CARB");
                flag = false;
            }
        }
        if(flag){
            System.out.println("-");
        }
    }
}
