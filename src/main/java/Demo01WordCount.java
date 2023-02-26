package com.beicai.mr1710A.day01;

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

public class Demo01WordCount {

    // mapper的实现类
    //创建MyMapper继承Mapper父类重写里面的map方法，mapper后面的类型K1和V1是map的输入，K2和V2是map的输出
    public static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            //key 偏移量
            //value 一行数据

            //map 每次只处理一行数据
            String lines = value.toString();
            String[] splited = lines.split(" ");



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
    //创建MyReducer继承Reducer父类，重写里面的reduce方法，Reducer后面的类型是K1和V1是Reducer的输入(也是map的K2和V2)，K2和V2是Reducer输出
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
    //可以理解为程序的入口，从驱动类开始从上到下读取（运行）
    public static void main(String[] args) throws Exception {
        //获取配置对象
        //是为了与虚拟机建立一个连接
        Configuration conf = new Configuration();
//		conf.set("", "");

        //获取job对象
        //获取我们主类的名称，当程序能够找到相应的类
        Job job = Job.getInstance(conf, "Demo01WordCount");
        //设置运行jar的类
        //找到主类并且运行
        job.setJarByClass(Demo01WordCount.class);
        //设置mapper类
        //找到MyMapper的类，因为要运行map所以必须要先找到他的类
        job.setMapperClass(MyMapper.class);
        //找到MyMapper的类之后，找到k2也就是map的输出，为什么：因为我没有办法决定文件的类型，但是我可以决定他输出的类型
        job.setMapOutputKeyClass(Text.class);
        ////找到MyMapper的类之后，找到v2也就是map的输出，为什么：因为我没有办法决定文件的类型，但是我可以决定他输出的类型
        job.setMapOutputValueClass(IntWritable.class);
        //设置reducer类
        //找到MyReducer的类，因为要运行reduce所以必须要先找到他的类、

        /**
         问：为什么map端的输出类型是setMapOutputKeyClass，而reduce端的输出类型是setOutputKeyClass
         */
        job.setReducerClass(MyReducer.class);
        //找到MyReducer的类之后，找到k2也就是reduce的输出
        job.setOutputKeyClass(Text.class);
        //找到MyReducer的类之后，找到k2也就是reduce的输出
        job.setOutputValueClass(Text.class);

        //输入 输出
        //输入文件的位置
        FileInputFormat.addInputPath(job, new Path(args[0]));
        //输出文件的位置（也就是执行完成的文件）
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        //判断是否完成任务
        int status = job.waitForCompletion(true)?0:-1;
        System.exit(status);
    }
}
