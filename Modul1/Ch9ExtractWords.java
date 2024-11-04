package Modul1;

import java.util.*;

//maria gresia_235314094
public class Ch9ExtractWords {

    private static final char BLANK = ' ';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index, numberOfCharacters, beginIdx, endIdx;
        String word, sentence;

        System.out.print("Input: ");//meminta input
        sentence = scanner.nextLine();//menyimpan input ke dalam "sentence"
        
        //menyimpan jumlah karakter sentence ke dalam "numberOfCharacters"
        numberOfCharacters = sentence.length();
        index = 0;

        //melakukan perulangan selama index kurang dari numberOfCharacters
        while (index < numberOfCharacters) {
            //jika karakter di index pada "sentence" adalah blank
            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;//maka akan menambahkan nilai index
            }
            beginIdx = index;//menyimpan indeks awal kata
            
            //jika karakter di index pada "sentence" bukan blank
            while (index < numberOfCharacters && sentence.charAt(index) != BLANK) {
                index++;//maka akan menambahkan nilai index
            }
            
            endIdx = index;//menyimpan indeks akhir kata
            //jika beginIdx tidak sama dengan endIdx
            if (beginIdx != endIdx) {
                //mengambil kata pada sentence dari beginIdx hingga endIdx
                word = sentence.substring(beginIdx, endIdx);
                System.out.println(word);//menampilkan isi dari "word"
            }
        }
    }
}
