package com.iremenber.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iremenber.api.vo.Product;
import com.iremenber.api.webmagic.SearchUtil;

@RestController
public class SearchController {
    
    @RequestMapping(value="/search",method=RequestMethod.GET)
    public List<Product> search(@RequestParam(name="keyWord") String keyWord){
		return SearchUtil.search(keyWord);
    }
}