package Modul1;

import java.util.regex.*;
import java.util.Scanner;

//maria gresia_235314094
public class RegularExpression2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //soal no 4c
        System.out.print("Masukkan kata = ");//meminta input
        String masukan2 = in.next();//menyimpan input ke dalam "masukan2"
        
        //memeriksa apakah masukan2 terdiri dari huruf kecil atau besar
        //dan tidak boleh mengandung angka
        boolean benar = masukan2.matches("[a-zA-Z]+");
        if (benar) {
            System.out.println("sesuai");
        } else {
            System.out.println("tidak sesuai");
        }
    }
}
