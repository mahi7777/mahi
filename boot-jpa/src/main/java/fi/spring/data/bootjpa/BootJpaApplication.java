package fi.spring.data.bootjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fi.spring.data.bootjpa.entity.User;
import fi.spring.data.bootjpa.repository.UserRepository;

@SpringBootApplication
public class BootJpaApplication  implements CommandLineRunner{
@Autowired
UserRepository userRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
			Scanner scanner= new Scanner(System.in);
			
					while (true) {
						System.out.println("Enter the user name");
						String userName = scanner.next();
						System.out.println("Enter the user new password");
						String password = scanner.next();
						
						userRepo.changePassword(userName, password);
						
						System.out.println("password changed.........");
					listAllUsers();
					
						
					}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void getByEmail() {
		try {
			Scanner scanner= new Scanner(System.in);
			boolean running = true;
			while(running) {
				System.out.println("Enter email to search");
				String email = scanner.next();
				if(email.equals("exit")) {
					running = false;
					return;
					
				}
				Optional<User> tmpUser = userRepo.findByEmail(email);
				if(!tmpUser.isEmpty())
				{
					User objUser = tmpUser.get();
					System.out.println(objUser.getUserName());
					System.out.println(objUser.getPassword());
					System.out.println(objUser.getName());
					System.out.println(objUser.getEmail());
				}
				else
					System.out.println("no such user found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		void listAllUsers() {
			List<User> allUsers=userRepo.findAll();
			for(User objUser:allUsers) {
				System.out.println(objUser.getUserName());
				System.out.println(objUser.getPassword());
				System.out.println(objUser.getName());
				System.out.println(objUser.getEmail());
				System.out.println("**************************");
			}
			
		
		

}


	
}	

