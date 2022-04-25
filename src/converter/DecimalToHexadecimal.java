package converter;

import constants.HelperConstants;

public class DecimalToHexadecimal extends FromDecimal {
    public DecimalToHexadecimal(double num) {
        super(num, HelperConstants.HEXADECIMAL_BASE);
    }
}
