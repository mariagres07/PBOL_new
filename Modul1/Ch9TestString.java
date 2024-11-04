package Modul1;

//maria gresia_235314094
public class Ch9TestString {

    public static void main(String[] args) {
        String message = "Welcome to Java!";
        String pesan = new String("Welcome to this class!");
        String s = new String();//membuat objek String 
        s = "Welcome";//mengisi objek s dengan kata "Welcome"

        //menampilkan isi dari message, pesan, dan s
        System.out.println(message);
        System.out.println(pesan);
        System.out.println(s);
        
        //menampilkan karakter ke-4 dari s pada index ke-3
        System.out.println("Huruf ke-3 dari string : " + s.charAt(3));
        
        //menampilkan huruf ke-5 hingga index ke-7 dengan menggunakan subString pada message
        System.out.println("Huruf ke-5 hingga 7 dari string adalah : " + message.substring(4, 7));
    }
}
