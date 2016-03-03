import java.util.Scanner;
import java.util.Random;


public class Zork {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		int secret = rnd.nextInt(4);
		int roomsEntered = 0;
		int[] entryFlag = new int[8];
		for(int i = 0; i < 8; i++)
		{
			entryFlag[i] = 0;
		}
		

		roomsEntered = foyer(sc, entryFlag, secret);
		
		sc.close();
		System.out.printf("You entered %d rooms.%n", roomsEntered);
		
		int isFollowed = rnd.nextInt(4);
		if (isFollowed == 0)
		{
			System.out.println("You have been followed.");
		}
		else 
		{
			System.out.println("You are safe...for now.");
		}
	}

	public static int foyer(Scanner sc, int[] entryFlag, int secret) 
	{
		entryFlag[0] = 1;
		
		System.out.println("You are standing in the foyer.");
		System.out.println("You see a dead scorpion.");
		
		System.out.println("You can (1) exit to the south, or (2) exit to the north.");
		int choice = choiceValidator(sc, 2);
		if(choice == 1)
		{
			//Exits house
		}
		else
		{
			frontRoom(sc, entryFlag, secret);
		}

		int totalRooms = totalRoomsEntered(entryFlag);
		return totalRooms;
	}

	public static void frontRoom(Scanner sc, int[] entryFlag, int secret) 
	{
		entryFlag[1] = 1;
		
		System.out.println("You are standing in the front room.");
		System.out.println("You see a piano.");
		
		System.out.println("You can (1) exit to the west, (2) exit to the east, or (3) exit to the south.");
		int choice = choiceValidator(sc, 3);
		if(choice == 1)
		{
			library(sc, entryFlag, secret);
		}
		else if (choice == 2)
		{
			kitchen(sc, entryFlag, secret);
		}
		else
		{
			foyer(sc, entryFlag, secret);
		}
		
	}

	public static void library(Scanner sc, int[] entryFlag, int secret) 
	{
		entryFlag[2] = 1;
		
		System.out.println("You are standing in the library.");
		System.out.println("You see spiders.");

		System.out.println("You can (1) exit to the north, or (2) exit to the east.");
		int choice = choiceValidator(sc, 2);
		if (choice == 1)
		{
			diningRoom(sc, entryFlag, secret);
		}
		else {
			frontRoom(sc, entryFlag, secret);
		}
	}

	public static void kitchen(Scanner sc, int[] entryFlag, int secret) 
	{
		entryFlag[3] = 1;
		
		System.out.println("You are standing in the kitchen.");
		System.out.println("You see bats.");

		System.out.println("You can (1) exit to the north, or (2) exit to the west.");
		int choice = choiceValidator(sc, 2);
		if (choice == 1)
		{
			parlor(sc, entryFlag, secret);
		}
		else 
		{
			frontRoom(sc, entryFlag, secret);
		}
		
		
	}

	public static void diningRoom(Scanner sc, int[] entryFlag, int secret) 
	{
		entryFlag[4] = 1;
		
		System.out.println("You are standing in the dining room.");
		System.out.println("You see dust and an empty box.");
		
		System.out.println("You can (1) exit to the south.");
		int choice = choiceValidator(sc, 1);

		library(sc, entryFlag, secret);
	}

	public static void vault(Scanner sc, int[] entryFlag, int secret) 
	{
		entryFlag[5] = 1;
		int choice;
		
		System.out.println("You are standing in the vault.");
		System.out.println("You see 3 walking skeletons.");
		
		if (secret == 0)
		{
			System.out.println("You can (1) exit to parlor, or (2) exit to the secret room.");
			choice = choiceValidator(sc, 2);
			if (choice == 1)
			{
				parlor(sc, entryFlag, secret);
			}
			else
			{
				secretRoom(sc, entryFlag, secret);
			}
		}
		else 
		{
			System.out.println("You can (1) exit to the east.");
			choice = choiceValidator(sc, 1);
			parlor(sc, entryFlag, secret);
		}
	}

	public static void parlor(Scanner sc, int[] entryFlag, int secret) 
	{
		entryFlag[6] = 1;
		
		System.out.println("You are standing in the parlor.");
		System.out.println("You see a treasure chest.");

		System.out.println("You can (1) exit to the south, or (2) exit to the west.");
		int choice = choiceValidator(sc, 2);
		
		if (choice == 1)
		{
			kitchen(sc, entryFlag, secret);
		}
		else
		{
			vault(sc, entryFlag, secret);
		}
	}

	public static void secretRoom(Scanner sc, int[] entryFlag, int secret) 
	{
		entryFlag[7] = 1;
		
		System.out.println("You are standing in the secret room.");
		System.out.println("You see piles of gold.");

		System.out.println("You can (1) exit to the west");
		int choice = choiceValidator(sc, 1);
		
		vault(sc, entryFlag, secret);
		
	}
	
	public static int totalRoomsEntered(int[] entryFlag)
	{
		int totalRooms = 0;
		for(int i = 0; i < entryFlag.length; i++)
		{
			totalRooms += entryFlag[i];
		}
		return totalRooms;
	}
	
	public static int choiceValidator(Scanner sc, int max)
	{
		int choice =  sc.nextInt();
		while(choice < 1 || choice > max)
		{
			System.out.printf("Invalid choice, choose between 1 and %d.%n", max);
			choice = sc.nextInt();
		}
		return choice;
	}
}
