package sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class DataFrameCreate {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("DataFrameCreate").setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        SQLContext sqlContext = new SQLContext(sc);

        DataFrame dataFrame =sqlContext.read().json("E:\\spark_resource\\students.json");

        dataFrame.show();



    }

}
