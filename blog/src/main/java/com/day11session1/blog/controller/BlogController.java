package com.day11session1.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.day11session1.blog.exception.InvalidInputException;
import com.day11session1.blog.model.Blog;
import com.day11session1.blog.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{blogTitle}")
    public ResponseEntity<Blog> getBlogByTitle(@PathVariable String blogTitle) {
        Blog blog = blogService.getBlogByTitle(blogTitle);
        if (blog != null) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(blog, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) throws InvalidInputException {
        blogService.addBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidInputException(InvalidInputException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
