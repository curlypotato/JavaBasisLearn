package basis;

/**
 * 基础篇：二分查找
 *
 * @author broWsJle
 * @date 2022/11/18 18:01
 */
public class BinarySearch {

    /**
     * 二分查找 方法
     *
     * @param a 有序数组
     * @param t 需查找的数值
     * @return 返回查找到的索引
     */
    public static Integer search(int[] a, int t) {
        int l = 0; // 左边界索引
        int r = a.length - 1; // 右边界索引
        int m; // 中间索引

        while (l <= r) {
            m = (l + r) >>> 1;
            if (a[m] == t) {
                return m; // m下的值等于t，返回m
            } else if (a[m] > t) {
                r = m - 1; // m下的值大于t，将右边界索引向左移-1
            } else {
                l = m + 1; // m下的值小于t，将左边界索引向右移+1
            }
        }
        // 如果循环完后，没找到返回-1
        return -1;
    }
}
