package com.company;

import java.util.ArrayList;

/**
 * <b>OperationsWithNumbers</b> class.
 * @author Marhunou Uladzislau
 * @version 1.0
 */

public class OperationsWithNumbers {
    /**
     * Method - find quantity of numbers with even digits only
     * @param input - array of integers
     * @return finalQuantity - returns an int
     */
    public int FindEvenDigitsOnlyNumbers (ArrayList<Integer> input) {
        int finalSum = 0;
        for(var i : input) {
            int temp  = i;
            boolean check = true;
            while(temp > 0 && check) {
                if(temp % 2 != 0) {
                    check = false;
                }
                temp /= 10;
            }
            if(check) {
                finalSum++;
            }
        }
        return finalSum;
    }

    /**
     * Method - find quantity of numbers with even amount of even and odd digits
     * @param input - array of integers
     * @return finalQuantity - returns an int
     */
    public int FindNumbersWithEqualQuantityOfEvenAndNonEven (ArrayList<Integer> input) {
        int finalQuantity = 0;
        for (var i : input) {
            int temp  = i;
            int even = 0, nonEven = 0;
            while(temp > 0) {
//                (temp % 2) ? even++ : nonEven++;
                if(temp % 2 == 0) {
                    even++;
                } else {
                    nonEven++;
                }
                temp /= 10;
            }
            if(even == nonEven) {
                finalQuantity++;
            }
        }
        return finalQuantity;
    }
}
