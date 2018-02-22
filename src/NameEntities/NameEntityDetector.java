package NameEntities;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class NameEntityDetector extends Configured implements Tool {

    public int run(String[] args) throws Exception {

        Configuration conf = getConf();
        String model = args[2];
        conf.set("model", model);
        //System.out.println("model = " + conf.get("model"));

        Job job = Job.getInstance(conf, "nameEntities");
        job.setJarByClass(NameEntityDetector.class);
        job.setMapperClass(NameMapper.class);
        job.setCombinerClass(NameReducer.class);
        job.setReducerClass(NameReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(2);

        //FileInputFormat.addInputPath(job, new Path("/home/giulia/IdeaProjects/Hadoop_NE/tweets"));
        //FileOutputFormat.setOutputPath(job, new Path("/home/giulia/IdeaProjects/Hadoop_NE/output"));
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean success = job.waitForCompletion(true);
        return success ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {

        long inizio = System.currentTimeMillis();
        int res = ToolRunner.run(new Configuration(), new NameEntityDetector(), args);
        long fine = System.currentTimeMillis();

        long tempo = fine - inizio;

        System.out.println("\nTempo di esecuzione: " + tempo);

        System.exit(res);




    }


}
