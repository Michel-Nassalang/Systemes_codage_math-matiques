package Codage_TP;

import java.util.Scanner;

public class Tp1 {
    public static Scanner scan = new Scanner(System.in);
    public static void toBinaire(String mot){
        System.out.print("Veuillez donner un mot : ");
        byte[] bytes = mot.getBytes();
        System.out.print("Le mot " + mot + " en byte donne " + bytes.length + " bytes : ");
        for (byte b : bytes) {
            System.out.print(" " + b);
        }
        System.out.println(".");
        String code = "";
        for (byte b : bytes) {
            code = code + Integer.toBinaryString(b);
        }
        String tricode = code + "||" + code + "||" + code;
        System.out.println("Le mot en binaire donne : " + code);
        System.out.println("Le code de répétition 3 du mot est :" + tricode);
    }
    public static void toStrings(String mot){
        String code = "";
        byte[] bytes = mot.getBytes();
        String bin;
        for(byte b : bytes){
            bin = Integer.toBinaryString(b);
            while(bin.length()<8){
                bin = "0" + bin;
            }
            code = code + bin;
        }
        int len = code.length();
        int part = len/8;
        String conv = "";
        for(int i = 0; i < part; i++){
            int a = 8*i;
            int b = a+8;
            String chaine = code.substring(a,b);
            int dec = Integer.parseInt(chaine,2);
            char carac = (char) dec;
            conv = conv + carac;
        }
        System.out.println("Le mot donné en entrée est : "+ conv);
    } 
    public static void main(String[] args){
        System.out.print("Donnez un mot : ");
        String mot = scan.next();
        toBinaire(mot);
        // toStrings(mot);
    }
}
