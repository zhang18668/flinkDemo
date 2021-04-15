package hdpf

import hdpf.bean.Participant
import hdpf.utils.{FlinkUtils, GlobalConfigUtil}
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.api.scala._
import hdpf.sink.MySqlSink
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks
import org.apache.flink.streaming.api.watermark.Watermark
import scala.util.parsing.json.JSON

object App {

  def main(args: Array[String]): Unit = {
    // Flink流式环境的创建
    val env = FlinkUtils.initFlinkEnv()

    // 整合Kafka
    val consumer = FlinkUtils.initKafkaFlink()

    // 测试打印
    val kafkaDataStream: DataStream[String] = env.addSource(consumer)
    val canalDs = kafkaDataStream.map{json => Participant(json)}
    //    canalDs.print()

    val waterDs: DataStream[Participant] = canalDs.assignTimestampsAndWatermarks(new AssignerWithPeriodicWatermarks[Participant] {

      // 当前的时间戳
      var currentTimestamp = 0L

      // 延迟的时间
      val delayTime = 2000l

      // 返回水印时间
      override def getCurrentWatermark: Watermark = {
        new Watermark(currentTimestamp - delayTime)
      }

      // 比较当前元素的时间和上一个元素的时间,取最大值,防止时光倒流
      override def extractTimestamp(element: Participant, previousElementTimestamp: Long): Long = {
        currentTimestamp = Math.max(element.timestamp, previousElementTimestamp)
        currentTimestamp
      }
    })
    waterDs.print()
//    waterDs.map()
    waterDs.addSink(Canal=>new MySqlSink)




    // 执行任务
    env.execute("sync-db")
  }
}
