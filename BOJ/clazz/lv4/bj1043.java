package BOJ.clazz.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1043
 * name = 거짓말
 * tier = gold 4
 */

public class bj1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] people = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        boolean[] truth = new boolean[n + 1];
        for (int i = 0; i < t; i++) {
            truth[Integer.parseInt(st.nextToken())] = true;
        }

        int[][] parties = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int[] party = new int[p];
            for (int j = 0; j < party.length; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }
            parties[i] = party;
        }


        Solution s = new Solution(n, m, people, truth, parties);
        bw.write(s.run() + "\n");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n; // num of entire people
        private int m; // num of parties
        private int[] people; // group
        private boolean[] truth; // people who know the truth
        private int[][] parties; // array of parties and people who participated in those parties

        public Solution(int n, int m, int[] people, boolean[] truth, int[][] parties) {
            this.n = n;
            this.m = m;
            this.people = people;
            this.truth = truth;
            this.parties = parties;
        }

        public int run() {
            int ans = 0;
            boolean beQuiet = false;

            holdParty();

            for (int[] party : parties) {
                for (int person : party) {
                    if (isAwareTruth(person)) {
                        beQuiet = true;
                        break;
                    }
                }
                if (beQuiet)
                    beQuiet = false;
                else
                    ans++;
            }
            return ans;
        }

        private void holdParty() {
            for (int i = 0; i < people.length; i++)
                people[i] = i;

            for (int[] party : parties) {
                if (party.length < 2) continue;
                for (int i = 0; i < party.length - 1; i++) {
                    union(party[i], party[i + 1]);
                }
            }
        }

        private boolean isAwareTruth(int person) {
            int parent = find(person);
            for (int i = 0; i < truth.length; i++) {
                if (truth[i] && find(i) == parent) {
                    return true;
                }
            }
            return false;
        }

        private void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot < bRoot) people[bRoot] = aRoot;
            else people[aRoot] = bRoot;
        }

        private int find(int x) {
            if (people[x] == x) return x;
            return find(people[x]);
        }

    } // end of class
}
