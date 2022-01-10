package client.octal;

import client.constants.HelperConstants;
import client.converters.fromdecimal.FromDecimal;

public class DecimalToOctal extends FromDecimal {
    public DecimalToOctal(double num) {
        super(num, HelperConstants.OCTAL_BASE);
    }
}
