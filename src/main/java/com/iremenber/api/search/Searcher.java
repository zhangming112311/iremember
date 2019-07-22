package com.iremenber.api.search;

import com.iremenber.api.vo.Mall;

public interface Searcher {
	Mall search(String keyWord);
}
