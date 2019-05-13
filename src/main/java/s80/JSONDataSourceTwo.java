package s80;
/**
 * 从文件中读取json串数据，然后找出成绩大于80分的学生，保存成json串save_json。
 *
 * 然后构建一个原始的json串数据。追加到json串save_json里面。期间要增加列
 */

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import java.util.ArrayList;
import java.util.List;

public class JSONDataSourceTwo {

    public static void main(String[] args) {

        SparkConf  conf = new SparkConf()
                              .setAppName("JSONDataSourceTwo")
                             .setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new SQLContext(sc);

        // 针对json文件，创建DataFrame（针对json文件创建DataFrame）
        DataFrame studentsDF =sqlContext.read().json("E:\\spark_resource\\student_score.json");

        // （注册临时表，针对临时表执行sql语句）
        studentsDF.registerTempTable("students");
        // 针对学生成绩信息的DataFrame，注册临时表，查询分数大于80分的学生的姓名,数据类型为DataFrame
       DataFrame goodStudentsDF = sqlContext.sql("select name , score from students where score >= 80");
        //studentsDF.saveAsTable("1");
        goodStudentsDF.show();
        //（将DataFrame转换为rdd，执行transformation操作）
        List<String> goodStudentNames =  goodStudentsDF.javaRDD().map(new Function<Row, String>() {

            private  static  final  long  serialVersionUID = 1L;

            @Override
            public String call(Row row) throws Exception {
                return row.getString(0);
            }
        }).collect();

        //然后针对JavaRDD<String> ，创建DataFrame
        //针对包括json串的JavaRDD，创建DataFrame
        List<String> studentInfoJSONs =new ArrayList<String>();
        studentInfoJSONs.add("{\"name\":\"Leo\", \"age\":18}");
        studentInfoJSONs.add("{\"name\":\"Marry\", \"age\":17}");
        studentInfoJSONs.add("{\"name\":\"Jack\", \"age\":19}");

        // 针对学生基本信息DataFrame，注册临时表，然后查询分数大于80分的学生的基本信息
        JavaRDD<String> studentInfoJSONsRDD = sc.parallelize(studentInfoJSONs);

        // 然后将两份数据的DataFrame，转换为JavaPairRDD，执行join transformation
        // （将DataFrame转换为JavaRDD，再map为JavaPairRDD，然后进行join）


        // 然后将封装在RDD中的好学生的全部信息，转换为一个JavaRDD<Row>的格式
        // （将JavaRDD，转换为DataFrame）


        // 创建一份元数据，将JavaRDD<Row>转换为DataFrame


        // 将好学生的全部信息保存到一个json文件中去
        // （将DataFrame中的数据保存到外部的json文件中去）





    }
}
