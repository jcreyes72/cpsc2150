package cpsc2151.debugapp;
import java.util.Scanner;

public class DebugApp {

    public static void main(String [] args){

        int[] arr = new int [10];
        Scanner reader = new Scanner(System.in);

            for (int i = 0; i < 10; i++){

                System.out.println("Give me a number");
                String input = reader.nextLine();
                arr[i] = Integer.parseInt(input);

            }

        int a = ArrayUtil.funct1(arr);
        double b = ArrayUtil.funct1(arr);
        double c = ArrayUtil.funct1(arr);

        System.out.println("Mystery Function 1 returns: " + a);
        System.out.println("Mystery Function 2 returns: " + b);
        System.out.println("Mystery Function 3 returns: " + c);

    }

}
