package com.gs.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GameFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -2981099091790391071L;
	
	private static final String[] btnNames = {"����", "��һ��", "��һ��", "��һ��", "��һ��", "���һ��", "ѡ��", "��������", "ֹͣ����", "����"};
	private static final String[] actionCommands = {Constants.BTN_RESET, Constants.BTN_PREVIOUS, Constants.BTN_FIRST_LEVEL,
			Constants.BTN_PREVIOUS_LEVEL, Constants.BTN_NEXT_LEVEL, Constants.BTN_LAST_LEVEL, Constants.BTN_CHOOSE_LEVEL, 
			Constants.BTN_PLAY_MUSIC, Constants.BTN_STOP_MUSIC, Constants.BTN_ABOUT};
	
	private GamePanel gamePanel; // ������Ϸ�������
	private GameMusic gameMusic;

	public GameFrame() {
		setSize(700, 640);
		setTitle("������");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		gamePanel = new GamePanel(Constants.LEVEL_1);
		gameMusic = new GameMusic();
		add(gamePanel, BorderLayout.CENTER);
		initWidgets();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initWidgets() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(btnNames.length, 1));
		for (int i = 0, len = btnNames.length; i < len; i++) {
			JButton btn = new JButton(btnNames[i]);
			btn.setActionCommand(actionCommands[i]);
			btn.addActionListener(this);
			panel.add(btn);
		}
		add(panel, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals(Constants.BTN_RESET)) {
			gamePanel.chooseLevel(gamePanel.getCurrentLevel());
		} else if (action.equals(Constants.BTN_PREVIOUS)) {
			gamePanel.previousStep();
		} else if (action.equals(Constants.BTN_FIRST_LEVEL)) {
			gamePanel.chooseLevel(Constants.LEVEL_1);
		} else if (action.equals(Constants.BTN_PREVIOUS_LEVEL)) {
			gamePanel.chooseLevel(gamePanel.getCurrentLevel() - 1);
		} else if (action.equals(Constants.BTN_NEXT_LEVEL)) {
			gamePanel.chooseLevel(gamePanel.getCurrentLevel() + 1);
		} else if (action.equals(Constants.BTN_LAST_LEVEL)) {
			gamePanel.chooseLevel(Constants.LEVEL_11);
		} else if (action.equals(Constants.BTN_CHOOSE_LEVEL)) {
			chooseLevel();
		} else if (action.equals(Constants.BTN_ABOUT)) {
			JOptionPane.showMessageDialog(GameFrame.this, "��***������ �汾1.0������ϵ110", "����", JOptionPane.INFORMATION_MESSAGE);
			gamePanel.focus();
		} else if (action.equals(Constants.BTN_PLAY_MUSIC)) {
			gameMusic.play("/musics/popo.mid");
			gamePanel.focus();
		} else if (action.contentEquals(Constants.BTN_STOP_MUSIC)) {
			gameMusic.stop();
			gamePanel.focus();
		}
	}
	
	private void chooseLevel() {
		String result = JOptionPane.showInputDialog(GameFrame.this, "������1-11�صĹؿ�", "ѡ��ؿ�", JOptionPane.INFORMATION_MESSAGE);
		if (result != null) {
			int level = 1;
			try {
				level = Integer.valueOf(result);
			} catch(NumberFormatException ee) {
				JOptionPane.showMessageDialog(GameFrame.this, "����������", "����", JOptionPane.WARNING_MESSAGE);
			}
			gamePanel.chooseLevel(level);
		}
		gamePanel.focus();
	}
	
}
