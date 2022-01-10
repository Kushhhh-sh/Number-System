package client.hexadecimal;

import client.constants.HelperConstants;
import client.converters.fromdecimal.FromDecimal;

public class DecimalToHexadecimal extends FromDecimal {
    public DecimalToHexadecimal(double num) {
        super(num, HelperConstants.HEXADECIMAL_BASE);
    }
}
