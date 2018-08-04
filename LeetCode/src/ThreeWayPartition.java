

/**
 * 荷兰旗问题
 *
 */
public class ThreeWayPartition {

    public int[] threeWayPartition(int[] arr, int l, int r,int num){

        int pmin = l - 1;
        int pmax = r + 1;

        int cur = l;
        while (cur < pmax){
            if (arr[cur] < num){
                swap(arr, ++ pmin, cur ++);
            }else if (arr[cur] > num){
                swap(arr, -- pmax, cur);
            }else { // == num
                cur ++;
            }
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,4,3,6,1,0,7,8};
        ThreeWayPartition partition = new ThreeWayPartition();
        int[] ints = partition.threeWayPartition(arr, 0, arr.length - 1, 4);
        for (int i : ints
             ) {
            System.out.print(i);
        }
    }

}
