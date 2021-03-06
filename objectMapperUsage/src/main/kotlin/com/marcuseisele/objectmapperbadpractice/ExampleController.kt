package com.marcuseisele.objectmapperbadpractice

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {

    @PostMapping("/example/{path}/{id}")
    fun getExampleResponse(
        @PathVariable("path") path: String,
        @PathVariable("id") id: Int,
        @RequestBody body: ExampleRequest
    ) = ExampleResponse(path = path, someNumber = id, query = body.number.toString())
}

//data class ExampleRequest(val content: String)
//data class ExampleRequest(val content: String, val number: Int)
data class ExampleRequest(val number: Int)

data class ExampleResponse(val path: String, val someNumber: Int, val query: String)