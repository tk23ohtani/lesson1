/**
 * –³—”‚©‚ç‹ß—‚·‚é—L—”‚ÌŒó•â‚ğŒvZ‚·‚éB
 */
package com.gmail.tk23ohtani;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 * @author ohtani
 *
 */
public class Rational extends JFrame {

	JLabel[] tx = new JLabel[10];
	JTextField text1, text2;
	JButton btnInstall;

	public Rational() {

		JPanel pnlData = new JPanel();
		pnlData.setLayout(new GridLayout(2, 1));
		EtchedBorder border = new EtchedBorder(EtchedBorder.RAISED, Color.white, Color.gray);
		pnlData.setBorder(border);

		JPanel pnlInfomation = new JPanel();
		pnlInfomation.setLayout(new GridLayout(10, 1));
		for (int i=0; i<tx.length; i++) {
			pnlInfomation.add(tx[i] = new JLabel());
		}
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		text1 = new JTextField("3.1415927", 10);
		pnlButtons.add(text1);
		text2 = new JTextField("5", 2);
		pnlButtons.add(text2);
		btnInstall = new JButton("Calcurate");
//		btnInstall.setEnabled(false);
		btnInstall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				double target = Double.parseDouble(text1.getText());
				int digit = Integer.parseInt(text2.getText());
				double margin = 1.0;
				while (digit-- != 0) {
					margin = margin / 10.0;
				}

				double	dval;
				int		i, j, k=0, sta_val, stp_val;
				for (j=2; j<30; j++)
				{
					sta_val = (((int)target) - 1) * j;
					stp_val = (((int)target) + 1) * j;
					for (i=sta_val; i<=stp_val; i++)
					{
						dval = (double)i / (double)j;
						if ((dval > target - margin) && (dval < target + margin))
						{
							String str;
							str = i + "/" + j + "=" + dval + "(" + (target - dval) + ")";
							tx[k++].setText(str);
						}
						if (k >= 10) break;
					}
					if (k >= 10) break;
				}
			}
		});
		pnlButtons.add(btnInstall);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pnlButtons, BorderLayout.NORTH);
		getContentPane().add(pnlData, BorderLayout.CENTER);
		getContentPane().add(pnlInfomation, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rational");
		setLocationRelativeTo(null);
		setSize(350, 250);
		setVisible(true);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Rational();

	}

}
