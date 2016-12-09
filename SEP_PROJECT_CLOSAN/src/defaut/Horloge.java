package defaut;

import interfacePackage.AlgoDiffusion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Horloge extends JFrame implements ActionListener, ItemListener {
	private AlgoDiffusion algo;
	private CapteurImpl captImpl;
	private JLabel valueCapteur;
	private Canal c1;
	private Canal c2;
	private Canal c3;
	private Canal c4;

	public static void main(String args[]) {
		Horloge app = new Horloge();
		app.init(new DiffusionAtomique());
		app.execute();
	}

	public void execute() {
		while (true) {
			valueCapteur.setText(String.valueOf(captImpl.getValue() + 1));
			captImpl.tick();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void init(AlgoDiffusion algo) {
		this.setTitle("Projet SEP : CLOAREC - SANHAJI");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		Border border = BorderFactory.createTitledBorder("Horloge");
		panel.setBorder(border);
		ButtonGroup group = new ButtonGroup();

		JRadioButton radio1 = new JRadioButton("Atomique");
		radio1.setMnemonic(KeyEvent.VK_1);
		radio1.setActionCommand("atomique");
		radio1.setSelected(true);

		JRadioButton radio2 = new JRadioButton("Séquentielle");
		radio2.setMnemonic(KeyEvent.VK_2);
		radio2.setActionCommand("sequentielle");

		JRadioButton radio3 = new JRadioButton("Epoque");
		radio3.setMnemonic(KeyEvent.VK_3);
		radio3.setActionCommand("epoque");

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

		JPanel panelHorloge = new JPanel(new GridLayout(2, 2));
		Border borderHorloge = BorderFactory.createTitledBorder("Afficheurs");
		panelHorloge.setBorder(borderHorloge);

		JLabel t1 = new JLabel("Afficheur 1 :");
		t1.setFont(new Font("Serif", Font.PLAIN, 26));
		panelHorloge.add(t1);
		JLabel t2 = new JLabel("Afficheur 2 :");
		t2.setFont(new Font("Serif", Font.PLAIN, 26));
		panelHorloge.add(t2);
		JLabel t3 = new JLabel("Afficheur 3 :");
		t3.setFont(new Font("Serif", Font.PLAIN, 26));
		panelHorloge.add(t3);
		JLabel t4 = new JLabel("Afficheur 4 :");
		t4.setFont(new Font("Serif", Font.PLAIN, 26));
		panelHorloge.add(t4);

		Afficheur a1 = new Afficheur("0");
		a1.setFont(new Font("Serif", Font.PLAIN, 26));
		panelHorloge.add(a1);
		Afficheur a2 = new Afficheur("0");
		a2.setFont(new Font("Serif", Font.PLAIN, 26));
		panelHorloge.add(a2);
		Afficheur a3 = new Afficheur("0");
		a3.setFont(new Font("Serif", Font.PLAIN, 26));
		panelHorloge.add(a3);
		Afficheur a4 = new Afficheur("0");
		a4.setFont(new Font("Serif", Font.PLAIN, 26));
		panelHorloge.add(a4);

		Container contentPane = this.getContentPane();
		contentPane.add(panel, BorderLayout.SOUTH);
		contentPane.add(panelHorloge, BorderLayout.NORTH);

		JPanel panelCapteur = new JPanel(new GridLayout(2, 2));
		Border borderCapteur = BorderFactory.createTitledBorder("Capteur");
		panelCapteur.setBorder(borderCapteur);
		JLabel title = new JLabel("Valeur du capteur :");
		title.setFont(new Font("Serif", Font.PLAIN, 66));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panelCapteur.add(title);

		valueCapteur = new JLabel("0");
		valueCapteur.setFont(new Font("Serif", Font.PLAIN, 66));
		valueCapteur.setHorizontalAlignment(SwingConstants.CENTER);
		panelCapteur.add(valueCapteur);

		contentPane.add(panelCapteur, BorderLayout.CENTER);

		this.setSize(900, 500);
		this.setResizable(false);
		this.setVisible(true);

		captImpl = new CapteurImpl();

		c1 = new Canal(captImpl, a1);
		c2 = new Canal(captImpl, a2);
		c3 = new Canal(captImpl, a3);
		c4 = new Canal(captImpl, a4);

		algo.setCapteur(captImpl);
		algo.addCanal(c1);
		algo.addCanal(c2);
		algo.addCanal(c3);
		algo.addCanal(c4);
		algo.configure();

		captImpl.setAlgoDiff(algo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Choix de l'algorithme de diffusion "
				+ e.getActionCommand());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("Bouton "
				+ ((JRadioButton) e.getItem()).getActionCommand()
				+ " sélectionné");
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			if (algo instanceof DiffusionAtomique){
				((DiffusionAtomique) algo).reset();
			}
		}
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (((JRadioButton) e.getItem()).getActionCommand().equals(
					"atomique")) {
				algo = new DiffusionAtomique();
			}

			if (((JRadioButton) e.getItem()).getActionCommand().equals(
					"sequentielle")) {
				algo = new DiffusionSequentielle();
			}

			if (((JRadioButton) e.getItem()).getActionCommand()
					.equals("epoque")) {
				algo = new DiffusionEpoque();
			}
			
			this.init(algo);
		}
	}
}