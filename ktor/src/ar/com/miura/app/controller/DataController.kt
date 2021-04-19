package ar.com.miura.app.ar.com.miura.app.controller

import ar.com.miura.app.ar.com.miura.app.dto.DataDto
import ar.com.miura.app.ar.com.miura.app.service.DataService

class DataController(val dataService:DataService){
    fun listAll():List<DataDto> {
        return dataService.findAll()
    }
}