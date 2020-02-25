package src.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class ProcessUnitsMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter myreporter)
			throws IOException {
		// TODO Auto-generated method stub
		
		String line = value.toString();
		StringTokenizer myStringTokenizer = new StringTokenizer(line,"\t");
		String year = myStringTokenizer.nextToken();
		
		int tempPrice = 0, maxPrice = 0;
		
		while (myStringTokenizer.hasMoreTokens()) {
			tempPrice = Integer.parseInt(myStringTokenizer.nextToken());
			if (tempPrice > maxPrice)
				maxPrice = tempPrice;
		}
		
		output.collect(new Text(year), new IntWritable(maxPrice));
		
	}
	
}
