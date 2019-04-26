package sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class DataFrameOperation {

    public static void main(String[] args) {
        //创建DataFrame
        SparkConf conf = new SparkConf().setAppName("DataFrameOperation").setMaster("local");

        JavaSparkContext sc  = new JavaSparkContext(conf);

        SQLContext sqlContext = new SQLContext(sc);
        //创建出来的dataframe完全可以理解成为一张表
        DataFrame dataFrame =sqlContext.read().json("E:\\spark_resource\\students.json");
        // 打印DataFrame中所有的数据（select * from ...）
        dataFrame.show();

        // 打印DataFrame的元数据（Schema）
        dataFrame.printSchema();//(nullable = true)就是可为空的意思
        // 查询某列所有的数据
        dataFrame.select("name").show();
        // 查询某几列所有的数据，并对列进行计算
        dataFrame.select(dataFrame.col("name") , dataFrame.col("age").plus(50)).show();
        // 根据某一列的值进行过滤
        dataFrame.filter(dataFrame.col("name").gt("leo")).show();
        // 根据某一列进行分组，然后进行聚合
        dataFrame.groupBy(dataFrame.col("age")).count().show();

    }
}
