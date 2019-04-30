package sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class GenericLoadSave {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf()
                .setAppName("GenericLoadSave")
                .setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new SQLContext(sc);

       DataFrame usersDF = sqlContext.read().load("E:\\spark_resource\\users.parquet");

        usersDF.select("name","favorite_color")
                .write()
                .save("E:\\spark_resource\\namesAndFavColors.parquet");

    }
}
