package Modul1;

//maria gresia_235314094
public class Ch9TestChar {

    public static void main(String[] args) {
        //(int) 'X' mengubah karakter menjadi kode ASCII
        System.out.println("Kode ASCII dari karakter X : " + (int) 'X');

        //(char) mengubah angka 88 menjadi karakter
        System.out.println("Karakter dengan kode ASCII 88 : " + (char) 88);
        
        //memeriksa apakah String huruf kapital atau tidak
        if (Character.isUpperCase('a')) {
            System.out.println("Huruf Besar");
        } else {
            //mengubah String menjadi huruf kapital dengan menggunakan toUpperCase
            System.out.println("Huruf besarnya a adalah : " + Character.toUpperCase('a'));
        }

        char angka = '8';        
        //mengubah karakter menjadi digit angka dengan menggunakan isDigit
        if (Character.isDigit(angka)) {
            System.out.println("Angka " + angka);
        }

        char huruf = 'z';
        //mengubah karakter menjadi huruf dengan menggunakan isLetter
        if (Character.isLetter(huruf)) {
            System.out.println("Huruf " + huruf);
        }

    }
}
