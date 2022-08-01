

# 集合框架



## 泛型

### 泛型类

```java
//重点在这里
public class Teacher<T> implements Person<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
```

### 泛型方法

```java
public class Student implements Person<String> {

    @Override
    public void show(String s) {
        System.out.println(s);
    }

	//重点在这里
    public <E> E cece(E e) {
        System.out.println("泛型方法" + e);
        return e;
    }
}
```



## Set

### 特点

```
1.无序，没有下标
2.不能重复
```



### 代码

```java
Set<String> set = new HashSet<>();
set.add("华为");
set.add("小米");
set.add("华为");

System.out.println(set.contains("华为"));
System.out.println(set.size());

for (String s : set) {
    System.out.println(s);
}
```



### 结果

```
true
2
华为
小米
```



## HashSet

### 特点

```
1.在继承set的基础上，存储结构是哈希表（数组+链表+红黑树）
```

### 注意点

```
1.在添加对象时，需要注意重写hashcode方法和equals方法，因为继承来的方法，即使是属性相同，但直接new也会被认为是不同的，会占据一个新的位置
2.在重写hashCode时，可以给值加上一个质数（如31），这样做能够减少散列的冲突
```



### 代码

```java

HashSet<String> hash = new HashSet<>();

hash.add("A");
hash.add("B");
hash.add("C");
hash.add("A");

System.out.println(hash.contains("A"));
System.out.println(hash.size());
System.out.println(hash.toString());

hash.remove("A");
System.out.println(hash.toString());
```



### 结果

```
true
3
[A, B, C]
[B, C]
```



## TreeSet

### 特点

```
存储结构是红黑树
自带排序
其他跟set基本一样
```



### 要求

```
1.要实现Comparable接口（Integer和String可以不用，已经实现了），对compareTo()方法进行重写
2.或者实例化的时候使用Comparator（这种是定制化的比较）
```

#### 要求1的代码

```java
//类
public class Student implements Comparable<Student> {

    Integer age;
    String name;

    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        int n1 = this.name.compareTo(o.name);
        int n2 = this.age - o.age;
        return n1 == 0 ? n2 : n1;
    }
}


//实例化
public class Main {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();

        Student p1 = new Student("张三", 10);
        treeSet.add(p1);
        treeSet.add(new Student("张三", 10));
        treeSet.add(new Student("李四", 20));

        System.out.println(treeSet.size());
        for (Student student : treeSet) {
            System.out.println(student.name + student.age);
        }
    }
}


```



#### 要求2的代码

```java
public class Student {

    Integer age;
    String name;

    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }
}


public class Main {
    public static void main(String[] args) {
        //创建集合，并指定比较规则
        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int n1 = o1.name.compareTo(o2.name);
                int n2 = o1.age - o2.age;
                return n1 == 0 ? n2 : n1;
            }
        });

        Student p1 = new Student("张三", 10);
        treeSet.add(p1);
        treeSet.add(new Student("张三", 10));
        treeSet.add(new Student("李四", 20));

        System.out.println(treeSet.size());
        for (Student student : treeSet) {
            System.out.println(student.name + student.age);
        }
    }
}


```





## Map

### 特点

```
1.存储键值对
2.键不能重复，值可以重复
3.无序
```



### 代码

```java
public class Main {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        //添加元素
        map.put("A", new Student("张三", 20));
        map.put("B", new Student("李四", 18));
        map.put("C", new Student("测试", 20));
        map.put("A", new Student("张三", 20));

        System.out.println(map.size());

        //使用keySet()获取map的key的set集合，进行遍历
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + "----------" + map.get(key).name);

        }

        System.out.println("分割线============================================");

        //使用entrySet()获取它的包含键值对的item
        Set<Map.Entry<String, Student>> entryItemList = map.entrySet();
        for (Map.Entry<String, Student> studentMap : entryItemList) {
            System.out.println(studentMap.getKey() + "----------" + studentMap.getValue().name);
        }

    }
}

```



### 结果

```
3
A----------张三
B----------李四
C----------测试
分割线============================================
A----------张三
B----------李四
C----------测试
```





## HashMap

### 特点

```
1.基于map+hash表的实现
2.初始容量16，加载因子0.75，容量超过16*0.75时，自动扩容，扩容后为2*16，即2*n 用二进制表示的话，就是左移一位
3.存储结构：数组+链表+红黑树
```

### 注意

```
1.如果key是对象，可能存在去重失败的情况，这时候就要重写hashcode和equals方法
2.刚创建hashmap之后，没有添加元素时，table=null  size=0，等插入第一个元素时，table就有值了，（容量）size就是16了
```



### 源码解析

```
HashMap刚创建时，table是null，节省空间，当添加第一个元素时，table容量调整为16
当元素个数大于阈值（16*0.75 = 12）时，会进行扩容，扩容后的大小为原来的两倍，目的是减少调整元素的个数
jdk1.8 当每个链表长度 >8 ，并且数组元素个数 ≥64时，会调整成红黑树，目的是提高效率
jdk1.8 当链表长度 <6 时 调整成链表
jdk1.8 以前，链表时头插入，之后为尾插入
```



### 代码

#### 情况一

```java
public class Student {

    Integer age;
    String name;

    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        HashMap<Student, String> stus = new HashMap<>();
        Student p1 = new Student("A", 18);
        Student p2 = new Student("B", 18);
        Student p3 = new Student("C", 18);
        stus.put(p1, "AVal");
        stus.put(p2, "BVal");
        stus.put(p3, "CVal");

        //看这行，在没用重写hashcode和equals，是不会认为是同一个key的
        stus.put(new Student("A", 18), "Asdfasdf");

        System.out.println(stus.size());
    }
}

//想要正确的去重，就需要重写hashcode和equals，具体看情况二
```

