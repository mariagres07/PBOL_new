package Modul1;

//maria gresia_235314094
public class RegexSubstituion {

    public static void main(String[] args) {
        String firstString = "Every day is sunday";
        String secondString = "Vini pergi ke pasar 3 jam lalu, bersama 4 temannya";

        System.out.printf("Original String 1: %s\n", firstString);
        
        //mengganti kata "day" dengan "week there"
        firstString = firstString.replaceAll("\\bday\\b", "week there");
        System.out.printf("Original string 1 become : %s\n", firstString);

        System.out.printf("Original String 2: %s\n", secondString);
        
        //mengganti setiap huruf "a" dengan "o"
        secondString = secondString.replaceAll("[a]", "o");
        System.out.printf("Original String 2: %s\n", secondString);
        
        //mengganti setiap kata dengan "word"
        System.out.printf("Every word replaced by \"word\": %s\n", 
                firstString.replaceAll("\\w+", "word"));

        //mengganti angka pertama dengan "digit"
        secondString = secondString.replaceFirst("\\d", "digit");
        System.out.printf("Replaced second string: %s\n", secondString);

        //memisahkan kalimat yang memiliki koma menjadi kalimat yang terpisah
        String output = "String is split at commas: [";
        
        //memisahkan kata berdasarkan koma yang diikuti oleh spasi
        String[] results = secondString.split(", \\s*");

        for (String string : results) {
            output += "\"" + string + "\", ";
        }
        //menampilkan hasil pemisahan
        System.out.println("Hasil split : " + output);
        
        //menghapus koma dan spasi terakhir, lalu memberikan "]" di akhir
        output = output.substring(0, output.length() - 2) + "]";
        //menampilkan hasil pemisahan 
        System.out.println(output);
    }
}
