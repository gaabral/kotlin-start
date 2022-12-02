import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class Main {
    fun runLambda() {
            val data = getSpecificItem("uuid")
            val mapper = jacksonObjectMapper()
            val jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data)

            println(jsonStr)
        }

}