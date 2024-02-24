package com.example.models

import com.example.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.lang.NumberFormatException

fun Route.getAllHeroes() {

    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val apiReponse = heroRepository.getAllHeroes(page = page)

            call.respond(
                message = apiReponse,
                status = HttpStatusCode.OK
            )

        }catch (e: NumberFormatException){
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Invalid page number",
                ),
                status = HttpStatusCode.BadRequest)
        }catch (e: IllegalArgumentException){
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Heroes not found",
                ),
                status = HttpStatusCode.BadRequest)
        }

    }
}