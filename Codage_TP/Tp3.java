package Codage_TP;

import java.util.Scanner;

public class Tp3 {

    public static void tabstand(String m){ // Méthode par tableau standard
        String[][] tab = {{"0000","0001","0010","1000"},{"0101","0100","0111","1101"},{"1011","1010","1001","0011"},{"1110","1111","1100","0110"}};
        String code = "null";
        for(int i=0; i<=3; i++){
            for(int j=0; j<=3; j++){
                if(tab[i][j].equals(m)){
                    code = tab[i][0];
                }
            }
        }
        System.out.println("Le mot " + m + " est décodé avec le tableau standard par le mot de code " + code + ".");
    }
    // -----------------------------------------
    public static void vraiSemb(String m) { // Méthode par vraisemblance
        String[] tab = { "0000", "0101", "1011", "1110" };
        int dm = 4;
        String val = "null";
        String str = "";
        for (int i = 0; i < tab.length; i++) {
            str = tab[i];
            int recup = 0;
            for (int j = 0; j < str.length(); j++) {
                if (m.charAt(j) != str.charAt(j)) {
                    recup++;
                }
            }
            if (recup < dm) {
                dm = recup;
                val = str;
            }
        }
        System.out.println(
                "Le mot " + m + " est décodé avec la méthode de maximum de vraisemblance par le mot de code " + val + ".");
    }
    public static boolean binaire(int choix){
        System.out.print("Donnez un mot de longueur 4 en binaire : ");
            Scanner scan = new Scanner(System.in);
            int bin = scan.nextInt();
            String bins = String.valueOf(bin);
            while(bins.length()<4){
                bins = "0" + bins;
            }
            boolean isValid = true;
            if (bins.length() != 4) {
                isValid = false;
            }
            for (int i = 0; i < bins.length()-1; i++){
                if (bins.charAt(i) != '1' && bins.charAt(i) != '0') {
                    isValid = false;
                }
            }
            if(isValid) {
                if(choix == 1){
                    tabstand(bins);
                }else{
                    vraiSemb(bins);
                }
            }else{
                System.out.println("Le mot donné ne peut etre décodé par le code {0000,0101,1011,1110}");
            }
            
            return isValid;
        }


    public static void main(String[] args) {
        System.out.println("Veuillez choisir la méthode de décodage en tapant :");
        System.out.println("1 : Méthode par tableau standard");
        System.out.println("2 : Méthode par maximum de vraisemblance");
        System.out.print("Choix : ");
        try (Scanner sc = new Scanner(System.in)) {
            int c = sc.nextInt();
            boolean isVal = binaire(c);
            while (!isVal) {
                isVal = binaire(c);
            }
        }
    }
    
}
