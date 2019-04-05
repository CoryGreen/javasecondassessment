package treasureswamp;

public abstract class StuckInTheSwamp {
	
	private int positionX;
	private int positionY;
	
	private int[] position = {positionX, positionY};
	
	public int[] getPosition() {
		return position;
	}
	
	public void setPosition(int[] position) {
		this.position = position;
	}

	public StuckInTheSwamp(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
}
