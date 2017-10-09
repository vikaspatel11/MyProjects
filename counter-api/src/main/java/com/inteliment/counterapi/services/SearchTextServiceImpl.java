package com.inteliment.counterapi.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.inteliment.counterapi.beans.TextCount;
import com.inteliment.counterapi.utils.ServerContent;

@Service
public class SearchTextServiceImpl implements SearchTextService {

	public List<TextCount> countText(int count) {
		System.out.println("Inside service method....");
		List<TextCount> csvList = new ArrayList<TextCount>();
		String[] splits = ServerContent.content.split(" ");
		Map<String, Integer> textCount = new HashMap<String, Integer>();
		for (int i=0; i< splits.length;i++) {
			int counter = 0;
			for (int j=0; j<splits.length;j++) {
				if (splits[i].equalsIgnoreCase(splits[j])) {
					counter++;
				}
			}
			boolean isKeyPresent = false;
			for (String key: textCount.keySet()) {
				if (key.equalsIgnoreCase(splits[i])) {
					isKeyPresent = true;
					break;
				}
			}
			
			if (!isKeyPresent) {
				textCount.put(splits[i], counter);
			}
			
		}	
		
		List<Entry<String, Integer>> sortedList = textCountMapSortedByCount(textCount);
		
		for (int i=0; i<count;i++) {
			TextCount tc = new TextCount();
			tc.setText(sortedList.get(i).getKey());
			tc.setCount(sortedList.get(i).getValue());
			csvList.add(tc);
		}
		return csvList;
	}
	
	private <K,V extends Comparable<? super V>> List<Entry<K, V>> textCountMapSortedByCount(Map<K,V> map) {

		List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

		Collections.sort(sortedEntries, 
					new Comparator<Entry<K,V>>() {
	        @Override
	        public int compare(Entry<K,V> e1, Entry<K,V> e2) {
	            return e2.getValue().compareTo(e1.getValue());
	        }
		});
		return sortedEntries;
	}
}
