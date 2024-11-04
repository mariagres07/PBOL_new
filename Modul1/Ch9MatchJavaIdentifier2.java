package Modul1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//maria gresia_235314094
public class Ch9MatchJavaIdentifier2 {

    private static final String STOP = "STOP";
    private static final String VALID = "Valid Java identifier";
    private static final String INVALID = "Not a valid Java identifier";
    //pola diawali dengan huruf lalu dilanjut dengan huruf, angka, _ atau $
    private static final String VALID_IDENTIFIER_PATTERN = "[a-zA-Z][a-zA-Z0-9_$]*";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str, reply;
        Matcher matcher;
        
        //mencocokan input dengan pola pada "VALID_IDENTIFIER_PATTERN"
        Pattern pattern = Pattern.compile(VALID_IDENTIFIER_PATTERN);
        
        while (true) {
            System.out.print("Identifier: ");//meminta input
            str = scanner.next();//menyimpan input ke dalam "str"
            
            //jika input sama dengan STOP maka perulangan akan berhenti 
            if (str.equals(STOP)) {
                break;
            }
            
            //membuat objek untuk mencocokkan "str" dengan pola
            matcher = pattern.matcher(str);
            
            if (matcher.matches()) {
                reply = VALID;//jika sesuai, maka akan menampilkan pesan pada VALID
            } else {
                reply = INVALID;//jika tidak sesuai, maka akan menampilkan pesan pada INVALID
            }
            //menampilkan hasil dari "str" dan "reply"
            System.out.println(str + ": " + reply + "\n");
        }
    }
}
