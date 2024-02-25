package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound){
            call.respond(
                message = "The page you are looking for is not found",
                status = HttpStatusCode.NotFound
            )
        }
    }
}