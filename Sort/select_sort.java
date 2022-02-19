
public class select_sort{

    //选择最小值放到最左侧
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex]? j: minIndex;
            }
            swap(arr, i, minIndex);
        }
        
    }

    public static void swap(int[] arr, int i, int minIndex){
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,10,5, 0, 2, 3};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(arr.length);
    }
}