package com.promineotech;

import java.util.Random;

/*Test demo class is made up of four methods (addPositive, reverseString, 
 * randomNumberSquared, and getRandomInt)
 */
public class TestDemo {
	
	/*The addPositive method checks if the two parameters are positive. If either 
	 * parameter is not positive, the method throws an IllegalArgumentException with the
	 *  message "Both parameters must be positive!". If both parameters are positive, the method 
	 *  simply adds the two parameters and returns the result. 
	 */
	public int addPositive(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
        return a + b;
    }
	
	/*reverseString creates a new StringBuilder object with the original as an input.
	 * It then calls the reverse method which reverses the order of the characters in 
	 * the string. 
	 */
	public String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
	/*randomNumberSquared method first calls the getRandomInt method to get a random int between
	 *  1 and 10. The method then multiplies the random int by itself and returns the result.
	 */
	public int randomNumberSquared() {
		int randomNumber = getRandomInt();
		return randomNumber * randomNumber;
	}
	/*getRandomInt method creates a new Random object and then calls the nextInt method on the
	 *  Random object. The nextInt method returns a random int between 0 and the specified number.
	 *   In this case, the specified number is 10. The method then adds 1 to the random int and 
	 *   returns the result.
	 */
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	

}

