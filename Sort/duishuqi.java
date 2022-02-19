import java.util.Arrays;
public class duishuqi {

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
    //对数器方法b用于测试
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {


        //Math.random --> [0-1) 所有小数等概率返回
        //Math.random() * N -->[0-N) 所有小数等概率返回
        //(int)(Math.random()*N) -->[0-N-1] 所有整数等概率返回

        int[] arr = new int[(int)((maxSize + 1) * Math.random())];//随机长度
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1)*Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static boolean isEqual(int[] arr1, int[]arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i= 0 ; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {


        //测试次数50w次
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succ = true;

        for (int i = 0; i< testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            bubbleSort(arr1);
            comparator(arr2);

            if (!isEqual(arr1, arr2)) {
                System.out.println("Not Equal");
                for (int num : arr1) {
                    System.out.print(num);
                }
                System.out.println();
                for (int num : arr2) {
                    System.out.print(num);
                }
                succ = false;
                break;

            }
        }

        if (succ) {
            System.out.println("works");
        } else {
            System.out.println("oh no");
        }

    }
    
}
