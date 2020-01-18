package dev.fufa.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dev.fufa.entities.*;
import dev.fufa.services.UserService;
import dev.fufa.services.UserServiceImpl;
import dev.fufa.services.AccountService;
import dev.fufa.services.AccountServiceImpl;

public class UserApp { 

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		UserService us = new UserServiceImpl();            
		AccountService as = new AccountServiceImpl();      

		System.out.println("Welcome to ABC Bank!");
		int option;
		System.out.print("Press 1 to login:\n"           //This option is for users with account and for Supper User/SU_BMgr
				+ "Press 2 to create new account:\n"     // This option is for new and existing users to create account
				+ "Press 0 to exit system: \n");

		option = sc.nextInt();

		boolean currentUser = false;              // false means no one logged in, the current user not asked to login repeatdly
		User user = null;                         // null means, no body is logged in yet and is sure/accurate to use
		switch (option) {

		case 1:
			while (true) {
				try {
					if (!currentUser) {                                 // ! means if no body is logged in we do the options
						System.out.println("enter your username: ");
						String username = sc.nextLine();
						username = sc.nextLine();

						System.out.println("enter your password: ");
						String password = sc.nextLine();

						user = us.loginUser(username, password);
						currentUser = true; // True means some one is using;login so no request to loggin again
					}
					if (user.isStatus()) {

						if (!user.isIs_super_user()) {
							System.out.println("Options: ");
							System.out.println("press 1 to check balance: ");
							System.out.println("Press 2 to deposit: ");
							System.out.println("Press 3 to withdraw: ");
							System.out.println("Press 4 to delete account: ");
							System.out.println("Press 5 to view account: ");
							System.out.println("Press 0 to exit system: ");
							option = sc.nextInt();
						} else {
							System.out.println("Options: ");
							System.out.println("press 11 to approve users: ");
							System.out.println("press 22 to disapprove users: ");
							System.out.println("press 33 to create users: ");
							System.out.println("press 44 to view balance: ");
							System.out.println("Press 55 to update balance: ");
							System.out.println("Press 66 to delete all users: ");
							option = sc.nextInt();
						}
					} else {
						System.out.println("account disapproved! ");
						break;
					}

					switch (option) {
					case 1:
						List<Account> accounts = as.getAccountsForUser(user.getId());
						int b = 0;
						// System.out.println(user.getId());
						for (Account a : accounts) {
							if (a.getUserid() == user.getId()) {
								b += a.getBalance();
							}
						}
						System.out.println("The balance is: $" + b);
						break;
					case 2:
						System.out.println("Please enter Account ID:");
						int a_id = sc.nextInt();
						System.out.println("Thank you \n Enter deposit amount :");
						int amount = sc.nextInt();
						Account account = as.getAccountById(a_id);
						us.addAccountToBalance(account, amount);
						System.out.println("You deposited: $" + amount);
						break;
					case 3:
						System.out.println("Please enter Account ID:");
						int as_id = sc.nextInt();
						System.out.println("Thank you \n Enter withdrawal amount :");
						int amount_s = sc.nextInt();
						Account account_s = as.getAccountById(as_id);
						us.addAccountToBalance(account_s, amount_s);
						System.out.println("You withdraw:  $" + amount_s);
						break;
					case 4:
						System.out.println("Please enter Account ID:");
						int a_id1 = sc.nextInt();
						as.deleteAccount(a_id1);
						System.out.println(" Account deleted successfully");
						break;
					case 5:
						List<Account> accounts1 = as.getAccountsForUser(user.getId());

						for (Account a : accounts1) {
							System.out.println(a);
						}
						break;
						
						
						                         // loops for supper user (SU_BMgr)  11, 22, 33, 44, 55, 66
					case 11:
						System.out.println("Please enter User ID:");
						int u_id = sc.nextInt();
						User user1 = us.getUserById(u_id);
						user1.setStatus(true);
						us.updateUser(user1);
						System.out.println("User account approved!");

						System.out.println("\n\npress 1 to continue: ");
						System.out.println("Press 0  to exit: ");
						option = sc.nextInt();
						break;

					case 22:
						System.out.println("Please enter User ID:");
						int u_id1 = sc.nextInt();
						User user2 = us.getUserById(u_id1);
						user2.setStatus(false);
						us.updateUser(user2);
						System.out.println("User account denied!");

						System.out.println("\n\npress 1 to continue: ");
						System.out.println("Press 0  to exit: ");
						option = sc.nextInt();
						break;

					case 33:
						System.out.println("Please enter Account ID:");
						int u_id2 = sc.nextInt();
						User user_2 = us.getUserById(u_id2);
						System.out.println("Thank you!");
						us.getAccountsForUser(u_id2);
						System.out.println("User balance is: $" /* print the balance */ );
						break;
					case 44:

						for (User u : us.getAllUsers()) {
							for (Account a : as.getAccountsForUser(u.getId())) {
								System.out.println(a);
							}
						}

						break;
						
					case 55:
						System.out.println("Please enter Account ID:");
						int u_id3 = sc.nextInt();
						System.out.println("Please enter amount:");
						int newBalance = sc.nextInt();
						Account a1 = as.getAccountById(u_id3);
						a1.setBalance(newBalance);
						as.updateAccount(a1);
						System.out.println(" Account updated successfully!");
						break;
						
					case 66:               //Option to delete all users: Warning! Do not use this option unless necessary!!
						for (User u : us.getAllUsers()) {          // This loop calls for all accounts deleted by u_ID first
							if (!u.isIs_super_user()) {                   //!u = delete all except for the SU/BMgr
								for (Account a : as.getAccountsForUser(u.getId())) {
									as.deleteAccount(a.getId());             // delete account by id
								}
								us.deleteById(u.getId()); // delete user by id
							}
						}
						System.out.println(" All account deleted successfully");
					default:
						break;
					}

					System.out.println("\n\npress 1 to continue: ");
					System.out.println("Press 0 to exit: ");
					option = sc.nextInt();

				} catch (Exception e) {
					System.out.println("Incorrect entry ");
					System.out.println("Options: ");
					System.out.println("press 1 to continue: ");
					System.out.println("Press 0  to exit: ");
					option = sc.nextInt();
				}
				if (option == 1) {
					continue;
				}
				if (option == 0) {
					us.logoutUser();
					break;
				}
			}

			option = sc.nextInt();
			
			                   // case 2 = to create new accounts / New and existing users /

		case 2:
			System.out.println("Welcome! ");
			System.out.println("create username: ");
			String username = sc.nextLine();
			username = sc.nextLine();

			System.out.println("create password: ");
			String password = sc.nextLine();

			System.out.println("Successfully created!!!");

			System.out.println("\n\npress 1 to continue: ");
			System.out.println("Press 0  to exit: ");

			option = sc.nextInt();

			break;

		}

	}

}
		


























     

 /*Example: some UserApp Console input and outputs
****************************************************
****************************************************
Welcome to ABC Bank!
  
Press 1 to login:                         // Option#1 = for users with account and for the SU/Manager(SU_BMgr). 
Press 2 to create new account:            // Option #2 is for NEW and existing users to create account
Press 0 to exit system: 
    1

enter your username:                  //for incorrect entry the app denies and gives more options to continue or exit
   gzjhdgs
enter your password:   
   sds
Incorrect entry 

Options: 
press 1 to continue: 
Press 0  to exit: 
1

enter your username:   //For correct user/SU entry. Here we have SU/Manager(SU_BMgr) and he can do multiple jobs. Look his options below..
SU_BMgr
enter your password: 
ab222

Options: 
press 11 to approve users: 
press 22 to disapprove users: 
press 33 to create users: 
press 44 to view balance: 
Press 55 to update balance: 
Press 66 to delete all users: 
11

Please enter User ID:    // Option 11 is to approve users by "u_id" to access in to their accounts. Option 22 is to disapprove user.
1                        // The super user gets the existing user by u_id and approves or disaaproves
User account approved!


press 1 to continue:     // Then the SU/BMgr can continue for other options or can exit 
Press 0  to exit: 
0








 

 */

























           /* Project Instructions:    
 * ***********************************************************************
 * ************************************************************************
 * 1.Bank Assignment
 * 2.Console application: 
 * 3.A registered user can login with their username and password  
 * 4.An unregistered user can register by creating a username and password 
 * 5.A superuser can view, create, update, and delete all users.
 * 6.A user can view their own existing accounts and balances. 
 * 7.A user can create an account.
 * 8.A user can delete an account if it is empty.  
 * 9.A user can add to or withdraw from an account. 
 * 10.A user can execute multiple deposits or withdrawals in a session. 
 * 12.A user can logout. 
 * 13.Use sequences to generate USER_ID and BANK_ACCOUNT_ID. 
 * 14.Provide validation messages through the console for all user actions. 
 * 15.Use the DAO design pattern. 
 * 16.Store database connection information in a properties file. 
       // Required technologies: 
 * PL/SQL with at least one stored procedure, JDBC with prepared and callable statements,
 * Scanner for user input.
 
       /* Bonus:
 *  
 * 17.A user's transactions are recorded.
 * 18.A user may view transaction history. 
 * 19.JUnit tests on DAO methods.
 *  
 */
 
 