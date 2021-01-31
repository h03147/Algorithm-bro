package part_1.easy.arraylist;

import java.util.ArrayList;
import java.util.Collections;

/**
 * description: 1046 粉碎石头
 */
public class Stones1046 {

    public static void main(String[] args) {
        int[] array1 = {2, 7, 4, 1, 8, 1};
        System.out.println(stones(array1));
    }

    private static int stones(int[] stones) {
        // {2,7,4,1,8,1}
        ArrayList<Integer> arr2list = new ArrayList<Integer>();
        int size = stones.length;
        for(int i = 0; i < size; ++i)
        {
            arr2list.add(stones[i]);
        }

        while (size > 1) {
            Integer max1 = Collections.max(arr2list);
            arr2list.remove(max1);
            Integer max2 = Collections.max(arr2list);
            arr2list.remove(max2);
            if (max1 > max2) {
                int newstone = max1 - max2;
                arr2list.add(newstone);
                size -= 1;
            } else {
                size -= 2;
            }

        }
        if(arr2list.size() == 1)
        {
            return arr2list.get(0);
        }else {
            return 0;
        }
    }
}
