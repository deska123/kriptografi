import java.util.Scanner;

/** 
  * Program ini untuk melakukan enkripsi dan dekripsi Vigenere
  * dengan kunci yang ditentukan oleh user
  * 
  * @author Dennis Pratama Kamah 
  * @version 2016.04.09
  *
  */
public class VigenereCipher
{
    public static char[] huruf =
    {'a','b','c','d','e','f',
    'g','h','i','j','k','l',
    'm','n','o','p','q','r',
    's','t','u','v','w','x',
    'y','z'
    };     
    
    public static int cekIndeks(char huruf)
    {
        int indeks = 0;
        for(int i = 0; i < VigenereCipher.huruf.length; i++) {
            if(huruf == VigenereCipher.huruf[i]) {
                indeks = i;
                break;
            }
        }
        return indeks;
    }
    
    public static void enkripsi(String plainText, String kunci)
    {
        String baru = "";
        int j = 0;
        for(int i = 0; i < plainText.length(); i++, j++) {
            if(j == kunci.length()) {
                j = 0;
            }
            baru += VigenereCipher.huruf[(cekIndeks(plainText.charAt(i)) + cekIndeks(kunci.charAt(j))) % 26] + "";
        }
        System.out.println("Kata hasil enkripsi adalah : " + baru);
    }
    
    public static void dekripsi(String cipherText, String kunci)
    {
        String baru = "";
        int j = 0;
        for(int i = 0; i < cipherText.length(); i++, j++) {
            if(j == kunci.length()) {
                j = 0;
            }
            baru += VigenereCipher.huruf[(cekIndeks(cipherText.charAt(i)) - cekIndeks(kunci.charAt(j))) % 26] + "";
        }
        System.out.println("Kata hasil dekripsi adalah : " + baru);
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Apakah yang ingin anda lakukan (enkripsi/dekripsi): ");
        String pilihan = in.next();
        System.out.print("Masukkan kata yang ingin diproses (huruf kecil semua dan tanpa spasi): ");
        String kata = in.next();
        System.out.print("Masukkan kunci yang diinginkan (kurang dari sama dengan panjang kata diproses) : ");
        String kunci = in.next();
        if(pilihan.equals("enkripsi")) {
            enkripsi(kata, kunci);
        } else { 
            dekripsi(kata, kunci);
        }
    }  
}
