public class HW {

// Автор Семенюк Андрей

//1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;

     static void invertArray() {
        int[] arr = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Начальный вариант: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        System.out.print("После изменения:  ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    static void createArray() {
        int[] arr = new int[8];

        for (int i = 0, j = 0; i < arr.length; i++, j += 3) {
            arr[i] = j;
            System.out.print(arr[i] + " ");
        }
    }

//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int i : arr) {
            System.out.print(i + " ");
        }
            for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
            System.out.print(arr[i] + " ");
        }
    }

//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
// заполнить его диагональные элементы единицами;

// Задание закоммичено по причине поиска упрощенной версии, но из-за работы, могу не успеть во время сдать дз(((

//    static void create2D() {
//        int length = 5;
//
//        int[][] arr = new int[length][length];
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                if ((i == j) || (i == length - 1 - j)) {
//                    arr[i][j] = 1;
//                }
//            }
//        }
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

//5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

    static int[] findElemens(int[] array) {
        int[] m = new int[2];
        m[0] = m[1] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (m[0] > array[i])
                m[0] = array[i];
            if (m[1] < array[i])
                m[1] = array[i];
        }
        return m;
    }

//6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
// если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
// checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
// checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.

    static boolean checkTrue(int[] arr) {
        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < arr.length + 1; i++) {
            leftSum = 0;
            rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum) return true;
        }
        return false;
    }

//7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
// или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя
// пользоваться вспомогательными массивами.

    static void brainBroken(int[] arr, int n) {
            for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("(n = " + n + ")");
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
