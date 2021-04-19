package ar.com.miura.app.ar.com.miura.app.di

import ar.com.miura.app.ar.com.miura.app.controller.DataController
import ar.com.miura.app.ar.com.miura.app.service.DataService
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object ContextConfig {
    private val module = Kodein.Module("MODULE") {
        bind() from singleton { DataService() }
        bind() from singleton { DataController(instance()) }
    }
    internal val kodein = Kodein {
        import(module)
    }
}