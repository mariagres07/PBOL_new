package Modul1;

import java.util.regex.*;
import java.util.Scanner;

//maria gresia_235314094
public class RegularExpression1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //soal no 4b
        System.out.print("Masukkan kata = ");//meminta input
        String masukan1 = in.next();//menyimpan input ke dalam "masukan1"
        
        //memeriksa apakah masukan1 sesuai dengan format, yaitu diawali dengan angka
        //kemudian dilanjut dengan minimal asatu huruf besar dan selanjutnya 
        //huruf kecil atau besar minimal 8 karakter. lalu, diakhiri dengan "*" atau "#"
        boolean isValid = masukan1.matches("\\d[A-Z][A-Za-z]{6,}[*#]");
        if (isValid) {
            System.out.println("sesuai");
        } else {
            System.out.println("tidak sesuai");
        }
    }
}
