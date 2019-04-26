package sql;



public class RDD2DataFrameReflectionText {

    public static void main(String[] args) {

        //将txt的文本，转换成student格式的rdd类型（文本转换是默认string类型。直接数组去拿）


        // 使用反射方式，将RDD转换为DataFrame
        // 将Student.class传入进去，其实就是用反射的方式来创建DataFrame
        // 因为Student.class本身就是反射的一个应用
        // 然后底层还得通过对Student Class进行反射，来获取其中的field
        // 这里要求，JavaBean必须实现Serializable接口，是可序列化的

        // 使用反射方式，将RDD转换为DataFrame


        //拿到了一个DataFrame之后，就可以将其注册为一个临时表，然后针对其中的数据执行的sql语句

        //针对student临时表执行SQL语句，查询年纪小于18岁的学生，就是teenageer


        // 将查询出来的DataFrame，再次转换为RDD


        // 将RDD中的数据，进行映射，映射为Student（这里注意转换，他转换的是基于student对象）


        // 将数据collect回来，打印出来


    }
}
