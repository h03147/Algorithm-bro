package part_1.medium.other;

public class translateNum_swordOffer46 {

    public int translateNum(int num) {
        if(num <= 9) return 1;
        // 先按最大可截取的数字长度获取输入数字的余数，然后递归的计算翻译方法
        // 然后再分情况
        int num2abc = num % 100;
        // 如果小于等于9或者大于等于26的时候，余数不能按照2位数字组合，比如45，
        // 只能拆分为4和5；反例25，可以拆分为2和5，也可以作为25一个整体进行翻译
        if(num2abc <= 9 || num2abc >= 26) {
            return translateNum(num / 10);
        } else {
            // num2abc = [10, 25]时，既可以当做一个字母，也可以当做两个字母
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }

}
