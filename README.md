����main
��  ����java
��  ����resources
��  ��      application.conf   --�����ļ�
��  ��      data.txt
��  ��      hbase-site.xml
��  ��      log4j.properties  --��־�����ļ�
��  ��      suiji.txt  --�����ͨ�����ļ�10��
��  ��      
��  ����scala
��      ����hdpf
��          ��  App.scala  --���������
��          ��  
��          ����batch
��          ��      BatchFromFile.scala   --���������ļ�����
��          ��      
��          ����bean
��          ��      Arctan.scala     	 --Arctan����
��          ��      Canal.scala
��          ��      Device.scala    		  --Device����
��          ��      Location.scala			--Location����
��          ��      Message.scala			--Message����
��          ��      Participant.scala     -- Participant����
��          ��      Payload.scala        ---Payload����
��          ��      Pose.scala     --Pose����
��          ��      
��          ����demo
��          ��      TimeSlidingWindow.scala
��          ��      Trans_KeyBy.scala
��          ��      WindowApply.scala
��          ��      
��          ����sink
��          ��      BatchSinkCollection.scala
��          ��      BatchSinkFile.scala
��          ��      Sink_MySql.scala
��          ��      
��          ����source
��          ����utils
��                  FlinkUtils.scala
��                  GlobalConfigUtil.scala
��                  
����test
    ����java
    ����scala