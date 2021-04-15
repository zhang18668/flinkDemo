package hdpf.bean

import com.alibaba.fastjson.{JSON, JSONObject}
import java.lang.Boolean

case class Arctan(
                     var vehicle_judge: String,
                     var hdq: Double,
                     var pitch: Double,
                     var roll: Double
                   )

object Arctan {
  def apply(json: String): Arctan = {
    JSON.parseObject[Arctan](json, classOf[Arctan])
  }

  def main(args: Array[String]): Unit = {
    val json = "{\"vehicle_judge\":\"false\",\"longitude\":114.07176905010752,\"latitude\":30.449450284505255,\"altitude\":-2.1649386732047,\"headroom\":0}"
    val arc = Arctan(json)

    println(Boolean.parseBoolean(arc.vehicle_judge))
  }
}