package Modul1;

import java.util.*;

//maria gresia_235314094
public class Ch9CountJava {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int javaCount = 0;
        String word;
        
        while (true) {//melakukan perulangan hingga user menginput "STOP"
            System.out.print("Next word: ");//meminta input
            word = scanner.next();//menyimpan input ke dalam word
            
            if (word.equals("STOP")) {//perulangan berhenti jika input sama dengan "STOP" 
                break;
            } else if (word.equalsIgnoreCase("Java")) {//jika input sama dengan java tanpa memperhatikan kapital
                javaCount++;//menjumlahkan setiap kata "Java" yang telah diinput
            }
        }
        System.out.println("'Java' count: " + javaCount);//menampilkan jumlah kata "Java"
    }
}
