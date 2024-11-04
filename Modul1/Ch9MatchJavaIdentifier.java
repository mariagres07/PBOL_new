package Modul1;

import java.util.*;

//maria gresia_235314094
public class Ch9MatchJavaIdentifier {

    private static final String STOP = "STOP";
    private static final String VALID = "Valid Java identifier";
    private static final String INVALID = "Not a valid Java identifier";
    private static final String VALID_IDENTIFIER_PATTERN = "[a-zA-Z][a-zA-Z0-9_$]*";//harus diawali dengan huruf

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str, reply;
        
        while (true) {
            System.out.print("Identifier: ");//meminta input
            str = scanner.next();//menyimpan input ke dalam "str"
            
            //jika input sama dengan STOP maka perulangan akan berhenti
            if (str.equals(STOP)) {
                break;
            }
            
            //harus diawali dengan huruf, lalu dilanjut dengan huruf,angka, _, atau $
            if (str.matches("[a-zA-Z][a-zA-Z0-9_$]*")) {
                reply = VALID;//jika sesuai, maka akan menampilkan pesan pada VALID
            } else {
                reply = INVALID;//jika tidak sesuai, maka akan menampilkan pesan pada INVALID
            }
            System.out.println(str + ": " + reply + "\n");//menampilkan pesan pada reply
        }
    }
}
