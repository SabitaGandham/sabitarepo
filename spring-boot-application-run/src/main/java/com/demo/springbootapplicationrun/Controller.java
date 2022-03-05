package com.demo.springbootapplicationrun;

import com.demo.springbootapplicationrun.VO.ProductVO;
import com.demo.springbootapplicationrun.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path="/getProducts")
    public  List<ProductVO> getHello() throws URISyntaxException, IOException {

        List<ProductVO> productVOS= productService.getProducts();
        return productVOS;
    }
}
