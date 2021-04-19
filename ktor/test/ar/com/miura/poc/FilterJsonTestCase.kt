package ar.com.miura.app.ar.com.miura.poc

import ar.com.miura.app.ar.com.miura.app.utils.Utils
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.bohnman.squiggly.Squiggly
import com.github.bohnman.squiggly.util.SquigglyUtils
import com.google.gson.Gson
import org.junit.jupiter.api.Test


class FilterJsonTestCase {

    @Test
    fun `shouldFilterJson`() {
        val content = Utils.readPath(Utils.getPath("object.json"))
        val objectMapper = Squiggly.init(ObjectMapper(), "id")
        var result = SquigglyUtils.stringify(objectMapper, content)
        println(" Result is : ${result} ")
        result = Utils.normalizeString(result)
        assert(true)
    }

    @Test
    fun `shouldListNoFields`() {
        val content = Utils.readPath(Utils.getPath("object.json"))
        val objectMapper = Squiggly.init(ObjectMapper(), "")
        val gson = Gson()
        objectMapper.writeValue(System.out, Map::class.java)
    }

    @Test
    fun `listAll`() {

        val filter = "*"

        val content = Utils.readPath(Utils.getPath("object.json"))
        val gson = Gson()
        val model = gson.fromJson(content, Map::class.java)

        val objectMapper: ObjectMapper = Squiggly.init(ObjectMapper(), filter)
        objectMapper.writeValue(System.out, model)

    }

    @Test
    fun `listNone`() {

        val filter = ""

        val content = Utils.readPath(Utils.getPath("object.json"))
        val gson = Gson()
        val model = gson.fromJson(content, Map::class.java)

        val objectMapper: ObjectMapper = Squiggly.init(ObjectMapper(), filter)
        objectMapper.writeValue(System.out, model)

    }

}