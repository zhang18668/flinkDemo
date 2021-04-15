package hdpf.bean

import com.alibaba.fastjson.{JSON, JSONObject}
import java.lang.Boolean

case class Location(
                 var vehicle_judge: String,
                 var longitude: Double,
                 var latitude: Double,
                 var altitude: Double,
                 var headroom: Int
               )

object Location {
  def apply(json: String): Location = {
    JSON.parseObject[Location](json, classOf[Location])
  }

  def main(args: Array[String]): Unit = {
    val json = "{\"vehicle_judge\":\"false\",\"longitude\":114.07174935388105,\"latitude\":30.449874911928906,\"altitude\":-0.7003295662911274,\"headroom\":0}"
    val loca = Location(json)

    println(Boolean.parseBoolean(loca.vehicle_judge))
  }
}

