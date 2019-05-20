package myself_api;

import java.util.HashMap;
import java.util.Map;

/**
 * 科科牌ArrayList
 */
public class MyArrayList {


      private  Object[] value = null;

      private  int size = 0;

      MyArrayList(){
          value = new Object[10];
      }

      public  boolean add(Object obj){
          if(size ==value.length){
            expansion();
          }
          value[size++] =obj;
          return  true;
      }

      public  Object  get(int index){
            return  value[index];
      }


      public void remove(Object obj){

            Object[]  obj2 = new Object[size];
            int index = 0;
            int id = 0;
            for(int i = 0; i<=size;i++){
                String old = value[i].toString();
                String news = obj.toString();
                boolean result = old.equals(news);
                if(   !result ){
                        obj2[index] = value[i];
                        index ++;
                }else {
                    id++;
                    if(id == 1){
                        size--;
                    }else {
                        obj2[index] =value[i];
                        index ++;
                    }
                }
            }
          System.out.println("执行这个remove办法");
            value = obj2;

      }

        public void set(int index,Object  obj){
            Object[]  newObj = new Object[size];

           for(int i =0; i<size; i++){
                if(i==index){
                    newObj[i] = obj;
                }else {
                    newObj[i] = value[i];
                }

           }
            value = newObj;
        }

        /*
        数组清除
         */
        public  void clear(){
          size = 0;
          value = null;
        }


    /**
     * 返回数组的长度
     * @return
     */
    public  int size(){
          return  size;
      }

      private  boolean expansion(){
          Object[]  temp = new Object[value.length+5];
          temp =value.clone();
          return  true;
      }


    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("aaaaa");
        myArrayList.add("bbbbb");
        myArrayList.add("ccccc");

        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(1));
        System.out.println(myArrayList.get(2));

        System.out.println(myArrayList.size());

        myArrayList.set(1,"修改");
        System.out.println("修改的结果:"+myArrayList.get(1));

        System.out.println("修改的结果:"+myArrayList.size());

        myArrayList.remove("修改");
        System.out.println(myArrayList.get(0)+","+myArrayList.get(1));
    }
}
