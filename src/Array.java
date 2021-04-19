import java.util.Scanner;

public class Array {

        private int length;
        private int[] localArray;

        public void input() {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите длину массива: ");
            this.length = in.nextInt();
            localArray = new int[length];

            System.out.println("Введите сам массив через пробел: ");
            for (int i = 0; i < length; i++) {
                localArray[i] = in.nextInt();
            }
        }

        public void output() {
            System.out.println("Длина массива: " + length);
            System.out.println("Сам массив:");
            for (int i = 0; i < length; i++) {
                System.out.print(localArray[i] + " ");
            }
            System.out.println();
        }

        public void findNumberOfIntakes(int number) {
            int numberOfIntakes = 0;
            for (int i = 0; i < length; i++) {
                if (localArray[i] == number) {
                    numberOfIntakes++;
                }
            }
            System.out.println("Количество вхождений числа "
                    + number + " = " + numberOfIntakes);
        }

        public void getMaxElementWithIndex(int left, int right) {
            int maxElement = 0, maxElementIndex = 0;
            for (int i = left - 1; i <= right - 1; i++) {
                if (localArray[i] > maxElement) {
                    maxElement = localArray[i];
                    maxElementIndex = i + 1;
                }
            }
            System.out.println("Маскимальный элемент и его индекс: "
                    + maxElement + " " + maxElementIndex);
        }

        public void swapMaxToMin() {
            int maxElement = getMaxElement();
            int minElement = getMinElement();
            for (int i = 0; i < length; i++) {
                if (localArray[i] == maxElement) {
                    localArray[i] = minElement;
                }
            }
            output();
        }

        private int getMaxElement() {
            int maxElement = localArray[0];
            for (int i = 1; i < length; i++) {
                if (maxElement < localArray[i]) {
                    maxElement = localArray[i];
                }
            }
            return maxElement;
        }

        private int getMinElement() {
            int minElement = localArray[0];
            for (int i = 1; i < length; i++) {
                if (minElement > localArray[i]) {
                    minElement = localArray[i];
                }
            }
            return minElement;
        }

        public void inputRaspberry() {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите длину массива: ");
            this.length = in.nextInt() + 2;
            localArray = new int[length];

            System.out.println("Введите сам массив через пробел: ");
            for (int i = 0; i < length-2; i++) {
                localArray[i] = in.nextInt();
            }
            localArray[length-2] = localArray[0];
            localArray[length-1] = localArray[1];
        }


        public void calculateMaxSum() {
            int sum = 0;
            for (int i = 0; i < length-2; i++) {
                int currentSum = localArray[i] + localArray[i+1] + localArray[i+2];
                if (currentSum > sum) {
                    sum = currentSum;
                }
            }
            System.out.println(sum);
        }


        public void findSimilarTo(int number) {
            int index = 0,
                    difference = Math.abs(localArray[0] - number);

            for (int i = 1; i < length; i++) {
                int oldDifference = difference;
                int newDifference = Math.abs(localArray[i] - number);

                if (newDifference <= oldDifference && localArray[i] < localArray[index]) {
                    difference = newDifference;
                    index = i;
                }
            }

            System.out.println(localArray[index]);
        }
    }

