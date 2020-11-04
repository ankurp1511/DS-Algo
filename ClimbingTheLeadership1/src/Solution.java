import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        List<Integer> ranked = Arrays.asList(100,90,90,80,75,60);
        List<Integer> player = Arrays.asList(50,65,77,90,102);

        ranked = ranked.stream().distinct().collect(Collectors.toList());
        int i = ranked.size() - 1;
        int added = 0;
        int k;

        for(k = 0 ; k < player.size() ; k++){
            for(int j = i; j >= 0 ; j--){
                if(ranked.get(j) > player.get(k)){
                    ranked.add(j+1,player.get(k));
                    added++;
                    i=j;
                    System.out.println(j+2);
                    break;
                }else {
                    if(ranked.contains(player.get(k))){
                        added++;
                        i=ranked.indexOf(player.get(k)) - 1;
                        System.out.println(ranked.indexOf(player.get(k)) + 1);
                        break;
                    }
                }
            }
            if(added == 0){
                ranked.add(0, player.get(k));
                System.out.println(1);
                break;
            }else {
                added = 0;
            }
        }

        for (int m =0 ; m < player.size() - 1 - k; m++){
            System.out.println(1);
        }
    }
}
