package com.example.demo;

import org.springframework.boot.*;
import org.springframework.core.annotation.*;
import org.springframework.stereotype.*;

@Component
@Order
public class Second implements CommandLineRunner{
	
@Override
		public void run(String...args) throws Exception{
			System.out.println("Second");
}

}
