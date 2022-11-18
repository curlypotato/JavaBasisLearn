package basis;

import java.util.Arrays;

/**
 * 排序：
 * 1、冒泡
 * 2、选择
 * 3、插入
 * 4、希尔
 * 5、快速
 *
 * @author broWsJle
 * @date 2022/11/18 18:19
 */
public class Sort {

    /**
     * 1、冒泡
     *
     * @param a 数组
     */
    public static void bubble(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false; // 减少不必要的冒泡次数
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            System.out.println("第" + i + "轮冒泡：" + Arrays.toString(a));
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 1.1 冒泡-改进
     * 减少内部循环对比次数
     *
     * @param a
     */
    public static void bubbleImprove(int[] a) {
        // 设置最大索引变量
        int n = a.length - 1;
        while (true) {
            int last = 0;  // 表示最后一次交换索引位置
            for (int i = 0; i < n; i++) {
                System.out.println("比较次数：" + i);
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    last = i;
                }
            }
            n = last;
            System.out.println(Arrays.toString(a));
            if (n == 0) {
                break;
            }
        }
    }

    /**
     * 2、选择
     *
     * @param a
     */
    public static void selection(int[] a) {
        // i 代表每轮选择最小元素要交换到的目标索引
        for (int i = 0; i < a.length - 1; i++) {
            int s = i; // 代表最小元素的索引
            for (int j = s; j < a.length; j++) {
                if (a[j] < a[s]) {
                    s = j;
                }
            }
            swap(a, i, s);
            System.out.println("第" + i + "轮选择：" + Arrays.toString(a));
        }
    }

    /**
     * 3、插入
     *
     * @param a
     */
    public static void insert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int n = a[i]; // 需要插入的值
            int j = i - 1;
            while (j >= 0) {
                if (a[j] > n) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
                j--;
            }
            a[j + 1] = n;
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 4、希尔
     *
     * @param a
     */
    public static void shell(int[] a) {
        int length = a.length;
        int step = length / 2; // 首次的索引间隔数
        System.out.println("长度：" + length);
        while (step >= 1) {
            System.out.println("间隔：" + step);
            for (int i = 0; i < length; i++) {
                int n = i + step;
                if (n < length) {
                    if (a[i] > a[n]) {
                        swap(a, i, n);
                    }
                }
            }
            step = step - 1;
            System.out.println(Arrays.toString(a));
        }


    }

    /**
     * 5.1、快速排序：单排（洛穆托）
     *
     * @param a 数组
     * @param l 分区的上边界
     * @param h 分区的下边界
     */
    public static void quickLomuto(int[] a, int l, int h) {

        if (l >= h) {
            return;
        }

        Integer p = pertitionLomuto(a, l, h); // 正确的索引值
        quickLomuto(a, l, p - 1); // 左分区
        quickLomuto(a, p + 1, h); // 右分区
    }

    /**
     * 5.1、单排（洛穆托）
     *
     * @param a 数组
     * @param l 分区的上边界
     * @param h 分区的下边界
     * @return 代表了基准点元素所在的正确索引，用它确定下一轮分区的边界
     */
    private static Integer pertitionLomuto(int[] a, int l, int h) {
        int pv = a[h]; // 选择最右元素为基准点
        int i = l;
        for (int j = l; j < h; j++) {
            if (a[j] < pv) {
                if (i != j) {
                    swap(a, i, j);
//                    System.out.println(Arrays.toString(a) + "j=" + j);
                }
                i++;
            }
        }
        if (i != h) {
            swap(a, h, i);
        }
        System.out.println(Arrays.toString(a) + "i=" + i);
        return i;
    }


    /**
     * 5.2、双排（霍尔分区）
     *
     * @param a 数组
     * @param l 分区的上边界
     * @param h 分区的下边界
     */
    public static void quickHoare(int[] a, int l, int h) {

        if (l >= h) {
            return;
        }
        Integer p = pertitionHoare(a, l, h);
        quickHoare(a, l, p - 1); // 左分区
        quickHoare(a, p + 1, h); // 右分区

    }

    /**
     * 5.2、双排（霍尔分区）
     *
     * @param a 数组
     * @param l 分区的上边界
     * @param h 分区的下边界
     * @return
     */
    private static Integer pertitionHoare(int[] a, int l, int h) {
        int pv = a[l]; // 选择最左元素为基准点
        int i = l; // i从左向右找大的
        int j = h; // j从右向左找小的
        while (i < j) {
            // j 从右找小
            while (i < j && a[j] > pv) {
                j--;
            }
            // i 从左找大
            while (i < j && a[i] <= pv) {
                i++;
            }
            swap(a, i, j);
        }

        swap(a, l, j);
        System.out.println(Arrays.toString(a));
        return j;
    }

    /**
     * i与j两个索引下的值交换
     *
     * @param a 数组
     * @param i 交换i
     * @param j 交换j
     */
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
