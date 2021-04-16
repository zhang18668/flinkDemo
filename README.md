├─main
│  ├─java
│  ├─resources
│  │      application.conf   --配置文件
│  │      data.txt
│  │      hbase-site.xml
│  │      log4j.properties  --日志配置文件
│  │      suiji.txt  --随机交通数据文件10条
│  │      
│  └─scala
│      └─hdpf
│          │  App.scala  --主程序入口
│          │  
│          ├─batch
│          │      BatchFromFile.scala   --批处理本地文件数据
│          │      
│          ├─bean
│          │      Arctan.scala     	 --Arctan对象
│          │      Canal.scala
│          │      Device.scala    		  --Device对象
│          │      Location.scala			--Location对象
│          │      Message.scala			--Message对象
│          │      Participant.scala     -- Participant对象
│          │      Payload.scala        ---Payload对象
│          │      Pose.scala     --Pose对象
│          │      
│          ├─demo
│          │      TimeSlidingWindow.scala
│          │      Trans_KeyBy.scala
│          │      WindowApply.scala
│          │      
│          ├─sink
│          │      BatchSinkCollection.scala
│          │      BatchSinkFile.scala
│          │      Sink_MySql.scala
│          │      
│          ├─source
│          └─utils
│                  FlinkUtils.scala
│                  GlobalConfigUtil.scala
│                  
└─test
    ├─java
    └─scala