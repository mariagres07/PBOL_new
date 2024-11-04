package Modul1;

import java.util.*;

//maria gresia_235314094
public class Ch9CountVowels {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int numberOfCharacters, vowelCount = 0;
        char letter;

        System.out.print("What is your name? ");//meminta input
        name = scanner.nextLine();//menyimpan input ke dalam "name"

        numberOfCharacters = name.length();//menyimpan panjang dari nama ke dalam "numberOfCharacters"
        System.out.println(name);//menampilkan isi dari "name"

        for (int i = 0; i < numberOfCharacters; i++) {//memeriksa setiap karakter dalam "name"
            letter = name.charAt(i);//mengambil karakter ke-i

            //memeriksa apakah karakter tersebut merupakah huruf vokal atau tidak
            if (letter == 'a' || letter == 'A'
                    || letter == 'e' || letter == 'E'
                    || letter == 'i' || letter == 'I'
                    || letter == 'o' || letter == 'O'
                    || letter == 'u' || letter == 'U') {
                vowelCount++;//menjumlahkan setiap huruf vokal yang ada pada data name jika memenuhi syarat
            }
        }
        System.out.println(name + ", your name has " + vowelCount + " vowels");//menampilkan jumlah dari huruf vokal
    }
}
