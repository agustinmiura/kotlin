package ar.com.miura.app.ar.com.miura.app.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type


class GsonFactory {
    companion object {
        fun get(): Gson {
            return GsonBuilder().registerTypeAdapter(Double::class.java, object : JsonSerializer<Double?> {
                override fun serialize(
                    src: Double?,
                    typeOfSrc: Type?,
                    context: JsonSerializationContext?
                ): JsonElement {
                    if (src == src?.toLong()?.toDouble()) {
                        return JsonPrimitive(src?.toLong())
                    } else if (src == src?.toLong()?.toDouble()) {
                        return JsonPrimitive(src?.toInt())
                    } else {
                        return JsonPrimitive(src)
                    }
                    TODO("Not yet implemented")
                }
            }).create()
        }
    }
}