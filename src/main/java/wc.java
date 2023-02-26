import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class wc extends ToolRunner implements Tool{

    // mapper的实现类
    public static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            //key 偏移量
            //value 一行数据

            //map 每次只处理一行数据
            String lines = value.toString();
            String[] splited = lines.split("，");

            for (String word : splited) {

                //context 是上下文对象

                //作为输出  (word,1)
                context.write(new Text(word), new IntWritable(1));

				IntWritable a = new IntWritable();
				a.set(1); //赋值
				context.write(new Text(word), a);

            }
        }
    }

    //reducer实现了
    public static class MyReducer extends Reducer<Text, IntWritable, Text, Text>{
        @Override
        protected void reduce(Text key, Iterable<IntWritable> value,Context context) throws IOException, InterruptedException {
            //key  : 标识符    代表每一个单词
            //value: list（1,1,1,1,1）

            //定义初始值
            int sum = 0;

            for (IntWritable  v : value) {
                //遍历value 取值  做累加
                sum += v.get();
            }
            // 输出每个单词  出现的次数
            context.write(key, new Text(sum+""));
        }
    }

    //驱动类
    public static void main(String[] args) throws Exception {
        //获取配置对象
        Configuration conf = new Configuration();
        int status = ToolRunner.run(conf, new wc(), args);
        System.exit(status);
    }

    @Override
    public void setConf(Configuration conf) {

    }

    @Override
    public Configuration getConf() {
        return new Configuration();
    }

    @Override
    public int run(String[] args) throws Exception {

        Configuration conf = getConf();

        //获取job对象
        Job job = Job.getInstance(conf, "Demo01WordCount");
        //设置运行jar的类
        job.setJarByClass(wc.class);
        //设置mapper类
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //设置reducer类
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //输入 输出
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        int status = job.waitForCompletion(true)?0:-1;
        return status;
    }

}
