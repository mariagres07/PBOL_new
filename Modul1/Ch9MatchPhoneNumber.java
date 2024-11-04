package Modul1;

import java.util.*;

//maria gresia_235314094
public class Ch9MatchPhoneNumber {

    private static final String STOP = "0";
    private static final String VALID = "Valid phone number";
    private static final String INVALID = "Not a valid phone number";
    private static final String VALID_PHONE_PATTERN = "[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneStr, reply;
        
        while (true) {
            System.out.print("Phone#: ");//meminta input
            phoneStr = scanner.next();//menyimpan input ke dalam phoneStr
            
            //jika user menginput "STOP" maka perulangan akan berhenti
            if (phoneStr.equals(STOP)) {
                break;
            }
            //memeriksa apakah "phoneStr" cocok dengan "VALID_PHONE_PATTERN" 
            if (phoneStr.matches(VALID_PHONE_PATTERN)) {
                reply = VALID; //jika sesuai, maka akan mencetak pesan pada valid
            } else {
                reply = INVALID;//jika tidak sesuai, maka akan mencetak pesan pada invalid
            }
            //menampilkan no pada "phoneStr" dan "reply"
            System.out.println(phoneStr + ": " + reply + "\n");
        }
    }
}
