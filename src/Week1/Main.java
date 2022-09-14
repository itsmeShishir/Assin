package Week1;

import java.util.Arrays;

class Main
{
    public static int getMissingNumber(int[] arr)
    {
        int n = arr.length;
        int m = n + 1;
        int total = m * (m + 1) / 2;
        int sum = Arrays.stream(arr).sum();
        return total - sum ;
    }

    public static void main(String[] args)
    {
        int[] arr = { 8,24,-80};

        System.out.println("The missing number is " + getMissingNumber(arr));
    }
}