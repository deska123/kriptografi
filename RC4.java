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
  * Program ini untuk melakukan enkripsi/dekripsi suatu teks 
  * dengan menggunakan RC4, dimana kunci ditentukan sendiri
  * 
  * @author Dennis Pratama Kamah 
  * @version 2016.04.17
  *
  */
public class RC4 
{
    public static int[] arrayS = new int[256];
    public static int[] vektorT = new int[256];
    public static int[] keyStream = new int[256];
    public static String teksAwal;
    public static String teksAkhir = "";
    
    public static void inisialisasi(String kunci)
    {
        for(int i = 0; i < 256; i++) {
            arrayS[i] = i;
            vektorT[i] = (int) kunci.charAt(i % kunci.length());
        } 
    }
    
    public static void permutasiAwal(int[] S, int[] T)
    {
        int j = 0;
        for(int i = 0; i < 256; i++) {
            j = (j + arrayS[i] + vektorT[i]) % 256;
            int temp = arrayS[i];
            arrayS[i] = arrayS[j];
            arrayS[j] = temp;
        }
    }
    
    public static void bentukKunci(String kunci)
    {
        inisialisasi(kunci);
        permutasiAwal(arrayS, vektorT);
    }
    
    public static void streamGenerate()
    {
        int i = 0, j = 0;
        for(int a = 0; a < 256; a++) {
            i = (i + 1) % 256;
            j = (j + arrayS[i]) % 256;
            int temp = arrayS[i];
            arrayS[i] = arrayS[j];
            arrayS[j] = temp;
            int t = (arrayS[i] + arrayS[j]) % 256;
            keyStream[a] = arrayS[t];
        }
    }
    
    public static void prosesTeks(String teks, int[] keyStream)
    {
        for(int i = 0; i < teks.length(); i++) {
            teksAkhir += ((char)(((int) teks.charAt(i)) ^ keyStream[i])) + "";
        }
    }
    
    public static void prosesRC4(String teks, String kunci)
    {
        RC4.teksAwal = teks;
        bentukKunci(kunci);
        streamGenerate();
        prosesTeks(RC4.teksAwal, RC4.keyStream);
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan kunci yang diinginkan : ");
        String kunci = in.next();
        System.out.print("Masukkan teks (String) yang ingin dienkrip/dekrip (tanpa spasi) : ");
        String teks = in.next();
        System.out.println("");
        prosesRC4(teks, kunci);
        System.out.println();
        System.out.println("Hasilnya : " + RC4.teksAkhir);
    }
}
