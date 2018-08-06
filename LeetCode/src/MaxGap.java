

/**
 * 差值最大的相邻数
 */
public class MaxGap {

    public  int maxGap(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i ++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (min == max){
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];

        int bid = 0;
        for (int i = 0; i < len; i ++){
            bid = bucket(nums[i],len, min, max);
            //更新最大最小值
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i < len; i ++){
            if (hasNum[i]) {
                //
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    /**
     * 判断 num来自哪个桶，定位去哪个桶
     * @param num
     * @param len
     * @param min
     * @param max
     * @return
     */
    private int bucket(int num, int len, int min, int max) {
        return (num - min) * len / (max - min);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,6,7,8,9};
        MaxGap maxGap = new MaxGap();
        int gap = maxGap.maxGap(arr);
        System.out.println(gap);
    }
}
