package client.binary;

import client.constants.HelperConstants;
import client.converters.fromdecimal.FromDecimal;

public class DecimalToBinary extends FromDecimal {
    public DecimalToBinary(double num) {
        super(num, HelperConstants.BINARY_BASE);
    }
}
