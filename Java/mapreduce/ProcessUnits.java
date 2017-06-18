package mapreduce;

//$HADOOP_HOME/share/hadoop/common/hadoop-common-2.7.3.jar
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

//$HADOOP_HOME/share/hadoop/common/hadoop-mapreduce-client-core-2.7.3.jar
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class ProcessUnits {

	public static void main(String args[])throws Exception 
	{
		String inputPath = args[1];
		String outputPath = args[2];
		JobConf conf = new JobConf(ProcessUnits.class);
		
		conf.setJobName("max_eletricityunits"); 
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
		conf.setMapperClass(ProcessUnitsMapper.class);
		conf.setCombinerClass(ProcessUnitsReducer.class);
		conf.setReducerClass(ProcessUnitsReducer.class); 

		conf.setInputFormat(TextInputFormat.class); 
		conf.setOutputFormat(TextOutputFormat.class); 

		FileInputFormat.setInputPaths(conf, new Path(inputPath));
		FileOutputFormat.setOutputPath(conf, new Path(outputPath)); 

		JobClient.runJob(conf); 
	} 

}
