package treasureswamp;

public interface Compass {
	// technically it's not a compass. It's more like a radar
	int treasureXPosition = (int)(Math.random()*15);
	int treasureYPosition = (int)(Math.random()*15);
	Treasure treasure = new Treasure(treasureXPosition, treasureYPosition);
	int distanceToTreasure();
	
}
