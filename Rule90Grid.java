
public class Rule90Grid implements Runnable{
	private boolean[] grid;
	private int length, width;
	private Grid myGrid;
	private Thread gridThread;
	public Rule90Grid(int length,int width,Grid myGrid) {
		grid = new boolean[length*width];
		this.length = length;
		this.width = width;
		this.myGrid = myGrid;
		initalizeGrid();
		gridThread = new Thread(this);
		gridThread.start();
	}
	private void initalizeGrid() {
		for(int i = 0; i < grid.length; i++) {
			grid[i] = true;
		}
	}
	public boolean[][] shapeGrid() {
		boolean[][] temp = new boolean[length][width];
		int k = 0;
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				temp[i][j] = grid[k++];
			}
		}
		return temp;
	}
	public void update() {
		
	}
	@Override
	public void run() {
		while(true) {
			boolean[][] temp = shapeGrid();
			for(int i = 1; i < temp.length; i++) {
				for(int j = 1; j < temp[0].length-1; j++) {
					temp[i][j] = temp[i-1][j-1]^temp[i-1][j+1];
				}
			}
			for(int i = 0; i < temp.length; i++) {
				for(int j = 0; j < temp[0].length; j++) {
					myGrid.getGrid()[i][j].fill(temp[i][j]);
				}
			}
			initalizeGrid();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}	
}
