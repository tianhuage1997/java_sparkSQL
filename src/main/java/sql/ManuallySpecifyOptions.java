package sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class ManuallySpecifyOptions {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("ManuallySpecifyOptions")
                .setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new SQLContext(sc);

        DataFrame peopleDF = sqlContext.read()
                .format("json")
                .load("E:\\spark_resource\\people.json");
        peopleDF.select("name").write().format("parquet")
                .save("E:\\spark_resource\\people_json");


    }
}
