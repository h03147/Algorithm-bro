package part_1.easy.hashmap;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int num : nums) {
            if(hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
}
