package ar.com.miura.app.ar.com.miura.app.routes

import ar.com.miura.app.ar.com.miura.app.controller.DataController
import com.google.gson.Gson
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.dataRoutes(dataController: DataController) {
    route("/data") {
        get {
            val list = dataController.listAll()
            call.respondText(Gson().toJson(list), status = HttpStatusCode.OK)
        }
    }
}