package ar.com.miura.lc.backtracking

class LetterCasePermutations {
    fun letterCasePermutation(s: String): List<String> {
        var permutations = mutableListOf<String>();
        permute(s, 0, StringBuilder(), permutations);
        return permutations;
    }

    private fun permute(s:String, index:Int, stringBuilder:StringBuilder, permutations:MutableList<String>) {

        if (index>=s.length) {
            permutations.add(stringBuilder.toString());
            return;
        }

        var char = s[index];

        if (char.isLowerCase() || char.isUpperCase()) {
            var lowerCase = StringBuilder(stringBuilder).append(char.toLowerCase());
            var upperCase = StringBuilder(stringBuilder).append(char.toUpperCase());
            permute(s, index+1, lowerCase, permutations);
            permute(s, index+1, upperCase, permutations);

        } else {
            permute(s, index+1, stringBuilder.append(char), permutations);

        }
    }
}