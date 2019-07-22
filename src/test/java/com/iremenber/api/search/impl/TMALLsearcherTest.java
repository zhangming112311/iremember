package com.iremenber.api.search.impl;

import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.iremenber.api.vo.Mall;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TMALLsearcherTest {
	@Autowired
	private TMALLsearcher searcher;
	
	@Test
	public void testSearch() {
		Mall mall = searcher.search("哈曼卡顿音响");
		System.out.println(JSON.toJSONString(mall));
		assertTrue(StringUtils.isNoneBlank(mall.getName()));
		assertTrue(CollectionUtils.isNotEmpty(mall.getProducts()));;
	}
}
