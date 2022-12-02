import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue

class Main {
    fun runLambda() {
        val client = DynamoDbClient.create()
        val keyToGet = mutableMapOf<String, AttributeValue>()
        keyToGet["transactionId"] = AttributeValue.builder().s("uuid").build()

        val result = client.getItem() {
            it.tableName("table-name-placeholder")
            it.key(keyToGet)
        }
        val numbersMap = result.item()
        numbersMap?.forEach { key1 ->
            println(key1.key)
            println(key1.value)
        }
    }

}