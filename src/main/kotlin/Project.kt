import software.amazon.awssdk.services.dynamodb.DynamoDbClient

data class TableData(val id: String, val data: String, var expiresAt: String)

const val tableNameVal = "tablename-placeholder"

fun getSpecificItem(id: String): TableData {

    val client = DynamoDbClient.create()

    val result = client.scan {
        it.tableName(tableNameVal)
    }

    val list =  result.items().map {
        TableData(it["id"]!!.s(), it["data"]!!.s(), it["expiresAt"]!!.n())
    }

    return list.first { el -> el.id == id };


}


