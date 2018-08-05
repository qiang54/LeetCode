import java.util.Arrays;

/**
 * 堆排序
 */
public class Heapsort {

    public void heapSort(int[] arr){
        if (arr == null || arr.length < 2){ return;}

        //初次调整为大顶堆
        for (int i = 0; i< arr.length; i ++){
            heapInsert(arr,i);
        }

        int heapSize = arr.length;
        swap(arr, 0, -- heapSize);

        //循环把最大值放到数组末尾，在对其余进行调整
        while (heapSize > 0){
            heapify(arr,0, heapSize);
            swap(arr, 0, -- heapSize);
        }

    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2] ){
            //当孩子大于父节点
            swap(arr, index, (index - 1) / 2 );
            index = (index - 1) / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 重新调整为大顶堆
     * @param arr
     * @param index
     * @param heapSize
     */
    private void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            //查找当前节点的孩子中的较大值
            //右节点较大
            int lager = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left +1
                    : left;
            //比较父节点和较大子节点
            lager = arr[lager] > arr[index] ? lager : index;
            if (lager == index){
                //若父节点大
                break;
            }
            //否则父子节点交换
            swap(arr,index, lager);

            //向下走
            index = lager;
            left = index * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,4,3,6,1,0,7,8};
        Heapsort heapsort = new Heapsort();
        heapsort.heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }

}
