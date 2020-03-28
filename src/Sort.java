import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

class Sort {
    void bubbleSort(int arr[]) {
        for(int i = 0; i<arr.length - 1; i++) {
            for(int j = 0; j < arr.length -i -1; j++) {
                if( arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    printArray(arr);
                }
            }
        }
    }

    void selectionSort(int arr[]) {
        for(int i = 0; i< arr.length - 1; i++) {
            int min_el = i;

            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min_el]) {
                    min_el = j;
                }
            }
            // swap
            int temp = arr[min_el];
            arr[min_el] = arr[i];
            arr[i] = temp;

            printArray(arr);
        }
    }

    void insertionSort(int arr[]) {
        for(int i = 0; i<arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            printArray(arr);
        }
    }

    int shellSort(int arr[]) {
        for(int k = arr.length / 2; k > 0; k /= 2) {
            for(int i = k; i<arr.length; i += 1) {
                int temp = arr[i];

                int j;
                for(j = i; j >= k && arr[j - k] > temp; j -= k) {
                    arr[j] = arr[j - k];

                    printArray(arr);
                }
                arr[j] = temp;
            }
        }

        return 0;
    }


    void printArray(int arr[]) {
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter length of the array: ");
//        int length = scanner.nextInt();
//        int inputArr[] = new int[length];

//        for(int i=0; i<length; i++) {
//            inputArr[i] = scanner.nextInt();
//        }

//        System.out.println(Arrays.toString(inputArr));

        Sort sort = new Sort();
        int arr[] = {4,78,13, 45, 2, 90, 66, 34, 21, 32,10, 7, 5, 102, 56,11, 19, 23, 75, 88};

        System.out.println("--- INITIAL ARRAY ---");
        sort.printArray((arr));

        System.out.println("--- BUBBLE SORT ---");
        int bubble[] = arr.clone();
        sort.bubbleSort(bubble);
        sort.printArray(bubble);

        System.out.println("--- SELECTION SORT ---");
        int selection[] = arr.clone();
        sort.selectionSort(selection);
        sort.printArray(selection);

        System.out.println("--- INSERTION SORT ---");
        int insertion[] = arr.clone();
        sort.insertionSort(insertion);
        sort.printArray(insertion);

        System.out.println("--- SHELL SORT ---");
        int shell[] = arr.clone();
        sort.shellSort(shell);
        sort.printArray(shell);
    }
}