package Modul1;

import java.util.*;
import java.util.regex.*;

//maria gresia_235314094
public class Ch9PMCountJava {
    
    public static void main(String[] args) {
        String document = "Sistem manajemen belajar online di Universitas Sanata Dharma "
                + "\nmemiliki keamananan dan kehandalan yang sangat tinggi. "
                + "\nAdministrator LMS ini dapat diakses dengan username: admin "
                + "\ndan password: rahasia. Diharapkan semua staff agar merahasiakan "
                + "\nusername dan password ini agar sistem tetap aman sentosa";
        int wCount;
        Matcher matcher;
        
        //mencari berapa kali "username" muncul dengan menggunakan CASE_INSENSITIVE
        //agar menghiraukan huruf kapital atau tidak
        Pattern pattern = Pattern.compile("username", Pattern.CASE_INSENSITIVE);
        System.out.print("Sentence: " + document + "\n");//menampilkan isi dari "document"
        
        wCount = 0;
        //membuat objek untuk memeriksa pola yang sama dengan "document"
        matcher = pattern.matcher(document);
        
        while (matcher.find()) {//mencari dan menghitung berapa kali pola muncul
            wCount++;//menjumlahkan pola yang ditemukan
        }
        //menampilkan berapa banyak kata tersebut muncul
        System.out.println("The word 'username' occurred " + wCount + " times.");
    }
}
