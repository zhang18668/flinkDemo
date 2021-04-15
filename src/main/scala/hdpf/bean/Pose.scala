package hdpf.bean

import com.alibaba.fastjson.{JSON, JSONObject}

case class Pose(
                  var length: Double,
                  var width: Double,
                  var height: Double
                )

object Pose {
  def apply(json: String): Pose = {
    JSON.parseObject[Pose](json, classOf[Pose])
  }

  def main(args: Array[String]): Unit = {
    val json = "{\"length\":4.3034539222717289,\"width\":2.033831834793091,\"height\":1.4431898593902588}"
    val pose = Pose(json)

    println(pose.length)
  }
}