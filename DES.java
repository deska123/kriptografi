import java.util.ArrayList;
import java.util.Scanner;

/** 
  * Program ini untuk melakukan enkripsi suatu teks 64-bit 
  * dengan menggunakan algoritma DES
  * 
  * @author Dennis Pratama Kamah 
  * @version 2016.02.28
  *
  */
public class DES
{
    public static String hexToBinSmall(int hex)
    {
        String small = "";
        String[] konversi = 
        {"0000", "0001", "0010", "0011",
        "0100", "0101", "0110", "0111",
        "1000", "1001", "1010", "1011",
        "1100", "1101", "1110", "1111"};
        if(hex == 0) {
            small = konversi[0];
        } else if(hex == 1) {
            small = konversi[1];
        } else if(hex == 2) {
            small = konversi[2];
        } else if(hex == 3) {
            small = konversi[3];
        } else if(hex == 4) {
            small = konversi[4];
        } else if(hex == 5) {
            small = konversi[5];
        } else if(hex == 6) {
            small = konversi[6];
        } else if(hex == 7) {
            small = konversi[7];
        } else if(hex == 8) {
            small = konversi[8];
        } else if(hex == 9) {
            small = konversi[9];
        } else if(hex == 10) {
            small = konversi[10];
        } else if(hex == 11) {
            small = konversi[11];
        } else if(hex == 12) {
            small = konversi[12];
        } else if(hex == 13) {
            small = konversi[13];
        } else if(hex == 14) {
            small = konversi[14];
        } else {
            small = konversi[15];
        } 
        return small;
    }
    
    public static char[] hexToBin (String hex)
    {
        char[] bin = new char[hex.length() * 4];
        int j = 0;
        for(int i = 0; i < hex.length(); i++) {
            String temp = "";
            int in = 0;
            if(hex.charAt(i) == 'A') {
                in = 10;
            } else if(hex.charAt(i) == 'B') {
                in = 11;
            } else if(hex.charAt(i) == 'C') {
                in = 12;
            } else if(hex.charAt(i) == 'D') {
                in = 13;
            } else if(hex.charAt(i) == 'E') {
                in = 14;
            } else if(hex.charAt(i) == 'F') {
                in = 15;
            } else {
                in = Integer.parseInt(hex.charAt(i) + "");
            }
            temp = hexToBinSmall(in);
            bin[j] = temp.charAt(0);
            j++;
            bin[j] = temp.charAt(1);
            j++;
            bin[j] = temp.charAt(2);
            j++;
            bin[j] = temp.charAt(3);
            j++;
        }
        return bin;
    }
    
    public static String binToHex (char[] bin)
    {
        String baru = "";
        for(int i = 0; i < bin.length; i++) {
            if(bin[i] == '0' && bin[i + 1] == '0' && bin[i + 2] == '0' && bin[i + 3] == '0') {
                baru += "0";
            } else if(bin[i] == '0' && bin[i + 1] == '0' && bin[i + 2] == '0' && bin[i + 3] == '1') {
                baru += "1";
            } else if(bin[i] == '0' && bin[i + 1] == '0' && bin[i + 2] == '1' && bin[i + 3] == '0') {
                baru += "2";
            } else if(bin[i] == '0' && bin[i + 1] == '0' && bin[i + 2] == '1' && bin[i + 3] == '1') {
                baru += "3";
            } else if(bin[i] == '0' && bin[i + 1] == '1' && bin[i + 2] == '0' && bin[i + 3] == '0') {
                baru += "4";
            } else if(bin[i] == '0' && bin[i + 1] == '1' && bin[i + 2] == '0' && bin[i + 3] == '1') {
                baru += "5";
            } else if(bin[i] == '0' && bin[i + 1] == '1' && bin[i + 2] == '1' && bin[i + 3] == '0') {
                baru += "6";
            } else if(bin[i] == '0' && bin[i + 1] == '1' && bin[i + 2] == '1' && bin[i + 3] == '1') {
                baru += "7";
            } else if(bin[i] == '1' && bin[i + 1] == '0' && bin[i + 2] == '0' && bin[i + 3] == '0') {
                baru += "8";
            } else if(bin[i] == '1' && bin[i + 1] == '0' && bin[i + 2] == '0' && bin[i + 3] == '1') {
                baru += "9";
            } else if(bin[i] == '1' && bin[i + 1] == '0' && bin[i + 2] == '1' && bin[i + 3] == '0') {
                baru += "10";
            } else if(bin[i] == '1' && bin[i + 1] == '0' && bin[i + 2] == '1' && bin[i + 3] == '1') {
                baru += "11";
            } else if(bin[i] == '1' && bin[i + 1] == '1' && bin[i + 2] == '0' && bin[i + 3] == '0') {
                baru += "12";
            } else if(bin[i] == '1' && bin[i + 1] == '1' && bin[i + 2] == '0' && bin[i + 3] == '1') {
                baru += "13";
            } else if(bin[i] == '1' && bin[i + 1] == '1' && bin[i + 2] == '1' && bin[i + 3] == '0') {
                baru += "14";
            } else {
                baru += "15";
            } 
            i += 3;
        }
        return baru;
    }
    
