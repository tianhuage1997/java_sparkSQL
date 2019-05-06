package s77;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;


public class ParquetLoadData {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf()
                .setAppName("ParquetLoadData")
                .setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext  = new SQLContext(sc);

        // 读取Parquet文件中的数据，创建一个DataFrame
        DataFrame df = sqlContext.read().parquet("E:\\spark_resource\\users.parquet");
        // 将DataFrame注册为临时表，然后使用SQL查询需要的数据
        df.registerTempTable("users");
        DataFrame userNamesDF = sqlContext.sql("select name from users");

        // 对查询出来的DataFrame进行transformation操作，处理数据，然后打印出来
        List<String> userNames = userNamesDF.javaRDD().map(new Function<Row, String>() {

            private static final long serialVersionUID = 1L;

            @Override
            public String call(Row row) throws Exception {
                return "Name:"+row.getString(0);
            }
        }).collect();

        for(String userName : userNames){
            System.out.println(userName);
        }
    }
}
