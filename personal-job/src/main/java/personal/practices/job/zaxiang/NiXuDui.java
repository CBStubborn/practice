package personal.practices.job.zaxiang;


/**
 * 要求：求给定序列的逆序对个数
 * 解题思想:用分治法求解
 * Created by CBStubborn on 2017/11/9.
 */
public class NiXuDui {

    static int count = 0;

    // 将有二个有序数列a[first...mid]和a[mid...last]合并。
    static void mergeArray(int a[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] > a[j]) {
                // 左数组比右数组大
                temp[k++] = a[j++];
                // 因为如果a[i]此时比右数组的当前元素a[j]大，
                // 那么左数组中a[i]后面的元素就都比a[j]大
                // 【因为数组此时是有序数组】
                count += mid - i + 1;
            } else {
                temp[k++] = a[i++];
            }
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[first + i] = temp[i];
        }
    }

    static void mergeSort(int a[], int first, int last, int temp[]) {
        if (first < last) {
            System.out.println("first: " + first + " last: " + last);
            int mid = (first + last) / 2;
            mergeSort(a, first, mid, temp); // 左边有序
            mergeSort(a, mid + 1, last, temp); // 右边有序
            mergeArray(a, first, mid, last, temp); // 再将二个有序数列合并
        }
    }

    static void mergeSort(int a[]) {
        int[] p = new int[a.length];
        mergeSort(a, 0, a.length - 1, p);
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 6, 4};
        mergeSort(array);
        System.out.println(count);
    }
}
