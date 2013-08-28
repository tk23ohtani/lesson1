/**
 * –³—”‚©‚ç‹ß—‚·‚é—L—”‚ÌŒó•â‚ğŒvZ‚·‚éB
 */
package com.gmail.tk23ohtani;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author ohtani
 *
 */
public class Rational extends JFrame {

	private final static int DENOMINATOR = 500;
	private final static int DEPTH = 20;
	JLabel[] tx = new JLabel[DEPTH];
	JTextField text1, text2;
	JButton btnInstall;

	public Rational() {

		JPanel pnlInfomation = new JPanel();
		pnlInfomation.setLayout(new GridLayout(DEPTH, 1));
		for (int i=0; i<tx.length; i++) {
			pnlInfomation.add(tx[i] = new JLabel());
		}
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		text1 = new JTextField("3.1415927", 10);
		pnlButtons.add(text1);
		text2 = new JTextField("3", 2);
		pnlButtons.add(text2);
		btnInstall = new JButton("Calcurate");
		btnInstall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double target = Double.parseDouble(text1.getText());
				int digit = Integer.parseInt(text2.getText());
				double margin = 1.0;
				while (digit-- != 0) {
					margin = margin / 10.0;
				}
				calc(target, margin);
			}
		});
		pnlButtons.add(btnInstall);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pnlButtons, BorderLayout.NORTH);
		getContentPane().add(pnlInfomation, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rational");
		setLocationRelativeTo(null);
		setSize(350, 380);
		setVisible(true);

	}

	private void calc(double target, double margin) {
		double	dval, diff;
		double [] diffs = new double[DEPTH];
		int [] denoms = new int[DEPTH];
		for (int l=0; l<DEPTH; l++)
		{
			diffs[l] = 10.0;
			denoms[l] = DENOMINATOR;
			tx[l].setText("");

		}
		int		i, j, sta_val, stp_val;
		for (j=2; j<DENOMINATOR; j++)
		{
			sta_val = (((int)target) - 1) * j;
			stp_val = (((int)target) + 1) * j;
			for (i=sta_val; i<=stp_val; i++)
			{
				dval = (double)i / (double)j;
				diff = Math.abs(target - dval);
				if (margin > diff)
				{
					boolean isFoundSmallRational = false;
					for (int l=0; l<DEPTH; l++)
					{
						if (diffs[l] == diff)
						{
							break;
						}
						if (diffs[l] > diff)
						{
							if (isFoundSmallRational) break;
							for (int m=DEPTH-1; l<m; m--)
							{
								tx[m].setText(tx[m-1].getText());
								diffs[m] = diffs[m-1];
								denoms[m] = denoms[m-1];
							}
							diffs[l] = diff;
							denoms[l] = j;
							String str;
							str = i + "/" + j + "=" + dval + "(" + diff + ")";
							tx[l].setText(str);
							break;
						}
						if (denoms[l] < j)
						{
							isFoundSmallRational = true;
						}
					}
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Rational();

	}

}
