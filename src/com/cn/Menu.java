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
	boolean exit=false;//多线程停止判断flag
	MenuAction test;
	//菜单条
	JMenuBar bar = new JMenuBar();
	JMenu user = new JMenu("账户");
	JMenu function = new JMenu("功能");
	JMenu imessage = new JMenu("数据信息");
	JMenuItem StundentMessage = new JMenuItem("^学生信息^");
	JMenuItem IDMessage = new JMenuItem("^账号信息^");
	JMenuItem LoginMenu = new JMenuItem("^登录^");
	JMenuItem exitMenu = new JMenuItem("^退出^");
	JMenuItem addMenu = new JMenuItem("^注册新账号^");
	JMenuItem ChangeMenu = new JMenuItem("^修改账户信息^");
	JPanel c ;
	JLabel bg;
	MyFrame(){
		//菜单监视器对象=   
		test=new MenuAction(this);
		setTitle("学生管理系统");
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
		//不可放大
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
		bg.setBounds(0,0,800,600);// 疑问 ：为什么不加这个代码也可以贴图
		c = new JPanel();
		c.add(bg);
		
		this.add(c);

		
		
		this.setVisible(true);
		addWindowListener(new MyWindowListener(this));  
		
		
	}
}
//登录菜单监视器
class MenuAction implements ActionListener{
	MyFrame m;
	loginfream login;
	AddId addIdfream;
	AddId  reviser;
	StudentUi StuMessage;
	MenuAction(MyFrame m){
	     this.m=m;
	 	login = new loginfream( m);//菜单监视器对象创建的同时必须创建个登陆面的对象，默认让它不可见。这样就可以
	 							//调用他的flag的值传给你的Thread线程。当点击登陆再让这个页面加载出来就OK了！
	 	addIdfream=new AddId(m);	
	 	System.out.println("窗口初始化");
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		String select = e.getActionCommand();
		if(select=="^登录^"){
			login.setVisible(true);	//窗口可见
			//m.setEnabled(false);//先将主界面设置为不可操作状态
			m.setVisible(false);
		}else if(select=="^退出^"){
				login.flag=false;
				m.LoginMenu.setText("^登录^");
				//m.LoginMenu.setEnabled(true);
				JOptionPane.showMessageDialog(null, "~~~尊贵的"+login.textfield.getText()+"管理员，您以成功退出，欢迎体验本服务系统，期待与您下一次相遇~~~", "退出成功",JOptionPane.WARNING_MESSAGE);
				System.out.println("这个猪退出程序啦~");

		}else if(select=="^修改账户信息^"){
			//登录的话就可以修改信息了 额 那就要给修改信息那个页面一个存在的对象了
			//或者用注册页面的addidfream对象也可以；
			reviser= new AddId(m);
			reviser.textfield.setText("");
			reviser.AddButton.setText("修改");
			reviser.setTitle("修改用户信息");
			reviser.AddButton.setIcon(reviser.reviseIcon);
			reviser.setVisible(true);
			//m.setEnabled(false);
			m.setVisible(false);
		}else if(select=="^注册新账号^"){
			addIdfream.setVisible(true);
			//m.setEnabled(false);//先将主界面设置为不可操作状态
			m.setVisible(false);//先将主界面设置为不可见
		}else if(select.equals("^您好，"+login.textfield.getText())){
			JOptionPane.showMessageDialog(null, "哎呀ya，"+login.textfield.getText()+",你点疼人家了~~", "~~~~",JOptionPane.WARNING_MESSAGE);
		}else if(select=="^学生信息^"){
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
	JLabel jl = new JLabel("账号：");
	JLabel jl2 = new JLabel("密码：");
	JTextField textfield=new JTextField("请输入您的账号....",30);
	JPasswordField textfield2=new JPasswordField();
	JButton loninButton ;
	JLabel bg;
	JPanel panel=new JPanel();
	MyFrame  m;
	Icon loginIcon ;
	public boolean exit;
	loginfream(MyFrame m){
		super("登录界面");
		this.m=m;
		TestFream.SiteInit(this,400,300);
		//设置不能最大化
		this.setResizable(false);
		panel.setLayout(null);
		jl.setFont(new Font("宋体", Font.PLAIN, 20));
		jl.setForeground(Color.blue);
		jl.setLayout(null);
		jl.setBounds(50, 60, 120, 30);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		textfield.setFont(new Font("宋体", Font.PLAIN, 20));
		textfield.setLayout(null);
		//mFrame.add(textfield); 
		textfield.setBounds(120, 60, 170, 30);
		
		

		jl2.setFont(new Font("宋体", Font.PLAIN, 20));
		jl2.setLayout(null);
		jl2.setForeground(Color.blue);
		jl2.setBounds(50, 120, 120, 30);
		

		textfield2.setFont(new Font("宋体", Font.PLAIN, 20));
		textfield2.setLayout(null);
		//mFrame.add(textfield2); 
		textfield2.setBounds(120, 120, 170, 30);
		
		loninButton = new JButton("登录");
		loninButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		
		realizePassWorld = new JCheckBox("记住密码");
		realizePassWorld.setBounds(300,125,80,20);
		realizePassWorld.setOpaque(false);//使其透明
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
			if(field.getText().equals("请输入您的账号....")){
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

//按钮监听器
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
		if(select=="登录"){
			System.out.println("有个傻逼点击登陆啦！");
			//登陆
			id = m.textfield.getText().toString();
			passworld = m.textfield2.getText();
			User test = new User(id, passworld);
			if(id.equals("admin")&&passworld.equals("admin")||flaguser()){
				JOptionPane.showMessageDialog(m, "登录成功啦~~~~");
				System.out.println(id+"登录成功啦！");
			
				m.flag=true;//m.m.flag=true;
				if(!m.realizePassWorld.isSelected())
				m.textfield2.setText(null);//登陆成功将密码框文本清空
				m.dispose();
				m.m.setVisible(true);
				//m.m.setEnabled(true);//设置主窗口可见
				//第一个m代表登陆小窗口，第二个窗口代表程序主窗口
				//如果用户点击登陆 登陆界面出来 他不一定点登陆关闭窗口从而激活主界面，如果他
				//直接关闭这个页面呢？需要添加关闭页面的设置信息
				
			}else if(!AddbuttonAction.user.contains(test)){
				JOptionPane.showMessageDialog(null, "账号不存在，请检查重新输入！╮(╯▽╰)╭", "登录失败",JOptionPane.ERROR_MESSAGE); 
			}else{
				//JOptionPane warning = new JOptionPane();
				//warning.showMessageDialog(m, "用户名或密码错误");
				JOptionPane.showMessageDialog(null, "密码错误，请重新输入！╮(╯▽╰)╭", "登录失败",JOptionPane.ERROR_MESSAGE); 
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
        System.out.println("他不要我啦5555");
        MyWindowClose.exit=true;
       
   }  
}  
//登录窗口关闭监听
class MyWin extends WindowAdapter{
	loginfream MyWindowClose;
	MyWin(loginfream MyWindowClose){
			this.MyWindowClose =MyWindowClose;
	
	}
   public void windowClosing(WindowEvent e) {
        super.windowClosing(e); 
        MyWindowClose.m.setVisible(true);
       // MyWindowClose.m.setEnabled(true);
        MyWindowClose.m.test.login.textfield.setText("请输入您的账号....");
        MyWindowClose.m.test.login.textfield2.setText("");
        
        System.out.println("他不要我啦5555");
        MyWindowClose.exit=true;
       
   }  
}
