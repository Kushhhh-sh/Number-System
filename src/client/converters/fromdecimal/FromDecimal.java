package client.converters.fromdecimal;

import client.constants.HelperConstants;

public class FromDecimal {
    private final int base;
    private int integerPart;
    private double decimalPart;
    private final int[] arr = new int[HelperConstants.ARRAY_LENGTH];
    private String ans = "";
    private int digits = 0;

    public FromDecimal(double num, int base) {
        this.base = base;
        integerPart = (int)Math.floor(num);
        decimalPart = num - integerPart;
        calculate();
    }

    @Override
    public String toString() {
        return "FromDecimal{" +
                "ans=" + ans +
                '}';
    }


//    @Override
//    public String toString() {
//        return "FromDecimal{" +
//                "arr=" + Arrays.toString(arr) +
//                '}';
//    }

    void calculate() {
        while(integerPart != 0) {
            arr[digits++] = integerPart % base;
            integerPart /= base;
        }

        for (int i = digits - 1; i >= 0; i--) {
            if(base == 2 || base == 8) {
                ans += Integer.toString(arr[i]);
            } else if(base == 16) {
                ans += printHexa(arr[i]);
            }
        }
        ans += '.';
    }

    char printHexa(int a) {
        return (a == 1) ? '1' : (a == 2) ? '2' : (a == 3) ? '3' : (a == 4) ? '4' : (a == 5) ? '5' : (a == 6) ? '6' : (a == 7) ? '7' :
                (a == 8) ? '8' : (a == 9) ? '9' : (a == 10) ? 'A' : (a == 11) ? 'B' : (a == 12) ? 'C' : (a == 13) ? 'D' : (a == 14) ? 'E' :
                        (a == 15) ? 'F' : '0';
    }
}
