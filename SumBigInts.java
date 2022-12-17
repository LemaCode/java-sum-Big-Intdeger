// Name: Manasse Bosango
// Reason: Understand the importance and the use of array data type in java and programming

// This program reads an input file that contains sequences of integers to
// be added together.  The program reads them as Strings so that it can
// process large integers.  Reset the constant MAX_DIGITS to allow it to handle
// larger integers.

import java.io.*;
import java.util.*;

public class SumBigInts {
   public static final int MAX_DIGITS = 25;

   public static void main(String[] args) throws FileNotFoundException {
      // Read the file sum.txt and process it.
      Scanner input = new Scanner(new File("sum.txt"));
      processFile(input);
   }
   // more methods follow for i/o and add and .....

   public static void processFile(Scanner input) {
      String readLine = "";
      int countLines = 0;

      // Reading the next line of the file.
      while (input.hasNextLine()) {
         readLine = input.nextLine();
         countLines++;

         // Creating an array of integers with a length of 25.
         int[] sum = new int[MAX_DIGITS];

         // Creating a new scanner object that is reading the next token of the line in
         // the file.
         Scanner data = new Scanner(readLine);
         while (data.hasNext()) {
            int[] readInt = readBigInt(data); // int readInt = data.nextInt();
            addTwoArrays(sum, readInt); // sum = sum + readInt;
         }
         System.out.print(" = ");
         printArray(sum);
         System.out.println();
         // System.out.println("Line " + countLines + ": " + Arrays.toString(sum));
      }
      System.out.println("\n" + "Total lines = " + countLines);
   }

   /**
    * This function reads the next token of the line in the file and prints the
    * next token of the line
    * in the file. If there is another token in the line, it prints a plus sign
    * 
    * @param input The Scanner object that is reading the file.
    * @return The value of the method splitIntgerToDigits.
    */
   public static int[] readBigInt(Scanner input) {
      // Reading the next token of the line in the file.
      String readnextToken = input.next();

      // Printing the next token of the line in the file. If there is another token in
      // the line, it
      // prints a plus sign.
      System.out.print(readnextToken);
      if (input.hasNext()) {
         System.out.print(" + ");
      }

      // Returning the value of the method splitIntgerToDigits.
      return splitIntgerToDigits(readnextToken);
   }

   /**
    * It takes a string of digits, converts it into an array of characters, then
    * converts the array of
    * characters into an array of integers
    * 
    * @param largeInt The string that contains the large integer.
    * @return An array of integers.
    */
   public static int[] splitIntgerToDigits(String largeInt) {
      // Creating an array of integers with a length of 25.
      int[] arrayOfDigits = new int[MAX_DIGITS];

      // Converting the string into an array of characters.
      char[] charArray = largeInt.toCharArray();

      // Calculating the number of zeros to be appended to the front of the array.
      int appendingLength = MAX_DIGITS - largeInt.length();

      // Converting the string into an array of integers.
      for (int j = 0; j < largeInt.length(); j++) {
         arrayOfDigits[appendingLength + j] = Integer.parseInt(String.valueOf(charArray[j]));
         // arrayOfDigits[appendingLength + j] = Character.getNumericValue(charArray[j]);
      }

      // System.out.print(largeInt + ": " + largeInt.length());
      // System.out.println(Arrays.toString(arrayOfDigits));
      // Returning the value of the method splitIntgerToDigits.
      return arrayOfDigits;
   }

   // num1 = num1 + num2
   public static void addTwoArrays(int[] num1, int[] num2) {
      int carryOver = 0;

      // This is a for loop that is iterating through the array of integers from the
      // last index to the
      // first index.
      for (int i = MAX_DIGITS - 1; i >= 0; i--) {

         // Adding the two numbers together and getting the remainder of the sum.
         int sum = num1[i] + num2[i] + carryOver;
         carryOver = sum / 10;
         num1[i] = sum % 10;
      }
      // System.out.println(Arrays.toString(num1));
   }

   /**
    * It checks for leading zeros in the array and prints the array of integers
    * without the leading
    * zeros
    * 
    * @param array The array of integers that you want to print without the leading
    *              zeros.
    */
   public static void printArrayWithoutLeadingZero(int[] array) {
      // Checking for the leading zeros in the array.
      boolean checkForZero = false;

      for (int i : array) {

         // This is checking for the leading zeros in the array. If the array has a
         // leading zero, it
         // will continue to the next element in the array. If it doesn't, it will set
         // the boolean
         // checkForZero to true.
         if (!checkForZero && i == 0) {
            continue;
         } else {
            checkForZero = true;
         }
         // Printing the array of integers without the leading zeros.
         System.out.print(i);
      }
   }

   /**
    * It checks if the array has a unique value. If it does, it prints the value of
    * the first index of
    * the array. If it doesn't, it prints the array without the leading zeros
    * 
    * @param array This is the array that is being passed in.
    */
   public static void printArray(int[] array) {

      // Checking for the unique value in the array.
      boolean checkForUniqueValue = false;

      // Getting the value of the first index of the array.
      int valueOfFirstIndex = array[0];

      for (int i : array) {

         // Checking for the unique value in the array.
         // Assuming the first element to be the unique element
         if (i != valueOfFirstIndex) {
            checkForUniqueValue = true;
            break;
         }
      }

      // This is checking if the array has a unique value. If it does, it prints the
      // value of the first
      // index of the array. If it doesn't, it prints the array without the leading
      // zeros.
      if (!checkForUniqueValue) {
         System.out.print(valueOfFirstIndex);
      } else {
         printArrayWithoutLeadingZero(array);
      }
   }
}
