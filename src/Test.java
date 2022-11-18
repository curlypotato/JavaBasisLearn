import basis.BinarySearch;
import basis.Sort;

import java.util.Arrays;

/**
 * 测试类
 *
 * @author broWsJle
 * @date 2022/11/18 18:02
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("=======test start=======");

        // 二分查找
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println("=======二分查找 start=======");
//        int t = 8; // 查找数值
//        Integer search = BinarySearch.search(a, t);
//        System.out.println("a[" + search + "]=" + t);
//        System.out.println("=======二分查找 end=======");

        // 排序
        int[] sort = {5, 7, 6, 2, 66, 78, 4, 3, 9, 12, 15, 17, 20};
        // 1、冒泡
//        System.out.println("=======1、冒泡 start=======");
//        Sort.bubble(sort);
//        System.out.println("=======1、冒泡 end=======");
        // 1.1、冒泡-改进
//        System.out.println("=======1.1、冒泡-改进 start=======");
//        Sort.bubbleImprove(sort);
//        System.out.println("=======1.1、冒泡-改进 end=======");
        // 2、选择
//        System.out.println("=======2、选择 start=======");
//        Sort.selection(sort);
//        System.out.println("=======2、选择 end=======");
        // 3、插入
//        System.out.println("=======3、插入 start=======");
//        Sort.insert(sort);
//        System.out.println("=======3、插入 end=======");
        // 4、希尔
//        System.out.println("=======4、希尔 start=======");
//        Sort.shell(sort);
//        System.out.println("=======4、希尔 end=======");
        // 5.1、快速：单排（洛穆托）
//        System.out.println("=======5.1、快速：单排（洛穆托） start=======");
//        Sort.quickLomuto(sort, 0, sort.length - 1);
//        System.out.println("=======5.1、快速：单排（洛穆托） end=======");
        // 5.2、快速：双排（霍尔分区）
        System.out.println("=======4、希尔 start=======");
        Sort.quickHoare(sort, 0, sort.length - 1);
        System.out.println("=======4、希尔 end=======");

    }
}