    public static String binToHexAkhir(char[] bin)
    {
        String baru = "";
        for(int i = 0; i < bin.length; i++) {
            if(bin[i] == '0' && bin[i + 1] == '0' && bin[i + 2] == '0' && bin[i + 3] == '0') {
                baru += "0";
            } else if(bin[i] == '0' && bin[i + 1] == '0' && bin[i + 2] == '0' && bin[i + 3] == '1') {
                baru += "1";
            } else if(bin[i] == '0' && bin[i + 1] == '0' && bin[i + 2] == '1' && bin[i + 3] == '0') {
                baru += "2";
            } else if(bin[i] == '0' && bin[i + 1] == '0' && bin[i + 2] == '1' && bin[i + 3] == '1') {
                baru += "3";
            } else if(bin[i] == '0' && bin[i + 1] == '1' && bin[i + 2] == '0' && bin[i + 3] == '0') {
                baru += "4";
            } else if(bin[i] == '0' && bin[i + 1] == '1' && bin[i + 2] == '0' && bin[i + 3] == '1') {
                baru += "5";
            } else if(bin[i] == '0' && bin[i + 1] == '1' && bin[i + 2] == '1' && bin[i + 3] == '0') {
                baru += "6";
            } else if(bin[i] == '0' && bin[i + 1] == '1' && bin[i + 2] == '1' && bin[i + 3] == '1') {
                baru += "7";
            } else if(bin[i] == '1' && bin[i + 1] == '0' && bin[i + 2] == '0' && bin[i + 3] == '0') {
                baru += "8";
            } else if(bin[i] == '1' && bin[i + 1] == '0' && bin[i + 2] == '0' && bin[i + 3] == '1') {
                baru += "9";
            } else if(bin[i] == '1' && bin[i + 1] == '0' && bin[i + 2] == '1' && bin[i + 3] == '0') {
                baru += "A";
            } else if(bin[i] == '1' && bin[i + 1] == '0' && bin[i + 2] == '1' && bin[i + 3] == '1') {
                baru += "B";
            } else if(bin[i] == '1' && bin[i + 1] == '1' && bin[i + 2] == '0' && bin[i + 3] == '0') {
                baru += "C";
            } else if(bin[i] == '1' && bin[i + 1] == '1' && bin[i + 2] == '0' && bin[i + 3] == '1') {
                baru += "D";
            } else if(bin[i] == '1' && bin[i + 1] == '1' && bin[i + 2] == '1' && bin[i + 3] == '0') {
                baru += "E";
            } else {
                baru += "F";
            } 
            i += 3;
        }
        return baru;
    }
    
    public static char[] initialPermutation(char[] teks)
    {
        char[] baru = new char[teks.length];
        int[] ip = 
        {57, 49, 41, 33, 25, 17, 9, 1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7,
        56, 48, 40, 32, 24, 16, 8, 0,
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6};
        for(int i = 0; i < baru.length; i++) {
            baru[i] = teks[ip[i]];
        }
        return baru;
    }
    
    public static char[] finalPermutation(char[] teks)
    {
        char[] baru = new char[teks.length];
        int[] ip = 
        {39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        34, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41, 9, 49, 17, 57, 25,
        32, 0, 40, 8, 48, 16, 56, 24};
        for(int i = 0; i < baru.length; i++) {
            baru[i] = teks[ip[i]];
        }
        return baru;
    }
    
    public static char[] pc1 (char[] kunci)
    {
        char[] baru = new char[kunci.length - 8];
	int[] pc1 = 
        {56, 48, 40, 32, 24, 16, 8,
        0, 57, 49, 41, 33, 25, 17,
        9, 1, 58, 50, 42, 34, 26,
        18, 10, 2, 59, 51, 43, 35,
        62, 54, 46, 38, 30, 22, 14,
        6, 61, 53, 45, 37, 29, 21,
        13, 5, 60, 52, 44, 36, 28,
        20, 12, 4, 27, 19, 11, 3};
        for(int i = 0; i < baru.length; i++) {
            baru[i] = kunci[pc1[i]];
        }
        return baru;
    }
    
