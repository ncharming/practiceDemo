package LiKou;

/**
 * 盛最多水的容器：
 * - 暴力破解法：先把所有的 x轴 * y轴 计算出来保存到一个数组；然后取得数组中最大的数即可（可先排序再取值，也可）
 * - 递归
 */
public class LiKou_11_Solution {
    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 9};
        int[] array1 = maxArea(array);
        System.out.println(insertSort(array1));

        //一个动态规划，直接解决。牛逼
        System.out.println(maxAreaPlan(array));
    }

    static int[] maxArea(int[] max) {
        int[] allArray = new int[36];
        int len = max.length;
        int n = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                allArray[n] = Math.min(max[i], max[j]) * (j - i);
                n++;
            }
        }
        return allArray;
    }

    public static int insertSort(int[] arr) {
        int len = arr.length, temp;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {//从后往前对比，只要满足一次条件就交换一次
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr[len - 1];
    }

    /**
     * 双指针法：使用动态规划
     *
     * @param max
     * @return
     */
    static int maxAreaPlan(int[] max) {
        int res = 0;
        int i = 0;
        int j = max.length - 1;
        while (i < j) {
            int area = Math.min(max[i], max[j]) * (j - i);
            res = Math.max(area, res);
            if (max[i] < max[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}

