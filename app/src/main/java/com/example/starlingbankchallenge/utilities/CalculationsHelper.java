package com.example.starlingbankchallenge.utilities;

public class CalculationsHelper {
    public static double roundUpAvailableAmount(int minorUnits){
        double amountWithDecimal = (double) (minorUnits / 100.0);
        double roundedAmount = Math.ceil(amountWithDecimal);
        double availableAmountToRoundUp = roundedAmount - amountWithDecimal;
        return availableAmountToRoundUp;
    }
}
