package ar.com.miura.jvm.string;

public class CustomSortString {
    public String customSortString(String S, String T) {

        int[] bucket = new int[26];

        for(char c:T.toCharArray()) {
            bucket[c-'a']++;
        }

        StringBuilder sBuilder = new StringBuilder();

        for(char c:S.toCharArray()) {
            int limit = bucket[c-'a'];
            for(int i=0;i<limit;i++) {
                sBuilder.append(c);
            }
            bucket[c-'a'] = 0;
        }

        for(int i=0;i<26;i++) {
            int limit = bucket[i];
            for(int j=0;j<limit;j++) {
                sBuilder.append((char)(i+'a'));
            }
        }

        return sBuilder.toString();

    }
}
