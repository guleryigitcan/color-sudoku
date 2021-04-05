package PROJECT;
import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Jframe extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar mbar;
	private JMenu gameSettings;
	private JMenuItem showAnswers,Control,newGame;
	
	private Border redborder=BorderFactory.createLineBorder(Color.RED,5);
	private Border grayborder=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
	
	public int testsudoku[][]=new int[][]{
		  {6,2,8,1,3,7,9,5,4},                       
		  {1,9,4,8,2,5,6,7,3},
		  {3,5,7,6,4,9,1,8,2},
		  {8,7,9,2,4,6,3,1,5},                  
		  {4,1,2,3,5,7,9,8,6},
		  {5,6,3,8,9,1,7,2,4},
		  {5,8,2,4,9,3,7,6,1},
		  {7,3,9,5,6,1,2,4,8},
		  {4,1,6,2,7,8,9,3,5},
		  
	};
	ArrayList <JButton> butonkontrol = new ArrayList <JButton> ();
	buttonMaker ad=new buttonMaker();
	Random rd=new Random();	
	
																
	
	
	
	
	public void matrixMixer(int a[][]) {
		int temp;
		int b=0;
		int c=3;
		int d=6;
		int x=0;
		for(int i=0;i<9;i++) {
			x=0;
				for(int j=0;j<3;j++) {
				temp=a[i][x];
				a[i][x]=a[i][x+1];
				a[i][x+1]=temp;
				x=x+3;
				}
			}
		
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<6;j++) {
				temp=a[i][j];
				a[i][j]=a[i][j+3];
				a[i][j+3]=temp;
			}
		}
		
		
		for(int i=0;i<2;i++) {
			
			for(int j=0;j<9;j++) {
				temp=a[b][j];
				a[b][j]=a[b+1][j];
				a[b+1][j]=temp;
				
			}
			b=b+1;
		}
		
		
		for(int i=0;i<2;i++) {
			
			for(int j=0;j<9;j++) {
				temp=a[c][j];
				a[c][j]=a[c+1][j];
				a[c+1][j]=temp;
				
			}
			c=c+1;
		}
		
		for(int i=0;i<2;i++) {
			
			for(int j=0;j<9;j++) {
				temp=a[d][j];
				a[d][j]=a[d+1][j];
				a[d+1][j]=temp;
				
			}
			d=d+1;
		}
	}

	
	
	




public int findLocation(int a[][],int b,int c) {// finds which button
	int buton=0;
	if(b>0) {
	for(int i=0;i<b;i++) {
		
		buton=buton+9;
	
		}

	buton=buton+c;

	}
	else if (b==0) {
		buton=0;
		buton=buton+c;
	
	}
	return buton;
	}


public Jframe() {
	
	Board(testsudoku);
	
	
	
			mbar = new JMenuBar();
			gameSettings = new JMenu("GAME SETTINGS");
			showAnswers = new JMenuItem("SHOW ANSWERS");
			Control=new JMenuItem("CONTROL");
			newGame=new JMenuItem("NEW GAME");
			
			newGame.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					newgame();
					
					
				}
			});
			
			
			Control.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					control(testsudoku);
					
					
					
					
				}
			});
			
			mbar.add(gameSettings);
			showAnswers.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					showAnswer(testsudoku);
				}
			});
			
			
			gameSettings.add(showAnswers);
			gameSettings.add(Control);
			gameSettings.add(newGame);
			
			setJMenuBar(mbar);
			randomColor(testsudoku);
	
	
}


public  void Board(int a[][]) {
	JPanel board=new JPanel();
	
	board.setLayout(new GridLayout(3, 3));
	board.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	for(int row=0;row<3;++row) {
		for(int col=0;col<3;++col) {
			JPanel box=new JPanel(new GridLayout(3, 3));
			box.setBorder(grayborder);
			for(int cell=0;cell<9;++cell) {
				buttonMaker ad=new buttonMaker();
				ad.setBorder(grayborder);
				box.add(ad);
				butonkontrol.add(ad);
				ad.setOpaque(true);
				
				
				}
				
			
			
			
			board.add(box);
			
			
			
			
			
		}
		
		
	}
	
	Container pane=getContentPane();
	pane.setLayout(new BorderLayout());
	pane.add(board);
	

	
	
}


public void randomColor(int a[][]) {
	int sayý;
	int x;
	
	for(int i=0;i<9;i++) {
		for(int j=0;j<8;j++) {
			sayý=rd.nextInt(8)+1;
			
			
			x=a[i][sayý];
			
			switch(x) {
			case 1:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.BLACK);
			break;
			
			case 2:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.RED);
			break;
			
			case 3:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.YELLOW);
			break;
			
			case 4:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.BLUE);
			break;
			
			case 5:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.GREEN);
			break;
			
			case 6:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.ORANGE);
			break;
			
			case 7:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.PINK);
			break;
			
			case 8:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.GRAY);
			break;
			
			case 9:butonkontrol.get(findLocation(testsudoku, i, sayý)).setBackground(Color.CYAN);
			break;
			
			}
			
			
			
		}
	}
	
	
}

public void newgame() {
	for(int i=0;i<81;i++) {
		butonkontrol.get(i).setBackground(null);
		butonkontrol.get(i).setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
		
		
	}
	matrixMixer(testsudoku);
	
	randomColor(testsudoku);
}

public void showAnswer(int a[][]) {
	int x;
	
	
	for(int i=0;i<9;i++) {
		for(int j=0;j<9;j++) {
			
			x=a[i][j];
			switch(x) {
			
			case 1:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.BLACK);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			
			case 2:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.RED);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			
			case 3:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.YELLOW);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			
			case 4:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.BLUE);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			
			case 5:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.GREEN);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			
			case 6:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.ORANGE);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			
			case 7:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.PINK);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			
			case 8:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.GRAY);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			
			case 9:butonkontrol.get(findLocation(testsudoku, i, j)).setBackground(Color.CYAN);
			
			butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
			break;
			}
		}
	}
}
                                  







public void check() {// for JOption pane 
	int aa=0;
	for(int i=0;i<81;i++) {
		if(butonkontrol.get(i).getBorder()==redborder)
			aa++;
	}
	if(aa==0)
		JOptionPane.showMessageDialog(null, "Congratulations!", "DONE!", JOptionPane.INFORMATION_MESSAGE);
}

public void control(int a[][]) {
	int x;
	
	for(int i=0;i<9;i++) {
		for(int j=0;j<9;j++) {
			
			
			x=a[i][j];
			
			switch(x) {
			
			case 1:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.BLACK) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.BLACK)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			
			case 2:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.RED) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.RED)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			
			case 3:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.YELLOW) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.YELLOW)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			
			case 4:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.BLUE) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.BLUE)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			
			case 5:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.GREEN) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.GREEN)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			
			case 6:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.ORANGE) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.ORANGE)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			
			case 7:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.PINK) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.PINK)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			
			case 8:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.GRAY) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.GRAY)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			
			case 9:if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()!=Color.CYAN) 
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(redborder);
			else if(butonkontrol.get(findLocation(testsudoku, i, j)).getBackground()==Color.CYAN)
				butonkontrol.get(findLocation(testsudoku, i, j)).setBorder(grayborder);
	
			break;
			}
		}
	}
	check();
}
	

public void yshow() {
	setVisible(true);
	setSize(600, 600);
}


}
