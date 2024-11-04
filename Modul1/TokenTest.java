package Modul1;

import java.util.Scanner;
import java.util.StringTokenizer;

//maria gresia_235314094
public class TokenTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sentence and press Enter : ");//meminta input
        String sentence = scanner.nextLine();//menyimpan input ke dalam "sentence"
        
        //menghapus huruf vokal dan memisahkannya dari kata selanjutnya
        StringTokenizer tokens = new StringTokenizer(sentence, "[aeiou]");
        
        //menampilkan jumlah kata yang terpisah
        System.out.printf("Number of elements: %d\nThe tokens are:\n", tokens.countTokens());
        
        //menampilkan hasil token
        while (tokens.hasMoreTokens()) {
            System.out.println(tokens.nextToken());
        }
    }
}
