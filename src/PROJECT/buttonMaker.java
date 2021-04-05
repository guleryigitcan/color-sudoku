package PROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class buttonMaker extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cliked;
	
	public buttonMaker() {
		JButton buton=new JButton();
		
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			
				cliked++;
			
				
				if(cliked==1&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.BLACK);
				else if (cliked==2&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.RED);
				else if(cliked==3&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.YELLOW);
				else if(cliked==4&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.BLUE);
				else if(cliked==5&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.GREEN);
				else if(cliked==6&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.ORANGE);
				else if(cliked==7&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.PINK);
				else if(cliked==8&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.GRAY);
				else if(cliked==9&&e.getButton()==MouseEvent.BUTTON1)
					setBackground(Color.CYAN);
				else if(cliked==10&&e.getButton()==MouseEvent.BUTTON1)
					cliked=cliked%10;
				else if(e.getButton()==MouseEvent.BUTTON3) {
					setBackground(null);
					cliked=0;
				}
					
				
				
			}
		});
	}

}
