package sql;

import bean.Student;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class RDD2DataFrameReflection {

    public static void main(String[] args) {
        SparkConf conf =new SparkConf().setAppName("RDD2DataFrameReflection").setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext  sqlContext = new SQLContext(sc);

        JavaRDD<String>  lines=sc.textFile("E:\\spark_resource\\students.txt");
        //将txt的文本，转换成student格式的rdd类型
        JavaRDD<Student>   students  =lines.map(new Function<String, Student>() {

            private  static  final long serialVersionUID = 1L;

            @Override
            public Student call(String line) throws Exception {
                String[] lineSplited = line.split(",");
                Student student= new Student();
                student.setId(Integer.valueOf(lineSplited[0].trim()));
                student.setName(lineSplited[1].trim());
                student.setAge(Integer.valueOf(lineSplited[2].trim()));
                return student;
            }
        });

        // 使用反射方式，将RDD转换为DataFrame
        // 将Student.class传入进去，其实就是用反射的方式来创建DataFrame
        // 因为Student.class本身就是反射的一个应用
        // 然后底层还得通过对Student Class进行反射，来获取其中的field
        // 这里要求，JavaBean必须实现Serializable接口，是可序列化的

        // 使用反射方式，将RDD转换为DataFrame
        DataFrame studentDF = sqlContext.createDataFrame(students,Student.class);

        //拿到了一个DataFrame之后，就可以将其注册为一个临时表，然后针对其中的数据执行的sql语句
       studentDF.registerTempTable("students");

        //针对student临时表执行SQL语句，查询年纪小于18岁的学生，就是teenageer
        DataFrame  teenagerDF =sqlContext.sql("SELECT  * FROM students WHERE AGE <= 18");

        // 将查询出来的DataFrame，再次转换为RDD


        // 将RDD中的数据，进行映射，映射为Student


        // row中的数据的顺序，可能是跟我们期望的是不一样的！




    }
}
