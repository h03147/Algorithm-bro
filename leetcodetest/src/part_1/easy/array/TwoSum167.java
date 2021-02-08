package part_1.easy.array;

public class TwoSum167 {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        for(int num : twoSum(numbers, 9)) {
            System.out.print(num + ", ");
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        //     // 方法一
        //     int[] answer = new int[2];
        //     for(int i = 0; i < numbers.length; ++i) {
        //         for(int j = i + 1; j < numbers.length; ++j) {
        //             if(numbers[i] + numbers[j] == target) {
        //                 answer[0] = i + 1;
        //                 answer[1] = j + 1;
        //                 break;
        //             }
        //         }
        //     }
        //     return answer;
        // }
        // 方法二 双指针实现
        int low = 0, high = numbers.length - 1;
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                return new int[] {low + 1, high + 1};
            }else if(sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[] {0, 0};
    }
}
