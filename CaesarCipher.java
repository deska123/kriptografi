/* Copyright (c) 2016 Dennis Pratama Kamah - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * You may use, distribute and modify this code under the
 * terms of the XYZ license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the XYZ license with
 * this file. If not, please write to: dennis.pratama@ui.ac.id or dkamah913@gmail.com
 */

import java.util.Scanner;

/** 
  * Program ini untuk melakukan enkripsi atau dekripsi Cipher
  * dengan kunci yang ditentukan oleh user
  * 
  * @author Dennis Pratama Kamah 
  * @version 2016.04.09
  *
  */
public class CaesarCipher 
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
        for(int i = 0; i < CaesarCipher.huruf.length; i++) {
            if(huruf == CaesarCipher.huruf[i]) {
                indeks = i;
                break;
            }
        }
        return indeks;
    }
    
    public static void enkripsi(String plainText, int kunci)
    {
        String baru = "";
        for(int i = 0; i < plainText.length(); i++) {
            baru += CaesarCipher.huruf[(cekIndeks(plainText.charAt(i)) + kunci) % 26] + "";
        }
        System.out.println("Kata hasil enkripsi adalah : " + baru);
    }
    
    public static void dekripsi(String cipherText, int kunci)
    {
        String baru = "";
        for(int i = 0; i < cipherText.length(); i++) {
            int indeksBaru = (cekIndeks(cipherText.charAt(i)) - kunci) % 26;
            if(indeksBaru < 0) {
                indeksBaru += 26;
            }
            baru += CaesarCipher.huruf[indeksBaru] + "";
        }
        System.out.println("Kata hasil dekripsi adalah : " + baru);
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Apakah yang ingin anda lakukan (enkripsi/dekripsi): ");
        String pilihan = in.next();
        System.out.print("Masukkan besar kunci yang diinginkan : ");
        int kunci = in.nextInt();
        System.out.print("Masukkan kata yang ingin diproses (huruf kecil semua dan tanpa spasi): ");
        String kata = in.next();
        if(pilihan.equals("enkripsi")) {
            enkripsi(kata, kunci);
        } else { 
            dekripsi(kata, kunci);
        }
    }  
}
