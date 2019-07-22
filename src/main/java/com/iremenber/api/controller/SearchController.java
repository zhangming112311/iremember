package com.iremenber.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iremenber.api.search.SearchUtil;
import com.iremenber.api.vo.Mall;

@RestController
public class SearchController {
	private SearchUtil searchUtil;
    @RequestMapping(value="/search",method=RequestMethod.GET)
    public List<Mall> search(@RequestParam(name="keyWord") String keyWord){
		return searchUtil.search(keyWord);
    }
}