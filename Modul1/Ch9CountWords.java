package Modul1;

import java.util.*;
import javax.swing.JOptionPane;

//maria gresia_235314094
public class Ch9CountWords {

    private static final char BLANK = ' ';

    public static void main(String[] args) {
        int index, wordCount, numberOfCharacters;

        //meminta input yang akan ditampilkan dengan menggunakan JOptionPane.showInputDialog
        String sentence = JOptionPane.showInputDialog("Enter a sentence: ");
        //menyimpan jumlah karakter "sentence" ke dalam numberOfCharacters
        numberOfCharacters = sentence.length();

        index = 0;
        wordCount = 0;

        //melakukan perulangan selama index kurang dari numberOfCharacters
        while (index < numberOfCharacters) {
            //jika karakter di index pada "sentence" adalah blank
            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;//maka akan menambahkan nilai index
            }
            //jika karakter di index pada "sentence" bukan blank
            while (index < numberOfCharacters && sentence.charAt(index) != BLANK) {
                index++;//maka akan menambahkan nilai index
            }
            wordCount++;//menjumlahkan banyaknya kata yang ada
        }
        System.out.println("\nInput sentence: " + sentence);//menampilkan isi dari variabel sentence
        System.out.println("    Word count: " + wordCount + " words");//menampilkan jumlah dari banyak kata yang ada 
    }
}
