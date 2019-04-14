package com.cn;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AddId extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyFrame m;
	JLabel jl = new JLabel("账号：");
	JLabel jl2 = new JLabel("密码：");
	JTextField textfield;
	JPasswordField textfield2;
	JButton AddButton = new JButton("注册");
	JLabel bg,FlagPicture;
	Icon addIcon;
	Icon reviseIcon;
	JPanel panel=new JPanel();
	List <Icon> s1;
	AddId(MyFrame m){
		super("注册新账号");
		//this.setTitle("注册新账号");一个意思
		this.m=m;
		TestFream.SiteInit(this,400,300);
		
		panel.setLayout(null);
		jl.setFont(new Font("宋体", Font.PLAIN, 20));
		jl.setForeground(Color.blue);
		jl.setLayout(null);
		jl.setBounds(50, 60, 120, 30);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textfield= new JTextField("请输入新账号....");
		textfield.setFont(new Font("宋体", Font.PLAIN, 20));
		textfield.setLayout(null);
		textfield.setBounds(120, 60, 170, 30);
		
	

		jl2.setFont(new Font("宋体", Font.PLAIN, 20));
		jl2.setLayout(null);
		jl2.setForeground(Color.blue);
		jl2.setBounds(50, 120, 120, 30);
		
		textfield2= new JPasswordField();
		textfield2.setFont(new Font("宋体", Font.PLAIN, 20));
		textfield2.setLayout(null);
		//mFrame.add(textfield2); 
		textfield2.setBounds(120, 120, 170, 30);
		

		AddButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		AddButton.setLayout(null);
		AddButton.setForeground(Color.red);
		AddButton.setBounds(140, 170, 120, 50);
		
		
		panel.add(jl);
		panel.add(jl2);
		panel.add(textfield);
		panel.add(textfield2);
		panel.add(AddButton);
		s1=new ArrayList<Icon>();
		for(int i=0;i<2;i++){
		    Icon image=new ImageIcon("image\\"+i+".png");
		    s1.add(image);
		  }
		FlagPicture = new JLabel();
		FlagPicture.setIcon(null);
		FlagPicture.setLayout(null);
		FlagPicture.setBounds(290,60,30,30);
		panel.add(FlagPicture);
		bg= new JLabel(new ImageIcon("image\\aa.jpg")); 
		bg.setLayout(null);
		bg.setBounds(0,0,400,300);
		panel.add(bg);
		this.add(panel); 
		//this.setVisible(true);
		//m.setEnabled(false);//先将主界面设置为不可操作状态
		
		reviseIcon = new ImageIcon("image\\revise.png");
		addIcon = new ImageIcon("image\\add.png");
		
		AddButton.setIcon(addIcon);
		//	窗口关闭监听器
		addWindowListener(new MyWinadd(this));
		textfield.getDocument().addDocumentListener (new DocumentListener(){
			String reg = "^[^ ]+$";
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String keyword = textfield.getText();
				User aUser = new User(keyword,null);
				if(AddbuttonAction.user.contains(aUser)||!keyword.matches(reg)||keyword.length()>10){
					FlagPicture.setIcon(s1.get(1));
					System.out.println("insertUpdate有此账号"+keyword);
				}
				else{
					FlagPicture.setIcon(s1.get(0));
					System.out.println("insertUpdate无此账号"+keyword);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String keyword = textfield.getText();
				User aUser = new User(keyword,null);
				if(AddbuttonAction.user.contains(aUser)||!keyword.matches(reg)||keyword.length()>10){
					
					FlagPicture.setIcon(s1.get(1));
					System.out.println("remove有这个账号"+keyword);
				}
				else{	
					FlagPicture.setIcon(s1.get(0));
					System.out.println("remove无此账号"+keyword);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String keyword = textfield.getText();
				User aUser = new User(keyword,null);
				if(AddbuttonAction.user.contains(aUser)||!keyword.matches(reg)||keyword.length()>10){
					
					FlagPicture.setIcon(s1.get(1));
					System.out.println("changed有这个账号"+keyword);
				}
				else{
					
					FlagPicture.setIcon(s1.get(0));
					System.out.println("changed无此账号"+keyword);
				}
			}
			
		}); 



		AddButton.addActionListener(new AddbuttonAction(this));
		textfield.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JTextField field =  (JTextField) e.getSource();
			if(field.getText().equals("请输入新账号....")){
				field.setText("");
			}
		}
	});
		
		
	}
	
	 void reserve(User addserUser){
		 Iterator<User> t = AddbuttonAction.user.iterator();
		
		 
		 //一次保存一个新增的用户
	/*	 try {
				FileWriter fw=new FileWriter("sendfile.ini",true);
				fw.write(addserUser.id+" "+addserUser.passworld+"\r\n");
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-gxenerated catch block
				e1.printStackTrace();
			}*/
		 

		
		//每调用此一次重新保存用户集合所有信息 这样就会重复保留信息 所以要检查文件是否存在 存在就删除
		 String filename="sendfile.ini";
		 File file = new File(filename); 
		 if(!file.exists()){
		 System.out.println("文件不存在~~~~");
		 }else{
			 System.out.println("存在文件~~~~~~~~~");
			 file.delete();//删除文件
		 } 
		 while(t.hasNext()){
			 User dataUser = t.next();	
			  try {
				FileWriter fw=new FileWriter("sendfile.ini",true);
				fw.write(dataUser.id+" "+dataUser.passworld+"\r\n");
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-gxenerated catch block
				e1.printStackTrace();
			}
			 
			 //这块代码每次都打开新文件。。
/*				File writename = new File("output.txt"); 
				try {
					writename.createNewFile();
					BufferedWriter out = new BufferedWriter(new FileWriter(writename));
					out.write(dataUser.id+" "+dataUser.passworld+"\r\n");  
			        out.flush(); // 把缓存区内容压入文件  
			        out.close(); // 最后记得关闭文件
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				}

		 
	 
	 } 
		
}




//注册按钮监听器
class AddbuttonAction implements ActionListener{
	AddId addId;
	static ArrayList<User> user = new ArrayList<User>();
	AddbuttonAction(AddId addId){
		this.addId=addId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		String select = e.getActionCommand();
		if(select=="注册"){
		System.out.println("有个猪再注册新账号，咱要不要给他啊？");
		this.adduser1();
	}else if(select=="修改"){
		dduser2();
	}
	
}
	void dduser2(){
		int a=0;
		String id =addId.textfield.getText();
		String passworld = addId.textfield.getText();
		User revise = new User(id, passworld);
		for(User removUser:AddbuttonAction.user){
			if(addId.m.test.login.textfield.getText().equals(removUser.id)){
				System.out.println("删除的账号"+removUser);
				AddbuttonAction.user.remove(a);
				break;
			}else{
				a++;
				System.out.println("目前遍历账号："+removUser.id);
				System.out.println(addId.textfield.getText());
			}

		}
		String reg = "^[^ ]+$";
		if(!id.matches(reg)){
			JOptionPane.showMessageDialog(null, "账号不能有空格请重新输入~~~", "账号格式错误",JOptionPane.ERROR_MESSAGE); 
		}else if(!passworld.matches(reg)){
			JOptionPane.showMessageDialog(null, "密码不能有空格请重新输入~~~", "密码格式错误",JOptionPane.ERROR_MESSAGE); 
		}else if(id.length()>10){
			JOptionPane.showMessageDialog(null, "要修改的账号太长啦，你能记住吗！最长10位呦~~~", "账号格式错误",JOptionPane.ERROR_MESSAGE); 
		}else if(passworld.length()>10){
			JOptionPane.showMessageDialog(null, "要修改的密码太长啦，你能记住吗！最长10位呦~~~", "账号格式错误",JOptionPane.ERROR_MESSAGE); 
		}else{
			User addserUser = new User(id, passworld);
			if(user.contains(revise)){
				JOptionPane.showMessageDialog(null, "当前账号系统已经存在啦！请重新输入╮(╯▽╰)╭", "账号重复",JOptionPane.ERROR_MESSAGE); 
			}else {
				user.add(revise);
				System.out.println("修改后的信息："+revise);
				//以下三段代码的意思是修改后重新登录 //因为让登录界面重现，所有就不要主窗口显示了。因为登录成功会自动显示主界面
				addId.m.test.login.flag=false;
				addId.m.LoginMenu.setText("^登录^");
				addId.m.test.login.textfield.setText(id);
				addId.m.test.login.setVisible(true);
				JOptionPane.showMessageDialog(null, "修改成功！请牢记您修改的信息呦~~~~");
				JOptionPane.showMessageDialog(null, "开始用新账号登录吧~~~~");
				addId.dispose();
				addId.reserve(addserUser);
				//addId.m.setEnabled(true);//设置主窗口可点
				//addId.m.setVisible(true);
			}
		}	
		
	
	}
	 void adduser1(){
		String id = addId.textfield.getText();
		@SuppressWarnings("deprecation")
		String passworld = addId.textfield2.getText();
		String reg = "^[^ ]+$";
		if(!id.matches(reg)){
			JOptionPane.showMessageDialog(null, "账号不能有空格请重新输入~~~", "账号格式错误",JOptionPane.ERROR_MESSAGE); 
		}else if(!passworld.matches(reg)){
			JOptionPane.showMessageDialog(null, "密码不能有空格请重新输入~~~", "密码格式错误",JOptionPane.ERROR_MESSAGE); 
		}else if(id.length()>10){
			JOptionPane.showMessageDialog(null, "要注册的账号太长啦，你能记住吗，最长10位呦~~~", "账号格式错误",JOptionPane.ERROR_MESSAGE); 
		}else if(passworld.length()>10){
			JOptionPane.showMessageDialog(null, "要注册的密码太长啦，你能记住吗，最长10位呦~~~", "账号格式错误",JOptionPane.ERROR_MESSAGE); 
		}else{
			User addserUser = new User(id, passworld);
			if(user.contains(addserUser)){
				JOptionPane.showMessageDialog(null, "当前账号系统已经存在啦！请重新输入╮(╯▽╰)╭", "账号重复",JOptionPane.ERROR_MESSAGE); 
			}else {
				user.add(addserUser);
				System.out.println(user);
				JOptionPane.showMessageDialog(null, "恭喜您注册成功啦快去登陆吧！╮(╯▽╰)╭", "注册成功",JOptionPane.WARNING_MESSAGE); 
				addId.textfield.setText("请输入新账号....");
				addId.textfield2.setText(null);
				addId.dispose();
				addId.reserve(addserUser);
				//addId.m.setEnabled(true);//设置主窗口可点
				addId.m.setVisible(true);
			}
		}	
		
	}
	 
}
class User{
	String id;
	String passworld;
	User(String id,String passworld){
		this.id=id;
		this.passworld=passworld;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassworld() {
		return passworld;
	}
	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		User user =(User)obj;
		return id.equals(user.id);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{帐号："+this.id+"密码："+this.passworld+"}";
	}
}

class MyWinadd extends WindowAdapter{
	AddId mAddId;
	MyWinadd(AddId mAddId){
		this.mAddId = mAddId;
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		//设置主窗口可见
		mAddId.m.setVisible(true);
		mAddId.textfield2.setText(null);
	}
}
