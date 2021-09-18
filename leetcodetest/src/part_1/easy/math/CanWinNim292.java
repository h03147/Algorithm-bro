package part_1.easy.math;

public class CanWinNim292 {

    public boolean canWinNim(int n) {
        // 当前回合剩余的石头数量是四的倍数，这个人会输
        return n % 4 != 0;
    }

}
