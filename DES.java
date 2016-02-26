import java.util.ArrayList;
import java.util.Scanner;

public class DES
{
    public static char[] hexToBin (String hex)
    {
        char[] bin = new char[hex.length() * 4];
        String[] konversi = 
        {"0000", "0001", "0010", "0011",
        "0100", "0101", "0110", "0111",
        "1000", "1001", "1010", "1011",
        "1100", "1101", "1110", "1111"};
        int j = 0;
        char a,b,c,d;
        for(int i = 0; i < hex.length(); i++) {
            String temp = "";
            if(hex.charAt(i) == '0') {
                temp = konversi[0];
            } else if(hex.charAt(i) == '1') {
                temp = konversi[1];
            } else if(hex.charAt(i) == '2') {
                temp = konversi[2];
            } else if(hex.charAt(i) == '3') {
                temp = konversi[3];
            } else if(hex.charAt(i) == '4') {
                temp = konversi[4];
            } else if(hex.charAt(i) == '5') {
                temp = konversi[5];
            } else if(hex.charAt(i) == '6') {
                temp = konversi[6];
            } else if(hex.charAt(i) == '7') {
                temp = konversi[7];
            } else if(hex.charAt(i) == '8') {
                temp = konversi[8];
            } else if(hex.charAt(i) == '9') {
                temp = konversi[9];
            } else if(hex.charAt(i) == 'A') {
                temp = konversi[10];
            } else if(hex.charAt(i) == 'B') {
                temp = konversi[11];
            } else if(hex.charAt(i) == 'C') {
                temp = konversi[12];
            } else if(hex.charAt(i) == 'D') {
                temp = konversi[13];
            } else if(hex.charAt(i) == 'E') {
                temp = konversi[14];
            } else {
                temp = konversi[15];
            }
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
        char[] temp = teks;
        for(int i = 0; i < baru.length; i++) {
            baru[i] = teks[ip[i]];
        }
        return baru;
    }
    
    public static char[] pc1 (char[] kunci)
    {
        char[] baru = new char[kunci.length - 8];
        char[] temp = kunci;
        for(int i = 0; i < baru.length; i++) {
            if(i == 0) {
                baru[i] = temp[56];
            } else if(i == 1){
                baru[i] = temp[48];
            } else if(i == 2){
                baru[i] = temp[40];
            } else if(i == 3){
                baru[i] = temp[32];
            } else if(i == 4){
                baru[i] = temp[24];
            } else if(i == 5){
                baru[i] = temp[16];
            } else if(i == 6){
                baru[i] = temp[8];
            } else if(i == 7){
                baru[i] = temp[0];
            } else if(i == 8){
                baru[i] = temp[57];
            } else if(i == 9){
                baru[i] = temp[49];
            } else if(i == 10){
                baru[i] = temp[41];
            } else if(i == 11){
                baru[i] = temp[33];
            } else if(i == 12){
                baru[i] = temp[25];
            } else if(i == 13){
                baru[i] = temp[17];
            } else if(i == 14){
                baru[i] = temp[9];
            } else if(i == 15){
                baru[i] = temp[1];
            } else if(i == 16){
                baru[i] = temp[58];
            } else if(i == 17){
                baru[i] = temp[50];
            } else if(i == 18){
                baru[i] = temp[42];
            } else if(i == 19){
                baru[i] = temp[34];
            } else if(i == 20){
                baru[i] = temp[26];
            } else if(i == 21){
                baru[i] = temp[18];
            } else if(i == 22){
                baru[i] = temp[10];
            } else if(i == 23){
                baru[i] = temp[2];
            } else if(i == 24){
                baru[i] = temp[59];
            } else if(i == 25){
                baru[i] = temp[51];
            } else if(i == 26){
                baru[i] = temp[43];
            } else if(i == 27){
                baru[i] = temp[35];
            } else if(i == 28){
                baru[i] = temp[62];
            } else if(i == 29){
                baru[i] = temp[54];
            } else if(i == 30){
                baru[i] = temp[46];
            } else if(i == 31){
                baru[i] = temp[38];
            } else if(i == 32){
                baru[i] = temp[30];
            } else if(i == 33){
                baru[i] = temp[22];
            } else if(i == 34){
                baru[i] = temp[14];
            } else if(i == 35){
                baru[i] = temp[6];
            } else if(i == 36){
                baru[i] = temp[61];
            } else if(i == 37){
                baru[i] = temp[53];
            } else if(i == 38){
                baru[i] = temp[45];
            } else if(i == 39){
                baru[i] = temp[37];
            } else if(i == 40){
                baru[i] = temp[29];
            } else if(i == 41){
                baru[i] = temp[21];
            } else if(i == 42){
                baru[i] = temp[13];
            } else if(i == 43){
                baru[i] = temp[5];
            } else if(i == 44){
                baru[i] = temp[60];
            } else if(i == 45){
                baru[i] = temp[52];
            } else if(i == 46){
                baru[i] = temp[44];
            } else if(i == 47){
                baru[i] = temp[36];
            } else if(i == 48){
                baru[i] = temp[28];
            } else if(i == 49){
                baru[i] = temp[20];
            } else if(i == 50){
                baru[i] = temp[12];
            } else if(i == 51){
                baru[i] = temp[4];
            } else if(i == 52){
                baru[i] = temp[27];
            } else if(i == 53){
                baru[i] = temp[19];
            } else if(i == 54){
                baru[i] = temp[11];
            } else {
                baru[i] = temp[3];
            }
        }
        return baru;
    }
    
    public static char[] pc2 (char[] kunci)
    {
        char[] baru = new char[kunci.length - 8];
        char[] temp = kunci;
		
        for(int i = 0; i < baru.length; i++) {
            if(i == 0) {
                baru[i] = temp[13];
            } else if(i == 1){
                baru[i] = temp[16];
            } else if(i == 2){
                baru[i] = temp[10];
            } else if(i == 3){
                baru[i] = temp[23];
            } else if(i == 4){
                baru[i] = temp[0];
            } else if(i == 5){
                baru[i] = temp[4];
            } else if(i == 6){
                baru[i] = temp[2];
            } else if(i == 7){
                baru[i] = temp[27];
            } else if(i == 8){
                baru[i] = temp[14];
            } else if(i == 9){
                baru[i] = temp[5];
            } else if(i == 10){
                baru[i] = temp[20];
            } else if(i == 11){
                baru[i] = temp[9];
            } else if(i == 12){
                baru[i] = temp[22];
            } else if(i == 13){
                baru[i] = temp[18];
            } else if(i == 14){
                baru[i] = temp[11];
            } else if(i == 15){
                baru[i] = temp[3];
            } else if(i == 16){
                baru[i] = temp[25];
            } else if(i == 17){
                baru[i] = temp[7];
            } else if(i == 18){
                baru[i] = temp[15];
            } else if(i == 19){
                baru[i] = temp[6];
            } else if(i == 20){
                baru[i] = temp[26];
            } else if(i == 21){
                baru[i] = temp[19];
            } else if(i == 22){
                baru[i] = temp[12];
            } else if(i == 23){
                baru[i] = temp[1];
            } else if(i == 24){
                baru[i] = temp[40];
            } else if(i == 25){
                baru[i] = temp[51];
            } else if(i == 26){
                baru[i] = temp[30];
            } else if(i == 27){
                baru[i] = temp[36];
            } else if(i == 28){
                baru[i] = temp[46];
            } else if(i == 29){
                baru[i] = temp[54];
            } else if(i == 30){
                baru[i] = temp[29];
            } else if(i == 31){
                baru[i] = temp[39];
            } else if(i == 32){
                baru[i] = temp[50];
            } else if(i == 33){
                baru[i] = temp[44];
            } else if(i == 34){
                baru[i] = temp[32];
            } else if(i == 35){
                baru[i] = temp[47];
            } else if(i == 36){
                baru[i] = temp[43];
            } else if(i == 37){
                baru[i] = temp[48];
            } else if(i == 38){
                baru[i] = temp[38];
            } else if(i == 39){
                baru[i] = temp[55];
            } else if(i == 40){
                baru[i] = temp[33];
            } else if(i == 41){
                baru[i] = temp[52];
            } else if(i == 42){
                baru[i] = temp[45];
            } else if(i == 43){
                baru[i] = temp[41];
            } else if(i == 44){
                baru[i] = temp[49];
            } else if(i == 45){
                baru[i] = temp[35];
            } else if(i == 46){
                baru[i] = temp[28];
            } else {
                baru[i] = temp[31];
            } 
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
        int j = 28;
        for(int i = 0; i < kanan.length; i++) {
            gabung[j] = kanan[i];
            j++;
        }
        return gabung;
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
        daftarKunci.add(binToHex(pc2(gabungKiriKanan(kiri,kanan))));
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
            daftarKunci.add(binToHex(pc2(gabungKiriKanan(kiri,kanan))));
        }
        return daftarKunci;
    }
         
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        /*System.out.print("Masukkan kunci untuk enkripsi/dekripsi : ");
        String kunci = in.next();
        System.out.print("Masukkan banyak ronde : ");
        int ronde = in.nextInt();
        /*System.out.print("Masukkan kata yang ingin dienkripsi : ");
        String teks = in.next();
        
        char[] ip = initialPermutation(hexToBin(teks));
        System.out.println("Daftar Kunci :");
        System.out.println(bentukSubkey(kunci,ronde));*/
        System.out.println(hexToBin("5998E13A4B26"));        
    }  
}
