package converter;

import constants.HelperConstants;

public class DecimalToBinary extends FromDecimal {
    public DecimalToBinary(double num) {
        super(num, HelperConstants.BINARY_BASE);
    }
}
