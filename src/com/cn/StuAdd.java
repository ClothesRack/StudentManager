package com.cn;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class StuAdd extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp;
	JTextField numField,classnumField,nameField,phonenumField,majorField,houseaddressField;
	JLabel numJLabel,classnumJLabel,nameJLabel,phonenumjJLabel,majorJLabel,houseaddressJLabel,sexJLabel;
	JLabel title;
	StudentUi mStudentUi;
	JButton jb1 ,jb2;
	JComboBox jcb ;
	StuAdd(StudentUi mStudentUi){
		super("����ѧ����Ϣ");
		this.mStudentUi = mStudentUi;
		numField = new JTextField();
		TestFream.SiteInit(this, 400, 630);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		 jp= new JPanel() {
				
	            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                ImageIcon ii = new ImageIcon("image\\StuAdd.jpg");
	                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
	            }
	        };
		classnumField = new JTextField();
		nameField = new JTextField();
		phonenumField = new JTextField();
		majorField = new JTextField();
		houseaddressField = new JTextField();
		
		//nameField.setLayout(null);
		nameField.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		nameField.setBounds(105, 60, 230, 40);
		
		numField.setLayout(null);
		numField.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		numField.setBounds(105, 130, 230, 40);
		
		
		//majorField.setLayout(null);
		majorField.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		majorField.setBounds(105, 200, 230,  40);
		
		classnumField.setLayout(null);
		classnumField.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		classnumField.setBounds(105, 270, 230, 40);
		
		//phonenumField.setLayout(null);
		phonenumField.setFont(new Font("΢���ź�", Font.PLAIN,25));
		phonenumField.setBounds(105, 340, 230,  40);

		
		//houseaddressField.setLayout(null);
		houseaddressField.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		houseaddressField.setBounds(105, 410, 230, 40);
		
		title = new JLabel("����ѧ����Ϣ");
		title .setFont(new Font("΢���ź�", Font.PLAIN, 30));
		title.setForeground(Color.red);
		title.setBounds(90, 10, 200, 40);
		
		numJLabel = new JLabel("ѧ��:");
		classnumJLabel = new JLabel("�༶:");
		nameJLabel = new JLabel("����:");
		phonenumjJLabel = new JLabel("�ֻ�����:");
		majorJLabel = new JLabel("רҵ:");
		houseaddressJLabel = new JLabel("��ͥסַ:");
		
		numJLabel.setFont(new Font("΢���ź�", Font.PLAIN,20));
		numJLabel.setForeground(Color.blue);
		numJLabel.setBounds(10, 120,100, 60);
		
		phonenumjJLabel.setFont(new Font("΢���ź�", Font.PLAIN,20));
		phonenumjJLabel.setForeground(Color.blue);
		phonenumjJLabel.setBounds(10, 330,100, 60);
		
		classnumJLabel.setFont(new Font("΢���ź�", Font.PLAIN,20));
		classnumJLabel.setForeground(Color.blue);
		classnumJLabel.setBounds(10, 260,100, 60);
		
		majorJLabel.setFont(new Font("΢���ź�", Font.PLAIN,20));
		majorJLabel.setForeground(Color.blue);
		majorJLabel.setBounds(10, 150,100, 60);
		
		nameJLabel.setFont(new Font("΢���ź�", Font.PLAIN,20));
		nameJLabel.setForeground(Color.blue);
		nameJLabel.setBounds(10, 50,100, 60);
		
		houseaddressJLabel.setFont(new Font("΢���ź�", Font.PLAIN,20));
		houseaddressJLabel.setForeground(Color.blue);
		houseaddressJLabel.setBounds(10, 400,100, 60);
		
		sexJLabel = new JLabel("�Ա�:");
		sexJLabel.setFont(new Font("΢���ź�", Font.PLAIN,20));
		sexJLabel.setForeground(Color.blue);
		sexJLabel.setBounds(10, 460,60, 60);
		
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("ȡ��");
		jb1.setFont(new Font("΢���ź�", Font.PLAIN,20));
		jb1.setForeground(Color.red);
		jb1.setBounds(80, 520,80, 60);
		
		jb2.setFont(new Font("΢���ź�", Font.PLAIN,20));
		jb2.setForeground(Color.red);
		jb2.setBounds(260, 520,80, 60);
		
		String[] sg= {"��","Ů"};
		jcb = new JComboBox(sg);
		jcb.setBounds(105,480,100,20);
		jp.setLayout(null);
		jp.add(jcb);
		jp.add(sexJLabel);
		jp.add(numField);
		jp.add(classnumField);
		jp.add(majorField);
		jp.add(houseaddressField);
		jp.add(phonenumField);
		jp.add(nameField);
		jp.add(title);
		jp.add(numJLabel);
		jp.add(phonenumjJLabel);
		jp.add(houseaddressJLabel);
		jp.add(majorJLabel);
		jp.add(classnumJLabel);
		jp.add(nameJLabel);
		jp.add(jb1);
		jp.add(jb2);
		this.add(jp);
		addWindowListener(new winaddClose(this));
		jb1.addActionListener(new AddStu(this));
		jb2.addActionListener(new AddStu(this));
	}
}

