package com.gs.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = -8153506578750980360L;
	
	private BufferedImage[] images;
	private int[][] map;
	private int currentLevel;
	private String levelInfo;
	private Stack<GameStep> maps;
	
	public GamePanel() {
		
	}
	
	public GamePanel(int level) {
		maps = new Stack<GameStep>();
		images = GameUtil.getImages();
		map = GameUtil.getLevel(level);
		currentLevel = level;
		levelInfo = "��"  + level + "��"; 
		setFocusable(true); // �����Ƿ���Ի�ȡ����
		requestFocus(); // ���󽹵�
		addKeyListener(this);
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public void focus() {
		setFocusable(true); // �����Ƿ���Ի�ȡ����
		requestFocus(); // ���󽹵�
	}
	
	/**
	 * ����֮ǰ�Ѿ���ȡ�Ĺؿ���ͼ��ͼƬ����Ӧ�Ĺؿ����Ƴ���
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		for (int row = 0; row < Constants.TOTAL; row++) {
			for (int col = 0; col < Constants.TOTAL; col++) {
				g.setFont(new Font("����", Font.BOLD, 48));
				g.setColor(Color.GREEN);
				g.drawString(levelInfo, 240, 60);
				int imageIndex = map[row][col];
				g.drawImage(images[imageIndex], col * Constants.IMAGE_SIZE, row * Constants.IMAGE_SIZE, 
						Constants.IMAGE_SIZE, Constants.IMAGE_SIZE, null);
			}
		}
	}
	
	/**
	 * ����ѡ��ؿ�����Ҫ��������GamePanel�еĵ�ǰ�ؿ��������»�õ�ǰ�ؿ�����Ӧ�ĵ�ͼ������������ʾ�Ĺؿ���Ϣ
	 * �ٵ���repaint������repaint���Զ�����update��update�Զ�����paint����
	 * @param level
	 */
	public void chooseLevel(int level) {
		maps.clear();
		if (level <= 0) {
			level = Constants.LEVEL_1;
		} else if (level >= 12) {
			level = Constants.LEVEL_11;
		}
		map = GameUtil.getLevel(level);
		currentLevel = level;
		levelInfo = "��"  + level + "��"; 
		currentSpriteIsOnDestination = false;
		repaint();
		focus();
	}
	
	// ��ǰ�ľ����Ƿ���Ŀ��λ����
	// ÿ�����ƶ���ʱ�򣬶���Ҫ�жϵ�ǰ�˵�λ���Ƿ�����Ŀ��λ���ϣ�����ǣ����λ��Ӧ�ñ��Ŀ��λ��
	// ��������ñ��Ŀ��λ��
	// ������Ƶ�����һ��λ����Ŀ��λ�ã����� Ŀ�����ӣ�����ζ�ŵ�ǰ����Ŀ��λ���ϣ���ֵΪtrue������ֵ���false
	private boolean currentSpriteIsOnDestination = false; 
	private void move(int direction, int row1, int col1, int row2, int col2, int row3, int col3) {
		/**
		 * 1�� ǰһ��λ���Ƿ���
		 * 	ʲô������
		 * 2��ǰһ��λ�������ӣ�����һ��λ��������
		 * 	ʲô������
		 * 3��ǰһ��λ�������ӣ�����һ��λ����Ŀ������
		 * 	ʲô������
		 * 4��ǰһ��λ����Ŀ�����ӣ�����һ��λ��������
		 * 	ʲô������
		 * 5��ǰһ��λ����Ŀ�����ӣ�����һ��λ����Ŀ������
		 * 	ʲô������
		 * 
		 * 6��ǰһ��λ�������ӣ�����һ��λ����Ŀ��λ��
		 * 	�������Ƶ�Ŀ��λ�ã�������Ҫ���Ŀ�����ӣ�����ǰ�ƣ���ԭ�ȵ�λ���������Ŀ��λ�ã����ɲݵ�
		 * 7��ǰһ��λ�������ӣ�����һ��λ���ǲݵ�
		 * 	�������ƶ���һ��λ�ã����ӵ�λ�ñ�ɲݵأ�����ǰ�ƣ���ԭ�ȵ�λ���������Ŀ��λ�ã����ɲݵ�
		 * 8��ǰһ��λ����Ŀ�����ӣ�����һ��λ�� ��Ŀ��λ��
		 * 	�Ѹ�Ŀ�������Ƶ���һ��λ�ã�ԭ��Ŀ�����ӵ�λ�ñ��Ŀ��λ�ã�����ǰ�ߣ���ԭ�ȵ�λ���������Ŀ��λ�ã����ɲݵ�
		 * 9��ǰһ��λ�� ��Ŀ�����ӣ�����һ��λ���ǲݵ�
		 * 	��Ŀ�������ƶ�����һ��λ�ã���Ŀ�����ӵ�λ�øĳ�Ŀ��λ�ã�����ǰ�ߣ���ԭ�ȵ�λ���������Ŀ��λ�ã����ɲݵ�
		 * 10��ǰһ��λ����Ŀ��λ��
		 * 	��¼��Ŀ��λ�õ������У����ƶ�����Ŀ��λ��
		 * 11��ǰһ��λ���ǲݵ�
		 * 	��ֱ����
		 */
		if (map[row2][col2] == GameUtil.HOUSE
				|| (map[row2][col2] == GameUtil.BOX && map[row3][col3] == GameUtil.BOX)
				|| (map[row2][col2] == GameUtil.BOX && map[row3][col3] == GameUtil.DES_BOX)
				|| (map[row2][col2] == GameUtil.DES_BOX && map[row3][col3] == GameUtil.BOX)
				|| (map[row2][col2] == GameUtil.DES_BOX && map[row3][col3] == GameUtil.DES_BOX)) {
			
		} else {
			GameStep gameStep = new GameStep();
			gameStep.setMap(copyArray());
			gameStep.setCurrentSpriteIsOnDestination(currentSpriteIsOnDestination);
			maps.push(gameStep);
			if (map[row2][col2] == GameUtil.BOX && map[row3][col3] == GameUtil.DESTINATION) { // 6
				map[row3][col3] = GameUtil.DES_BOX; // �ƶ����ӵ�Ŀ��λ��
				map[row2][col2] = direction; // ���ƶ�����һ��λ��
				if (currentSpriteIsOnDestination) {
					map[row1][col1] = GameUtil.DESTINATION;
					currentSpriteIsOnDestination = false;
				} else {
					map[row1][col1] = GameUtil.GRASS;
				}
			} else if (map[row2][col2] == GameUtil.BOX && map[row3][col3] == GameUtil.GRASS) { // 7
				map[row3][col3] = GameUtil.BOX;
				map[row2][col2] = direction;
				if (currentSpriteIsOnDestination) {
					map[row1][col1] = GameUtil.DESTINATION;
					currentSpriteIsOnDestination = false;
				} else {
					map[row1][col1] = GameUtil.GRASS;
				}
			} else if (map[row2][col2] == GameUtil.DES_BOX && map[row3][col3] == GameUtil.DESTINATION) { // 8
				map[row3][col3] = GameUtil.DES_BOX;
				map[row2][col2] = direction;
				if (currentSpriteIsOnDestination) {
					map[row1][col1] = GameUtil.DESTINATION;
				} else {
					map[row1][col1] = GameUtil.GRASS;
				}
				currentSpriteIsOnDestination = true;
			} else if (map[row2][col2] == GameUtil.DES_BOX && map[row3][col3] == GameUtil.GRASS) { // 9
				map[row3][col3] = GameUtil.BOX;
				map[row2][col2] = direction;
				if (currentSpriteIsOnDestination) {
					map[row1][col1] = GameUtil.DESTINATION;
				} else {
					map[row1][col1] = GameUtil.GRASS;
				}
				currentSpriteIsOnDestination = true;
			} else if (map[row2][col2] == GameUtil.DESTINATION) { // 10
				map[row2][col2] = direction;
				if (currentSpriteIsOnDestination) {
					map[row1][col1] = GameUtil.DESTINATION;
				} else {
					map[row1][col1] = GameUtil.GRASS;
				}
				currentSpriteIsOnDestination = true;
			} else if (map[row2][col2] == GameUtil.GRASS) { // 11
				map[row2][col2] = direction;
				if (currentSpriteIsOnDestination) {
					map[row1][col1] = GameUtil.DESTINATION;
					currentSpriteIsOnDestination = false;
				} else {
					map[row1][col1] = GameUtil.GRASS;
				}
			}
		}
		
	}
	
	private void move(int direction) {
		int[] sprite = GameUtil.getSprite(map);
		int row = sprite[0];
		int col = sprite[1];
		switch(direction) {
		case KeyEvent.VK_UP:
			move(GameUtil.SPRITE_UP, row, col, row - 1, col, row - 2, col);		
			break;
		case KeyEvent.VK_DOWN:
			move(GameUtil.SPRITE_DOWN, row, col, row + 1, col, row + 2, col);
			break;
		case KeyEvent.VK_LEFT:
			move(GameUtil.SPRITE_LEFT, row, col, row, col - 1, row, col - 2);
			break;
		case KeyEvent.VK_RIGHT:
			move(GameUtil.SPRITE_RIGHT, row, col, row, col + 1, row, col + 2);
			break;
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_UP:// TODO ������
			move(KeyEvent.VK_UP);
			break;
		case KeyEvent.VK_DOWN:// TODO ������
			move(KeyEvent.VK_DOWN);
			break;
		case KeyEvent.VK_LEFT:// TODO ������
			move(KeyEvent.VK_LEFT);
			break;
		case KeyEvent.VK_RIGHT:// TODO ������
			move(KeyEvent.VK_RIGHT);
			break;
		}
		if (isWin()) {
			int result = JOptionPane.showConfirmDialog(getParent(), "�Ƿ������һ�أ�", "��ϲ����", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
				chooseLevel(getCurrentLevel() + 1);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	private boolean isWin() {
		for (int i = 0; i < Constants.TOTAL; i++) {
			for (int j = 0; j < Constants.TOTAL; j++) {
				if (map[i][j] == GameUtil.BOX) {
					return false;
				}
			}
		}
		return true;
	}
	
	private int[][] copyArray() {
		int[][] originalMap = new int[Constants.TOTAL][Constants.TOTAL];
		for (int i = 0; i < Constants.TOTAL; i++) {
			for (int j = 0; j < Constants.TOTAL; j++) {
				originalMap[i][j] = map[i][j];
			}
		}
		return originalMap;
	}
	
	public void previousStep() {
		if (!maps.empty()) { // �ж�stackջ�Ƿ�������
			GameStep step = maps.pop();
			map = step.getMap();
			currentSpriteIsOnDestination = step.isCurrentSpriteIsOnDestination();
			repaint();
		}
		focus();
	}

}
