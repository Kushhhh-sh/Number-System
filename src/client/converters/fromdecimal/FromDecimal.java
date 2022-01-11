package client.converters.fromdecimal;

public class FromDecimal {
    private final double num;
    private final int base;
    private int integerPart;
    private double decimalPart;
    private final int[] arr = new int[10];
    private long ans;
    private int i = 0;
    public FromDecimal(double num, int base) {
        this.num = num;
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

    void calculate() {
        while(integerPart != 0) {
            arr[i++] = integerPart % base;
            integerPart /= base;
        }

        for (int i = 10 - 1; i >= 0; i--) {
            ans = ans * 10 + arr[i];
        }

        System.out.println(ans);
    }
}
