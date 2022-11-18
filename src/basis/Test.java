package basis;

import java.util.Arrays;

/**
 * @author broWsJle
 * @date 2022/11/16 16:58
 */
public class Test {

    public static void main(String[] args) {
//        int[] a = {4,3,5,7,6,8,9,2,1};
        int[] a = {18,23,19,9,23,15};
//        int[] a = {1,2,3,4,5,6,7,8,9};
        // 冒泡排序
        bubble(a);
        // 选择排序
//        selection(a);
        // 插入排序
//        insert(a);
    }

    /**
     * 插入排序
     * @param a
     */
    private static void insert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int n = a[i]; // 待插入的值
            int j = i - 1;
            while (j>=0) {
                if (n < a[j]) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
                j--;
            }
            a[i-1] = n;
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 选择排序
     * @param a
     */
    private static void selection(int[] a) {

        for (int i = 0; i < a.length-1; i++) {
            int s = i;
            for (int j = s + 1; j < a.length; j++) {
                if (a[s] > a[j]) {
                    s = j;
                }
            }
            if (s != i) {
                int t= a[i];
                a[i] = a[s];
                a[s] = t;
            }
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 冒泡排序
     * @param a
     */
    private static void bubble(int[] a) {
        int n = a.length - 1;
        while (true) {
            int p = a.length - 1;
            for (int i = 0; i < n ; i++) {
                if (a[i] > a[i+1]) {
                    int t = a[i];
                    a[i] = a[i+1];
                    a[i+1] = t;
                    p = i;
                }
            }
            n = p;
            System.out.println(Arrays.toString(a));
            if (n == 0) {
                break;
            }

        }
    }

}
