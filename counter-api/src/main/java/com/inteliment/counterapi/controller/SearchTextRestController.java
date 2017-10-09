package com.inteliment.counterapi.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inteliment.counterapi.beans.SearchTexts;
import com.inteliment.counterapi.beans.TextCount;
import com.inteliment.counterapi.services.SearchTextService;
import com.inteliment.counterapi.utils.ServerContent;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;


@RestController
public class SearchTextRestController {
	
	@Autowired
	SearchTextService searchService;
	@RequestMapping(value="/search", method = RequestMethod.POST) 
	public String searchText(@RequestBody SearchTexts searchTexts) {
		
		JSONObject outputObj = new JSONObject();
		JSONArray arr = new JSONArray();
		outputObj.put("Counts", arr);
		for (String text : searchTexts.searchText) {
			JSONObject obj = new JSONObject();

			Pattern p = Pattern.compile(text, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(ServerContent.content);
			int count = 0;
			while (m.find()){
			    count +=1;
			}
			
			obj.put(text, count);
			
			arr.put(obj);
		}
		
		return outputObj.toString();
	}
	
	
	@RequestMapping(value="top/{count}", produces = {"text/csv"})
	public void countTopTexts(@PathVariable int count, HttpServletResponse response) {
		System.out.println("Top:"+count);
		try {
			
		   List<TextCount> csvList = searchService.countText(count);
           StatefulBeanToCsv csv = new StatefulBeanToCsvBuilder(response.getWriter()).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator('|').build();
           csv.write(csvList);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	
}
