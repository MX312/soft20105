
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class map extends Mapper<LongWritable, Text, Text, LongWritable>{//框架传过来是什么、写回去的是什么类型

    public static void main(String[] args) {

    }
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString().toLowerCase(); //得到了每一行的数据
        String[] words = line.split("[\\s\\d\\pP]+");
        for (String word: words) {
            context.write(new Text(word), new LongWritable(1));
        }
    }
}
