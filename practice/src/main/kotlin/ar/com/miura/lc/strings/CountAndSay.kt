package ar.com.miura.lc.strings

class CountAndSay {
    fun countAndSay(n: Int): String {
        return subCountAndSay(n)
    }

    private fun subCountAndSay(n: Int): String {
        var encoded = "1"
        for (index in 1..n) {

            if (index == 1) {
                encoded = "1"

            } else if (index == 2) {
                encoded = "11"

            } else {
                encoded = encode(encoded)

                println("index ${index} : encoded : ${encoded}")

            }
        }
        return encoded
    }

    private fun encode(string: String): String {

        var char: Char = string.get(0)
        var index = 1
        var count = 1

        var sBuffer = StringBuffer()
        val size = string.length
        while (index < size) {

            if (string.get(index - 1) == string.get(index)) {
                count++
            } else {

                sBuffer.append(count.toString())
                sBuffer.append(char)

                char = string.get(index)
                count = 1

            }


            index++
        }

        sBuffer.append(count)
        sBuffer.append(char)

        return sBuffer.toString()
    }

}