package Modul1;

import java.util.Scanner;

//maria gresia_235314094
public class Ch9ReplaceAll {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name? ");//meminta input
        String kalimat = scanner.nextLine();//menyimpan input ke dalam "kalimat"
        String diganti = kalimat.replaceAll("[aeiou]", "@");//mengganti setiap huruf vokal dengan "@"

        System.out.println("orginal string: " + kalimat);//menampilkan input "kalimat"
        System.out.println("replaced string: " + diganti);//menampilkan string setelah huruf vokal diganti dengan "@"

        String replaced = diganti.replaceAll("[0-9]", "*");//mengganti angka dengan "*"
        System.out.println("replaced number: " + replaced);//menampilkan kstring setelah angka diganti dengan "*"
        
        String changed = diganti.replaceAll("\\s+", "");//menghapus spasi
        System.out.println("replaced white space: " + changed);//menampilkan string setelah spasi dihapus
    }
}
