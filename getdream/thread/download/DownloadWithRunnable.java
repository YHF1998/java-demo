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

        //启动线程
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}
