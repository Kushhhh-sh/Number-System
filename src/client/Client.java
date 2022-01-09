package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) {
        int num = 0;
        int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("This is Number System!!");
            System.out.print("Please Enter a Number: ");
            num = Integer.parseInt(br.readLine());
            System.out.print("\nChoose from the following Number Systems: \n1. Binary\n2. Octal\n3. Hexadecimal\n\nYour Choice: ");
            choice = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Error Occured!!");
        }

        switch (choice) {
            case 1:
                System.out.println("So You have selected Binary Number System!!");
                break;
            case 2:
                System.out.println("So You have selected Octal Number System!!");
                break;
            case 3:
                System.out.println("So You have selected Hexadecimal Number System!!");
                break;
            default:
                System.out.println("Please Enter a valid choice!!");
                break;
        }
    }
}
