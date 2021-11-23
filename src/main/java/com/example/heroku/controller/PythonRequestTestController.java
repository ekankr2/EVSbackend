package com.example.heroku.controller;

//import com.esc.khweb.entity.python.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
public class PythonRequestTestController {

    @GetMapping("/spring2pythonRequest")
    public ModelAndView doRequestPythonRest(Model model) {
        log.info("doRequestPythonRest()");

        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        String result = restTemplate.getForObject(
                // 프로젝트 진행시에는 이 부분만 바꿔가면서 사용하게 될 것임
                "http://localhost:5000/spring2pythonRequest",
                String.class
        );

        log.info("result = " + result);
        /*
           부가적으로 이 중간 부분에 추가적인 가공이 필요하다면
           처리된 결과인 result를 이 부분에서 가공하여 아래 html에서 처리를 하거나
           혹은 Vue로 보내서 출력하는 형식을 취해도 무방하다.
         */

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/pyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }

}
