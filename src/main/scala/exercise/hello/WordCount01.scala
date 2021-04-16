package exercise.hello

import org.apache.flink.api.scala._

object WordCount01 {
  def main(args: Array[String]): Unit = {
    val environment = ExecutionEnvironment.getExecutionEnvironment
    var lines = environment.fromElements("itcast hadoop spark", "itcast hadoop spark", "itcast hadoop", "itcast")
    var line1 = lines.flatMap { line => line.split(" ")}
    val word = line1.map { x => (x, 1) }
    val wordGroup = word.groupBy(0)
    val wordCount=wordGroup.sum(1)
    wordCount.print()

  }
}
