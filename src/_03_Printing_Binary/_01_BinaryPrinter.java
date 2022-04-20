package _03_Printing_Binary;

public class _01_BinaryPrinter {
    /*
     * Complete the methods below so they print the passed in parameter in binary.
     * Do not use the Integer.toBinaryString method!
     * Use the main method to test your methods.
     */


    public static void printByteBinary(byte b) {
        // We first want to print the bit in the one's place
    	
        // Shift b seven bits to the right
//    	b >>= 7;

        // Use the & operator to "mask" the bit in the one's place
        // This can be done by "anding" (&) it with the value of 1
    	
//    	b &= 1;

        // Print the result using System.out.print (NOT System.out.println)
    	
//    	System.out.print(b);
    	
    	
    	for(int i = 7; i >= 0; i--) {
    		System.out.print((b >> i) & 1);
    	}
        //Use this method to print the remaining 7 bits of b
    }

    public static void printShortBinary(short s) {
        // Create 2 byte variables
    	byte b1;
    	byte b2;
    
    	
    	b1 = (byte) ((s >> 8) & 0b11111111);
    	b2 = (byte) (s & 0b11111111);
    	
//    	System.out.println("1: " + b1);
//    	System.out.println("2: " + b2);

    	
    	printByteBinary(b1);
    	printByteBinary(b2);
    	
    	
    	

        // Use bit shifting and masking (&) to save the first
        // 8 bits of s in one byte, and the second 8 bits of
        // s in the other byte

        // Call printByteBinary twice using the two bytes
        // Make sure they are in the correct order
    }

    public static void printIntBinary(int i) {
        // Create 2 short variables
    	
    	short s1;
    	short s2;

        // Use bit shifting and masking (&) to save the first
        // 16 bits of i in one short, and the second 16 bits of
        // i in the other short
    	s1 = (short) ((i >> 16) & 0b1111111111111111);
    	s2 = (short) (i & 0b1111111111111111);
    	
    	printShortBinary(s1);
    	printShortBinary(s2);

        // Call printShortBinary twice using the two short variables
        // Make sure they are in the correct order
    }

    public static void printLongBinary(long l) {
        // Use the same method as before to complete this method
    	int i1;
    	int i2;
    	
    	
    	i1 = (int) ((l >> 32) & 0b11111111111111111111111111111111);
    	i2 = (int) (l & 0b11111111111111111111111111111111);
    	
    	printIntBinary(i1);
    	printIntBinary(i2);
    }

    public static void main(String[] args) {
        // Test your methods here
    	System.out.println("Byte test:");
    	System.out.print("Target: " + Integer.toBinaryString(15) + "\nActual: ");
    	printByteBinary((byte)15);
    	System.out.println();
    	System.out.print("Target: " + Integer.toBinaryString(234) + "\nActual: ");
    	printByteBinary((byte)234);
    	
    	System.out.println();
    	System.out.println();
    	System.out.println("Short test:");
    	System.out.print("Target: " + Integer.toBinaryString(300) + "\nActual: ");
    	printShortBinary((short) 300);
    	System.out.println();
    	System.out.print("Target: " + Integer.toBinaryString(47589) + "\nActual: ");
    	printShortBinary((short)47589);
    	
    	System.out.println();
    	System.out.println();
    	System.out.println("Int test:");
    	System.out.print("Target: " + Integer.toBinaryString(300) + "\nActual: ");
    	printIntBinary(300);
    	System.out.println();
    	System.out.print("Target: " + Integer.toBinaryString(2147483607) + "\nActual: ");
    	printIntBinary(2147483607);
    	
    	System.out.println();
    	System.out.println();
    	System.out.println("Long test:");
    	System.out.print("Target: " + Integer.toBinaryString(300) + "\nActual: ");
    	printLongBinary(300);
    	System.out.println();
    	System.out.print("Target: " + Long.toBinaryString(2146627483607L) + "\nActual: ");
    	printLongBinary(2146627483607L);
    	
    	
    	
    	
    	
    	
    }
}
