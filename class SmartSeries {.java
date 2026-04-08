class SmartSeries {

    public static void main(String[] args) {

        int[] arr = {10, 25, 30, 7, 18};

        int sum = 0;
        int max = arr[0];
        int min = arr[0];
        int even = 0, odd = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (arr[i] > max)
                max = arr[i];

            if (arr[i] < min)
                min = arr[i];

            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;M
        }

        double avg = (double) sum / arr.length;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
        System.out.println("Largest = " + max);
        System.out.println("Smallest = " + min);
        System.out.println("Even count = " + even);
        System.out.println("Odd count = " + odd);
    }
}