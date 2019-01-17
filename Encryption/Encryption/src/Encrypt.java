 


public class Encrypt extends main{

	/**
	 * This function will take a message and use a key  to encrypt it
	 * @param test: Message that will be encrypted
	 * @param key: encryption key
	 * @return encrypted message message
	 */
	public String encrypt(String test, int key){
		
		int[] digits = intToArray(key);
		int[] ordered = order(digits);
		String shifted = new String();
		int direction = digits[0];
		/*//First Shift
		shifted = shift(test, digits[1], ordered[1]);
		value = arrToInt(digits[0], digits[1], digits[2]) - 
				arrToInt(digits[0], digits[2], digits[3])
				% digits[3];
		shifted = shift(shifted, value, ordered[1]);
		*/

		shifted = shift(test,digits[1],ordered[1], direction);
		shifted = shift(shifted,digits[2],ordered[2], direction);
		shifted = shift(shifted,digits[3],ordered[3], direction);

		
		return shifted;
	}
	/**
	 * Function: arrToInt
	 * Description: reads in parameters to convert an array to an integer
	 * @param signed: positive or negative
	 * @param hunds: third digit
	 * @param tens: second digit
	 * @param ones: first digit
	 * @return integer equivalent to array
	 */
	public int arrToInt(int signed, int hunds, int tens, int ones){
		int sign;
		if(signed==0)
			sign = 1;
		else
			sign = -1;
		return ((hunds * 100) + (tens * 10) + ones) * sign;
	}
	
	/**
	 * Function: arrToInt(overloaded)
	 * Description: reads in parameters to convert an array to an integer
	 * @param signed: positive or negative
	 * @param tens: second digit
	 * @param ones: first digit
	 * @return integer equivalent to array
	 */	
	public int arrToInt(int signed, int tens, int ones){
		int sign;
		if(signed==0)
			sign = 1;
		else
			sign = -1;
		return ((tens * 10) + ones) * sign;
	}
	
	/**
	 * Function: shift
	 * Description: shifts a string by shifting each char
	 * @param msg: string to be shifted
	 * @param shifter: amount the char will be shifted
	 * @param interval: which char in the string will be shifted
	 * @param direction: positive or negative
	 * @return string that is shifted
	 */
	public String shift(String msg, int shifter, int interval, int direction){
		int offset = ' ';
		int range = '~' - ' ' +1;
		if(direction==0){
			direction = 1;
		}
		else if(direction==1){
			direction = -1;
		}
		StringBuilder postShift = new StringBuilder(msg);
		for(int i = interval; i < msg.length()+1; i+=interval){
			char ch = (char)(((int)msg.charAt(i-1) + (shifter * direction) - offset) % range +offset);
			postShift.setCharAt(i-1,ch);
		}
		return postShift.toString();
	}
	
	/**
	 * Function: intToArray
	 * Description: Converts an int to an array with the first index being the sign value
	 * @param digits: int to be converted into an array
	 * @return array converted from digits
	 */
	public static int[] intToArray(int digits){

		int keyArray[] = new int[4];
		int i = 0;
		
		//Extracts sign. + is 0. - is 1.
		if(digits >= 0)
			keyArray[i] = 0;
		else
			keyArray[i] = 1;
		
		//Extracts each digit		
		while(digits != 0){
			i++;
			keyArray[keyArray.length - i] = digits % 10;
			digits = digits/10;
		}
		return keyArray;
	}
	
	/**
	 * Function: order
	 * Description: Determines the order of the array of digits ignoring the sign index
	 * e.g.
	 * 
	 * Passed in:		[0][4][5][2]
	 * Returns:			[0][2][3][1]
	 * 
	 * Passed in:		[1][1][0][0]
	 * Returns:			[1][3][1][2]
	 * 
	 * @param digits: the key in int[] form with sign index
	 * @return described above
	 */
	public static int[] order(int[] digits){
		int[] lowToHigh = fillArray(digits);
		int[] original = fillArray(digits);
		int[] retArray = new int[4];
		retArray[0] = 0;
		
		boolean swapped = false;
		
		bubbleSort(lowToHigh);
		
		for(int i = 1; i < lowToHigh.length; i++){
			swapped = false;
			for(int j = 1; j < original.length; j++){
				if(!swapped){
					if(lowToHigh[i] == original[j]){
						if(retArray[j] == 0){
							retArray[j]=i;
							swapped = true;
						}
					}
				}
			}
		}
		
		return retArray;
	}
	
	/***********************************************************************
	 * Helper methods for debugging purposes
	 ************************************************************************/
	/**
	 * Function: fillArray
	 * Description: Copies an entire array
	 * @param array: returns a copy of the original array
	 * @return
	 */
	public static int[] fillArray(int[] array){
		int[] retArray = new int[array.length];
		for(int i =0; i < array.length; i++){
			retArray[i] = array[i];
		}
		
		return retArray;
	}
	
	/**
	 * Function: bubbleSort
	 * Description: sorts an array from least to greatest
	 * @param array: array to be sorted
	 */
	public static void bubbleSort(int[] array){
		for(int i =1; i < array.length-1;i++){
			for(int j = 1; j < array.length-i;j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1] = temp;
				}
				else if(array[j] == array[j+1]){
					
				}
			}
		}
	}
	/**
	 * Function: print
	 * Description: prints an array for debugging purposes
	 * @param array
	 */
	public static void print(int[] array){
		for(int i=0; i<array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	
}
