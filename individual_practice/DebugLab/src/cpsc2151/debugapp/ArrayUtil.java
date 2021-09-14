package cpsc2151.debugapp;

public class ArrayUtil {

    public static int funct1(int [] arr){

        int sum = 0;

            for (int i = 0; i < arr.length; i++){
                sum += arr[i];
            }

        return sum;
    }

    public static double funct2(int [] arr){

        int sum = funct1(arr);
        double num = sum / arr.length;
        return num;

    }

    public static double funct3(int [] arr){

        double x = 0.0;

            for (int i = 0; i < arr.length; i++){

                x += (double)arr[i] / arr[arr.length - i - 1];

            }

        return x;
    }



}
