/*
 ID: Qi Sipu
 PROB: namenum
 LANG: JAVA
 */
//package namenum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class namenum {

    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        BufferedReader br1 = new BufferedReader(new FileReader("dict.txt"));

        int[] arr = new int[20];
        boolean found = false;
        char[][] charArr = {{}, {}, {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'},
        {'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y'}};

        String str = br.readLine();
        int length = str.length();
        int correctLength = 0;
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(Character.toString(str.charAt(i)));
        }

        str = br1.readLine();
        int pos = 0;
        while (str != null) { //read all words in the file
            pos = 0;
            //check if the length is correct
            if (str.length() == length) {
                while (pos < length) {
                    //check each character in this word
                    char ch = str.charAt(pos); //letter in the word
                    if (ch == charArr[arr[pos]][0] || ch == charArr[arr[pos]][1] || ch == charArr[arr[pos]][2]) {
                        pos++; //this position has match
                    }else break;
                    if (pos == length) {
                        found = true;
                        out.println(str);
                    } //find a match
                }
            }
           // if (found) break;
            str = br1.readLine();
        }

        if (!found) {
            out.println("NONE");
        }

        out.close();
        System.exit(0);
    }

}
