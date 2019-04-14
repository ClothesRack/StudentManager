package com.cn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean flag=false;
	boolean exit=false;//���߳�ֹͣ�ж�flag
	MenuAction test;
	//�˵���
	JMenuBar bar = new JMenuBar();
	JMenu user = new JMenu("�˻�");
	JMenu function = new JMenu("����");
	JMenu imessage = new JMenu("������Ϣ");
	JMenuItem StundentMessage = new JMenuItem("^ѧ����Ϣ^");
	JMenuItem IDMessage = new JMenuItem("^�˺���Ϣ^");
	JMenuItem LoginMenu = new JMenuItem("^��¼^");
	JMenuItem exitMenu = new JMenuItem("^�˳�^");
	JMenuItem addMenu = new JMenuItem("^ע�����˺�^");
	JMenuItem ChangeMenu = new JMenuItem("^�޸��˻���Ϣ^");
	JPanel c ;
	JLabel bg;
	MyFrame(){
		//�˵�����������=   
		test=new MenuAction(this);
		setTitle("ѧ������ϵͳ");
		bar.add(user);
		user.add(LoginMenu);
		user.add(exitMenu);
		user.add(addMenu);
		user.add(ChangeMenu);
		
		bar.add(function);
		function.add(imessage);
		imessage.add(StundentMessage);
		imessage.add(IDMessage);
		this.add(bar,BorderLayout.NORTH);
		//���ɷŴ�
		this.setResizable(false);
		//LoginMenu.addActionListener(new MenuAction(this));
		LoginMenu.addActionListener(test);
		exitMenu.addActionListener(test);
		ChangeMenu.addActionListener(test);
		addMenu.addActionListener(test);
		StundentMessage.addActionListener(test);
		TestFream.SiteInit(this,800,600);

		
		bg = new JLabel(new ImageIcon("image\\aa.jpg")); 
		bg.setLayout(null);
		bg.setBounds(0,0,800,600);// ���� ��Ϊʲô�����������Ҳ������ͼ
		c = new JPanel();
		c.add(bg);
		
		this.add(c);

		
		
		this.setVisible(true);
		addWindowListener(new MyWindowListener(this));  
		
		
	}
}
//��¼�˵�������
class MenuAction implements ActionListener{
	MyFrame m;
	loginfream login;
	AddId addIdfream;
	AddId  reviser;
	StudentUi StuMessage;
	MenuAction(MyFrame m){
	     this.m=m;
	 	login = new loginfream( m);//�˵����������󴴽���ͬʱ���봴������½��Ķ���Ĭ���������ɼ��������Ϳ���
	 							//��������flag��ֵ�������Thread�̡߳��������½�������ҳ����س�����OK�ˣ�
	 	addIdfream=new AddId(m);	
	 	System.out.println("���ڳ�ʼ��");
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		String select = e.getActionCommand();
		if(select=="^��¼^"){
			login.setVisible(true);	//���ڿɼ�
			//m.setEnabled(false);//�Ƚ�����������Ϊ���ɲ���״̬
			m.setVisible(false);
		}else if(select=="^�˳�^"){
				login.flag=false;
				m.LoginMenu.setText("^��¼^");
				//m.LoginMenu.setEnabled(true);
				JOptionPane.showMessageDialog(null, "~~~����"+login.textfield.getText()+"����Ա�����Գɹ��˳�����ӭ���鱾����ϵͳ���ڴ�������һ������~~~", "�˳��ɹ�",JOptionPane.WARNING_MESSAGE);
				System.out.println("������˳�������~");

		}else if(select=="^�޸��˻���Ϣ^"){
			//��¼�Ļ��Ϳ����޸���Ϣ�� �� �Ǿ�Ҫ���޸���Ϣ�Ǹ�ҳ��һ�����ڵĶ�����
			//������ע��ҳ���addidfream����Ҳ���ԣ�
			reviser= new AddId(m);
			reviser.textfield.setText("");
			reviser.AddButton.setText("�޸�");
			reviser.setTitle("�޸��û���Ϣ");
			reviser.AddButton.setIcon(reviser.reviseIcon);
			reviser.setVisible(true);
			//m.setEnabled(false);
			m.setVisible(false);
		}else if(select=="^ע�����˺�^"){
			addIdfream.setVisible(true);
			//m.setEnabled(false);//�Ƚ�����������Ϊ���ɲ���״̬
			m.setVisible(false);//�Ƚ�����������Ϊ���ɼ�
		}else if(select.equals("^���ã�"+login.textfield.getText())){
			JOptionPane.showMessageDialog(null, "��ѽya��"+login.textfield.getText()+",������˼���~~", "~~~~",JOptionPane.WARNING_MESSAGE);
		}else if(select=="^ѧ����Ϣ^"){
			StuMessage =new StudentUi(m);
		}
		
		
	}

}
class loginfream extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JCheckBox realizePassWorld;
	boolean flag=false;
	JLabel jl = new JLabel("�˺ţ�");
	JLabel jl2 = new JLabel("���룺");
	JTextField textfield=new JTextField("�����������˺�....",30);
	JPasswordField textfield2=new JPasswordField();
	JButton loninButton ;
	JLabel bg;
	JPanel panel=new JPanel();
	MyFrame  m;
	Icon loginIcon ;
	public boolean exit;
	loginfream(MyFrame m){
		super("��¼����");
		this.m=m;
		TestFream.SiteInit(this,400,300);
		//���ò������
		this.setResizable(false);
		panel.setLayout(null);
		jl.setFont(new Font("����", Font.PLAIN, 20));
		jl.setForeground(Color.blue);
		jl.setLayout(null);
		jl.setBounds(50, 60, 120, 30);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		textfield.setFont(new Font("����", Font.PLAIN, 20));
		textfield.setLayout(null);
		//mFrame.add(textfield); 
		textfield.setBounds(120, 60, 170, 30);
		
		

		jl2.setFont(new Font("����", Font.PLAIN, 20));
		jl2.setLayout(null);
		jl2.setForeground(Color.blue);
		jl2.setBounds(50, 120, 120, 30);
		

		textfield2.setFont(new Font("����", Font.PLAIN, 20));
		textfield2.setLayout(null);
		//mFrame.add(textfield2); 
		textfield2.setBounds(120, 120, 170, 30);
		
		loninButton = new JButton("��¼");
		loninButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		loninButton.setLayout(null);
		loninButton.setForeground(Color.red);
		loninButton.setBounds(145, 170, 110, 50);
		loninButton.setOpaque(false);
		loginIcon =new ImageIcon("image\\login.png");
		loninButton.setIcon(loginIcon);
		panel.add(jl);
		panel.add(jl2);
		panel.add(textfield);
		panel.add(textfield2);
		panel.add(loninButton);
		
		realizePassWorld = new JCheckBox("��ס����");
		realizePassWorld.setBounds(300,125,80,20);
		realizePassWorld.setOpaque(false);//ʹ��͸��
		panel.add(realizePassWorld);
		bg= new JLabel(new ImageIcon("image\\aa.jpg")); 
		bg.setLayout(null);
		bg.setBounds(0,0,400,300);
		panel.add(bg);
		this.add(panel);
		loninButton.addActionListener(new JbuttonAction(this));
		textfield.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			JTextField field =  (JTextField) e.getSource();
			if(field.getText().equals("�����������˺�....")){
				field.setText("");
			}
		}
	});
		addWindowListener(new MyWin(this));
	}
	
	
	
	boolean getflag(){
		return flag;
	}
	
	
}