#### 结果

```
4
```



#### 情况二

```java
public class Student {

    Integer age;
    String name;

    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    //重写equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age.equals(student.age) && name.equals(student.name);
    }

    //重写hashcode
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}


public class Main {
    public static void main(String[] args) {
        HashMap<Student, String> stus = new HashMap<>();
        Student p1 = new Student("A", 18);
        Student p2 = new Student("B", 18);
        Student p3 = new Student("C", 18);
        stus.put(p1, "AVal");
        stus.put(p2, "BVal");
        stus.put(p3, "CVal");

        //看这行，因为student重写了equals和hashcode所以成功去重
        stus.put(new Student("A", 18), "Asdfasdf");

        System.out.println(stus.size());
    }
}
```

#### 结果

```
3
```



### 遍历

#### 代码

```java
 //方式一
 for (Student student : stus.keySet()) {
 	System.out.println(student.name + "======" + stus.get(student));
 }

 System.out.println("分割线=========================");

 //方式二
 for (Map.Entry<Student, String> studentStringEntry : stus.entrySet()) {
     System.out.println(studentStringEntry.getKey().name + "======" + studentStringEntry.getValue());
 }
```

#### 结果

```
A======Asdfasdf
B======BVal
C======CVal
分割线=========================
A======Asdfasdf
B======BVal
C======CVal
```



## TreeMap

### 特点

```
存储结构：红黑树
要实现比较去重，就需要重写compareTo方法或者定制Comparator,对应内容参考TreeSet
```





# IO框架



# GUI

## AWT

### 第一个demo

```java
package com.getdream.gui.lesson01;

import java.awt.*;

public class TestFrame {
    public static void main(String[] args) {
        //Frame f = new Frame("第一个窗口demo");
        //
        ////设置可见性
        //f.setVisible(true);
        //
        ////设置宽高
        //f.setSize(400, 400);
        //
        ////设置颜色
        //f.setBackground(new Color(19, 59, 20));
        //
        ////弹出的初始值
        //f.setLocation(200, 200);
        //
        ////设置不允许调整窗口大小
        //f.setResizable(false);


        MyFrame f1 = new MyFrame(100, 100, 200, 200, Color.BLUE);
        MyFrame f2 = new MyFrame(150, 150, 200, 200, Color.YELLOW);
        MyFrame f3 = new MyFrame(200, 200, 200, 200, Color.GREEN);
        MyFrame f4 = new MyFrame(250, 250, 200, 200, Color.PINK);
    }
}


class MyFrame extends Frame {
    static int id = 0;//可能存在多个窗口，用于计数

    public MyFrame(int x, int y, int w, int h, Color color) {
        super("MyFrame" + (++id));
        setBackground(color);
        setBounds(x, y, w, h);
        setVisible(true);
    }
}
```



### Panel面板

```java
package com.getdream.gui.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Panel 可以看成是一个空间，但是不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame f = new Frame();

        //布局的概念
        Panel panel = new Panel();

        //设置布局
        f.setLayout(null);

        //设置坐标
        f.setBounds(300, 300, 500, 500);
        //设置背景色
        f.setBackground(Color.GREEN);

        //panel设置坐标，相当于frame 其实就是类似前端的div
        panel.setBounds(50, 50, 200, 200);
        panel.setBackground(new Color(0, 25, 254));

        //把panel加进去frame
        f.add(panel);

        //设置可见性
        f.setVisible(true);

        //监听事件，监听关闭窗口事件
        //使用适配器模式，选择性重写，这里选择性重写关闭窗口事件
        f.addWindowListener(new WindowAdapter() {
            //重写关闭事件
            @Override
            public void windowClosing(WindowEvent e) {
                //结束程序
                System.exit(0);
            }
        });
    }
}

```



### 布局管理器

#### 流式布局

```java
package com.getdream.gui.lesson01;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame f = new Frame();


        //组件-按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");


        //设置布局为流式布局
        //f.setLayout(new FlowLayout());
        //设置布局为流式布局-左浮动
        f.setLayout(new FlowLayout(FlowLayout.LEFT));

        f.add(button1);
        f.add(button2);
        f.add(button3);

        f.setBackground(Color.GREEN);
        f.setBounds(200, 200, 200, 200);
        f.setVisible(true);


    }
}

```



#### 东西南北中

```java
package com.getdream.gui.lesson01;

import java.awt.*;

public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("TestBorderLayout");


        Button button = new Button("dong");
        Button button2 = new Button("xi");
        Button button3 = new Button("nan");
        Button button4 = new Button("bei");
        Button button5 = new Button("zhong");


        frame.setBackground(Color.GREEN);
        frame.setBounds(300, 400, 400, 400);
        frame.setVisible(true);

        //设置布局
        frame.setLayout(new BorderLayout());

        //设置布局
        frame.add(button, BorderLayout.EAST);
        frame.add(button2, BorderLayout.WEST);
        frame.add(button3, BorderLayout.SOUTH);
        frame.add(button4, BorderLayout.NORTH);
        frame.add(button5, BorderLayout.CENTER);

    }
}

```



#### 表格布局

```java
package com.getdream.gui.lesson01;

import java.awt.*;

public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");

        frame.setBounds(400, 400, 400, 400);
        frame.setBackground(Color.GREEN);
        frame.setVisible(true);

        //表格布局 3行两列
        frame.setLayout(new GridLayout(3, 2));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);

        //自动填充，会按表格方式的顺序进行排列
        frame.pack();
    }
}

```



## Swing
