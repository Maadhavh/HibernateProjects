package com.jsp.core;

import java.util.ArrayList;
import java.util.Scanner;

import com.jsp.appservice.dto.ApplicationDto;
import com.jsp.appservice.dto.ApplicationDto1;
import com.jsp.appservice.entity.ApplicationEntity;
import com.jsp.appservice.repository.ApplicationRepositiory1;

public class App1 
{	Scanner sc = new Scanner(System.in);
	public static void main( String[] args ) {
		ApplicationRepositiory1 repo = new ApplicationRepositiory1();
		
		ApplicationDto1 dto = new ApplicationDto1();
		dto.setAltKey(121);
		dto.setUserName("Mohan");
		dto.setPassword("1235");
		
		repo.update(dto);
	}
	

}