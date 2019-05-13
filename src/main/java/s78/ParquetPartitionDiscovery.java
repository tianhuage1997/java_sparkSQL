package s78;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class ParquetPartitionDiscovery {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf()
                .setAppName("ParquetPartitionDiscovery")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new SQLContext(sc);

        DataFrame usersDF = sqlContext.read().parquet("E:\\spark_resource\\users.parquet");

        usersDF.printSchema();
        usersDF.show();




    }


}
