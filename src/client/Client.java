package client;

import client.binary.DecimalToBinary;
import client.constants.HelperConstants;
import client.hexadecimal.DecimalToHexadecimal;
import client.octal.DecimalToOctal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) {
        double num = 0;
        int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("This is Number System!!");
            System.out.print("Please Enter a Number: ");
            num = Double.parseDouble(br.readLine());
            System.out.print("Enter the decimal precision of the answer (No. Of Digits After Decimal): ");
            HelperConstants.PRECISION = Integer.parseInt(br.readLine());
            System.out.print("\nChoose from the following Number Systems: \n1. Binary\n2. Octal\n3. Hexadecimal\n\nYour Choice: ");
            choice = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Error Occured!!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid Input Value..!!\nRequired Value: Int OR Double");
            System.exit(0);
        }

        switch (choice) {
            case 1:
                System.out.println("The Binary of " + num + " is: " + new DecimalToBinary(num));
                break;
            case 2:
                System.out.println("The Octal of " + num + " is: " + new DecimalToOctal(num));
                break;
            case 3:
                System.out.println("The Hexadecimal of " + num + " is: " + new DecimalToHexadecimal(num));
                break;
            default:
                System.out.println("Please Enter a valid choice!!");
                break;
        }
    }
}
