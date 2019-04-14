package com.cn;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StudentUi extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addStudentjButton;
	JButton reviseJButton;
	JButton removeJButton;
	JButton seeaboutJbButton;
	JButton showJbButton;
	JButton lookjButton;
	JTextField lookjField;
    JTable jt;//��ά��Ԫ��
    JScrollPane jsp;//������
	ImageIcon seeaboutIcon,addStudentIcon,reviseIcon,removeIcon,showIcon;
	MyFrame myFrame;
	//StudentModel sm;
	String sql;
	JPanel p ;
	JLabel titleJLabel;
	DefaultTableModel tableModel;   //���ģ�Ͷ���
	DefaultTableCellRenderer renderer;
	StudentMessage s;
	StuAdd a;
	//JLabel bg;
	 StudentUi(MyFrame myFrame) {
		// TODO Auto-generated constructor stub
		super("ѧ����Ϣ");

		this.myFrame = myFrame;
		a = new StuAdd(this);
		a.setVisible(false);
        String[] columnNames = {"����","ѧ��","רҵ","�༶","�ֻ�����","��ͥסַ","�Ա�"};   //����
        String [][]tableVales={}; //����
		tableModel = new DefaultTableModel(tableVales,columnNames);
        //��ʼ��
        jt = new JTable(tableModel){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
            {
                       return false;//��������༭
            }
	 	};
	 	//����һ��ѡһ��
	 	//jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jt.setFont(new Font("Menu.font", Font.PLAIN, 30));
        jt.setRowHeight(30);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setOpaque(false);//render��Ԫ�������
		//��������������У�������Ⱦ������Ϊrenderer
		for(int i = 0 ; i < columnNames.length ; i ++)
		{
			jt.getColumn(columnNames[i]).setCellRenderer(renderer);
		}
		myFrame.setVisible(false);
		 p= new JPanel() {
			
	            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                ImageIcon ii = new ImageIcon("image\\StuMessBk.jpg");
	                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
	            }
	        };
	    
	    titleJLabel = new JLabel("ѧ����Ϣ���£�");
	    titleJLabel.setFont(new Font("����", Font.PLAIN, 50));
	    titleJLabel.setForeground(Color.red);
	    titleJLabel.setBounds(420,20, 500,50);
	    
	    showJbButton =new JButton("��ʾ������Ϣ");
	    showIcon = new ImageIcon("image\\showIcon.png");
	    showJbButton.setIcon(showIcon);
	    showJbButton = new JButton("��ʾ������Ϣ");
	    showJbButton.setFont(new Font("����", Font.PLAIN, 20));
	    showJbButton.setForeground(Color.blue);
	    showJbButton.setBounds(80,20, 200, 30);
	    showIcon = new ImageIcon("image\\showIcon.png");
	    showJbButton.setIcon(showIcon);
	    
	    
		addStudentjButton = new JButton("����ѧ����Ϣ");
		addStudentjButton.setFont(new Font("����", Font.PLAIN, 30));
		addStudentjButton.setForeground(Color.blue);
		//addStudentjButton.setLayout(null);
		addStudentjButton.setBounds(80,80, 200, 30);
		addStudentIcon = new ImageIcon("image\\addStudentIcon.png");
		addStudentjButton.setIcon(addStudentIcon);
		
		reviseJButton = new JButton("�޸�ѧ����Ϣ");
		
		reviseJButton.setFont(new Font("����", Font.PLAIN, 30));
		reviseJButton.setForeground(Color.blue);
		//reviseJButton.setLayout(null);
		reviseJButton.setBounds(80, 140, 200, 30);
		reviseIcon = new ImageIcon("image\\reviseIcon.png");
		reviseJButton.setIcon(reviseIcon);
		
		removeJButton = new JButton("ɾ��ѧ����Ϣ");
		
		removeJButton.setFont(new Font("����", Font.PLAIN, 30));
		removeJButton.setForeground(Color.blue);
		//removeJButton.setLayout(null);
		removeJButton.setBounds(80, 200, 200, 30);
		removeIcon = new ImageIcon("image\\removeIcon.png");
		removeJButton.setIcon(removeIcon);
		
		seeaboutJbButton = new JButton("����ѧ����Ϣ");
		seeaboutJbButton.setFont(new Font("����", Font.PLAIN, 30));
		seeaboutJbButton.setForeground(Color.blue);
		//seeaboutJbButton.setLayout(null);
		seeaboutJbButton.setBounds(80, 260, 200, 30);
		seeaboutIcon = new ImageIcon("image\\seeaboutIcon.png");
		seeaboutJbButton.setIcon(seeaboutIcon);
		//���رյ��̴���
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new StuAddWin(myFrame));
		
		
		lookjButton =new JButton("����");
		lookjField = new  JTextField("������Ҫ��ѧ����ѧ��:");
		lookjButton.setVisible(false);
		lookjField.setVisible(false);
		lookjField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JTextField field =  (JTextField) e.getSource();
				if(field.getText().equals("������Ҫ��ѧ����ѧ��:")){
					field.setText("");
				}
			}
		});
		lookjButton.setFont(new Font("����", Font.PLAIN, 30));
		lookjButton.setForeground(Color.blue);
		lookjButton.setBounds(140, 400, 100, 40);
		lookjButton.setIcon(seeaboutIcon);
		
		lookjField.setFont(new Font("����", Font.PLAIN, 20));
		lookjField.setForeground(Color.red);
		lookjField.setBounds(90, 340, 220, 40);

		lookjButton.addActionListener(new StudentMessage(this));
		addStudentjButton.addActionListener(new StudentMessage(this));
		seeaboutJbButton.addActionListener(new StudentMessage(this));
		removeJButton.addActionListener(new StudentMessage(this));
		reviseJButton.addActionListener(new StudentMessage(this));
		showJbButton.addActionListener(new StudentMessage(this));
		setJButton(lookjButton);
		setJButton(addStudentjButton);
		setJButton(removeJButton);
		setJButton(seeaboutJbButton);
		setJButton(reviseJButton);
		setJButton(showJbButton);
        p.setLayout(null);
		p.add(lookjButton);
		p.add(lookjField);
		p.add(showJbButton);
		p.add(seeaboutJbButton);
		p.add(reviseJButton);
		p.add(addStudentjButton);
		p.add(removeJButton);
		
		sql="";
        //�����п�
        jt.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(120);
        jt.getColumnModel().getColumn(1).setPreferredWidth(120);
        
        jt.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(120);
        jt.getColumnModel().getColumn(2).setPreferredWidth(120);
        
        jt.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(130);
        jt.getColumnModel().getColumn(3).setPreferredWidth(130);
        
        jt.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(150);
        jt.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        jt.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
        jt.getColumnModel().getColumn(5).setPreferredWidth(220);
        
        jt.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(20);
        jt.getColumnModel().getColumn(6).setPreferredWidth(50);
        jsp = new JScrollPane(jt);
        jsp.setBounds(400, 100, 1300, 600);
        jsp.setVisible(false);
        jt.setOpaque(false);//��table����Ϊ͸��  
        jsp.setOpaque(false);//��jsp���������Ϊ͸��  
        jsp.getViewport().setOpaque(false);//��jsp��viewport����Ϊ͸��  
        jt.getTableHeader().setFont(new Font("Dialog", 0, 20));
        //jt.getTableHeader().setBackground(Color.blue);
        p.add(titleJLabel);
        p.add(jsp);
		this.add(p);
		TestFream.SiteInit(this, 350, 400);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
		/*
		 * ���ð�ť���͸�� 
		 */
		private void setJButton(JButton btn) {  
			btn.setBackground(new Color(102, 0, 204));// ��ɫ 
			btn.setFont(new Font("Dialog", Font.BOLD, 24));  
			btn.setOpaque(false);  
			btn.setBorder(BorderFactory.createEmptyBorder());  
		}
}
class StudentMessage implements ActionListener{
	StudentUi m;
	
