package _02_AND_OR_and_XOR;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Goal: Implement left and right rotate methods.
 * 
 * Inherently Java doesn't have an instruction to perform left or right
 * rotates (though there are rotate functions in the Integer class).
 * 
 * A rotate is when a bit is shifted outside the width of the variable and is
 * placed on the other side. Here is an example of a right rotate on int 7
 * by 1:
 *      00000000 00000000 00000000 00000111   // original value of 7
 *      10000000 00000000 00000000 00000011   // rotate right by 1
 * 
 * Normally when the number 7 is right shifted by 1, the rightmost '1' is
 * discarded and the result looks like this:
 *      00000000 00000000 00000000 00000011   // 7 >> 1 (last '1' is discarded)
 * For a right rotate the number is not discarded and it's placed on the left,
 * the most significant bit (bit 31).
 * 
 * The same goes for a left rotate:
 *      11111111 11111111 11111111 11111000   // original value of -8
 *      11111111 11111111 11111111 11110001   // rotate left by 1
 */
public class _02_Rotate {
	
	String toBinary(int a) {
		return Integer.toBinaryString(a);
	}
    
    int rotateLeft(int value, int rotateAmount) {

    	for(int i = 0; i < rotateAmount; i++) {
    		int firstDigit = Integer.parseInt(toBinary(value).charAt(0) + "");
    		value = value << 1;
    		if(firstDigit == 1) {
    			value += 1;
    		}
    	}
    	return value;
    	
    	
//    	int firstDigits = Integer.parseInt(toBinary(value).substring(0,rotateAmount) + "");
//    	String firstReverseStr = "";
//    	while(firstDigits > 0){
//    		firstReverseStr += firstDigits % 10;
//    		firstDigits /= 10;
//    	}
//    	int firstReverse = Integer.parseInt(firstReverseStr);
//    	
//    	value <<= rotateAmount;
//    	
//    	value += firstReverse;
//    	
//    	
//    	return 0;

    }
    
    int rotateRight(int value, int rotateAmount) {
    	System.out.println();
    	for(int i = 0; i < rotateAmount; i++) {
    		System.out.println("Begin loop");
    		int lastDigit = Integer.parseInt(toBinary(value).charAt(toBinary(value).length()-1) + "");
    		
//    		System.out.println("Val: " + value);
//    		System.out.println("Binary: " + toBinary(value));
//    		System.out.println("Last digit: " + lastDigit);
//
//    		System.out.println();
//    		System.out.println("Val before: " + toBinary(value));
    		value = value >>> 1;
//    		System.out.println("Val after: " + toBinary(value));
//    		System.out.println();
    		
    		if(lastDigit == 1) {
    			value += (1 << 31);
    		}
//    		if(lastDigit == 1) {
//    			value += Math.pow(2, 31)-2;
//    		}
    		
    		
//    		System.out.println("new val: " + value);
//    		System.out.println("new bin: " + toBinary(value));

    	}
    	
    	
    	System.out.println(Integer.MAX_VALUE);
    	System.out.println(Math.pow(2, 31));
    	
    	
    	
    	
        return value;
    }
    
    @Test
    void testRotateLeft() {
        int i = -8;

        int result = rotateLeft(i, 1);
        System.out.println("Left rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-15));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-15, result);
        
        result = rotateLeft(i, 3);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(-57));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-57, result);
    }
    
    @Test
    void testRotateRight() {
        int i = 7;
        
        int result = rotateRight(i, 1);
        System.out.println("\nRight rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-2147483645));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-2147483645, result);
        
        result = rotateRight(i, 16);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(458752));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(458752, result);
    }
}
