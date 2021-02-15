package part_1.easy.greedyalgorithm;

public class CanPlaceFlowers605 {

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
         * 分析题意：判断每个位置是种花，要看他的前置节点和
         * 后置节点是否为空（有间隔），为空就种，否则不能种花
         * 有两种特殊情况的边界值需要额外考虑，如果当前位置是
         * 第一个花盆，他就没有前置节点，或者当前位置是最后一
         * 个花盆，那么就没有后置节点。但是我们为了保证判断条
         * 件的一致性，所以第一个花盆，让他的前置节点直接给0
         * 最后一个花盆的后置节点同样给0。
         */

        int size = flowerbed.length;
        for(int i  = 0; i < size && n > 0; ++i) {
            if(flowerbed[i] == 1){
                continue;
            }
            // 如果当前位置为0，则判断其前置节点和后置节点是否为0（有间隔）
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == (size - 1) ? 0 : flowerbed[i + 1];
            if(pre == 0 && next == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
