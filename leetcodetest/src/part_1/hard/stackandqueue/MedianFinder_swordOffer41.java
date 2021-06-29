package part_1.hard.stackandqueue;

import java.util.PriorityQueue;

public class MedianFinder_swordOffer41 {

    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left;
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right;
    /* 当前数据流读入的元素个数 */
    private int N = 0;
    /** initialize your data structure here. */
    public MedianFinder_swordOffer41() {
        left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public double findMedian() {
        if (N % 2 == 0){
            return (left.peek() + right.peek()) / 2.0;
        }
        else {
            return (double) right.peek();
        }
    }

}
