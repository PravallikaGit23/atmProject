package com.abc.atm.client;   //password ,lines ,vs(grandtotal)

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.Scanner;

import com.atm.dto.LoginDTO;
import com.atm.dto.UserDTO;
import com.atm.login.LoginService;
import com.atm.registration.RegisterUser;
import com.atm.service.AtmServiceImpl;

public class AtmClient {

	public static void main(String[] args) throws InterruptedException {
		do {
			System.out.println("_______________________________________________1");
			System.out.println("--------------ABC BANK ATM-------------------- ");
			System.out.println("1.LOGIN");
			System.out.println("2.REGISTER FOR ATM SERVICES");

			System.out.println("-----------------------------------------------");
			System.out.println("ENTER YOUR CHOICE : ");
			Scanner optionPage = new Scanner(System.in);
			int option = 0;
			try {
				option = Integer.parseInt(optionPage.nextLine());
				System.out.println("________________________________________________2");
			} catch (NumberFormatException e) {
				System.out.println("please enter 1 or 2. NOT in word format.");
			}
			switch (option) {
			case (1): {

				Scanner sc = new Scanner(System.in);
				System.out.println("enter user name:");
				String userName = sc.nextLine();
				System.out.println("enter password: ");
				String userPassword = sc.nextLine();

				LoginDTO loginDTO = new LoginDTO();
				loginDTO.setUserName(userName);
				loginDTO.setPassWord(userPassword);

				UserDTO userDTO = LoginService.authenticateUser(loginDTO);

				if (userDTO.getPassWord() != null) {

					System.out.println("Hello ! " + userDTO.getUserName() + "  you are logged in...");
					System.out.println("_______________________________________");
					System.out.println("1.check balance .");
					System.out.println("2.withdrawl ");
					System.out.println("3.Deposit");
					System.out.println("4.account INFO");
					//System.out.println("5.Logout");
					System.out.println("Enter your option :");
					int useOption = 0;
					try {
						useOption = sc.nextInt();
						sc.nextLine();

					} catch (Exception e) {
						System.out.println("please enter the option number .please DO NOT enter in word format.");
						Thread.sleep(2000);
						System.out.println("you are logged out. please login for security purpose.");
						System.out.println("____________________________________________");

					}
					switch (useOption) {
					case 1: {
						System.out.println("your balance is " + userDTO.getAccBalance());
						System.out.println("_______________________________________");
						break;
					}
					case 2: {
						System.out.println("Enter amount to withdraw :");
						int withdrawlAmount = sc.nextInt();
						sc.nextLine();
						if (userDTO.getAccBalance() > (withdrawlAmount + 1000)) {
							AtmServiceImpl atmService = new AtmServiceImpl();
							int result = atmService.withDrawl(userDTO.getAccNumber(), withdrawlAmount);
							if (result == 1) {
								System.out.println("COLLECT YOUR CASH");
								System.out.println("_______________________________________");
							} else {
								System.out.println("Server is unavailble, please try after sometime");
							}

						} else {
							System.out.println("Insufficient funds. Minimum balance to be maitained is 1000");
						}
						break;
					}
					case 3: {
						System.out.println("keep your money aligned in proper manner and then enter the amount.");

						System.out.println("Enter amount to deposit :");

						int deposit = sc.nextInt();
						sc.nextLine();
						AtmServiceImpl atmService = new AtmServiceImpl();
						int result = atmService.deposit(userDTO.getAccNumber(), deposit);
						if (result == 1) {
							System.out.println("Amount deposited to your account.");
							System.out.println("_______________________________________");
						} else {
							System.out.println("Server is unavailble, please try after sometime");
						}

						// flag2 = false;
						break;
					}
					case 4: {
						System.out.println("account holder name is :   " + userDTO.getUserName());
						System.out.println("account number is :   " + userDTO.getAccNumber());
						System.out.println(" phone number :   " + userDTO.getPhone());
						System.out.println("your balance is :   " + userDTO.getAccBalance());
						System.out.println("email :    " + userDTO.getEmail());
						System.out.println("bank name :  " + userDTO.getBankName());
						System.out.println("home branch bank address :   " + userDTO.getBankAddress());
						System.out.println("_______________________________________");
						break;
					}
					
					default: {
						System.out.println("Please enter valid option .");
						break;
					}
					}
				} else {
					System.out.println("<---------invalid credentials. please enter valid credentials.-------->");
				}
				// rs.close();
				break;
			}
			case (2): {

				RegisterUser user = RegisterUser.registerUser();
				break;
			}
			default:
				System.out.println("PLEASE ENTER VALID OPTION : 1 OR 2:");
			}
		} while (true);

	}

}
