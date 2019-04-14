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
    JTable jt;//二维单元表
    JScrollPane jsp;//滚动条
	ImageIcon seeaboutIcon,addStudentIcon,reviseIcon,removeIcon,showIcon;
	MyFrame myFrame;
	//StudentModel sm;
	String sql;
	JPanel p ;
	JLabel titleJLabel;
	DefaultTableModel tableModel;   //表格模型对象
	DefaultTableCellRenderer renderer;
	StudentMessage s;
	StuAdd a;
	//JLabel bg;
	 StudentUi(MyFrame myFrame) {
		// TODO Auto-generated constructor stub
		super("学生信息");

		this.myFrame = myFrame;
		a = new StuAdd(this);
		a.setVisible(false);
        String[] columnNames = {"姓名","学号","专业","班级","手机号码","家庭住址","性别"};   //列名
        String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
        //初始化
        jt = new JTable(tableModel){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
            {
                       return false;//表格不允许被编辑
            }
	 	};
	 	//设置一次选一行
	 	//jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jt.setFont(new Font("Menu.font", Font.PLAIN, 30));
        jt.setRowHeight(30);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setOpaque(false);//render单元格的属性
		//遍历表格中所有列，将其渲染器设置为renderer
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
	    
	    titleJLabel = new JLabel("学生信息如下：");
	    titleJLabel.setFont(new Font("宋体", Font.PLAIN, 50));
	    titleJLabel.setForeground(Color.red);
	    titleJLabel.setBounds(420,20, 500,50);
	    
	    showJbButton =new JButton("显示所有信息");
	    showIcon = new ImageIcon("image\\showIcon.png");
	    showJbButton.setIcon(showIcon);
	    showJbButton = new JButton("显示所有信息");
	    showJbButton.setFont(new Font("宋体", Font.PLAIN, 20));
	    showJbButton.setForeground(Color.blue);
	    showJbButton.setBounds(80,20, 200, 30);
	    showIcon = new ImageIcon("image\\showIcon.png");
	    showJbButton.setIcon(showIcon);
	    
	    
		addStudentjButton = new JButton("增添学生信息");
		addStudentjButton.setFont(new Font("宋体", Font.PLAIN, 30));
		addStudentjButton.setForeground(Color.blue);
		//addStudentjButton.setLayout(null);
		addStudentjButton.setBounds(80,80, 200, 30);
		addStudentIcon = new ImageIcon("image\\addStudentIcon.png");
		addStudentjButton.setIcon(addStudentIcon);
		
		reviseJButton = new JButton("修改学生信息");
		
		reviseJButton.setFont(new Font("宋体", Font.PLAIN, 30));
		reviseJButton.setForeground(Color.blue);
		//reviseJButton.setLayout(null);
		reviseJButton.setBounds(80, 140, 200, 30);
		reviseIcon = new ImageIcon("image\\reviseIcon.png");
		reviseJButton.setIcon(reviseIcon);
		
		removeJButton = new JButton("删除学生信息");
		
		removeJButton.setFont(new Font("宋体", Font.PLAIN, 30));
		removeJButton.setForeground(Color.blue);
		//removeJButton.setLayout(null);
		removeJButton.setBounds(80, 200, 200, 30);
		removeIcon = new ImageIcon("image\\removeIcon.png");
		removeJButton.setIcon(removeIcon);
		
		seeaboutJbButton = new JButton("查找学生信息");
		seeaboutJbButton.setFont(new Font("宋体", Font.PLAIN, 30));
		seeaboutJbButton.setForeground(Color.blue);
		//seeaboutJbButton.setLayout(null);
		seeaboutJbButton.setBounds(80, 260, 200, 30);
		seeaboutIcon = new ImageIcon("image\\seeaboutIcon.png");
		seeaboutJbButton.setIcon(seeaboutIcon);
		//仅关闭当盘窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new StuAddWin(myFrame));
		
		
		lookjButton =new JButton("查找");
		lookjField = new  JTextField("请输入要查学生的学号:");
		lookjButton.setVisible(false);
		lookjField.setVisible(false);
		lookjField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JTextField field =  (JTextField) e.getSource();
				if(field.getText().equals("请输入要查学生的学号:")){
					field.setText("");
				}
			}
		});
		lookjButton.setFont(new Font("宋体", Font.PLAIN, 30));
		lookjButton.setForeground(Color.blue);
		lookjButton.setBounds(140, 400, 100, 40);
		lookjButton.setIcon(seeaboutIcon);
		
		lookjField.setFont(new Font("宋体", Font.PLAIN, 20));
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
        //设置列宽
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
        jt.setOpaque(false);//将table设置为透明  
        jsp.setOpaque(false);//将jsp根面板设置为透明  
        jsp.getViewport().setOpaque(false);//将jsp的viewport设置为透明  
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
		 * 设置按钮风格：透明 
		 */
		private void setJButton(JButton btn) {  
			btn.setBackground(new Color(102, 0, 204));// 紫色 
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
		if(select=="增添学生信息"){
			//m.addStudentjButton.setVisible(false);
			m.setVisible(false);
			TestFream.SiteInit(m, 1800, 800);
			m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			m.a.setVisible(true);


			
		}else if(select=="显示所有信息"){
			TestFream.SiteInit(m, 1800, 800);
			//m.setVisible(false);
			//m.setVisible(true);
			m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			m.jsp.setVisible(true);
            //清空单元表内容然后重新读取
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
			
		}else if(select=="删除学生信息"){
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
					System.out.println("删除学生学号："+m.jt.getValueAt(index, 1).toString());
					//清空单元表内容然后重新读取
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
				JOptionPane.showMessageDialog(null, "请先选中要删除的学生哦~~");
			}
		}else if(select=="查找学生信息"){
			//m.seeaboutJbButton.setVisible(false);
			//清空单元表内容然后重新读取
			DefaultTableModel model =(DefaultTableModel) m.jt.getModel();
			 while(model.getRowCount()>0){
			      model.removeRow(model.getRowCount()-1);
			 }
			//点击查找学生信息后单元表显示所有学生信息
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
			JOptionPane.showMessageDialog(null, "请先在下方文本框输入要查询学生学号哦~~");
			m.jsp.setVisible(true);

			
		}else if(select=="修改学生信息"){
			//m.reviseJButton.setVisible(false);
			TestFream.SiteInit(m, 1800, 800);
			m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			m.jsp.setVisible(true);
			if((index=m.jt.getSelectedRow())!=-1){
				
				System.out.println("修改学生学号："+m.jt.getValueAt(index, 1).toString());
				//getMessage.revision(m.jt.getValueAt(index, 1).toString());
				m.a.jb1.setText("修改");
				m.a.title.setText("修改学生信息");
				m.a.title.setText("修改学生信息");
				//修改界面显示
				m.a.setVisible(true);
				m.a.nameField.setText(m.jt.getValueAt(index, 0).toString());
				m.a.numField.setText(m.jt.getValueAt(index, 1).toString());
				m.a.majorField.setText(m.jt.getValueAt(index, 2).toString());
				m.a.classnumField.setText(m.jt.getValueAt(index, 3).toString());
				m.a.phonenumField.setText(m.jt.getValueAt(index, 4).toString());
				m.a.houseaddressField.setText(m.jt.getValueAt(index, 5).toString());
				m.a.mStudentUi.setVisible(false);

			}else{

				JOptionPane.showMessageDialog(null, "请先选中要修改的学生哦~~");
			}
		}else if(select=="查找"){
			try {

				//清空单元表内容然后重新读取
				DefaultTableModel model =(DefaultTableModel) m.jt.getModel();
				 while(model.getRowCount()>0){
				      model.removeRow(model.getRowCount()-1);
				 }
				getMessage.lookMessage(m.lookjField.getText());
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{

					m.lookjField.setText("请输入要查学生的学号:");
			}
		
		}

	}
	
}


//关闭窗口处理事件
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
