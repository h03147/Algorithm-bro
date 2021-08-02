package part_1.easy.dp;

public class rectCover_swordOffer10 {

    public int rectCover(int target) {
        if(target <= 2) return target;
        int pre2 = 1, pre1 = 2;
        int ret = 0;
        for(int i = 3; i <= target; ++i) {
            ret = pre2 + pre1;
            pre2 = pre1;
            pre1 = ret;
        }
        return ret;
    }

}
