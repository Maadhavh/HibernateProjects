package com.jsp.core;

import java.util.List;
import java.util.stream.Collectors;

import com.jsp.appservice.entity.ApplicationEntity;
import com.jsp.appservice.repository.AppHQLRepository;

public class App2 {

	public static void main(String[] args) {
		AppHQLRepository appHQLRepository = new AppHQLRepository();
		
		//List<ApplicationEntity> appList = appHQLRepository.findAll();
		//List<ApplicationEntity> ls = appHQLRepository.findAl();
		
		//Approach 1:
//	
//		ls.forEach( each -> {
//		System.out.println(each);
//		});

		
		//This will return list of objects
		
		 /* appList.stream()
				.filter(each -> 
								each.getApplicationName()
								.equalsIgnoreCase("income tax"))
				.collect(Collectors.toList());
				
		
		//To get only one specific row having appname as income tax 
		
		/*  ApplicationEntity entity = appList.stream().filter( each ->
								each.getApplicationName()
								.equalsIgnoreCase("income tax")
								)
				.findAny()
				.orElse(null);
		System.out.println(entity);

		*/
		
		//Get rows by passing App Name
		//System.out.println(appHQLRepository.findByAppName("Game App"));
		
		//Update url using appName
		//appHQLRepository.updateUrlByAppName("https://www.IndianGames.com", "Game App");
		
		ApplicationEntity entity = appHQLRepository.findAll();
		System.out.println(entity);

	}

}