class AddStu implements ActionListener{
	StuAdd a;
	GetRowMessage message;
	AddStu(StuAdd a){
		this.a = a;
		message = new GetRowMessage(this.a.mStudentUi);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String select=e.getActionCommand();
		if(select=="ȷ��"){
			if(a.nameField.getText().equals("")||a.numField.getText().equals("")||a.majorField.getText().equals("")
				||a.classnumField.getText().equals("")||a.phonenumField.getText().equals("")||a.houseaddressField.getText().equals("")){
					JOptionPane.showMessageDialog(a, "����һ��������Ϣû����д�ϣ�����һ�������ύ��~~~~");	
				}else{
					Connection ct = null;
		            PreparedStatement pstmt = null;
		            ResultSet rs = null;
		            
		            try{
		                //1.��������
		                Class.forName("com.mysql.cj.jdbc.Driver");
		                System.out.println("���سɹ�");
		                //2.�������ݿ�
		                //���弸������

		                ct = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd);
		        
		                //�����������
		            
		                String strsql = "insert into student values(?,?,?,?,?,?,?)";
		                pstmt = ct.prepareStatement(strsql);
		               
		                //������ֵ
		                pstmt.setString(1,a.nameField.getText());
		                pstmt.setString(2,a.numField.getText());
		                pstmt.setString(3,a.majorField.getText());
		                pstmt.setString(4,a.classnumField.getText());
		                pstmt.setString(5,a.phonenumField.getText());
		                pstmt.setString(6,a.houseaddressField.getText());
		                pstmt.setString(7,(String)a.jcb.getSelectedItem());
		                pstmt.executeUpdate();
		             
		              //��յ�Ԫ������Ȼ�����¶�ȡ
						DefaultTableModel model =(DefaultTableModel)a.mStudentUi.jt.getModel();
						 while(model.getRowCount()>0){
						      model.removeRow(model.getRowCount()-1);
						 }
		                message.GetRow();
		                a.mStudentUi.jsp.setVisible(true);
		                a.setVisible(false);
		                a.mStudentUi.setVisible(true);
		                a.classnumField.setText(null);
		                a.houseaddressField.setText(null);
		                a.majorField.setText(null);
		                a.nameField.setText(null);
		                a.phonenumField.setText(null);
		                a.numField.setText(null);
		/*   		     //�����ٻ���µ�����ģ��,
		   		     try {
		   		    	  message = new GetRowMessage(this);
		   				a.mStudentUi.sm = new StudentModel("");
		   				a.mStudentUi.tableModel.addRow(a.mStudentUi.sm);
		                a.mStudentUi.jsp.setVisible(true);
		                a.setVisible(false);
		                a.mStudentUi.setVisible(true);
		                
		   		     	} catch (SQLException e1) {
		   				// TODO Auto-generated catch block
		   				e1.printStackTrace();
		   		     	}*/

		              
		            }catch(Exception arg1){
		                arg1.printStackTrace();
		            }finally{
		                try{
		                if(rs!=null){
		                rs.close();
		                rs = null;
		                    }
		                if(pstmt != null){
		                pstmt.close();
		                pstmt = null;
		                    }
		                if(ct != null){
		                ct.close();
		                ct = null;
		                    }                
		                }catch(Exception arg2){
		                    arg2.printStackTrace();
		                }
		            }
				}
            
            
        }else if(select=="ȡ��"){
        	a.mStudentUi.setVisible(true);
        	a.setVisible(false);
        }else if(select=="�޸�"){
        	//GetRowMessage revis =new GetRowMessage(a.mStudentUi);
        	if(a.nameField.getText().equals("")||a.numField.getText().equals("")||a.majorField.getText().equals("")
    				||a.classnumField.getText().equals("")||a.phonenumField.getText().equals("")||a.houseaddressField.getText().equals("")){
    					JOptionPane.showMessageDialog(a, "����һ��������Ϣû����д�ϣ�����һ�������ύ��~~~~");	
    				}else{
    					try {
    		        		
    		        		//�޸������ĺ���
    		        		message.revision(a.mStudentUi.jt.getValueAt(StudentMessage.index, 1).toString());
    						//��յ�Ԫ������Ȼ�����¶�ȡ
    						DefaultTableModel model =(DefaultTableModel) a.mStudentUi.jt.getModel();
    						 while(model.getRowCount()>0){
    						      model.removeRow(model.getRowCount()-1);
    						 }
    						 a.mStudentUi.setVisible(true);
    						 a.setVisible(false);
    						 message.GetRow();
    						 a.jb1.setText("ȷ��");
    		                a.mStudentUi.setVisible(true);
    		                a.classnumField.setText(null);
    		                a.houseaddressField.setText(null);
    		                a.majorField.setText(null);
    		                a.nameField.setText(null);
    		                a.phonenumField.setText(null);
    		                a.numField.setText(null);
    						
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    		        }
    				}
    				}
        	
	
	
}
class winaddClose extends WindowAdapter{
	StuAdd mAdd;
	public winaddClose(StuAdd mAdd) {
		// TODO Auto-generated constructor stub
		this.mAdd=mAdd;
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		mAdd.mStudentUi.setVisible(true);
		}
}