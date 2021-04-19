package ar.com.miura.app.ar.com.miura.app.service

import ar.com.miura.app.ar.com.miura.app.dto.DataDto

class DataService {
    fun findAll():List<DataDto>{
        return getAll()
    }

    private fun getAll():List<DataDto> {
        var i = 0
        val list = mutableListOf<DataDto>()
        while(i<=10) {

            val map = mutableMapOf<Any, Any>(
                "name" to "subName" + i,
                "description" to "subDescription" + i,
                "id" to i,
                "subAttribute" to "subValue",
                "subInt" to 10
            )

            list.add(DataDto(
                i.toLong(),
                "name " + i,
                "description : " + i,
                map
            ))
            i++
        }
        return list
    }
}