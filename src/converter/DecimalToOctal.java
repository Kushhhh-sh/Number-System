package converter;

import constants.HelperConstants;

public class DecimalToOctal extends FromDecimal {
    public DecimalToOctal(double num) {
        super(num, HelperConstants.OCTAL_BASE);
    }
}
