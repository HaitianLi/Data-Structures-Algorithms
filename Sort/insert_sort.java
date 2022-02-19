public class insert_sort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                }
            }
        }


    }   

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {


        int[] arr = {10,9,8,7,5,3,1,7,4,9,3,2,6,0,3,6,7,2,5,9};
        insertSort(arr);
        for(int i : arr) {
            System.out.println(i);
        }
    }
}
