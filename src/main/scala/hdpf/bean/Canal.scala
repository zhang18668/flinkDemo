package hdpf.bean

import com.alibaba.fastjson.{JSON, JSONObject}

case class Canal(
                  var emptyCount: Long,
                  var logFileName: String,
                  var dbName: String,
                  var logFileOffset: Long,
                  var eventType: String,
                  var columnValueList: String,
                  var tableName: String,
                  var timestamp: Long
                )

object Canal {
  def apply(json: String): Canal = {
    JSON.parseObject[Canal](json, classOf[Canal])
  }

  def main(args: Array[String]): Unit = {
    val json = "{\"emptyCount\":2,\"logFileName\":\"mysql-bin.000005\",\"dbName\":\"pyg\",\"logFileOffset\":20544,\"eventType\":\"INSERT\",\"columnValueList\":[{\"columnName\":\"commodityId\",\"columnValue\":\"6\",\"isValid\":true},{\"columnName\":\"commodityName\",\"columnValue\":\"欧派\",\"isValid\":true},{\"columnName\":\"commodityTypeId\",\"columnValue\":\"3\",\"isValid\":true},{\"columnName\":\"originalPrice\",\"columnValue\":\"43000.0\",\"isValid\":true},{\"columnName\":\"activityPrice\",\"columnValue\":\"40000.0\",\"isValid\":true}],\"tableName\":\"commodity\",\"timestamp\":1558764495000}"
    val canal = Canal(json)

    println(canal.timestamp)
  }
}