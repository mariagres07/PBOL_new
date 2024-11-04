package Modul1;

import java.util.regex.*;
import java.util.Scanner;

//maria gresia_235314094
public class RegularExpression11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //soal no 4d
        System.out.println();
        String teks = "<html lang=\"id\"><head><meta charset=\"UTF-8\"> "
                + "<meta name=\"viewport\" content=\"width=device-width, "
                + "initial-scale=1.0\"> <h1>Selamat Datang di Situs Kami!</h1> \n</header> <main> "
                + "<p>Ini adalah paragraf pertama dari halaman web "
                + "contoh ini. \nHTML adalah bahasa yang digunakan untuk membuat struktur halaman web.</p> "
                + "<p> \nAnda bisa belajar lebih lanjut tentang HTML di <a href=\"https://www.htmlschools.com\" "
                + "target=\"_blank\">HTMLSchools</a>.</p> </main><footer> <p> \n2024 "
                + "Contoh Halaman Web. Semua hak cipta dilindungi.</p></footer></body></html>";
        
        //menghapus semua tag HTML 
        String teksBaru = teks.replaceAll("<[^>]*>", "");//menghapus tag HTML 

        //menampilkan hasil teks setelah penghapusan tag HTML
        System.out.println(teksBaru);
    }
}