    public static char[] pc2 (char[] kunci)
    {
        char[] baru = new char[kunci.length - 8];
	int[] pc1 = 
        {13, 16, 10, 23, 0, 4, 2, 27,
        14, 5, 20, 9, 22, 18, 11, 3,
        25, 7, 15, 6, 26, 19, 12, 1,
        40, 51, 30, 36, 46, 54, 29, 39, 
        50, 44, 32, 47, 43, 48, 38, 55,
        33, 52, 45, 41, 49, 35, 28, 31};
        for(int i = 0; i < baru.length; i++) {
            baru[i] = kunci[pc1[i]];
        }
        return baru;
    }
    
    public static char[] leftShift(char[] kunci)
    {
        char baru[] = new char[kunci.length];
        for(int i = 0; i < baru.length; i++) {
            if(i == baru.length - 1) {
                baru[i] = kunci[0];
            } else {
                baru[i] = kunci[i + 1];
            }
        }
        return baru;
    }   
    
    public static char[] gabungKiriKanan (char[] kiri, char[] kanan)
    {
        char gabung[] = new char[kiri.length + kanan.length];
        for(int i = 0; i < kiri.length; i++) {
            gabung[i] = kiri[i];
        }
        int j = kiri.length;
        for(int i = 0; i < kanan.length; i++) {
            gabung[j] = kanan[i];
            j++;
        }
        return gabung;
    }
    
    public static char[] expansionPermutation(char[] kunciKanan)
    {
        char[] baru = new char[kunciKanan.length + 16];
	int[] eP = 
        {31, 0, 1, 2, 3, 4,
        3, 4, 5, 6, 7, 8,
        7, 8, 9, 10, 11, 12,
        11, 12, 13, 14, 15, 16,
        15, 16, 17, 18, 19, 20,
        19, 20, 21, 22, 23, 24,
        23, 24, 25, 26, 27, 28,
        27, 28, 29, 30, 31, 0};
        for(int i = 0; i < baru.length; i++) {
            baru[i] = kunciKanan[eP[i]];
        }
        return baru;
    }
    
    public static char[] xor(char[] eP, char[] subKey)
    {
        char[] baru = new char[eP.length];
        for(int i = 0; i < baru.length; i++) {
            if(eP[i] == '0' && subKey[i] == '0') {
                baru[i] = '0';
            } else if(eP[i] == '0' && subKey[i] == '1') {
                baru[i] = '1';
            } else if(eP[i] == '1' && subKey[i] == '0') {
                baru[i] = '1';
            } else {
                baru[i] = '0';
            }
        }
        return baru;
    }

