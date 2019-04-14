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
	JLabel jl = new JLabel("�˺ţ�");
	JLabel jl2 = new JLabel("���룺");
	JTextField textfield;
	JPasswordField textfield2;
	JButton AddButton = new JButton("ע��");
	JLabel bg,FlagPicture;
	Icon addIcon;
	Icon reviseIcon;
	JPanel panel=new JPanel();
	List <Icon> s1;
	AddId(MyFrame m){
		super("ע�����˺�");
		//this.setTitle("ע�����˺�");һ����˼
		this.m=m;
		TestFream.SiteInit(this,400,300);
		
		panel.setLayout(null);
		jl.setFont(new Font("����", Font.PLAIN, 20));
		jl.setForeground(Color.blue);
		jl.setLayout(null);
		jl.setBounds(50, 60, 120, 30);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textfield= new JTextField("���������˺�....");
		textfield.setFont(new Font("����", Font.PLAIN, 20));
		textfield.setLayout(null);
		textfield.setBounds(120, 60, 170, 30);
		
	

		jl2.setFont(new Font("����", Font.PLAIN, 20));
		jl2.setLayout(null);
		jl2.setForeground(Color.blue);
		jl2.setBounds(50, 120, 120, 30);
		
		textfield2= new JPasswordField();
		textfield2.setFont(new Font("����", Font.PLAIN, 20));
		textfield2.setLayout(null);
		//mFrame.add(textfield2); 
		textfield2.setBounds(120, 120, 170, 30);
		

		AddButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
		//m.setEnabled(false);//�Ƚ�����������Ϊ���ɲ���״̬
		
		reviseIcon = new ImageIcon("image\\revise.png");
		addIcon = new ImageIcon("image\\add.png");
		
		AddButton.setIcon(addIcon);
		//	���ڹرռ�����
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
					System.out.println("insertUpdate�д��˺�"+keyword);
				}
				else{
					FlagPicture.setIcon(s1.get(0));
					System.out.println("insertUpdate�޴��˺�"+keyword);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String keyword = textfield.getText();
				User aUser = new User(keyword,null);
				if(AddbuttonAction.user.contains(aUser)||!keyword.matches(reg)||keyword.length()>10){
					
					FlagPicture.setIcon(s1.get(1));
					System.out.println("remove������˺�"+keyword);
				}
				else{	
					FlagPicture.setIcon(s1.get(0));
					System.out.println("remove�޴��˺�"+keyword);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String keyword = textfield.getText();
				User aUser = new User(keyword,null);
				if(AddbuttonAction.user.contains(aUser)||!keyword.matches(reg)||keyword.length()>10){
					
					FlagPicture.setIcon(s1.get(1));
					System.out.println("changed������˺�"+keyword);
				}
				else{
					
					FlagPicture.setIcon(s1.get(0));
					System.out.println("changed�޴��˺�"+keyword);
				}
			}
			
		}); 



		AddButton.addActionListener(new AddbuttonAction(this));
		textfield.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JTextField field =  (JTextField) e.getSource();
			if(field.getText().equals("���������˺�....")){
				field.setText("");
			}
		}
	});
		
		
	}
	
	 void reserve(User addserUser){
		 Iterator<User> t = AddbuttonAction.user.iterator();
		
		 
		 //һ�α���һ���������û�
	/*	 try {
				FileWriter fw=new FileWriter("sendfile.ini",true);
				fw.write(addserUser.id+" "+addserUser.passworld+"\r\n");
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-gxenerated catch block
				e1.printStackTrace();
			}*/
		 

		
		//ÿ���ô�һ�����±����û�����������Ϣ �����ͻ��ظ�������Ϣ ����Ҫ����ļ��Ƿ���� ���ھ�ɾ��
		 String filename="sendfile.ini";
		 File file = new File(filename); 
		 if(!file.exists()){
		 System.out.println("�ļ�������~~~~");
		 }else{
			 System.out.println("�����ļ�~~~~~~~~~");
			 file.delete();//ɾ���ļ�
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
			 
			 //������ÿ�ζ������ļ�����
/*				File writename = new File("output.txt"); 
				try {
					writename.createNewFile();
					BufferedWriter out = new BufferedWriter(new FileWriter(writename));
					out.write(dataUser.id+" "+dataUser.passworld+"\r\n");  
			        out.flush(); // �ѻ���������ѹ���ļ�  
			        out.close(); // ���ǵùر��ļ�
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				}

		 
	 
	 } 
		
}




//ע�ᰴť������
class AddbuttonAction implements ActionListener{
	AddId addId;
	static ArrayList<User> user = new ArrayList<User>();
	AddbuttonAction(AddId addId){
		this.addId=addId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		String select = e.getActionCommand();
		if(select=="ע��"){
		System.out.println("�и�����ע�����˺ţ���Ҫ��Ҫ��������");
		this.adduser1();
	}else if(select=="�޸�"){
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
				System.out.println("ɾ�����˺�"+removUser);
				AddbuttonAction.user.remove(a);
				break;
			}else{
				a++;
				System.out.println("Ŀǰ�����˺ţ�"+removUser.id);
				System.out.println(addId.textfield.getText());
			}

		}
		String reg = "^[^ ]+$";
		if(!id.matches(reg)){
			JOptionPane.showMessageDialog(null, "�˺Ų����пո�����������~~~", "�˺Ÿ�ʽ����",JOptionPane.ERROR_MESSAGE); 
		}else if(!passworld.matches(reg)){
			JOptionPane.showMessageDialog(null, "���벻���пո�����������~~~", "�����ʽ����",JOptionPane.ERROR_MESSAGE); 
		}else if(id.length()>10){
			JOptionPane.showMessageDialog(null, "Ҫ�޸ĵ��˺�̫���������ܼ�ס���10λ��~~~", "�˺Ÿ�ʽ����",JOptionPane.ERROR_MESSAGE); 
		}else if(passworld.length()>10){
			JOptionPane.showMessageDialog(null, "Ҫ�޸ĵ�����̫���������ܼ�ס���10λ��~~~", "�˺Ÿ�ʽ����",JOptionPane.ERROR_MESSAGE); 
		}else{
			User addserUser = new User(id, passworld);
			if(user.contains(revise)){
				JOptionPane.showMessageDialog(null, "��ǰ�˺�ϵͳ�Ѿ�������������������r(�s���t)�q", "�˺��ظ�",JOptionPane.ERROR_MESSAGE); 
			}else {
				user.add(revise);
				System.out.println("�޸ĺ����Ϣ��"+revise);
				//�������δ������˼���޸ĺ����µ�¼ //��Ϊ�õ�¼�������֣����оͲ�Ҫ��������ʾ�ˡ���Ϊ��¼�ɹ����Զ���ʾ������
				addId.m.test.login.flag=false;
				addId.m.LoginMenu.setText("^��¼^");
				addId.m.test.login.textfield.setText(id);
				addId.m.test.login.setVisible(true);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ������μ����޸ĵ���Ϣ��~~~~");
				JOptionPane.showMessageDialog(null, "��ʼ�����˺ŵ�¼��~~~~");
				addId.dispose();
				addId.reserve(addserUser);
				//addId.m.setEnabled(true);//���������ڿɵ�
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
			JOptionPane.showMessageDialog(null, "�˺Ų����пո�����������~~~", "�˺Ÿ�ʽ����",JOptionPane.ERROR_MESSAGE); 
		}else if(!passworld.matches(reg)){
			JOptionPane.showMessageDialog(null, "���벻���пո�����������~~~", "�����ʽ����",JOptionPane.ERROR_MESSAGE); 
		}else if(id.length()>10){
			JOptionPane.showMessageDialog(null, "Ҫע����˺�̫���������ܼ�ס���10λ��~~~", "�˺Ÿ�ʽ����",JOptionPane.ERROR_MESSAGE); 
		}else if(passworld.length()>10){
			JOptionPane.showMessageDialog(null, "Ҫע�������̫���������ܼ�ס���10λ��~~~", "�˺Ÿ�ʽ����",JOptionPane.ERROR_MESSAGE); 
		}else{
			User addserUser = new User(id, passworld);
			if(user.contains(addserUser)){
				JOptionPane.showMessageDialog(null, "��ǰ�˺�ϵͳ�Ѿ�������������������r(�s���t)�q", "�˺��ظ�",JOptionPane.ERROR_MESSAGE); 
			}else {
				user.add(addserUser);
				System.out.println(user);
				JOptionPane.showMessageDialog(null, "��ϲ��ע��ɹ�����ȥ��½�ɣ��r(�s���t)�q", "ע��ɹ�",JOptionPane.WARNING_MESSAGE); 
				addId.textfield.setText("���������˺�....");
				addId.textfield2.setText(null);
				addId.dispose();
				addId.reserve(addserUser);
				//addId.m.setEnabled(true);//���������ڿɵ�
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
		return "{�ʺţ�"+this.id+"���룺"+this.passworld+"}";
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
		//���������ڿɼ�
		mAddId.m.setVisible(true);
		mAddId.textfield2.setText(null);
	}
}
