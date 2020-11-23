package LiKou;

/**
 * 力扣的第26题：删除排序数组中的重复项
 */
public class LiKou_26_Solution {
    public static void main(String[] args) {
        int nums[] = {0, 3, 4, 4, 4, 5, 5, 6, 7, 7, 8, 8};
        int len = removeDuplicate(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
            if (i < len - 1)
                System.out.print(",");
        }
    }

    /**
     * 双指针法：
     *
     * @param nums
     * @return
     */
    static int removeDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1)
            return length;
        int i = 0;
        for (int j = 1; j < length; j++) {

            if (nums[i] != nums[j])
                nums[++i] = nums[j];
/**
 * 上面这种方式会减少赋值操作。
 *  这两种方式都可以，下面这种需要不断的将重复的值往前面写。
 if (nums[i] != nums[j])
 i++;
 nums[i] = nums[j];
 */
        }
        return i + 1;
    }
}
