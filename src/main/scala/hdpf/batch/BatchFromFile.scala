package hdpf.batch

import hdpf.bean.{Device, Message, Participant, Payload}
import org.apache.flink.api.common.functions.MapFunction
import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}
import org.apache.flink.api.scala._
import scala.collection.mutable.Set

object BatchFromFile {

  def main(args: Array[String]): Unit = {

    // 创建env
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    // 加载文件
    val textDataSet: DataSet[String] = env.readTextFile("D:\\flink\\flinkDemo\\src\\main\\resources\\suiji.txt")

    //算法
    case class Point(var x: Double, var y: Double) {
      def getPoint = Point.apply(x, y)
    }
    /**
      * 判断点是否在多边形内部
      */
    def isInPloyin(p: Point, pts: List[Point]) = {
      var intersectionp = 0
      for (i <- pts.indices) {

        val p1 = pts(i)
        val p2 = pts((i + 1) % pts.size)

        if (p.y >= Array(p1.y, p2.y).min && p.y < Array(p1.y, p2.y).max)
          if (((p.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x) < p.x)
            intersectionp += 1
      }
      intersectionp % 2
    }

    // 打印
    val mesSet = textDataSet.map {
      tex =>
        val list = List(Point(114.0717, 30.44909), Point(114.0717, 30.44910), Point(114.0722, 30.44909), Point(114.0722, 30.44910))

        var message: Message = Message(tex)
        var payload: Payload = Payload(message.payload)
        var devices: Array[Device] = payload.device_data
        var set = scala.collection.mutable.Set[String]()

        for (dev <- devices) {
          var objects: Array[Participant] = dev.`object`
          for (obj <- objects) {
            //            println(obj)
            //            println("speed:"+obj.speed)

            //            println("latitude:"+obj.location.latitude)
            var p = Point(obj.location.longitude, obj.location.latitude)
            val i = isInPloyin(p, list)
            println("longitude:" + obj.location.longitude + "latitude:" + obj.location.latitude + "在不在:====" + i)
            println(i)
            if (i==1) set += obj.id
          }
          set
       }
    }
//    println("set"+set.toArray.length)
    //    mesSet.map(_ =>_.device_data)
    mesSet.collect()


  }
}




