import java.util.*;
 



/*
	public class main {


		*//**
		 * Function: main
		 * Description: Asks user to either encrypt a string or decrypt a string
		 *//*
		public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello. Welcome to my program.");
		int num;
		
		
		 *  Asks user to Encrypt or Decrypt.
		 
		do{
			System.out.println("Enter 1: Encrypt or 2: Decrypt!");

			while(!sc.hasNextInt()){
				System.out.println("Enter an integer!");
				sc.next();
			}
			num = sc.nextInt();
			System.out.println(num);
		} while(num > 2 || num < 1);
		
		
		
		
		 * User chose to Encrypt
		 
		if(num==1){
			System.out.println("Hello. Please enter a string.");
			//Skips to next input to prevent nextLine() to grab nothing
			sc.nextLine();
			//Grabs first line
			String msg = sc.nextLine();
			int key;
			do{
				System.out.println("Please enter a number between -1000 and 1000");

				while(!sc.hasNextInt()){
					System.out.println("Enter an integer!");
					sc.next();
				}
				key = sc.nextInt();
			} while((key >= 1000) || key <= -1000);
			
			Encrypt test = new Encrypt();
			System.out.println("Original String: " + msg);
			System.out.println("Encrypting...");
			String printVal = test.encrypt(msg, key);
			System.out.println("Converted String: " + printVal);
			
			
			 * Gives an option to automatically decrypt
			 
			System.out.println("Do you want to decrypt?");
			do{
				System.out.println("Enter 1: Yes or 2: No!");

				while(!sc.hasNextInt()){
					System.out.println("Enter an integer!");
					sc.next();
				}
				num = sc.nextInt();
				System.out.println(num);
			} while(num > 2 || num < 1);

			
			 * Closes out console
			 
			if(num==2){
				System.out.println("Goodbye");
				System.exit(0);
			}
			
			
			 * Decrypts
			 
			if(num==1){
				Decrypt test1 = new Decrypt();
				System.out.println("Original String: " + printVal);
				System.out.println("Decrypting...");
				String printVal1 = test1.decrypt(printVal, key);
				System.out.println("Converte1d String: " + printVal1);
			}
			
			sc.close();
			sc.close();	
		}
		
		
		 * Decrypts
		 
		if(num==2){
			System.out.println("Hello. Please enter a string.");
			//Skips to next input to prevent nextLine() to grab nothing
			sc.nextLine();
			//Grabs first line
			String msg = sc.nextLine();
			int key;
			do{
				System.out.println("Please enter the key to decrypt");

				while(!sc.hasNextInt()){
					System.out.println("Enter an integer!");
					sc.next();
				}
				key = sc.nextInt();
			} while((key >= 1000) || key <= -1000);
			
			//System.out.println(key);
			Decrypt test = new Decrypt();
			System.out.println("Original String: " + msg);
			System.out.println("Decrypting...");
			String printVal = test.decrypt(msg, key);
			System.out.println("Converted String: " + printVal);

			sc.close();
			sc.close();	
		}
	}*/



}