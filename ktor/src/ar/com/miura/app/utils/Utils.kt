package ar.com.miura.app.ar.com.miura.app.utils

import java.io.File

class Utils {
    companion object {
        fun readPath(path:String): String {
            return File(path).readText(Charsets.UTF_8)
        }
        fun readWithoutWhiteSpace(path:String):String {
            return File(path).readText(Charsets.UTF_8)
                .replace("\\s","")
                .replace("\n", "")
                .trim()
        }
        fun normalizeString(value:String):String {
            return value.replace("\\s","")
                .replace("\n", "")
                .replace(" ", "")
                .trim()
        }
        fun getPath(name:String):String {
            return File("resources/json/" + name).absolutePath
        }

    }
}
