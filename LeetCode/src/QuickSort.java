import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {

    public int Partiton(int[] arr, int left, int right){
        int flag = right;
        while (left < right){
            while (left < right && arr[left] <= arr[flag]){ ++ left ; }
            while (left < right && arr[right] >= arr[flag]){ -- right; }
            swap(arr, left, right);
        }
        swap(arr, right, flag);
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quickSort(int[] arr, int left, int right){
        if (left > right){
            return;
        }
        int index = Partiton(arr, left, right);
        quickSort(arr, left,index - 1);
        quickSort(arr, index + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,1,7,3,4,6};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0 , arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
