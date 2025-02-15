# 开头

## 项目代码的demo地址

```
https://github.com/YHF1998/java-demo
```



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



### 简单布局demo

```java
package com.getdream.gui.lesson01;

import java.awt.*;

public class ExDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setBounds(300, 400, 400, 300);
        frame.setBackground(Color.GREEN);

        //弄个表格布局,2行一列
        frame.setLayout(new GridLayout(2, 1));

        //四个面板
        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2, 1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2, 2));

        //上半部分
        p1.add(new Button("East-1"), BorderLayout.EAST);
        p1.add(new Button("West-1"), BorderLayout.WEST);
        p2.add(new Button("p2-btn-1"));
        p2.add(new Button("p2-btn-2"));
        p1.add(p2, BorderLayout.CENTER);

        frame.add(p1);

        //下半部分
        p3.add(new Button("East-1"), BorderLayout.EAST);
        p3.add(new Button("West-1"), BorderLayout.WEST);
        for (int i = 0; i < 4; i++) {
            p4.add(new Button("for-" + i));
        }
        p3.add(p4, BorderLayout.CENTER);

        frame.add(p3);


    }
}
```



## Swing





# 多线程

## run和start方法

```
1.直接调用run方法的话，是顺序执行，自上而下
2.调用start方法，是异步并行，同步执行
3.start方法内部是有调用run方法的，所以我们在拉起多线程的时候，都是调用start方法
```



## 多线程实现的方式

### 选择实现多线程的方式

```
1.一般都会选用实现Runnable接口的方式
2.因为继承Thread类这种方式，存在着单继承局限性
3.而实现Runnable接口可以避免单继承的局限性，更加灵活方便，一个对象能被多个线程调用  new Thread(t1).start(); 执行3次，就能被3个线程调用，而使用继承Thread类的则不行
```



### 继承Thread

```
启动方式：子类对象.start()
```



```
com/getdream/thread/download/Download.java
```

```java
package com.getdream.thread.download;

public class Download extends Thread {
    private String url;//网络图片地址
    private String name;//图片保存名

    public Download(String url, String name) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载成功：" + name);
    }

    //main 主线程
    public static void main(String[] args) {
        //拉起多线程下载
        Download t1 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "1.jpg");
        Download t2 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "2.jpg");
        Download t3 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "3.jpg");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}




```



### 实现Runnable接口

```
启动方式： new Thread(实现接口类的对象).start();
```



```
com/getdream/thread/download/DownloadWithRunnable.java
```

```java
package com.getdream.thread.download;

//使用实现 Runnable 接口的线程方式
public class DownloadWithRunnable implements Runnable {
    private String url;//网络图片地址
    private String name;//图片保存名

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载成功：" + name);
    }

    //main 主线程
    public static void main(String[] args) {
        //注意这里 继承Thread的话，在实例化后就能直接start()启动线程的
        //但是通过实现Runnable接口方式，是需要使用 new Thread（实例）.start()的方式进行调用并启动的
        Download t1 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "1.jpg");
        Download t2 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "2.jpg");
        Download t3 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "3.jpg");

        //启动线程 两种方式的启动方式区别 就在这里
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

```



## 简述

```
一个java程序实际是一个jvm进程，jvm进程用一个主线程来执行main方法，在main方法内部，我们又可以启动多个线程（线程内部还可以继续启动多线程，不过不易层级过多，容易管理混乱）。此外，jvm还有负责垃圾回收的其他工作线程
```



## 创建新线程

```
有两种方法创建线程，一种是继承Thread类，另一种是实现Runnable接口

1.一般都会选用实现Runnable接口的方式
2.因为继承Thread类这种方式，存在着单继承局限性
3.而实现Runnable接口可以避免单继承的局限性，更加灵活方便，一个对象能被多个线程调用  new Thread(t1).start(); 执行3次，就能被3个线程调用，而使用继承Thread类的则不行

```



