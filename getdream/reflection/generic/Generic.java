package com.getdream.reflection.generic;


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//使用反射 获取泛型信息
public class Generic {

    public static void main(String[] args) throws NoSuchMethodException {
        Method test01 = T.class.getMethod("test01", Map.class, List.class);

        Integer i = 1;

        System.out.println(i instanceof Integer);

        //获取泛型参数类型
        Type[] parameterTypes = test01.getGenericParameterTypes();
        for (Type parameterType : parameterTypes) {
            System.out.println("#" + parameterType);
            //#java.util.Map<java.lang.String, java.lang.Integer>
            //获取真实的参数类型
            if (parameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) parameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                    //class java.lang.String
                    //class java.lang.Integer
                    //真实类型名称
                    //System.out.println(actualTypeArgument.getTypeName());

                }

            }

        }
    }
}


class T {

    public void test01(Map<String, Integer> map, List<Integer> list) {
        System.out.println(111);
    }

    public Map<String, Integer> test2() {
        return null;
    }


}
