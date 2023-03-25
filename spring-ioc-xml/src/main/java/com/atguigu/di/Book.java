package com.atguigu.di;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/25 9:59
 * @Description:
 */
public class Book {
    private String bname;
    private String author;
    private String others;

    public Book() {
        System.out.println("无参构造执行了...");
    }

    public Book(String bname, String author) {
        System.out.println("有参构造执行了...");
        this.bname = bname;
        this.author = author;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // 1. set方法注入
        Book book = new Book();
        book.setBname("java");
        book.setAuthor("尚硅谷");

        // 2. 通过构造器注入
        Book book1 = new Book("c++", "尚硅谷");
    }
}
