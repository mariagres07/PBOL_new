package Modul1;

import java.util.*;

//maria gresia_235314094
public class Ch9CountVowels2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name, nameUpper;
        int numberOfCharacters, vowelCount = 0;
        char letter;
        
        System.out.print("What is your name?");//meminta input
        name = scanner.nextLine();//menyimpan input ke dalam "name"
        
        numberOfCharacters = name.length();//menyimpan panjang dari nama ke dalam "numberOfCharacters"
        nameUpper = name.toUpperCase();//toUpperCase() digunakan untuk mengubah data menjadi kapital
        
        for (int i = 0; i < numberOfCharacters; i++) {//memeriksa setiap karakter dalam "nameUpper"
            letter = nameUpper.charAt(i);//mengambil karakter ke-i yang telah diubah menjadi huruf kapital
            if (letter == 'A'//memeriksa apakah termasuk AIUEO
                    || letter == 'E'
                    || letter == 'I'
                    || letter == 'O'
                    || letter == 'U') {
                vowelCount++;//menjumlahkan setiap huruf vokal yang ada pada data name jika memenuhi syarat
            }
        }
        System.out.println(name + ", your name has "+ vowelCount + " vowels");//menampilkan jumlah dari huruf vokal
    }
}
