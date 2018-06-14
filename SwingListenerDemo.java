package grid;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingListenerDemo {
	private JFrame f;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	int rows = 6;
	int cols = 5;
	int max=0;
	int i=1;
	int j=1;
	int k=1;
	int count=1;
	long duration;
	int distance;
	Map<String,String> map = new HashMap<String,String>();
	Map<String,JButton> buttonMap = new HashMap<String,JButton>();
	final JTextField tf = new JTextField();
	JButton b = new JButton("Click Here");
	long startTime;
	long endTime;
	public SwingListenerDemo() throws InterruptedException {
		/*System.out.println("please provide number of rows to be created");
		Scanner sc = new Scanner(System.in);
		rows = sc.nextInt();
		System.out.println("please provide number of columns to be created");
		cols = sc.nextInt();*/
		startTime=System.currentTimeMillis();
		prepareGUI();

	}

	public static void main(String[] args) throws InterruptedException {
		SwingListenerDemo swingDemo = new SwingListenerDemo();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		}

	private void prepareGUI() throws InterruptedException {
		f = new JFrame("Button Example");
		
		int grid = rows * cols;
//		distance=grid/9;
		if(grid<16){
			JOptionPane.showMessageDialog(null, "Not enough value sir,please increase size !");
			f.setVisible(true);
			Thread.sleep(500);
			System.exit(0);
		}else if(grid>100){
			JOptionPane.showMessageDialog(null, "It's Huge Value sir,please reduce the size !");
			f.setVisible(true);
			Thread.sleep(500);
			System.exit(0);
		}
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Random randomGenerator = new Random();
		while (numbers.size() < 9 || j<=grid) {
			int random = randomGenerator.nextInt(10);
			
			if (!numbers.contains(random) && random != 0) {
//				distance=grid/9;
				numbers.add(random);
//				System.out.println(i+" " + random);
				b = new JButton("" + random);
				buttonMap.put("b"+i,b);
				b.setBounds(50, 100, 95, 30);
				b.setBackground(Color.white);
				b.setBorderPainted(false);
				f.add(b);
				f.setSize(550, 450);
				f.setLayout(new GridLayout(rows, cols));
				f.setVisible(true);
				String text = b.getText();
				map.put(""+random,""+i);
				i++;
				j++;
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							check(text);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				});
				
			}else if(k<=(grid-9)){
				b = new JButton();
				b.setBounds(50, 100, 95, 30);
				b.setBackground(Color.white);
				b.setBorderPainted(false);
				f.add(b);
				f.setSize(550, 450);
				f.setLayout(new GridLayout(rows, cols));
				f.setVisible(true);
				k++;
				j++;
//				distance--;
			}
		

			}
	}

	protected void check(String text) throws InterruptedException {
		String position=map.get(text);
//		System.out.println(position);
		int number=Integer.parseInt(text);
		/*int num=Integer.getInteger(map.get("text"));
		b.setText(map.get("text"));
		b.setBackground(null);*/
		if(max==0){
			count++;
			disableButton();
			max=number;
//			startTime=System.currentTimeMillis();
		}else if(number==(max+1)){
			count++;
			max=number;
		}else{
			JOptionPane.showMessageDialog(null, "Wrong number choosen");
			f.setVisible(true);
			Thread.sleep(500);
			System.exit(0); 	
		}
//		if(count>9){
		if(max==9){
		endTime=System.currentTimeMillis();
			duration=(endTime-startTime)/1000;
			JOptionPane.showMessageDialog(null, "You Champ ! Total time taken to solve after your first click ="+duration+" seconds");
			f.setVisible(true);
			Thread.sleep(500);
			System.exit(0); 
		}
		
	}
	public void disableButton(){
		for(int ab=1;ab<=9;ab++){
			buttonMap.get("b"+ab).setText("");
			buttonMap.get("b"+ab).setBackground(Color.black);
			buttonMap.get("b"+ab).setBorderPainted(true);
			
		}
	}
	
}