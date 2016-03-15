package caeser;

public class CaeserCipher {

	public static void decode(String input){		
		for(int c = 1; c < 26 ; c++){
			String output = "";
			for (char ch : input.toUpperCase().toCharArray()){
				int ascii = ((int) ch) + c;
				if (ascii > 90){
					ascii = ascii - 91 + 65;
				}
				output += (char) ascii;
			}
			System.out.println(c + " " + output);
		}
		
	}
	
	
	public static void main(String[] args) {
		CaeserCipher.decode("ifmmpxpsme");
	}

}
