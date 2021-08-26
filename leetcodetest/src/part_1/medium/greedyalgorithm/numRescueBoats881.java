package part_1.medium.greedyalgorithm;

public class numRescueBoats881 {

    public int numRescueBoats(int[] people, int limit) {
        // 题型：贪心算法 + 双指针
        // 保证每个人都过河，那么最重的那个人最重只能刚好和船的limit一样重
        // 其他人体重只可能小于等于他
        int ans = 0;
        int light = 0, heavy = people.length - 1;
        Arrays.sort(people);
        while(light <= heavy) {
            // 在还没过河的人当中，最重的和最轻的一起如果没超过limit，就赶紧做一艘船一起过去
            if(people[light] +people[heavy] <= limit) {
                light++; // 最轻的人坐船过去了一个
            }
            // 否则说明两人一起超重了，这个最轻的人和最重的一起坐都超重了，那其他人和最重的这
            // 个人一起坐只会更重，没办法，只能让当前最重的这个人一人独自做船过去咯
            heavy--; // 和最轻的人一起过去或者自己太重了独自坐船过去
            ans++; // 无论哪种每趟都有人能过河消耗一艘船
        }
        return ans;
    }

}
