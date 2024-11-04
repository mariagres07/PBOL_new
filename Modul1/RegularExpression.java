package Modul1;

import java.util.regex.*;
import java.util.Scanner;

//maria gresia_235314094
public class RegularExpression {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //soal no 4a
        System.out.print("Masukkan angka = ");//meminta input
        String masukan = in.next();//menyimpan input ke dalam "masukan"
        
        //memeriksa apakah masukan terdiri dari 5 hingga 10 digit angka
        boolean valid = masukan.matches("\\d{5,10}");
        if (valid) {
            System.out.println("sesuai");
        } else {
            System.out.println("tidak sesuai");
        }
    }
}
