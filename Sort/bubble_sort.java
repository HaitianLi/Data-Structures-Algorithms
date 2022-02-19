public class bubble_sort{

    //把最大值挪到最右侧
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static int findOddTimeNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    public static void findOddNumTwoTimes(int[] arr) {
        int eor = 0;

        for (int curNum:arr) {
            eor ^= curNum;
        }

        //提取出不等于0的数的二进制的最右侧的1 拿出来
        //位运算常规操作
        int rightOne = eor & (~eor + 1);
        
        int onlyone = 0;
        for (int curNum: arr) {
            if ((curNum & rightOne) == 0) {
                onlyone ^= curNum;
            }
        }
        System.out.println(onlyone + " " + (eor ^ onlyone));
    }

    public static void main(String[] args) {
        int[] arr = {3,4,2,6,1,7,8,2,9,16,10};
        int[] arr1 = {1,1,2,2,3,3,4,4,5,5,6,6,6,6,7,7,7,8,8,9,9};
        int[] arr2 = {1,1,2,2,3,3,3,4,4,5,6,6,6,6,7,7,8,8};
        bubbleSort(arr);
        System.out.println(findOddTimeNum(arr1));
        findOddNumTwoTimes(arr2);

        // for(int i: arr) {
        //     System.out.println(i);
        // }
    }
}