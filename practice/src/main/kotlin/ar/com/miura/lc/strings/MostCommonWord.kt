package ar.com.miura.lc.strings

class MostCommonWord {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {

        val regex = Regex("[^A-Za-z0-9 ]")

        /*
        Add banned words
        */
        var bannedSet = mutableSetOf<String>();
        for(banWord in banned) {
            bannedSet.add(banWord.toLowerCase());
        }

        var wordQty = mutableMapOf<String,Int>();
        var filteredWord = ""

        var splitted = paragraph.split(" ",",","?","!","'",":",".")
        for(word in splitted) {

            filteredWord = word.toLowerCase();

            filteredWord = regex.replace(filteredWord, "");

            if (filteredWord.isNotBlank() && !bannedSet.contains(filteredWord)) {
                var qty = wordQty.getOrDefault(filteredWord, 0);
                qty++;
                wordQty.put(filteredWord, qty);
            }

        }

        var word = ""
        var max = Int.MIN_VALUE;
        for((key,value) in wordQty) {
            if (value>max) {
                max = value;
                word = key;
            }
        }

        return word;
    }
}