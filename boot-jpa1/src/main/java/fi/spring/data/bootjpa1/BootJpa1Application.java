package fi.spring.data.bootjpa1;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fi.spring.data.bootjpa1.entity.Users;
import fi.spring.data.bootjpa1.repository.UsersRepository;

@SpringBootApplication
public class BootJpa1Application
implements CommandLineRunner{
@Autowired
UsersRepository userRepo; 
	public static void main(String[] args) {
		SpringApplication.run(BootJpa1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		//getUserDetails();
	//listAllUsers();
		try {
			Scanner scanner =new Scanner(System.in);
					System.out.println("enter the  name to serch");
			String name = scanner.next();
		Users objUser=userRepo.findbyName(name);
		System.out.println("***********************");
		System.out.println(objUser.getUserName());
		System.out.println(objUser.getPassword());
		System.out.println(objUser.getName());
		System.out.println(objUser.getEmail());
		System.out.println("***********************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private void listAllUsers() {
		List<Users> allUsers= userRepo.findAll();
		for(Users objUser : allUsers) {
			System.out.println("***********************");
			System.out.println(objUser.getUserName());
			System.out.println(objUser.getPassword());
			System.out.println(objUser.getName());
			System.out.println(objUser.getEmail());
			System.out.println("***********************");
		}
	}

	private void getUserDetails() {
		try {
			Scanner scanner =new Scanner(System.in);
					System.out.println("enter the user name to serch");
			String userName = scanner.next();
			Optional <Users> tmpUser	=userRepo.findById("mahi");
if(!tmpUser.isEmpty()) {
			
Users objUser =tmpUser.get();
System.out.println(objUser.getUserName());
System.out.println(objUser.getPassword());
System.out.println(objUser.getName());
System.out.println(objUser.getEmail());



}
else
			System.out.println("no such users found");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
