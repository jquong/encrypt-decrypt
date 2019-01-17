public class Decrypt extends main{
	 
	/**
	 * This function will take the encrypted text and the key used to encrypt it and then decrypt it
	 * to a readable message.
	 * @param test: Encrypted message that will be decrypted
	 * @param key: encryption key
	 * @return decrypted message
	 */
	public String decrypt(String test, int key){
		int[] digits = extractDigits(key);
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
		shifted = shift(test,digits[3],ordered[3], direction);
		shifted = shift(shifted,digits[2],ordered[2], direction);
		shifted = shift(shifted,digits[1],ordered[1], direction);
		
		return shifted;
	}
	
	/**
	 * Shifts a specified interval of characters by a specified distance
	 * and shift amount
	 * @param msg: Message to be decrypted
	 * @param shifter: amount that the character will be shifted
	 * @param interval: which characters in the message will be shifted
	 * @param direction: direction at which the shift will occur
	 * @return the shifted message
	 */
	public String shift(String msg, int shifter, int interval, int direction){
		int offset = ' ';
		int range = '~' - ' ' +1;
		if(direction==0){
			direction = -1;
		}
		else if(direction==1){
			direction = 1;
		}
		
		StringBuilder postShift = new StringBuilder(msg);
		for(int i = interval; i < msg.length()+1; i+=interval){
			int shift_num = ((((shifter * direction) - offset) % range) +offset);
			char ch = (char)((int)msg.charAt(i-1) + shift_num);
			if(ch < offset){
				int diff = offset - ch;
				ch = (char)((int)'~' + 1 - diff);
			}
			postShift.setCharAt(i-1,ch);
		}
		return postShift.toString();
	}
	
	/**
	 * Extracts the digits from an integer format into an int array with the sign in the first
	 * element
	 * 
	 * @param digits: key passed in
	 * @return keyArray
	 */
	public static int[] extractDigits(int digits){

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
	 * order(int[] digits): Orders digits into low to high in the array. Keeps the signed bit
	 * @param digits: key passed in as an array
	 * @return digit array sorted from low to high
	 */
	public static int[] order(int[] digits){
		// Creates copies of digits
		int[] lowToHigh = fillArray(digits);
		int[] original = fillArray(digits);
		int[] retArray = new int[4];
		retArray[0] = 0;
		
		boolean swapped = false;
		// Sorts 
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
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Helper method to copy an array
	 * @param array: array that will be copied
	 * @return the copied new array
	 */
	public static int[] fillArray(int[] array){
		int[] retArray = new int[array.length];
		for(int i =0; i < array.length; i++){
			retArray[i] = array[i];
		}
		
		return retArray;
	}
	/**
	 * Helper method to bubble sort an array
	 * @param array: array that will be sorted
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
	 * Helper method prints an array used for debugging
	 * @param array: array that will be printed
	 */
	public static void print(int[] array){
		for(int i=0; i<array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	
}


