package treasureswamp;

public class Player extends StuckInTheSwamp implements Compass {
	
	
	public Player(int positionX, int positionY) {
		super(positionX, positionY);
	}

	public int distanceToTreasure() {
		double distanceXToTravelSquared = Math.pow((this.getPositionX()-treasureXPosition), 2);
		double distanceYToTravelSquared = Math.pow((this.getPositionY()-treasureYPosition), 2);
		double distanceSquared = distanceXToTravelSquared + distanceYToTravelSquared;
		double distance = Math.pow(distanceSquared, 0.5);
		return (int) distance;
	}
	
	public void frustration(int numberOfTries) {
		switch (numberOfTries) {
		case 1:
			System.out.println("Not too long now, hopefully");
			break;
		case 2:
		case 3:
			System.out.println("A few more steps to go, possibly");
			break;
		case 4:
		case 5:
		case 6:
		case 7:
			break;
		case 8:
			System.out.println("Alright now this is taking a while");
		case 9:
			System.out.println("Seriously?!");
			break;
		case 10:
		case 11:
		case 12:
		case 13:
			break;
		default:
			System.out.println("So, it's now possible you might end up with nothing to show for this sordid adventure");
				
				
		}
	}
	
	public void frustration(boolean northTaken, boolean eastTaken, boolean southTaken, boolean westTaken) {
		if (northTaken && eastTaken && southTaken && westTaken) {
			System.out.println("Now you're just going round in circles");
		}
		else if ((northTaken && southTaken) || (eastTaken && westTaken)) {
			System.out.println("You're now going back the way you came!");
		}
	}
}