    GetRowMessage getMessage;
	static int index;
	StudentMessage(StudentUi m){
		this.m=m;

		getMessage = new GetRowMessage(m);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String select=e.getActionCommand();
		if(select=="����ѧ����Ϣ"){
			//m.addStudentjButton.setVisible(false);
			m.setVisible(false);
			TestFream.SiteInit(m, 1800, 800);
			m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			m.a.setVisible(true);


			
		}else if(select=="��ʾ������Ϣ"){
			TestFream.SiteInit(m, 1800, 800);
			//m.setVisible(false);
			//m.setVisible(true);
			m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			m.jsp.setVisible(true);
            //��յ�Ԫ������Ȼ�����¶�ȡ
				DefaultTableModel model =(DefaultTableModel)m.jt.getModel();
				 while(model.getRowCount()>0){
				      model.removeRow(model.getRowCount()-1);
				 }
			try {
				getMessage.GetRow();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(select=="ɾ��ѧ����Ϣ"){
			//m.removeJButton.setVisible(false);

			TestFream.SiteInit(m, 1800, 800);
			m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			m.jsp.setVisible(true);
			try {
				getMessage.GetRow();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if((index=m.jt.getSelectedRow())!=-1){
				try {
					getMessage.deleStu(m.jt.getValueAt(index, 1).toString());
					System.out.println("ɾ��ѧ��ѧ�ţ�"+m.jt.getValueAt(index, 1).toString());
					//��յ�Ԫ������Ȼ�����¶�ȡ
					DefaultTableModel model =(DefaultTableModel) m.jt.getModel();
					 while(model.getRowCount()>0){
					      model.removeRow(model.getRowCount()-1);
					 }
					getMessage.GetRow();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "����ѡ��Ҫɾ����ѧ��Ŷ~~");
			}
		}else if(select=="����ѧ����Ϣ"){
			//m.seeaboutJbButton.setVisible(false);
			//��յ�Ԫ������Ȼ�����¶�ȡ
			DefaultTableModel model =(DefaultTableModel) m.jt.getModel();
			 while(model.getRowCount()>0){
			      model.removeRow(model.getRowCount()-1);
			 }
			//�������ѧ����Ϣ��Ԫ����ʾ����ѧ����Ϣ
			try {
				getMessage.GetRow();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			m.lookjButton.setVisible(true);
			m.lookjField.setVisible(true);
			TestFream.SiteInit(m, 1800, 800);
			m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			JOptionPane.showMessageDialog(null, "�������·��ı�������Ҫ��ѯѧ��ѧ��Ŷ~~");
			m.jsp.setVisible(true);

			
		}else if(select=="�޸�ѧ����Ϣ"){
			//m.reviseJButton.setVisible(false);
			TestFream.SiteInit(m, 1800, 800);
			m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			m.jsp.setVisible(true);
			if((index=m.jt.getSelectedRow())!=-1){
				
				System.out.println("�޸�ѧ��ѧ�ţ�"+m.jt.getValueAt(index, 1).toString());
				//getMessage.revision(m.jt.getValueAt(index, 1).toString());
				m.a.jb1.setText("�޸�");
				m.a.title.setText("�޸�ѧ����Ϣ");
				m.a.title.setText("�޸�ѧ����Ϣ");
				//�޸Ľ�����ʾ
				m.a.setVisible(true);
				m.a.nameField.setText(m.jt.getValueAt(index, 0).toString());
				m.a.numField.setText(m.jt.getValueAt(index, 1).toString());
				m.a.majorField.setText(m.jt.getValueAt(index, 2).toString());
				m.a.classnumField.setText(m.jt.getValueAt(index, 3).toString());
				m.a.phonenumField.setText(m.jt.getValueAt(index, 4).toString());
				m.a.houseaddressField.setText(m.jt.getValueAt(index, 5).toString());
				m.a.mStudentUi.setVisible(false);

			}else{

				JOptionPane.showMessageDialog(null, "����ѡ��Ҫ�޸ĵ�ѧ��Ŷ~~");
			}
		}else if(select=="����"){
			try {

				//��յ�Ԫ������Ȼ�����¶�ȡ
				DefaultTableModel model =(DefaultTableModel) m.jt.getModel();
				 while(model.getRowCount()>0){
				      model.removeRow(model.getRowCount()-1);
				 }
				getMessage.lookMessage(m.lookjField.getText());
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{

					m.lookjField.setText("������Ҫ��ѧ����ѧ��:");
			}
		
		}

	}
	
}


//�رմ��ڴ����¼�
class StuAddWin extends WindowAdapter{
	MyFrame myFrame;
	StuAddWin(MyFrame myFrame){
	  this.myFrame=myFrame;
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		myFrame.setVisible(true);
	}
}
