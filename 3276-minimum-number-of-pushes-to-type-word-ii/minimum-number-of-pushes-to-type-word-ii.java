class Solution {
        /*
        #########################################################################
        #                                                                       #
        #  =============================================                        #
        #                  SIDDARDHA CHILUVERU                                  #
        #  =============================================                        #
        #                                                                       #
        #  Author      : Siddardha Chiluveru                                    #
        #  Description : Solution / Code / Project                              #
        #  Date        : 2026-07-31                                             #
        #                                                                       #
        #########################################################################
        */
    public int minimumPushes(String s) {
        int[] freq = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }
        int ans = 0;
        int cnt = 0;
        int press = 1;
        Arrays.sort(freq);
        for (int i = 25; i >= 0; i--) {
            if (freq[i] > 0) {
                ans = ans + (freq[i] * press);
                cnt += 1;
                if (cnt == 8) {
                    cnt = 0;
                    press += 1;
                }
            }
        }
        return ans;
    }
}