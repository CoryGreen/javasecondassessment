package treasureswamp;

import java.util.Scanner;

public class Swamp {
	
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int positionX = 7;
		int positionY = 7;
		int swampThingPositionX = (int)(Math.random()*15);
		int swampThingPositionY = (int)(Math.random()*15);
		boolean youAwokeTheBeast = false;
		Player player = new Player(positionX, positionY);
		SwampThing swampThing = new SwampThing(swampThingPositionX, swampThingPositionY);
		exposition();
		boolean compassNotYetFineTuned = true;
		while (compassNotYetFineTuned) {
			System.out.println("Press T to fine-tune the compass");
			String fineTuning = sc.nextLine();
			fineTuning = fineTuning.toUpperCase();
			if (fineTuning.contentEquals("T")) {
				compassNotYetFineTuned = false;
			}
		}
		System.out.println("The compass whirrs to life and begins beeping, displaying a message");
		findTheTreasure(positionX, positionY, player, swampThing, youAwokeTheBeast);
		
		if ((player.distanceToTreasure() == 0) && (player.getPosition() != (swampThing.getPosition()))) {
			youWin();
		} else {
			System.out.println("As you keep walking you stike upon a solid object in the ground");
			System.out.println("Could it be the treasure?");
			if (player.distanceToTreasure() == 0) {
				System.out.println("It does seem about right");
			} else {
				System.out.println("The compass doesn't seem to agree");
			}
			System.out.println("Do you wish to reach in to the swamp to find out?");
			String willYou = sc.nextLine();
			willYou = willYou.toLowerCase();
			if (willYou.contains("yes")) {
				youAwokeTheBeast = true;
				System.out.println("What have you done? The swamp beneath you stirs");
				System.out.println("Shortly, a giant great beast emerges out of it");
				System.out.println("It observes you with an apparent look of annoyance");
				System.out.println("You immediately head towards the pick up point");
				System.out.println("You will not get the treasure today, but at least you may get out alive");
				double aChance = Math.random();
				if (aChance < 0.5) {
					System.out.println("The swamp creature makes short work of reaching you");
					youreDead();
				} else {
					System.out.println("The strange creature must have decided you are not worth the effort");
					System.out.println("It promptly returns to its slumber");
					System.out.println("Do you wish to return to the seach?");
					String willYouReturn = sc.nextLine();
					willYouReturn = willYouReturn.toLowerCase();
					if (willYouReturn.contentEquals("yes")) {
						findTheTreasure(positionX, positionY, player, swampThing, true);
					}
				}
			} else {
				System.out.println("You move on from the point. What might have been if you had been more curious?");
				positionX++;
				positionY++;
				player.setPositionX(positionX);
				player.setPositionY(positionY);
				findTheTreasure(positionX, positionY, player, swampThing, false);
				if (player.getPositionX()==swampThing.getPositionX() &&
						player.getPositionY()==swampThing.getPositionY()) {
					theBeastCatchesYou();
				}
			}
		}
		sc.close();
	}

	private static void youWin() {
		System.out.println("You found it!");
		System.out.println("Time to get out of this festid swamp!");
		System.out.println("Go get a nice long shower and decide on how to spend your fortune");
	}
	
	private static void exposition() {
		System.out.println("You find yourself right in the middle of the swamp");
		System.out.println("The so called Infinite Tessellating Swamp");
		System.out.println("Of course such a notion is absurd, you tell yourself");
		System.out.println("Any scholar worth one's salt knows that infinity is not a number");
		System.out.println("But it is quite a large swamp, the size of England, you've managed to gather");
		System.out.println("Luckily the treasure can't be too far away");
		System.out.println("The compass has pinpointed it to within 10 metres");
		System.out.println("Now that you are close you can finetune the compass");
	}
	private static void findTheTreasure(int positionX, int positionY,
			Player player, SwampThing swampThing, boolean youAwokeTheBeast) {
		if (youAwokeTheBeast) {
			System.out.println("You get back to the search, hoping the beast remains asleep");
			positionX = 0;
			positionY = 0;
		}
		boolean isNorthTaken = false;
		boolean isEastTaken = false;
		boolean isSouthTaken = false;
		boolean isWestTaken = false;
		int numberOfTries = 0;
		while ((player.distanceToTreasure() != 0) &&
				!(player.getPositionX() == swampThing.getPositionX() &&
				player.getPositionY() == swampThing.getPositionY())) {
			System.out.println("The treasure is " + player.distanceToTreasure() + " metres from the player");
			System.out.println("Would you like to go North, East, South, or West?");
			String newPlayerPosition = sc.nextLine();
			newPlayerPosition = newPlayerPosition.toLowerCase();
			switch (newPlayerPosition) {
			case "north":
				positionY++;
				player.setPositionY(positionY);
				isNorthTaken = true;
				break;
			case "east":
				positionX++;
				player.setPositionX(positionX);
				isEastTaken = true;
				break;
			case "south":
				positionY--;
				player.setPositionY(positionY);
				isSouthTaken = true;
				break;
			case "west":
				positionX--;
				player.setPositionX(positionX);
				isWestTaken = true;
				break;
				default:
					System.out.println("Please enter a valid input");
			}
			numberOfTries++;
			player.frustration(numberOfTries);
			player.frustration(isNorthTaken, isEastTaken, isSouthTaken, isWestTaken);
			if (youAwokeTheBeast) {
				double theBeastMightReturn = Math.random();
				if (theBeastMightReturn < 0.8) {
					continue;
				} else {
					theBeastCatchesYou();
				}
			}
		}
	}
		
	private static void theBeastCatchesYou() {
		System.out.println("There is a deep gurgling sound behind you");
		System.out.println("You turn around and find the beast staring back at you");
		youreDead();
	}
	
	public static void youreDead() {
		System.out.println("You will not be going home today, you will never return");
		System.out.println("Game Over");
	}
}
