package mapreduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class ProcessUnitsReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{

	public void reduce(Text key, Iterator<IntWritable> value,
			OutputCollector<Text, IntWritable> output, Reporter myReporter)
			throws IOException {
		// TODO Auto-generated method stub
		
		int maxPriceAvg = 20;
		int val = Integer.MIN_VALUE;
		
		while (value.hasNext()) {
			//if ((val = value.next().get()) > maxPriceAvg)
			//	maxPriceAvg = val;
			System.out.println(val = value.next().get());
			output.collect(key, new IntWritable(val));
		}
		
	}
}