```java
class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```



### 方法一：继承Thread类

```java
public class Download extends Thread {
    private String url;//网络图片地址
    private String name;//图片保存名

    public Download(String url, String name) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载成功：" + name);
    }

    //main 主线程
    public static void main(String[] args) {
        //拉起多线程下载
        Download t1 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "1.jpg");
        Download t2 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "2.jpg");
        Download t3 = new Download("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "3.jpg");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}

```



### 方法二：实现Runnable接口

```java
//使用实现 Runnable 接口的线程方式
public class DownloadWithRunnable implements Runnable {
    private String url;//网络图片地址
    private String name;//图片保存名

    public DownloadWithRunnable(String url, String name) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载成功：" + name);
    }

    //main 主线程
    public static void main(String[] args) {
        //注意这里 继承Thread的话，在实例化后就能直接start()启动线程的
        //但是通过实现Runnable接口方式，是需要使用 new Thread（实例）.start()的方式进行调用并启动的
        DownloadWithRunnable t1 = new DownloadWithRunnable("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "1.jpg");
        DownloadWithRunnable t2 = new DownloadWithRunnable("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "2.jpg");
        DownloadWithRunnable t3 = new DownloadWithRunnable("https://img2.baidu.com/it/u=2859542338,3761174075&fm=253&fmt=auto&app=138&f=JPEG?w=501&h=500", "3.jpg");

        //启动线程
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

```



## 线程优先级

可以对线程设定优先级

```java
Thread.setPriority(int n) // 1~10, 默认值5
```

```
jvm自动把1（低）~10（高）的优先级映射到操作系统实际优先级上（不同的操作系统有不同的优先级数量）。优先级高的线程被操作系统调度的优先级较高，操作系统对高优先级线程可能调度更频繁，但我们不能通过设置优先级来确保高优先级的线程一定会先执行
```



## 线程的状态

### 描述

```
New：新创建的线程，尚未执行
Runnable：运行中的线程，正在执行run（）方法的java代码
Blocked：运行中的线程，因为某些操作阻塞而被挂起
Waiting：运行中的线程，因为某些操作在等待中
Timed Waiting:运行中的线程，因为执行sleep()方法正在计时等待
Terminated：线程已经终止，因为run()方法执行完毕

状态转移图表示如下：

		 ┌─────────────┐
         │     New     │
         └─────────────┘
                │
                ▼
┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐
 ┌─────────────┐ ┌─────────────┐
││  Runnable   │ │   Blocked   ││
 └─────────────┘ └─────────────┘
│┌─────────────┐ ┌─────────────┐│
 │   Waiting   │ │Timed Waiting│
│└─────────────┘ └─────────────┘│
 ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─
                │
                ▼
         ┌─────────────┐
         │ Terminated  │
         └─────────────┘
         
```

```
当线程启动后，它可以在Runnable、Blocked、Waiting和Timed Waiting这几个状态之间切换，直到最后变成Terminated状态，线程终止

线程终止的原因有：
线程正常终止：run方法执行到return语句返回；
线程以为终止：run方法因为未捕获的异常导致线程终止
对某个线程的Thread实例调用stop（）方法强制终止（强烈不推荐使用）
```



### 等待线程

```
调用join（）方法时，主线程会等待该线程运行结束后，才会继续向下执行自身线程，如果另一个子线程写在后面，并且还没启动，也会不执行，需要等待调用join（）方法的线程执行完成。

join()方法可以重载，指定一个等待时间，超过等待时间就不再继续等待，main线程就可以继续向下执行了
```



```java
/**
 * 等待某个线程结束才继续运行
 */
public class JoinThread {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main主线程开始");
        Thread t1 = new Thread(() -> {
            int num = 0;
            while (true) {
                num++;
                if (num < 100) {
                    System.out.println("这是线程内部" + num);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        });

        System.out.println("子线程启动");
        //启动线程
        t1.start();
        
        //等待线程结束
        // 此处main线程会等待t结束
        //t1.join();
        //如果添加参数，那么会等待这么长时间（子线程还在继续运行，没有停止的情况下），然后继续向下执行
        t1.join(100);
        
        System.out.println("即将结束main主线程");
    }
}
```



