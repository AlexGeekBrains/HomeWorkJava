package lesson3;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {



        /*
        Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0;
        */

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));

        /*
        Задать пустой целочисленный массив длиной 100.
       С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
       */

        int[] arrOneHundred = new int[100];
        for (int i = 0; i < arrOneHundred.length; i++) {
            arrOneHundred[i] = i + 1;
        }
        System.out.println(Arrays.toString(arrOneHundred));

        /*
        Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        и числа меньшие 6 умножить на 2;
        */

        int[] lessSixMultiplyTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < lessSixMultiplyTwo.length; i++) {
            if (lessSixMultiplyTwo[i] < 6) {
                lessSixMultiplyTwo[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(lessSixMultiplyTwo));

        /*
        Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
        если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких
        элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         */

        int[][] arrSquare = new int[10][10];
        for (int i = 0; i < arrSquare.length; i++) {
            for (int j = arrSquare.length - 1; j >= 0; j--) {
                if (i == j || j == arrSquare.length - i - 1) {
                    arrSquare[i][j] = 1;
                }
                System.out.print(arrSquare[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println(Arrays.toString(returnArray(8, 9)));


        /*Задать одномерный массив и найти в нем минимальный и максимальный элементы ;*/

        int[] arrMinMax = {10, 12, 9, 7, 1, 9, -27, 11, 10, 21, 3};
        int min = 0;
        int max = 0;

        for (int i = 0; i < arrMinMax.length; i++) {
            if (arrMinMax[i] < 0) {
                max += arrMinMax[i];
            } else {
                min += arrMinMax[i];
            }
            for (int j = 0; j < arrMinMax.length; j++) {
                if (arrMinMax[j] > max) {
                    max = arrMinMax[j];
                }
                if (arrMinMax[j] < min) {
                    min = arrMinMax[j];
                }
            }
        }
        System.out.println("Наименьший элемент в массиве " + min + " Наибольший элемент в массиве " + max);


        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));

        shift(new int[]{2, 4, 6, 8, 10, 12, 16, 18}, 3);
    }

       /*
    * ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
        checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
        checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
        */


    public static boolean checkBalance(int[] arr) {

        int left = arr[0] + arr[1];
        int right = arr[arr.length - 1] + arr[arr.length - 2];

        if (left != right) {
            for (int i = 2; i < arr.length - 2; i++) {
                for (int j = arr.length - 3; j > i - 1; j--) {
                    right += arr[j];
                    if (left == right)
                        return true;
                }
                left += arr[i];
                right = arr[arr.length - 1] + arr[arr.length - 2];
                if (left == right) return true;

            }
        } else return true;
        return false;
    }


    /* Написать метод, принимающий на вход два аргумента: len и initialValue,
        и возвращающий одномерный массив типа int
        длиной len, каждая ячейка которого равна initialValue;*/

    public static int[] returnArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = initialValue;
        return arr;
    }

    /*
     *** Написать метод, которому на вход подается одномерный массив и число n
     * (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива
     *  на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными
     *  массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2
     * (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     */

    public static void shift(int[] arr, int integration) {

        int counter = 0;
        int vault = 0;

        if (integration > 0) {
            do {
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (i == arr.length - 1) {
                        vault = arr[i];
                        arr[i] = arr[i - 1];
                        counter++;
                    } else if (i != 0) {
                        arr[i] = arr[i - 1];

                    } else {
                        arr[i] = vault;

                    }
                }
            } while (counter < integration);
        } else if (integration < 0) {

            do {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        vault = arr[i];
                        arr[i] = arr[i + 1];
                        counter--;
                    } else if (i != arr.length - 1) {
                        arr[i] = arr[i + 1];

                    } else {
                        arr[i] = vault;

                    }
                }
            } while (counter > integration);
        } else {
            arr = arr;
        }


        System.out.println(Arrays.toString(arr));
    }


}

















