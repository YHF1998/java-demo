package com.getdream.reflection.annotation;


import java.awt.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;

//使用反射获取注解
public class AnnotationAction {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.getdream.reflection.annotation.User");

        //通过反射获取类注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            System.out.println(annotation);
        }

        //获取注解的value的值
        Table table = (Table) c1.getAnnotation(Table.class);
        //调用Table注解的value()方法，其实就是字段名+（）,字段名是什么 它就替换成什么
        //可以看下面的类属性调用获取，就知道了
        System.out.println(table.value());

        //通过反射获取类属性注解
        //先通过反射，获取属性字段
        Field field = c1.getDeclaredField("name");
        //再通过getAnnotation方法并且进行强制转换得到对应注解
        TableField tableField = field.getAnnotation(TableField.class);
        //然后调用对应的注解值
        System.out.println(tableField.colName());
        System.out.println(tableField.type());
        System.out.println(tableField.length());


    }
}

@Table("tb_user")
class User {

    @TableField(colName = "tb_id", type = "int", length = 11)
    private int id;

    @TableField(colName = "tb_name", type = "int", length = 3)
    private int age;

    @TableField(colName = "tb_name", type = "varchar", length = 50)
    private String name;
}


//作用在方法和类
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//类的注解-》对应表
@interface Table {
    String value() default "";
}


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//属性的注解-》对应表字段
@interface TableField {
    //字段名
    String colName();

    //字段类型
    String type();

    //字段长度
    int length();
}