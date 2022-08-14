package com.getdream.reflection.withClass;

//class类的创建方式有哪些
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的class对象
        Class<?> c1 = Class.forName("com.getdream.reflection.withClass.User");
        System.out.println(c1);
        System.out.println(c1.hashCode());

        //一个类在内存中只有一个class对象
        //一个类被加载后，类的整个结构都会被封装在class对象中


        //方式一：通过对象获取
        User user = new User(1, "asdf");
        Class cls1 = user.getClass();
        System.out.println(cls1.hashCode());

        //方式二：forname获取
        Class cls2 = Class.forName("com.getdream.reflection.withClass.User");
        System.out.println(cls2.hashCode());

        //方式三：通过类名.class 也能获得
        Class cls3 = User.class;
        System.out.println(cls3.hashCode());

        //方式四：基本内置类型的包装类都有一个Type属性
        Class cls4 = Integer.TYPE;
        System.out.println(cls4);

        //获得父类类型
        Class cls5 = c1.getSuperclass();
        System.out.println(cls5);

    }
}


//实体类：pojo entity
class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}