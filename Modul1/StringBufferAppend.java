package Modul1;

//maria gresia_235314094
public class StringBufferAppend {

    public static void main(String[] args) {
        Object objectRef = "hello";
        String string = "goodbye";
        char charArray[] = {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean booleanValue = true;
        char characterValue = 'Z';
        int integerValue = 7;
        long longValue = 10000000000L;
        float floatValue = 2.5f;
        double doubleValue = 33.333;
        
        StringBuffer lastBuffer = new StringBuffer("last StringBuffer");
        
        StringBuffer buffer = new StringBuffer();
        
        //menambahkan string dari objek
        buffer.append(objectRef);        
        buffer.append("\n");
        //menambahkan string ke StringBuffer
        buffer.append(string);
        buffer.append("\n");
        //menambahkan seluruh array karakter
        buffer.append(charArray);
        buffer.append("\n");
        //menambahkan sebagian dari array karakter
        buffer.append(charArray, 0, 3);
        buffer.append("\n");
        //menambahkan nilai boolean
        buffer.append(booleanValue);
        buffer.append("\n");
        //menambahkan karakter 
        buffer.append(characterValue);
        buffer.append("\n");
        //menambahkan nilai integer
        buffer.append(integerValue);
        buffer.append("\n");
        //menambahkan nilai long
        buffer.append(longValue);
        buffer.append("\n");
        //menambahkan nilai float
        buffer.append(floatValue);
        buffer.append("\n");
        //menambahkan nilai double
        buffer.append(doubleValue);
        buffer.append("\n");
        //menambahkan seluruh isi dari StringBuffer
        buffer.append(lastBuffer);
        
        //menampilkan isi dari objek buffer 
        System.out.printf("buffer contains %s\n", buffer.toString());
    }
}
