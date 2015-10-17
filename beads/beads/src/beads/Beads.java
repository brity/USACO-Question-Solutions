/*
 ID: Qi Sipu
 PROB: beads
 LANG: JAVA
 */
//package beads;

import java.io.*;

class beads {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int l = str.length();
        str = str + str;

        String str1 = new StringBuffer(str).reverse().toString();

        int[] a = new int[350];
        int[] b = new int[350];

        char ch, ch1;
        int ans = 0;

        boolean f;
        for (int i = 0; i < n; i++) {
            f = true;
            int q = i;
            ch = str.charAt(i);
            ans = 0;

            if (ch != 'w') {
                for (int j = i; j < 2 * n - 1; j++) {
                    ch1 = str.charAt(j);
                    if ((ch1 == ch) || (ch1 == 'w')) {
                        ans++;
                    } else {
                        break;
                    }

                }
            } else {

                while (str.charAt(q) == 'w') {
                    ans++;
                    q++;
                    if (q == n) {
                        f = false;
                        break;
                    }
                }
                if (f) {

                    ch = str.charAt(q);
                    for (int j = q; j < 2 * n - 1; j++) {
                        ch1 = str.charAt(j);
                        if ((ch1 == ch) || (ch1 == 'w')) {
                            ans++;
                        } else {
                            break;
                        }

                    }
                }

            }

            a[i] = ans;
            if (a[i] > n) {
                a[i] = n;
            }

        }

        for (int i = 0; i < n; i++) {
            f = true;
            int q = i;
            ch = str1.charAt(i);
            ans = 0;

            if (ch != 'w') {
                for (int j = i; j < 2 * n - 1; j++) {
                    ch1 = str1.charAt(j);
                    if ((ch1 == ch) || (ch1 == 'w')) {
                        ans++;
                    } else {
                        break;
                    }

                }
            } else {

                while (str1.charAt(q) == 'w') {
                    ans++;
                    q++;
                    if (q == n) {
                        f = false;
                        break;
                    }
                }
                if  (f){
                    ch = str1.charAt(q);
                    for (int j = q; j < 2 * n - 1; j++) {
                        ch1 = str1.charAt(j);
                        if ((ch1 == ch) || (ch1 == 'w')) {
                            ans++;
                        } else {
                            break;
                        }

                    }
                }

            }

            b[i] = ans;
            if (b[i] > n) {
                b[i] = n;
            }

        }

        ans = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] + b[n - i] > ans) {
                ans = a[i] + b[n - i];
            }
        }

        if (ans > l) {
            ans = l;
        }
        out.println(ans);
        //System.out.println(ans);
        out.close();
        System.exit(0);
    }
}
