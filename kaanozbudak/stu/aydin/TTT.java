package kaanozbudak.stu.aydin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.GridLayout;

public class TTT extends JFrame
{
    private BoardCell [] boardCells;
    private static final String XTURN = "X";
    private static final String OTURN = "O";
    private String boardConfig = "012345678";

    private String turn;
    TTT() {
        boardCells = new BoardCell[9];
        turn = XTURN;
        setLayout(new GridLayout(3,3,5,5));

        for(int i = 0; i < 9; i++){
            boardCells[i] = new BoardCell(i);
            boardCells[i].setFont(new Font("Sans-serif",
                    Font.BOLD, 36));
            boardCells[i].addMouseListener(
                    new MyMouseListener());
            add(boardCells[i]);
        }

    }
    void changeTurns(){
        if(turn.equals(XTURN))
            turn = OTURN;
        else 	turn = XTURN;
    }
    boolean isClicked(int cellNum){

        return !boardConfig.contains(
                String.valueOf(cellNum));
    }
    void makeMove(int cellNum){
        boardConfig=boardConfig.replace(
                String.valueOf(cellNum), turn);
        System.out.println(boardConfig);
    }
    String getMySym(int index){
        if(Character.isDigit(boardConfig.charAt(index)))
            return "";
        else if(boardConfig.charAt(index) == 'X')
            return "X";
        return "O";
    }
    class BoardCell extends JPanel{
        private static final String XSYM = "X";
        private static final String OSYM = "O";
        private static final String NSYM = "";

        private String mySymbol;
        private int myNum;
        BoardCell(int num){
            myNum = num;
        }
        int getNumber(){
            return myNum;
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            setBackground(Color.RED);

            g.drawString(getMySym(myNum), 50,50);

        }
    }
	/*class MouseAdapter implements MouseListener{
		public void mouseEntered(MouseEvent e){}
		//...
	}*/

    class MyMouseListener extends MouseAdapter {
        //private static int countClick = 0;
        public void mouseClicked(MouseEvent e){
			/*BoardCell bc = (BoardCell)e.getSource();
			int i;
			for(i = 0; i < 9; i++)
				if(bc == boardCells[i])
					break;
			System.out.println("clicked on "+i);*/
            BoardCell bc = (BoardCell) e.getSource();

            if(!isClicked(bc.getNumber())){
                System.out.println("clicked");
                makeMove(bc.getNumber());
                changeTurns();
                bc.repaint();
            }
        }
    }
    public static void main(String args[])
    {
        TTT game=new TTT();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        game.setResizable(false);
        game.setSize(300,300);
        game.setTitle("TicTacToe");
        game.setLocation(800,400);

    }
}
