package com.app.main;

import java.util.List;
import java.util.Scanner;

import com.app.bo.PlayerBO;
import com.app.bo.impl.PlayerBoImpl;
import com.app.exception.BusinessException;
import com.app.model.Player;

public class PlayerMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Player App");
		Scanner scanner = new Scanner(System.in);
		PlayerBO playerBO = new PlayerBoImpl();
		int ch = 0;
		do {
			System.out.println("Player Menu");
			System.out.println("----------------");
			System.out.println("1)Add Player");
			System.out.println("2)Remove Player");
			System.out.println("3)Search Player By id");
			System.out.println("4)Get All Players");
			System.out.println("5)Search Players By Gender");
			System.out.println("6)Search Players By Age");
			System.out.println("7)Search Players By Age Range");
			System.out.println("8)Search Players By Name");
			System.out.println("9)Search Players By TeamName");
			System.out.println("10)EXIT");
			System.out.println("Enter your choice");
			ch = Integer.parseInt(scanner.nextLine());

			switch (ch) {
			case 1:
				System.out.println("Enter Player details");
				System.out.println("Enter Player Id");
				int id = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter player name");
				String name = scanner.nextLine();
				System.out.println("Enter player teamName");
				String teamName = scanner.nextLine();
				System.out.println("Enter player age");
				int age = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter Player Gender(m/f/o)");
				String gender = scanner.nextLine();
				Player player = new Player(id, name, teamName, age, gender);

				try {
					player = playerBO.createPlayer(player);
					if (player != null && player.getId() != 0) {
						System.out.println("Player created with below details");
						System.out.println(player);
					}
				} catch (BusinessException e1) {
					System.out.println(e1.getMessage());
				}

				break;
			case 2:
				System.out.println("Enter id to delete");
				int id8 = Integer.parseInt(scanner.nextLine());
				try {
					playerBO.removePlayerById(id8);
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter player id for player details");
				int id1 = Integer.parseInt(scanner.nextLine());
				try {
					Player p = playerBO.getPlayerById(id1);
					if (p != null) {
						System.out.println("Player with id " + id1 + " found with details ");
						System.out.println(p);
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:
				try {
					List<Player> playerList = playerBO.getAllPlayers();
					if (playerList != null && playerList.size() > 0) {
						System.out.println("Total there are " + playerList.size() + " no of players.. Details are");
						for (Player p1 : playerList) {
							System.out.println(p1);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println("Enter gender(m/f/o) to get the players list");
				String gender1 = scanner.nextLine();
				try {
					List<Player> playerList = playerBO.getPlayersByGender(gender1);
					if (playerList != null && playerList.size() > 0) {
						System.out.println("Total there are " + playerList.size() + " no of players..with gender "
								+ gender1 + " Details are");
						for (Player p1 : playerList) {
							System.out.println(p1);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("Enter age to get the players list");
				int age1 = Integer.parseInt(scanner.nextLine());
				try {
					List<Player> playerList = playerBO.getPlayersByAge(age1);
					if (playerList != null && playerList.size() > 0) {
						System.out.println("Total there are " + playerList.size() + " no of players..with age " + age1
								+ " Details are");
						for (Player p1 : playerList) {
							System.out.println(p1);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 7:
				System.out.println("Enter upper and lower age to get the players list");
				int upper = Integer.parseInt(scanner.nextLine());
				int lower = Integer.parseInt(scanner.nextLine());
				try {
					List<Player> playerList = playerBO.getPlayersByAgeRange(upper, lower);
					if (playerList != null && playerList.size() > 0) {
						System.out.println("Total there are " + playerList.size()
								+ " no of players..with the req range Details are");
						for (Player p1 : playerList) {
							System.out.println(p1);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 9:
				System.out.println("Enter team name");
				String teamname1 = scanner.nextLine();
				try {
					List<Player> playerList = playerBO.getPlayersByTeamName(teamname1);
					if (playerList != null && playerList.size() > 0) {
						System.out.println("Total there are " + playerList.size()
								+ " no of players..with the req range Details are");
						for (Player p1 : playerList) {
							System.out.println(p1);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				System.out.println("Enter player name");
				String name1 = scanner.nextLine();
				try {
					List<Player> playerList = playerBO.getPlayersByName(name1);
					if (playerList != null && playerList.size() > 0) {
						System.out.println("Total there are " + playerList.size()
								+ " no of players..with the req range Details are");
						for (Player p1 : playerList) {
							System.out.println(p1);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 10:
				System.out.println("Thank you for using our app");

				break;

			default:
				System.out.println("Invalid option Try again");
				break;
			}
		} while (ch != 9);
	}

}
