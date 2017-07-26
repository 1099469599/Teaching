package com.gs.qq.ui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.gs.bean.Account;
import com.gs.bean.Message;
import com.gs.qq.client.Client;
import com.gs.qq.ui.common.UIUtil;
import com.gs.qq.ui.listener.ExitListener;
import com.gs.qq.ui.listener.FrameDragListener;
import com.gs.qq.ui.listener.MainLabelListener;
import com.gs.qq.ui.listener.MainStatusListener;
import com.gs.qq.ui.listener.MinListener;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -7983465140805238715L;
	
	private JLabel bgLbl;
	private Client client;
	private Account account;
	
	private ReqThread reqThread;
	
	private Map<Account, ChatFrame> chatFrames;

	public void setChatFrames(Map<Account, ChatFrame> chatFrames) {
		this.chatFrames = chatFrames;
	}
	
	public Map<Account, ChatFrame> getChatFrames() {
		return chatFrames;
	}
	
	/**
	 *	ʵ���������ڣ�����client��account����
	 *	account��������ʾ�û���Ϣ��Label���õ�
	 *client�ڴ��������ں���Ҫ���ݹ�ȥ
	 * @param client
	 * @param account
	 */
 	public MainFrame(Client client, Account account) {
		this.client = client;
		client.setMainFrame(this); // �������洫�ݸ�client
		this.account = account;
		chatFrames = new HashMap<Account, ChatFrame>();
		setSize(300, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/qq_icon.png"));
		background();
		top();
		center();
		bottom();
		FrameDragListener frameDragLtn = new FrameDragListener(this);
		addMouseListener(frameDragLtn);
		addMouseMotionListener(frameDragLtn);
		UIUtil.setLookAndFeel();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void background() {
		bgLbl = new JLabel();
		bgLbl.setIcon(new ImageIcon("img/main_bg.png"));
		bgLbl.setBounds(0, 0, 300, 600);
		add(bgLbl);
	}
	
	private void top() {
		JLabel iconLbl = new JLabel(new ImageIcon("img/tubiao.png"));
		iconLbl.setBounds(0, 0, 51, 24);
		bgLbl.add(iconLbl);
		Icon exitIcon = new ImageIcon("img/exit_def.png");
		JLabel exitLbl = new JLabel(exitIcon);
		exitLbl.setBounds(270, 0, 30, 30);
		exitLbl.addMouseListener(new ExitListener(client, account));
		bgLbl.add(exitLbl);
		Icon minIcon = new ImageIcon("img/min_def.png");
		JLabel minLbl = new JLabel(minIcon);
		minLbl.setBounds(240, 0, 30, 30);
		minLbl.setName("main_min");
		minLbl.addMouseListener(new MinListener(this));
		bgLbl.add(minLbl);
		
		JLabel headLbl = new JLabel(new ImageIcon("img/head/" + account.getHeadIcon() + ".png"));
		headLbl.setBounds(20, 30, 62, 70);
		bgLbl.add(headLbl);
		
		JLabel nicknameLbl = new JLabel(account.getNickname());
		nicknameLbl.setBounds(100, 50, 50, 30);
		bgLbl.add(nicknameLbl);
		
		JLabel statusLbl = new JLabel(new ImageIcon("img/online.png"));
		statusLbl.setBounds(160, 100, 20, 20);
		statusLbl.addMouseListener(new MainStatusListener(client, account, statusLbl, statusLbl));
		bgLbl.add(statusLbl);
		
	}
	
	private FriendListPanel friendListPanel;
	private void center() {
		UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.setBounds(20, 180, 260, 360);
		tabPane.setOpaque(false);
		tabPane.setBackground(new Color(0.15f, 0.15f, 0.15f, .0f)); //JTabbedPaneû��͸��
		tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		friendListPanel = new FriendListPanel(client, this, account);
		tabPane.addTab("����", new ImageIcon("img/xunzhang.png"), friendListPanel, "�ҵ�QQ����");
		tabPane.addTab("������", new ImageIcon("img/qq_icon.png"), new JLabel("bbbbb"), "������");
		bgLbl.add(tabPane);
	}
	
	private JLabel reqMsgLbl;
	public JLabel getReqMsgLbl() {
		return reqMsgLbl;
	}
	private void bottom() {
		reqMsgLbl = new JLabel(new ImageIcon("img/qme.png"));
		reqMsgLbl.setBounds(190, 550, 50, 25);
		reqMsgLbl.setName("reqMsg");
		reqMsgLbl.addMouseListener(new MainLabelListener(client, this));
		bgLbl.add(reqMsgLbl);
		JLabel searchLbl = new JLabel(new ImageIcon("img/search_def.png"));
		searchLbl.setBounds(230, 550, 50, 25);
		searchLbl.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new FriendSearchFrame(client, account); // ������˲��Һ��ѣ��򵯳����Һ����б��ڣ���client���ݵĸô���
			}
		});
		bgLbl.add(searchLbl);
	}
	
	private Message message;
	public Message getMessage() {
		return message;
	}
	public void receiveRequestMsg(Message message) {
		this.message = message;
		reqThread = new ReqThread(); // �޸�ͼ����߳���
		new Thread(reqThread).start();
		
	}
	
	public ReqThread getReqThread() {
		return reqThread;
	}
	
	/**
	 * ÿ��һ���ϵͳ��Ϣͼ���л�ͼ��
	 *
	 */
	public class ReqThread implements Runnable {
		
		boolean needRunning = true;
		boolean isRemoved = false;
		
		public void setNeedRunning(boolean needRunning) {
			this.needRunning = needRunning;
		}
		
		@Override
		public void run() {
			while(needRunning) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (!isRemoved) {
					reqMsgLbl.setIcon(new ImageIcon("img/busy.png"));
					isRemoved = true;
				} else {
					reqMsgLbl.setIcon(new ImageIcon("img/qme.png"));
					isRemoved = false;
				}
			}
		}
		
	}

	public void updateFriendList(Account account) {
		friendListPanel.updateFriendList(account); // friendListPanel��ɺ����б���� 
	}
	
	public void updateFriendStatus(Account account) {
		friendListPanel.updateFriendStatus(account);
	}

}
