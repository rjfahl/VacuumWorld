import java.lang.Math;
public class Vacuum {
	private Square location;
	private int moves = 0;
	private int totalSuck = 0;
	
	public void move(){
		boolean hasMoved = false;
		
		while(!hasMoved)
			hasMoved = tryToMoveVacuum((int)(Math.random() * 4));
				
		moves++;
	}
	
	private boolean tryToMoveVacuum(int move){
		switch(move){
		case 0: 
			if(canMoveNorth()){
				setLocation(location.getNorth());
				return true;
			}
			break;
		case 1: 
			if(canMoveSouth()){
				setLocation(location.getSouth());
				return true;
			}
			break;
		case 2: 
			if(canMoveEast()){
				setLocation(location.getEast());
				return true;
			}
			break;
		case 3: 
			if(canMoveWest()){
				setLocation(location.getWest());
				return true;
			}
			break;
		}
		return false;
	}
	
	public void suck(){
		if(location.dirty()){
			location.changeState();
			totalSuck++;
		}
	}
	
	public void setLocation(Square location){
		this.location = location;
	}
	
	public int getMoves(){
		return moves;
	}
	
	public int getNumSuck(){
		return totalSuck;
	}
	
	private boolean canMoveNorth(){
		return location.getNorth() != null;
	}
	
	private boolean canMoveSouth(){
		return location.getSouth() != null;
	}
	
	private boolean canMoveEast(){
		return location.getEast() != null;
	}
	
	private boolean canMoveWest(){
		return location.getWest() != null;
	}
}