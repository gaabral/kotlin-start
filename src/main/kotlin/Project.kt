import software.amazon.awssdk.services.dynamodb.DynamoDbClient

data class TableData(val id: String, val data: String, var expiresAt: String)

const val tableNameVal = "tablename-placeholder"

fun getSpecificItem(transactionId: String): List<TableData> {

    val client = DynamoDbClient.create()

    val result = client.scan {
        it.tableName(tableNameVal)
    }

    return result.items().map {
        TableData(it["id"]!!.s(), it["data"]!!.s(), it["expiresAt"]!!.n())
    }


}


