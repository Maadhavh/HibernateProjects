package com.jsp.core;

import java.util.Scanner;

import com.jsp.appservice.repository.AppHQLRepository;

public class App2 {

	public static void main(String[] args) {
		AppHQLRepository appHQLRepository = new AppHQLRepository();
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("Welcome to Instagram");
		System.out.println("Please enter your username and password to login");
		
		while(true) {

			System.out.println("Your UserName: ");
			String urName = sc.nextLine();
			
			System.out.println("Your Password: ");
			String urPswd = sc.nextLine();
			
			System.out.println("----------------------------------LOGIN----------------------------------");
			
			
			
			String userName = appHQLRepository.findByUserName(urName);
			
			if(userName != null &&userName.equals(urName)) {
				String pwrd = appHQLRepository.findByPassword(urPswd);
				
				if(pwrd.equals(urPswd)){
					System.out.println("You have successfully logged in to Instagram");
					break;
				} else {
					System.out.println("Please enter a correct password");
					continue;
				}
			}
			else {
				System.out.println("Please enter a correct userName");
				continue;
			}
		}
		
	}

}