## 中断线程

```
方法有两种：
1.继承自Thread类的interrupt（）方法
2.线程类声明一个volatile 关键字类属性，确保每个线程都能读取到更新后的变量值
```

```java
/**
 * 停止线程的几种方式
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        // TODO: 2025/1/20  interrupt方式
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1);//暂停1毫秒
        //中断线程
        t.interrupt();
        


        // TODO: 2025/1/20 线程共享变量(volatile)方式 --实现Runnable接口 
        MyThread2 r = new MyThread2(); 
        Thread t2 = new Thread(r);
        Thread t4 = new Thread(r);
        t2.start();
        t4.start();
        Thread.sleep(10);//暂停10毫秒
        //停止线程
        r.running = false;

        // TODO: 2025/1/20 线程共享变量(volatile)方式 --继承Thread类
        MyThread3 t3 = new MyThread3();
        t3.start();
        Thread.sleep(1);//暂停
        t3.running = false; // 标志位置为false


        //等待线程结束
        t.join();
        t2.join();
        t3.join();
        t4.join();
    }
}



class MyThread extends Thread {
    public void run() {
        int n = 0;
        //isInterrupted方法是类Thread的方法，如果使用实现Runnable接口的方式写的类，是没有这个方法，需要注意
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " MyThread hello!");
        }
        System.out.println("MyThread 退出了!");
    }
}


class MyThread2 implements Runnable{
    
    //线程是否运行，默认运行。volatile 不限制是继承Thread还是实现Runnable接口，这两种方式都是能用volatile的
    //但是，其实用实现Runnable接口方式的话， 这个running参数，会控制所有用同一个实例拉起的线程,下面的结果会是两个线程一起停止的
    //        MyThread2 r = new MyThread2(); 
    //        Thread t2 = new Thread(r);
    //        Thread t4 = new Thread(r);
    //         r.running = false;
    public volatile  boolean running = true;
    
    @Override
    public void run() {
        int n = 0;
        while (this.running) {
            n ++;
            System.out.println(n + " MyThread2 hello!");
        }
        System.out.println("MyThread2 退出了!");
    }
}

class MyThread3 extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " MyThread3 hello!");
        }
        System.out.println("MyThread3 退出了!");
    }
}
```

### 注意点

```
volatile关键字的目的是告诉虚拟机：

每次访问变量时，总是获取主内存的最新值；
每次修改变量后，立刻回写到主内存。
volatile关键字解决的是可见性问题：当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值。

如果我们去掉volatile关键字，运行上述程序，发现效果和带volatile差不多，这是因为在x86的架构下，JVM回写主内存的速度非常快，但是，换成ARM的架构，就会有显著的延迟。
```



## 线程锁

### 两种加锁方式

```
Lock和synchronized
1.Lock是显式锁（手动打开和关闭），synchronized是隐式锁，出了作用域自动释放
2.Lock只有代码块锁，没有方法锁，synchronized有代码块锁和方法锁
3.使用Lock锁，jvm花费的时间更少，性能更好，扩展性强(提供更多的子类)
4.优先使用顺序：Lock > synchronized代码块 > synchronized方法
```





## 并发存在的问题

```
1.存在线程不安全
2.例：网络抢票，因为多线程，可能存在多个人同时抢到同一张票，这时候就存在的线程不安全问题
```





## 守护线程-daemon

```
com/getdream/thread/daemon/Daemon.java
```



