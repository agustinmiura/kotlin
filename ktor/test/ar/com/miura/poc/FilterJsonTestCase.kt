package ar.com.miura.app.ar.com.miura.poc

import ar.com.miura.app.ar.com.miura.app.utils.GsonFactory
import ar.com.miura.app.ar.com.miura.app.utils.Utils
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.bohnman.squiggly.Squiggly
import com.google.gson.Gson
import org.junit.jupiter.api.Test


class FilterJsonTestCase {

    @Test
    fun `listAll`() {

        val filter = "*"

        val content = Utils.readPath(Utils.getPath("object.json"))
        val gson = Gson()
        val model = gson.fromJson(content, Map::class.java)

        val objectMapper: ObjectMapper = Squiggly.init(ObjectMapper(), filter)
        objectMapper.writeValue(System.out, model)
        assert(true)

    }

    @Test
    fun `listNone`() {

        val filter = ""

        val content = Utils.readPath(Utils.getPath("object.json"))
        val gson = GsonFactory.get()
        val model = gson.fromJson(content, Map::class.java)

        val objectMapper: ObjectMapper = Squiggly.init(ObjectMapper(), filter)
        objectMapper.writeValue(System.out, model)
        assert(true)
    }

    @Test
    fun `listAttributes`() {

        val filter = "id,issueSummary,description"

        val content = Utils.readPath(Utils.getPath("array.json"))
        val gson = GsonFactory.get()
        val model = gson.fromJson(content, Array::class.java)

        val objectMapper: ObjectMapper = Squiggly.init(ObjectMapper(), filter)
        objectMapper.writeValue(System.out, model)
        assert(true)
    }

    @Test
    fun `listAttributes2`() {

        val filter = "id,issueSummary,description"

        val content = Utils.readPath(Utils.getPath("array.json"))
        val mapper = ObjectMapper()
        val model = mapper.readValue(content, Array::class.java)

        val objectMapper: ObjectMapper = Squiggly.init(ObjectMapper(), filter)
        objectMapper.writeValue(System.out, model)
        assert(true)
    }

    @Test
    fun `choosePath`() {

        val filter = "subObject[name,description]"

        /*
        val content = Utils.readPath(Utils.getPath("array.json"))
        val gson = GsonFactory.get()
        val model = gson.fromJson(content, Array::class.java)
        */
        val content = Utils.readPath(Utils.getPath("array.json"))
        val mapper = ObjectMapper()
        val model = mapper.readValue(content, Array::class.java)

        val objectMapper: ObjectMapper = Squiggly.init(ObjectMapper(), filter)
        objectMapper.writeValue(System.out, model)
        assert(true)
    }

    @Test
    fun `filterObject`() {

        //val filter = "assignee[firstName]"
        val filter = "actions[text,type]"
        /*
        val content = Utils.readPath(Utils.getPath("array.json"))
        val gson = GsonFactory.get()
        val model = gson.fromJson(content, Array::class.java)
        */
        val content = Utils.readPath(Utils.getPath("object.json"))
        val mapper = ObjectMapper()
        val model = mapper.readValue(content, Object::class.java)

        val objectMapper: ObjectMapper = Squiggly.init(ObjectMapper(), filter)
        objectMapper.writeValue(System.out, model)
        assert(true)
    }

}