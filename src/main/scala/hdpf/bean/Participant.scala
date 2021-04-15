package hdpf.bean


import com.alibaba.fastjson.{JSON, JSONObject}
import java.lang.Boolean

import com.sun.jmx.snmp.Timestamp
import hdpf.bean.{Arctan, Location, Pose}

case class Participant(
                     var `type`: String,
                     var license_plate: String,
                     var id: String,
                     var pose: Pose,
                     var location: Location,
                     var arctan: Arctan,
                     var conf: Double,
                     var speed: Double,
                     var timestamp: Long
                   )

object Participant {
  def apply(json: String): Participant = {
    JSON.parseObject[Participant](json, classOf[Participant])
  }

  def main(args: Array[String]): Unit = {
    val json = "{\"type\":\"mainvehicle\",\"license_plate\":\"\",\"id\":\"0\",\"pose\":{\"length\":5.0,\"width\":2.0,\"height\":1.7999999523162842},\"location\":{\"vehicle_judge\":\"false\",\"longitude\":114.07215337314804,\"latitude\":30.44909577965133,\"altitude\":-2.9815148713389036,\"headroom\":0},\"arctan\":{\"vehicle_judge\":\"false\",\"hdq\":1.33447,\"pitch\":0.0005008336738683283,\"roll\":-0.000014998080587247387},\"conf\":1.0,\"speed\":0.0}"
    val participant = Participant(json)

    println(participant.`type`)
    println(participant.pose)
    println(participant.id)
    println(participant.location.vehicle_judge)
    println(participant.arctan)
  }
}