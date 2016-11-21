import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class Horloge extends JFrame implements ActionListener, ItemListener {
	public static void main(String args[]) {
		Horloge app = new Horloge();
		app.init();
	}

	public void init() {
		this.setTitle("Test radio boutons");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		Border border = BorderFactory.createTitledBorder("Horloge");
		panel.setBorder(border);
		ButtonGroup group = new ButtonGroup();

		JRadioButton radio1 = new JRadioButton("Atomique");
		radio1.setMnemonic(KeyEvent.VK_1);
		radio1.setActionCommand("Choix_1");
		radio1.setSelected(true);

		JRadioButton radio2 = new JRadioButton("Séquentielle");
		radio2.setMnemonic(KeyEvent.VK_2);
		radio2.setActionCommand("Choix_2");

		JRadioButton radio3 = new JRadioButton("Epoque");
		radio3.setMnemonic(KeyEvent.VK_3);
		radio3.setActionCommand("Choix_3");

		group.add(radio1);
		panel.add(radio1);
		group.add(radio2);
		panel.add(radio2);
		group.add(radio3);
		panel.add(radio3);

		radio1.addActionListener(this);
		radio2.addActionListener(this);
		radio3.addActionListener(this);
		radio1.addItemListener(this);
		radio2.addItemListener(this);
		radio3.addItemListener(this);
		
		JPanel panelHorloge = new JPanel(new GridLayout(2, 4));
		Border borderHorloge = BorderFactory.createTitledBorder("Afficheurs");
		panelHorloge.setBorder(borderHorloge);
		
		JLabel t1 = new JLabel("Afficheur 1");
		panelHorloge.add(t1);
		JLabel t2 = new JLabel("Afficheur 2");
		panelHorloge.add(t2);
		JLabel t3 = new JLabel("Afficheur 3");
		panelHorloge.add(t3);
		JLabel t4 = new JLabel("Afficheur 4");
		panelHorloge.add(t4);
		
		JLabel a1 = new JLabel("0");
		panelHorloge.add(a1);
		JLabel a2 = new JLabel("0");
		panelHorloge.add(a2);
		JLabel a3 = new JLabel("0");
		panelHorloge.add(a3);
		JLabel a4 = new JLabel("0");
		panelHorloge.add(a4);

		Container contentPane = this.getContentPane();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(panelHorloge, BorderLayout.NORTH);
		this.setSize(900, 500);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clic sur le bouton : " + e.getActionCommand());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.print("Bouton "
				+ ((JRadioButton) e.getItem()).getActionCommand());
		if (e.getStateChange() == ItemEvent.DESELECTED)
			System.out.println(" deselectionne");
		if (e.getStateChange() == ItemEvent.SELECTED)
			System.out.println(" selectionne");
	}
}