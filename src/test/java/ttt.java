import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ttt {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if(nums[k] >= max){
                        max = nums[k];
                    }
                    if(nums[k] <= min){
                        min = nums[k];
                    }
                }
                sum += (max-min);
            }
        }
        return sum;
    }

    @Test
    public void maina(){
        System.out.println(lengthOfLastWord("a"));;
    }


    public int lengthOfLastWord(String s) {
        String[] sss = s.trim().split("");
        int cou = 0;
        int wei = sss.length-1;
        while (wei >= 0){
            if(sss[wei].equals(" ")){
               break;
            }
            wei--;
            cou++;
        }
        return cou;
    }

}
