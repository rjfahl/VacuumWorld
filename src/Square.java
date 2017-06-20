public class Square {
	private boolean dirty;
	private Square north,south,east,west = null;
	
	public Square(boolean dirty){
		this.dirty = dirty;
	}
	
	public Square(boolean dirty, Square north, Square south, Square east, Square west){
		this.dirty = dirty;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}
	
	public boolean dirty(){
		return dirty;
	}
	
	public void changeState(){
		if(dirty)
			dirty = false;
		else
			dirty = true;
	}

	public Square getNorth() {
		return north;
	}

	public void setNorth(Square north) {
		this.north = north;
	}

	public Square getSouth() {
		return south;
	}

	public void setSouth(Square south) {
		this.south = south;
	}

	public Square getEast() {
		return east;
	}

	public void setEast(Square east) {
		this.east = east;
	}

	public Square getWest() {
		return west;
	}

	public void setWest(Square west) {
		this.west = west;
	}
	
	public String toString(){
		if(dirty)
			return "D";
		else
			return "C";
	}
}