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



