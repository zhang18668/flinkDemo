package hdpf.batch

import hdpf.bean.{Device, Message, Participant, Payload}
import org.apache.flink.api.common.functions.MapFunction
import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}
import org.apache.flink.api.scala._

object BatchFromFile {

  def main(args: Array[String]): Unit = {

    // 创建env
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    // 加载文件
    val textDataSet: DataSet[String] = env.readTextFile("D:\\flink\\flinkDemo\\src\\main\\resources\\suiji.txt")

    // 打印
    val mesSet = textDataSet.map {
      tex =>
        var message: Message = Message(tex)
        var payload: Payload = Payload(message.payload)
        var devices: Array[Device] = payload.device_data
        for (dev <- devices) {
          var objects: Array[Participant] = dev.`object`
          for (obj<- objects){
            println(obj)
            obj.speed
          }
        }
    }
    //    mesSet.map(_ =>_.device_data)
        mesSet.print()

  }
}