//��ť������
class JbuttonAction implements ActionListener{
	loginfream m;
	String id,passworld;
	JbuttonAction(loginfream m){
	     this.m=m;
	  }
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		String select = e.getActionCommand();
		if(select=="��¼"){
			System.out.println("�и�ɵ�Ƶ����½����");
			//��½
			id = m.textfield.getText().toString();
			passworld = m.textfield2.getText();
			User test = new User(id, passworld);
			if(id.equals("admin")&&passworld.equals("admin")||flaguser()){
				JOptionPane.showMessageDialog(m, "��¼�ɹ���~~~~");
				System.out.println(id+"��¼�ɹ�����");
			
				m.flag=true;//m.m.flag=true;
				if(!m.realizePassWorld.isSelected())
				m.textfield2.setText(null);//��½�ɹ���������ı����
				m.dispose();
				m.m.setVisible(true);
				//m.m.setEnabled(true);//���������ڿɼ�
				//��һ��m�����½С���ڣ��ڶ������ڴ������������
				//����û������½ ��½������� ����һ�����½�رմ��ڴӶ����������棬�����
				//ֱ�ӹر����ҳ���أ���Ҫ��ӹر�ҳ���������Ϣ
				
			}else if(!AddbuttonAction.user.contains(test)){
				JOptionPane.showMessageDialog(null, "�˺Ų����ڣ������������룡�r(�s���t)�q", "��¼ʧ��",JOptionPane.ERROR_MESSAGE); 
			}else{
				//JOptionPane warning = new JOptionPane();
				//warning.showMessageDialog(m, "�û������������");
				JOptionPane.showMessageDialog(null, "����������������룡�r(�s���t)�q", "��¼ʧ��",JOptionPane.ERROR_MESSAGE); 
			}
			
			
		}
	}
	boolean flaguser(){
		//ArrayList<User> arrayList = AddbuttonAction.user;
		Iterator<User> s = AddbuttonAction.user.iterator();
		while(s.hasNext()){
			User aUser = s.next();
			if(aUser.id.equals(id)&&aUser.passworld.equals(passworld)){
				return true;
			}
		}
		return false;
	}

}


class MyWindowListener extends WindowAdapter{
	MyFrame MyWindowClose;
	MyWindowListener(MyFrame MyWindowClose){
		this.MyWindowClose = MyWindowClose;
	}
   public void windowClosing(WindowEvent e) {
        super.windowClosing(e); 
        System.out.println("����Ҫ����5555");
        MyWindowClose.exit=true;
       
   }  
}  
//��¼���ڹرռ���
class MyWin extends WindowAdapter{
	loginfream MyWindowClose;
	MyWin(loginfream MyWindowClose){
			this.MyWindowClose =MyWindowClose;
	
	}
   public void windowClosing(WindowEvent e) {
        super.windowClosing(e); 
        MyWindowClose.m.setVisible(true);
       // MyWindowClose.m.setEnabled(true);
        MyWindowClose.m.test.login.textfield.setText("�����������˺�....");
        MyWindowClose.m.test.login.textfield2.setText("");
        
        System.out.println("����Ҫ����5555");
        MyWindowClose.exit=true;
       
   }  
}
