package Codage_TP;

import java.util.Scanner;

public class Tp5 {

    public static void poids_faible() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Veuillez donner un mot : ");
            String mot = scan.next();
            System.out.print("Veuillez donner le nombre de bits de poids faible à renvoyer :");
            int num = scan.nextInt();
            byte[] bytes = mot.getBytes();
            System.out.print("Le mot " + mot + " en binaire donne " + bytes.length + " bytes : ");
            for (byte b : bytes) {
                System.out.print(" " + b);
            }
            System.out.println(".");
            String code = "";
            for (byte b : bytes) {
                code = code + Integer.toBinaryString(b);
            }
            System.out.println(code);
            String partie = code.substring(code.length()-num);
            System.out.println("Les "+num+ " bits de poids faible sont : " + partie);
        }
    }

    public static void main(String[] args) {
        poids_faible();
    }
}
