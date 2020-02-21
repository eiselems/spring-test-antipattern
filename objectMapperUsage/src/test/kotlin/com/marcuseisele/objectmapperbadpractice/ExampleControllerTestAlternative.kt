package com.marcuseisele.objectmapperbadpractice

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(ExampleController::class)
@AutoConfigureMockMvc
internal class ExampleControllerTestAlternative {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun getExampleResponse_givenValidRequest_shouldReturnMappedObject() {
        val path = "MYPATH"
        val id = 1337
        val bodyNumber = 123

        val payload = """{"number": $bodyNumber}"""

        mockMvc
            .perform(
                MockMvcRequestBuilders.post("/example/$path/$id")
                    .content(payload)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.path").value(path))
            .andExpect(MockMvcResultMatchers.jsonPath("$.someNumber").value(id))
            .andExpect(MockMvcResultMatchers.jsonPath("$.query").value(bodyNumber.toString()))

    }
}