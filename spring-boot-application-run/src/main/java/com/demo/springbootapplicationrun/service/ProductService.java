package com.demo.springbootapplicationrun.service;

import com.demo.springbootapplicationrun.VO.ProductVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    public List<ProductVO> getProducts() throws URISyntaxException, IOException {

        List<ProductVO> productVOS = new ArrayList<>();
        URL resource = ProductService.class.getClassLoader().getResource("products.json");
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        try
        {
            Reader targetReader = new StringReader(new String(bytes));

            JSONParser jsonParser = new JSONParser();
            //Read JSON file
            Object obj = jsonParser.parse(targetReader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            for(Object p: employeeList) {
                ProductVO n =parseEmployeeObject( (JSONObject) p );
                productVOS.add(n);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return productVOS;
    }

    private ProductVO parseEmployeeObject(JSONObject product)
    {
        ProductVO n = new ProductVO();
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) product.get("product");

        //Get employee first name
        n.setId((String) employeeObject.get("id"));

        //Get employee last name
        n.setName((String) employeeObject.get("name"));

        //Get employee website name
        n.setDesc((String) employeeObject.get("desc"));
        return n;
    }
}
