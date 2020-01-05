/*Создать модель (класс) "Number", который принимает (в констуркторе) !массив! с числами размером в n (0 < n < 10).
У данной модели будет перегруженый метод "getSum". Данный метод суммирует все значения массива.
Так же, если в этот метод передали строку - он возвращает строку, в которой есть строка которую передали и сумма всех чисел массива.
Если в метод передали число - сплюсовать это число с суммой всех чисел массива. Массив наполнить рандомными числами k, где 0 <= k <= 20.
Вывести результаты метода getSum в консоль.*/

package javacore;

import java.util.Scanner;

public class Numbers {

    private int arr[];

    Numbers(int arr[]) {
        this.arr = arr;
    }

    public int getSum() {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public String getSum(String string) {
        return string + getSum();
    }

    public void printArray() {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("");
    }

    private static int[] arrayCreator(int n) {
        int arr[] = new int[n];
        int min = 0, max = 20, range = max - min;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }

    public static void main(String[] args) {
        int sizeOfArray;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Enter size of array (0-10): ");
            sizeOfArray = scan.nextInt();
        } while (sizeOfArray < 0 || sizeOfArray > 10);

        Numbers numbers = new Numbers(arrayCreator(sizeOfArray));
        numbers.printArray();
        System.out.println("Sum of array elements is " + numbers.getSum());
        System.out.println(numbers.getSum("Sum of array elements with string is "));
    }
}
