/*package com.cts.Flexride;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Flexride.Entity.AdminEntity;
import com.cts.Flexride.Repo.AdminRepo;
import com.cts.Flexride.Service.AdminService;

@RestController
@SpringBootApplication
public class FlexrideApplication implements CommandLineRunner {
    
	@Autowired
	private AdminService adminservice;
	public static void main(String[] args) {
		SpringApplication.run(FlexrideApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
*/

package com.cts.Flexride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cts.Flexride.Entity.AdminEntity;
import com.cts.Flexride.Service.AdminService;
 
@SpringBootApplication
public class FlexrideApplication  {
 
    @Autowired
    private AdminService adminService;
    
    public static void main(String[] args) {
SpringApplication.run(FlexrideApplication.class, args);
    }
 
//    @Override
//    public void run(String... args) throws Exception {
//        // Create and set admin details (id will be auto-generated)
//        AdminEntity admin = new AdminEntity();
//        admin.setName("Anushka");
//        admin.setPhnumber(9433343018L);
//        admin.setEmail("anushkasamanta@gmail.com");
//        admin.setPassword("23455678");
//        
//        // Save admin details into the database
//        adminService.saveAdmin(admin);
//        System.out.println("Admin details have been stored in the database.");
//    }
}
