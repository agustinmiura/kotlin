package ar.com.miura.app

import ar.com.miura.app.ar.com.miura.app.controller.DataController
import ar.com.miura.app.ar.com.miura.app.di.ContextConfig
import ar.com.miura.app.ar.com.miura.app.routes.dataRoutes
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.request.path
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import org.kodein.di.generic.instance
import org.slf4j.event.Level

fun main(args: Array<String>): Unit = io.ktor.server.tomcat.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        gson {
        }
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    val dataController by ContextConfig.kodein.instance<DataController>()
    install(Routing) {
        dataRoutes(dataController)
    }

}

