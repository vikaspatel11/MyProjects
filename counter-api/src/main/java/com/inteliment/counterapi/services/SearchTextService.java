package com.inteliment.counterapi.services;

import java.util.List;

import com.inteliment.counterapi.beans.TextCount;

public interface SearchTextService {

	public List<TextCount> countText(int count);
}
