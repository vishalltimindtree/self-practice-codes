package com.day11session1.blog.model;

public class Blog {
    String blogTitle;
    String content;
    String author;
    
    public Blog() {
    }

    public Blog(String blogTitle, String content, String author) {
        this.blogTitle = blogTitle;
        this.content = content;
        this.author = author;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }    
}
