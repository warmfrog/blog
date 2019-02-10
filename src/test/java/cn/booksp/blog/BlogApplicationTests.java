package cn.booksp.blog;

import cn.booksp.blog.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    ArticleService articleService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findAllTypes(){
        System.out.println(articleService.getAllType("article"));
    }

}

