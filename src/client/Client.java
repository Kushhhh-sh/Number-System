package client;

import client.binary.DecimalToBinary;
import client.constants.HelperConstants;
import client.hexadecimal.DecimalToHexadecimal;
import client.octal.DecimalToOctal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws IOException {
        double num = 0;
        int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("This is Number System!!");
            System.out.print("\nChoose from the following operations: \n1. Decimal To Binary\t\t\t\t    2. Decimal To Octal\n3. Decimal To Hexadecimal\n\nYour Choice: ");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.print("Please Enter a Number: ");
                    num = Double.parseDouble(br.readLine());
                    System.out.print("Enter the decimal precision of the answer (No. Of Digits After Decimal): ");
                    HelperConstants.PRECISION = Integer.parseInt(br.readLine());
                    System.out.println("The Binary of " + num + " is: " + new DecimalToBinary(num));
                    break;
                case 2:
                    System.out.print("Please Enter a Number: ");
                    num = Double.parseDouble(br.readLine());
                    System.out.print("Enter the decimal precision of the answer (No. Of Digits After Decimal): ");
                    HelperConstants.PRECISION = Integer.parseInt(br.readLine());
                    System.out.println("The Octal of " + num + " is: " + new DecimalToOctal(num));
                    break;
                case 3:
                    System.out.print("Please Enter a Number: ");
                    num = Double.parseDouble(br.readLine());
                    System.out.print("Enter the decimal precision of the answer (No. Of Digits After Decimal): ");
                    HelperConstants.PRECISION = Integer.parseInt(br.readLine());
                    System.out.println("The Hexadecimal of " + num + " is: " + new DecimalToHexadecimal(num));
                    break;
                default:
                    System.out.println("Please Enter a valid choice!!");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid Input Value..!!\nRequired Value: Int OR Double");
            System.exit(1);
        }

    }
}
