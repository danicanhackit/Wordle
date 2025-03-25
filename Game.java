import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{
	
	private BufferedImage back; 
	
    private ArrayList<String> words = setWordList();

    private String selectedWord = words.get(generateRandomNum(0,words.size()-1));
    private int wordLength = selectedWord.length();
    private Tile [][] tiles = new Tile[5][wordLength];

	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
	
        setGrid();
		System.out.println(selectedWord);
		
	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
        drawGrid(g2d);
		
		twoDgraph.drawImage(back, null, 0, 0);

	}

    public void drawGrid(Graphics g2d){
        for(int r=0; r<tiles.length; r++){
            for(int c=0; c<tiles[r].length; c++){
                tiles[r][c].drawTile(g2d);
            }
        }
    }

    public void setGrid(){
        int x = 100;
        int y = 100;
        for(int r=0; r<tiles.length; r++){
            for(int c=0; c<tiles[r].length; c++){
                tiles[r][c] = new Tile(x, y, 'a');
                x+=110;
            }
            x=100;
            y+=110;
        }
    }
	
    public ArrayList<String> setWordList(){
        ArrayList<String> temp = new ArrayList<String>();
        File file = new File("words.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                temp.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return temp;
    }
	
    public int generateRandomNum(int min, int max){
        return (int)(Math.random()*(max-min)+min)+1;
    }


	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




    //DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	
	

	
}
