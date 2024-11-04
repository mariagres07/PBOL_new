package Modul1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//maria gresia_235314094
public class Ch9PMCountJava2 {

    public static void main(String[] args) {
        String sentence, pattern;
        
        sentence = "Sistem manajemen belajar online di Universitas Sanata Dharma "
                + "memiliki keamnanan dan kehandalan yang sangat tinggi. "
                + "Administrator LMS ini dapat diakses dengan username: admin "
                + "dan password: rahasia. Diharapkan semua staff agar merahasiakan "
                + "username dan password ini agar sistem tetap aman sentosa";
        
        //membuat pola untuk username dan password pada objek p1 dan p2
        Pattern p1 = Pattern.compile(".username:\\s(\\w+)");
        Pattern p2 = Pattern.compile(".password:\\s(\\w+)");
        
        //membuat objek untuk memeriksa kesesuaian pola pada sentence
        Matcher matcher1 = p1.matcher(sentence);
        Matcher matcher2 = p2.matcher(sentence);
        
        //mencari kecocokan pada p1 dalam sentence
        while (matcher1.find()) {
            //menampilkan yang sesuai dengan pola p1 dari objek matcher1
            System.out.println(matcher1.group(0));
            matcher2.find();//mencari kecocokan pada p2 dalam sentence
            //menampilkan yang sesuai dengan pola p2 dari objek matcher2
            System.out.println(matcher2.group(0));
        }
    }
}
