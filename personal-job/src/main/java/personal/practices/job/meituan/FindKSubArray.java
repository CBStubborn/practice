package personal.practices.job.meituan;

/**
 * Created by Stubborn on 2017/8/31.
 */
public class FindKSubArray {

    private static int getMaxSubLength(int[] array, int low, int high, int k) {
        int mid = (high + low) / 2;
        int leftLength = getMaxSubLength(array, low, mid, k);
        int rightLength = getMaxSubLength(array, mid + 1, high, k);
        int midLength = getCrossingMidSubArray(array, low, mid, high, k);
        System.out.println(leftLength + rightLength + midLength);
        return 0;
    }

    private static int getCrossingMidSubArray(int[] array, int low, int mid, int high, int k) {
        int length;
        int leftLength = 0;
        int[] leftArray = new int[mid - low];
        int[] rightArray = new int[high - mid];
        for (int i = mid - 1; i >= low; i--) {
            if (i == mid - 1) {
                leftArray[i - low] = array[i];
            } else {
                leftArray[i - low] = leftArray[i - low + 1] + array[i];
            }
        }
        for (int i = mid + 1; i <= high; i++) {
            if (i == (mid + 1)) {
                rightArray[i - mid - 1] = array[i];
            } else {
                rightArray[i - mid - 1] = rightArray[i - mid - 2] + array[i];
            }
        }
        for (int i = leftArray.length - 1; i >= 0; i--) {
            if ((leftArray[i] + array[mid]) % k == 0) {
                leftLength = 1 + leftArray.length - i;
            }
        }
        length = leftLength;
        for (int j = 0; j < rightArray.length - 1; j++) {
            if (length > 0) {
                if (rightArray[j] % k == 0) {
                    length = leftLength + j + 1;
                }
            } else {
                if ((rightArray[j] + array[mid]) % k == 0) {
                    length = leftLength + 1 + j + 1;
                }
            }
        }
        if (length == 0) {
            if (array[mid] % k == 0) {
                length = 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        getMaxSubLength(array, 0, 4, 5);
    }
}
