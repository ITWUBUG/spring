package com.itheima.controller;

import com.itheima.pojo.Address;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

//    @RequestParam(value = "name2", required = false)是别名
//    required = false取消必须有
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name2", required = false) String name, Integer age) {
        System.out.println(name);
        System.out.println(age);
        System.out.println("Hello World");
        return "Hello World";
    }


    //RequestMapping:的作用就是把路径资源里的{}中的数据映射到参数对象中
    //要写几个参数就写几个/{} 参数的顺序个数要一致
    //前端请求格式     localhost:8080/hello2/"张三"/12
    @RequestMapping("/hello2/{name}/{age}")
    public String hello2(@PathVariable String name, @PathVariable Integer age) {
        System.out.println(name);
        System.out.println(age);
        System.out.println("Hello World");
        return "Hello World";
    }


    @RequestMapping("/hello1")
    @ResponseBody//作用：使返回的格式是json格式
    public Result hello(@RequestBody Student stu) {
        System.out.println(stu);
        Result result = new Result();
        result.setCode(1);
        return result;
    }

    @RequestMapping("/method")
    public String method(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        System.out.println("ok");
        return "ok";
    }

//    @RequestParam：绑定参数关系
//    可以理解为把传入的值封装到List接口解决没有构造器的问题
    @RequestMapping("/method2")
    public String method2(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        System.out.println("ok");
        return "ok";
    }

    @RequestMapping("/method3")
    public String method3(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
        System.out.println(dateTime);
        System.out.println("ok");
        return "ok";
    }

    @RequestMapping("/method4")
    public Result method4(){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("丁真",12,new Address("浙江","杭州")));
        list.add(new Student("丁真",12,new Address("浙江","杭州")));
        return Result.success(list);
    }

    @RequestMapping("/method5")
    public Result method5(){
        Student student = new Student("丁真", 12, new Address("浙江", "杭州"));
        return Result.success(student);
    }


}