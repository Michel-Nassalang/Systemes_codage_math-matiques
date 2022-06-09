package Codage_TP;
import java.util.Scanner;

public class Tp4 {

	public static void poids() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Veuillez donner un mot : ");
			String mot = scan.next();
			byte[] bytes = mot.getBytes();
			System.out.print("Le mot " + mot +" en binaire donne "+ bytes.length + " bytes : ");
			for(byte b : bytes) {
				System.out.print(" "+ b);
			}
			System.out.println(".");
			String code = "";
			for(byte b : bytes) {
				code = code + Integer.toBinaryString(b);
			}
			System.out.println(code);
			int nb = 0;
			for (int index = 0; index < code.length(); index++) {
				if (code.charAt(index)=='1') {
					nb++;
				}
			}
			System.out.println("Le poids du mot est de: "+ nb);
		}
	}
	public static void main(String[] args) {
		poids();
	}

}
