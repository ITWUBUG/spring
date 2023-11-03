package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.List;


@RestController
public class EmpController {

    @RequestMapping("/getEmp")
    public Result getEmp() {

        URL resource = this.getClass().getClassLoader().getResource("emp.xml");
        String path = resource.getPath();

//        List<Emp> parse = XmlParserUtils.parse("D:\\Ideaproject\\boot_spring01\\springboot01\\src\\main\\resources\\emp.xml", Emp.class);
        List<Emp> parse = XmlParserUtils.parse(path, Emp.class);
        parse.stream().forEach(
                o -> {
                    if (o.getGender().equals("1")) {
                        o.setGender("男");
                    } else if (o.getGender().equals("2")) {
                        o.setGender("女");
                    }

                    String job = o.getJob();
                    if (job.equals("1")) {
                        o.setJob("讲师");
                    } else if (job.equals("2")) {
                        o.setJob("班主任");
                    } else if (job.equals("3")) {
                        o.setJob("就业指导");
                    }
                }
        );
        return Result.success(parse);
    }

}

