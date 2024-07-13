package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("list")
    public Result<String> list()
    {

        return Result.success("文章列表数据");
      }
}