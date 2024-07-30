package com.day11session1.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.day11session1.blog.exception.InvalidInputException;
import com.day11session1.blog.model.Blog;

@Service
public class BlogService {
    List<Blog> blogs = new ArrayList<>();

    public List<Blog> getAllBlogs() {
        return blogs;
    }

    public Blog getBlogByTitle(String blogTitle) {
        for (Blog blog : blogs) {
            if (blog.getBlogTitle().equals(blogTitle)) {
                return blog;
            }
        }
        return null;
    }

    public void addBlog(Blog blog) throws InvalidInputException {
        if (blog.getBlogTitle() == null || blog.getContent() == null ||
                blog.getAuthor() == null) {
            throw new InvalidInputException("Invalid input given! Kindly check your input.");
        }
        blogs.add(blog);
    }
}
