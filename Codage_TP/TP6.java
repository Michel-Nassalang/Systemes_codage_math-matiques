package Codage_TP;

import java.util.Scanner;

public class TP6 {

    public static int number(char bit){
        int r;
        if(bit == '0'){
            r = 0;
        }else{
            r = 1;
        }
        return r;
    }
    
    public static boolean binaire() {
        System.out.print("Donnez un mot de longueur 7 en binaire : ");
        Scanner scan = new Scanner(System.in);
        int bin = scan.nextInt();
        String bins = String.valueOf(bin);
        while (bins.length() < 7) {
            bins = "0" + bins;
        }
        boolean isValid = true;
        if (bins.length() != 7) {
            isValid = false;
        }
        for (int i = 0; i < bins.length() - 1; i++) {
            if (bins.charAt(i) != '1' && bins.charAt(i) != '0') {
                isValid = false;
            }
        }
        if (isValid) {
            int[] s = new int[3];
            int[][] mat = { { 0, 0, 1 }, { 0, 1, 0 }, { 0, 1, 1 }, { 1, 0, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 1 } };
            for(int i = 0; i < 3; i++) {
                int cal = 0;
                for (int j = 0; j < 7; j++){
                    cal = cal + mat[j][i]*number(bins.charAt(j));
                }
                if (cal % 2 == 1) {
                    s[i] = 1;
                }else{
                    s[i] = 0;
                }
            }
            String st = String.valueOf(s[0])+String.valueOf(s[1])+String.valueOf(s[2]);
            int pos = s[0]*4 + s[1]*2 + s[2]*1;
            if(pos == 0){
                System.out.println("Le syndrome du mot reçu est égal à 0.");
                System.out.println("Le mot reçu n'a pas d'erreur.");
            }else{
                System.out.println("Le syndrome du mot reçu est égal à " + st);
                System.out.println("L'erreur du mot reçu se trouve à la " + pos + "ième position.");
                String part1 = bins.substring(0, pos-1);
                String part2 = bins.substring(pos);
                String anc = bins;
                if(bins.charAt(pos)=='1'){
                    bins = part1 + "0" + part2;
                }else{
                    bins = part1 + "1" + part2;
                }
                System.out.println("Le mot " + anc + " reçu traité par le code de Hamming donne : " + bins);
            }
        } else {
            System.out.println("Le mot donné ne peut etre décodé par le code de Hamming (7,4,3)");
        }
        return isValid;
    }

    public static void main(String[] args){
        boolean isVal = binaire();
        while (!isVal) {
            isVal = binaire();
        }
    }
}
