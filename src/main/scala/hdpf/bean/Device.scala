package hdpf.bean


import com.alibaba.fastjson.{JSON, JSONObject}
import java.lang.Boolean

import scala.beans.BeanProperty

case class Device(
                   @BeanProperty var device_name: String,
                   @BeanProperty var object_num: Int,
                   @BeanProperty var `object`: Array[Participant]
                 )

object Device {
  def apply(json: String): Device = {
    JSON.parseObject[Device](json, classOf[Device])
  }

  def main(args: Array[String]): Unit = {
    val json = "{\"device_name\":\"0\",\"object_num\":0,\"object\":[{\"type\":\"main vehicle\",\"license_plate\":\"\",\"id\":\"0\",\"pose\":{\"length\":5.0,\"width\":2.0,\"height\":1.7999999523162842},\"location\":{\"vehicle_judge\":\"false\",\"longitude\":114.07215337314804,\"latitude\":30.44909577965133,\"altitude\":-2.9815148713389036,\"headroom\":0},\"arctan\":{\"vehicle_judge\":\"false\",\"hdq\":1.33447,\"pitch\":0.0005008336738683283,\"roll\":-0.000014998080587247387},\"conf\":1.0,\"speed\":0.0},{\"type\":\"truck\",\"license_plate\":\"\",\"id\":\"16392942\",\"pose\":{\"length\":16.473846435546876,\"width\":2.8721814155578615,\"height\":4.040584564208984},\"location\":{\"vehicle_judge\":\"false\",\"longitude\":114.07171852181846,\"latitude\":30.449609715811499,\"altitude\":-0.7881243844483282,\"headroom\":0},\"arctan\":{\"vehicle_judge\":\"false\",\"hdq\":3.05215,\"pitch\":0.0,\"roll\":0.0},\"conf\":1.0,\"speed\":10.262903133924713},{\"type\":\"car\",\"license_plate\":\"\",\"id\":\"7490277\",\"pose\":{\"length\":4.3034539222717289,\"width\":2.033831834793091,\"height\":1.4431898593902588},\"location\":{\"vehicle_judge\":\"false\",\"longitude\":114.07180924900142,\"latitude\":30.449406824796385,\"altitude\":-2.1547004530952229,\"headroom\":0},\"arctan\":{\"vehicle_judge\":\"false\",\"hdq\":3.05952,\"pitch\":0.0,\"roll\":0.0},\"conf\":1.0,\"speed\":3.483573789221393},{\"type\":\"car\",\"license_plate\":\"\",\"id\":\"3968596\",\"pose\":{\"length\":4.353801727294922,\"width\":2.0840282440185549,\"height\":1.39336359500885},\"location\":{\"vehicle_judge\":\"false\",\"longitude\":114.0717689172086,\"latitude\":30.44945207711771,\"altitude\":-2.1643439650399864,\"headroom\":0},\"arctan\":{\"vehicle_judge\":\"false\",\"hdq\":3.07921,\"pitch\":0.0,\"roll\":0.0},\"conf\":1.0,\"speed\":6.049478145039341}]}"
    val device = Device(json)


    println(device.`object`(0))
  }
}