```
线程分为用户线程和守护线程
虚拟机必须确保用户线程执行完毕
虚拟机不用等待守护线程执行完毕
比如，后台记录操作日志，监控内容，垃圾回收等待 就是守护线程

用户线程：当任何一个用户线程未结束，Java虚拟机是不会结束的。
守护线程：如果只剩守护线程未结束，Java虚拟机结束。

守护线程指为其他线程服务的线程。在jvm中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
因此，jvm退出时，不必关心守护线程是否已结束

守护线程是为其他线程服务的线程；

所有非守护线程都执行完毕后，虚拟机退出，守护线程随之结束；

守护线程不能持有需要关闭的资源（如打开文件等）。

Java中的守护线程（Daemon Thread）主要用于在后台执行一些辅助性或支持性的任务，这些任务通常不需要人为干预，并且会在所有用户线程（非守护线程）结束时自动退出。


```





## 线程同步和锁

```
com/getdream/thread/unsafe/Unsafe.java
```



```
在对共同的资源进行修改时，会存在竞争，这时就应该让他们排队
实现排队的方式，就是锁，关键字 synchronized
只要是对象，都能使用synchronized
方法体的synchronized 默认锁的是this
```



## 死锁

```
com/getdream/thread/deadLock/DeadLock.java
```



```
多个线程互相锁着对方需要的资源，形成僵持状态
```

### 死锁产生的必要条件

```
1.互斥条件：一个资源每次只能被一个进程使用
2.请求与保持条件：一个进程因为请求资源而阻塞时，对已经获得的资源不进行释放
3.不剥夺条件：进程已经获得的资源，在未使用完之前，不能够强行剥夺
4.循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系
```



## 两种加锁方式



```
Lock和synchronized
1.Lock是显式锁（手动打开和关闭），synchronized是隐式锁，出了作用域自动释放
2.Lock只有代码块锁，没有方法锁，synchronized有代码块锁和方法锁
3.使用Lock锁，jvm花费的时间更少，性能更好，扩展性强(提供更多的子类)
4.优先使用顺序：Lock > synchronized代码块 > synchronized方法
```



### synchronized

```
com/getdream/thread/deadLock/DeadLock.java
```

### Lock

```
com/getdream/thread/lock/Lock.java
```





## 生产者消费者

### 缓存法

```
com/getdream/thread/consumer/Test.java
```



### 信号灯法

```
com/getdream/thread/consumer02/Test.java
```





# 注解-Annotation

```
com/getdream/annotation/element/Element.java
```



# 反射



## 获取Class

```
com/getdream/reflection/withClass/Test.java
```



#### 通过对象获取

```java
 User user = new User(1, "asdf");
 Class cls1 = user.getClass();
System.out.println(cls1.hashCode());
```



#### 通过forname获取

```java
Class cls2 = Class.forName("com.getdream.reflection.withClass.User");
System.out.println(cls2.hashCode());
```



#### 通过类名.class获取

```java
Class cls3 = User.class;
System.out.println(cls3.hashCode());
```



## 获取所有类型的class

```
com/getdream/reflection/typeClass/TypeClass.java
```



```java
package com.getdream.reflection.typeClass;


import java.lang.annotation.ElementType;

//获取所有类型的class
public class TypeClass {
    public static void main(String[] args) {
        Class c1 = Object.class;//类
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;//一维数组
        Class c4 = int[][].class;//二维数组
        Class c5 = Override.class;//注解
        Class c6 = ElementType.class;//枚举类型
        Class c7 = Integer.class;//基本数据类型
        Class c8 = void.class;//void
        Class c9 = Class.class;//Class

        //使用alt+鼠标左键 复制多行 粘贴
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3); 
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
    }
}

```





## 获取运行时类的结构（构造器/方法/字段）

```
com/getdream/reflection/runtimeClass/Main.java
```



## 调用运行时类的结构（构造器/方法/字段）

```
com/getdream/reflection/dynamic/Main.java
```



## 反射获取泛型参数

```
com/getdream/reflection/generic/Generic.java
```



## 反射操作注解