    public static String sBox(int indeks, int baris, int kolom)
    {
        String baru = "";
        ArrayList<int[][]> listKotak = new ArrayList<>();
        int[][] s1 = {
            {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, 
            {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
        };
        listKotak.add(s1);
        int[][] s2 = {
            {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
            {3, 13, 4, 7, 15, 2, 8, 14, 0, 1, 10, 6, 9, 11, 5}, 
            {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
            {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
        };
        listKotak.add(s2);
        int[][] s3 = {
            {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
            {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1}, 
            {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
            {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
        };
        listKotak.add(s3);
        int[][] s4 = {
            {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
            {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9}, 
            {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
            {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
        };
        listKotak.add(s4);
        int[][] s5 = {
            {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
            {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6}, 
            {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
            {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
        };
        listKotak.add(s5);
        int[][] s6 = {
            {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
            {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8}, 
            {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
            {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
        };
        listKotak.add(s6);
        int[][] s7 = {
            {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
            {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6}, 
            {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
            {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
        };
        listKotak.add(s7);
        int[][] s8 = {
            {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
            {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2}, 
            {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
        };
        listKotak.add(s8);
        baru = hexToBinSmall(listKotak.get(indeks)[baris][kolom]);
        return baru;
    }
    
    public static char[] substitution(char[] xor)
    {
        char[] baru = new char[xor.length - 16];
        int j = 0, k = 0;
        for(int i = 0; i < xor.length; i += 6) {
            String bar = xor[i] + xor[i + 5] + "";
            int kolom, baris;
            if(bar.equals("00")) {
                baris = 0;
            } else if(bar.equals("01")) {
                baris = 1;
            } else if(bar.equals("10")) {
                baris = 2;
            } else {
                baris = 3;
            }
            String kol = xor[i + 1] + xor[i + 2] + xor[i + 3] + xor[i + 4] + "";
            kolom = Integer.parseInt(binToHex(kol.toCharArray()));
            String temp = sBox(j, baris, kolom);
            j++;
            baru[k] = temp.charAt(0);
            baru[k + 1] = temp.charAt(1);
            baru[k + 2] = temp.charAt(2);
            baru[k + 3] = temp.charAt(3);
            k += 4;
        }
        return baru;
    }
    
     public static char[] permutation(char[] subs)
    {
        char[] baru = new char[subs.length];
	int[] permut = 
        {15, 6, 19, 20, 28, 11, 27, 16,
        0, 14, 22, 25, 4, 17, 30, 9,
        1, 7, 23, 13, 31, 26, 2, 8,
        18, 12, 29, 5, 21, 10, 3, 24};
        for(int i = 0; i < baru.length; i++) {
            baru[i] = subs[permut[i]];
        }
        return baru;
    }
    
    public static char[] tukarKiriKanan(char[] kiri, char[] kanan)
    {
        char[] baru = new char[kiri.length + kanan.length];
        for(int i = 0; i < kanan.length; i++) {
            baru[i] = kanan[i];
        }
        int j = kanan.length;
        for(int i = 0; i < kiri.length; i++) {
            baru[j] = kiri[i];
            j++;
        }
        return baru;
    }
     
    public static ArrayList<String> bentukSubkey(String kunci, int ronde)
    {
        ArrayList<String> daftarKunci = new ArrayList<>();
        char temp[] = pc1(hexToBin(kunci));
        char temp1[] = new char[temp.length / 2];
        char temp2[] = new char[temp.length / 2];
        for(int i = 0; i < temp.length / 2; i++) {
            temp1[i] = temp[i];
        }
        int j = 28; 
        for(int i = 0; i < temp.length / 2; i++) {
            temp2[i] = temp[j];
            j++;
        }
        char kiri[] = leftShift(temp1);
        char kanan[] = leftShift(temp2);
        daftarKunci.add(binToHexAkhir(pc2(gabungKiriKanan(kiri,kanan))));
        for(int i = 2; i <= ronde; i++) {
            if(ronde == 2 || ronde == 9 || ronde == 16) {
                kiri = leftShift(kiri);
                kanan = leftShift(kanan);
            } else {
                kiri = leftShift(kiri);
                kiri = leftShift(kiri);
                kanan = leftShift(kanan);
                kanan = leftShift(kanan);
            }
            daftarKunci.add(binToHexAkhir(pc2(gabungKiriKanan(kiri,kanan))));
        }
        return daftarKunci;
    }
    
    public static ArrayList<String> bentukSubTeks(String teks, ArrayList<String> subKey, int ronde)
    {
        ArrayList<String> daftarSubTeks = new ArrayList<>();
        char[] ip = initialPermutation(hexToBin(teks));
        char[] kiri = new char[32];
        for(int i = 0; i < 32; i++) {
            kiri[i] = ip[i];
        }
        char[] kanan = new char[32];
        int j = 32;
        for(int i = 0; i < 32; i++) {
            kanan[i] = ip[j];
            j++;
        }
        for(int i = 0; i < ronde; i++) {
            char[] eP = expansionPermutation(kanan);
            char[] xor = xor(eP, hexToBin(subKey.get(i)));
            char[] subs = substitution(xor);
            char[] permut = permutation(subs);
            char[] xor2 = xor(kiri, permut);
            kiri = kanan;
            kanan = xor2;
            if(i == (ronde - 1)) {
                char[] swap = tukarKiriKanan(kiri, kanan);
                char[] end = finalPermutation(swap);
                daftarSubTeks.add(binToHexAkhir(end));
            } else {
                daftarSubTeks.add(binToHexAkhir(gabungKiriKanan(kiri,kanan)));
            } 
        }
        return daftarSubTeks;
    }
         
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan kunci untuk enkripsi/dekripsi : ");
        String kunci = in.next();
        System.out.print("Masukkan banyak ronde : ");
        int ronde = in.nextInt();
        System.out.print("Masukkan kata yang ingin dienkripsi : ");
        String teks = in.next();
        System.out.println("Daftar Kunci :");
        ArrayList subKey = bentukSubkey(kunci,ronde);
        for(int i = 0; i < subKey.size(); i++) {
            System.out.println("Kunci pada ronde ke-" + (i + 1) + " : " + subKey.get(i));
        }
        System.out.println();
        ArrayList subTeks = bentukSubTeks(teks, subKey, ronde);     
        for(int i = 0; i < subTeks.size(); i++) {
            System.out.println("Teks terenkripsi pada ronde ke-" + (i + 1) + " : " + subTeks.get(i));
        }
    }  
}
