import java.lang.Math;
public class Environment {
	private Square floor[][];
	private Vacuum vacuum;
	private int x, y = 0;
	
	public Environment(Vacuum vacuum, int y, int x){
		this.vacuum = vacuum;
		this.x = x;
		this.y = y;
		
		createFloorAndRandomlySetState();
		run();
	}
	
	public Environment(Vacuum vacuum, Square floor[][]){
		this.vacuum = vacuum;
		this.floor = floor;
		x = this.floor.length;
		y = this.floor[0].length;
		
		run();
	}
	
	private void run(){
		generateVacuumLocation();
		displayInitialFloor();
		cleanTheFloor();
		displayFinalSummary();
	}
	
	private void createFloorAndRandomlySetState(){
		initializeFloor();
		generateSquares();
		linkSquaresAndRandomlySetDirty();
	}
	
	private void initializeFloor(){
		floor = new Square[x][y];
	}
	
	private void generateSquares(){
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				floor[i][j] = new Square(false);
	}
	
	private void linkSquaresAndRandomlySetDirty(){
		for(int i = 0; i < x; i++){
			for(int j = 0; j< y; j++){
				linkEastWestSquares(i, j);
				linkNorthWestSquares(i, j);
				randomlyChangeState(i, j);
			}
		}
	}
	
	private void linkEastWestSquares(int i, int j){
		if(i > 0 && x > 1){
			floor[i - 1][j].setEast(floor[i][j]);
			floor[i][j].setWest(floor[i-1][j]);
		}
	}
	
	private void linkNorthWestSquares(int i, int j){
		if(j > 0 && y > 1){
			floor[i][j-1].setSouth(floor[i][j]);
			floor[i][j].setNorth(floor[i][j-1]);
		}
	}
	
	private void randomlyChangeState(int i, int j){
		if(randomlyChangeState())
			floor[i][j].changeState();
	}
	
	private boolean randomlyChangeState(){
		return (Math.random() > .5);
	}
	
	private void generateVacuumLocation(){
		int randX;
		int randY;
		
		do{
			randX = (int)(Math.random() * x);
			randY = (int)(Math.random() * y);
		}while(floor[randX][randY] == null);
		
		vacuum.setLocation(floor[randX][randY]);
	}

	private void displayInitialFloor(){
		System.out.println("Initial");
		displayFloor();
	}
	
	private void cleanTheFloor(){
		while(!checkIfFloorIsClean())
			cleanAndMoveVacuum();
	}
	
	private void cleanAndMoveVacuum(){
		vacuum.suck();
		vacuum.move();
	}
	
	private void displayFinalSummary(){
		System.out.println("Final");
		displayFloor();
		
		System.out.println("\nThe vacuum moved: " + vacuum.getMoves() + " times");
		System.out.println("The vacuum sucked: " + vacuum.getNumSuck() + " times\n");
	}
	
	private void displayFloor(){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++)
				printFloorPiece(i, j);
			System.out.println();
		}
	}
	
	private void printFloorPiece(int i, int j){
		if(floor[i][j] == null)
			System.out.print(" N ");
		else
			System.out.print(" " + floor[i][j] + " ");
	}
	
	private boolean checkIfFloorIsClean(){
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				if(!checkIfFloorPieceIsClean(i, j))
					return false;
		return true;
	}
	
	private boolean checkIfFloorPieceIsClean(int i, int j){
		try{
			if(floor[i][j].dirty())
				return false;
		}catch(Exception e){}
		return true;
	}
}