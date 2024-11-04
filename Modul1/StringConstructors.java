package Modul1;

import java.util.*;

//maria gresia_235314094
public class StringConstructors {

    public static void main(String[] args) {
        char charArray[] = {'b', 'i', 'r', 't', 'h', ' ', 'd', 'a', 'y'};
        String s = new String("hello");
        String s1 = new String();
        String s2 = new String(s);
        String s3 = new String(charArray);
        String s4 = new String(charArray, 6, 3);

        //menampilkan nilai dari s1, s2, s3, dan s4
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);

        //equals digunakan untuk membandingkan kata yang tidak mengabaikan kapitalisasi huruf
        //atau harus sama persis
        
        //jika s sama dengan "hello" dengan tidak mengabaikan kapitalisasi huruf
        if (s.equals("hello")) {
            //maka akan menampilkan pesan berikut
            System.out.println("s is equals as\"hello\"");
        } else {
            //jika tidak, maka akan menampilkan pesan ini
            System.out.println("s is not equals as\"hello\"");
        }

        //equalsIgnoreCase digunakan untuk membandingkan kata yang mengabaikan kapitalisasi huruf
        //atau tidak harus sama persis
        
        //jika s sama dengan "HELLO" dengan mengabaikan kapitalisasi huruf
        if (s.equalsIgnoreCase("HELLO")) {
            //maka akan menampilkan pesan ini
            System.out.println("s is equals as\"hello\"");
        } else {
            //jika tidak, maka akan menampilkan pesan ini
            System.out.println("s is not equals as\"hello\"");
        }
        
        //jika s3 mengandung "day"
        if (s3.contains("day")) {
            //maka akan menampilkan pesan ini
            System.out.println("s3 contains\"day\""); 
        } else {
            //jika tidak, maka akan menampilkan pesan ini
            System.out.println("s3 do not contains\"day\""); 
        }

        //concat digunakan untuk menggabungkan dua string
        
        //menggabungkan s dengan s3 dan disimpan ke dalam s5
        String s5 = s.concat(" ") + s3;
        //menampilkan hasil penggabungan dari s5
        System.out.println(s5);
        
        //replaceAll digunakan untuk mengganti suatu kata dengan kata baru
        
        //mengganti  "hello" dengan "happy" pada s5 dan disimpan ke dalam s6
        String s6 = s5.replaceAll("hello", "happy");
        //menampilkan hasil penggantian dari s6
        System.out.println(s6);

        //membuat array yang bernama s7 dengan panjang 3
        String[] s7 = new String[3];
        //memecah s6 dengan spasi        
        s7 = s6.split(" ");
        
        //melakukan perulangan dengan i kurang dari panjang s7 
        //menampilkan setiap elemennya
        for (int i = 0; i < s7.length; i++) {
            System.out.println(s7[i]);
        }
        
        //memisahkan s6 berdasarkan spasi dengan menggunakan StringTokenizer
        StringTokenizer tokens = new StringTokenizer(s6);
        
        //menampilkan jumlah token dari hasil pemisahan 
        System.out.println("Number of Token = " + tokens.countTokens());

        //menampilkan setiap token selama masih ada sisa
        while (tokens.hasMoreElements()) {
            System.out.println(tokens.nextToken());
        }
    }
}
