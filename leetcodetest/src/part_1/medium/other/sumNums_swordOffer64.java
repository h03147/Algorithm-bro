package part_1.medium.other;

public class sumNums_swordOffer64 {

    public int sumNums(int n) {
        int sum = n;
        // 双与运算如果不满足第一个条件，第二个条件就不会执行，从而达到递归终止的目的
        boolean b = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }

}
