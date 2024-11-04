package pbol;

public class kuis1 {
    
    public static boolean cek(String kata){
        String cekKata= "^[A-Z][A-Za-z0-9]{6}\\*$";
        return kata.matches(cekKata);
    }

    public static void main(String[] args) {
        System.out.println(cek("Asfwewt*"));
    }
}
