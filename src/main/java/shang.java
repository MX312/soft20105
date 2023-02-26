/**
 * MapReduce实验——排序
 *         要求我们编写mapreduce程序来对商品点击次数有低到高进行排序
 *
 * 去重操作和排序操作的区别：
 *         是否for循环遍历value值
 */


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class shang {
    static String INPUT_PATH="hdfs://192.168.57.128:9000/testhdfs1026/run/input/mapreducetest3.txt";
    static String OUTPUT_PATH="hdfs://192.168.57.128:9000/testhdfs1026/run/output/test3";

    /*
     * Mapper
     * NullWritable是Writable的一个特殊类，序列化的长度为0，实现方法为空实现
     * 如果你不需要使用键或值，你就可以将键或值声明为NullWritable。
     */
    static class MyMapper extends Mapper<Object,Text,IntWritable,Text>
    {

        private static Text goods=new Text();    //value
        private static IntWritable num = new IntWritable();    //key(用于排序)
        public void map(Object key, Text value, Context context) //Context context 记录输入的key和value 
                throws IOException, InterruptedException
        {
            String line = value.toString();
            String arr[] = line.split(" ");
            num.set(Integer.parseInt(arr[1]));
            goods.set(arr[0]);
            context.write(num, goods);
        }
    }

    //Reducer
    static class MyReduce extends Reducer<IntWritable,Text,IntWritable,Text>
    {
        //private static IntWritable result = new IntWritable();
        protected void reduce(IntWritable key,Iterable<Text> values,Context context)
                throws IOException,InterruptedException
        {

            for(Text val:values){
                context.write(key,val);
            }

            /**
             * 此处若执行如下语句，就是去重操作了
             * context.write(key, null);
             * 这就是去重和排序的区别，本实验是for循环遍历了key下的value集合，而去重实验则直接输出
             */


        }
    }



    public static void main(String[] args)
            throws IOException,ClassNotFoundException,InterruptedException{
        //Path inputpath=new Path(INPUT_PATH);
        Path outputpath=new Path(OUTPUT_PATH);
        Configuration conf=new Configuration();
        System.out.println("Start");
        Job job=Job.getInstance(conf);
        job.setJarByClass(shang.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReduce.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPaths(job, INPUT_PATH);
        FileOutputFormat.setOutputPath(job,outputpath);

        boolean flag = job.waitForCompletion(true);
        /*
         * wait for completion 工作等待完成。
         * Job运行是通过job.waitForCompletion(true)，
         * true表示将运行进度等信息及时输出给用户，false的话只是等待作业结束
         */
        System.out.println(flag);
        System.exit(flag? 0 : 1);
    }


}