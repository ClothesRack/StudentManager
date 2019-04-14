package com.cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GetRowMessage {
	StudentUi  a;
	//�����������ݿ�ı���
    Statement stat = null;
    Connection ct = null;
    ResultSet rs = null;//���ݿ����������ݱ�
    PreparedStatement ps = null;
	GetRowMessage(StudentUi a) {
		this.a = a;
	}
	void GetRow() throws SQLException{
       
        String sql = "select * from student";
	System.out.println("���سɹ�");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ct = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd);
		stat = ct.createStatement();//����stat����  

	    rs = stat.executeQuery(sql);//��ѯ���
	    while(rs.next()){
    		String []rowData = {rs.getString(1),rs.getString(2)
    				,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
    		 a.tableModel.addRow(rowData);
	    	}
	     } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				 if(rs!=null)
					 rs.close();
				 rs=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				 if(stat!=null)
					 stat.close();
				 stat=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				 if(ct!=null)
					 ct.close();
				 ct=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
	}
	void revision(String num) throws SQLException{
		
	       // String sql = "update from stu where stuId = ?";
		System.out.println("���سɹ�");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			ct = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd);
		     ps = ct.prepareStatement("update student set ����=?,ѧ��=?,רҵ=?,�༶=?,�ֻ�����=?,��ͥסַ=?,�Ա�=? where ѧ��='"+num+"'");
             ps.setString(1,a.a.nameField.getText());
		     ps.setString(2,a.a.numField.getText());
             ps.setString(3,a.a.majorField.getText());
             ps.setString(4,a.a.classnumField.getText());
             ps.setString(5,a.a.phonenumField.getText());
             ps.setString(6,a.a.houseaddressField.getText());
             ps.setString(7,(String)a.a.jcb.getSelectedItem());
		    // ps.setString(8,num);
		     ps.executeUpdate();
		     } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try {
					 if(rs!=null)
						 rs.close();
					 rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					 if(stat!=null)
						 stat.close();
					 stat=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					 if(ct!=null)
						 ct.close();
					 ct=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
	}
	
	void deleStu(String num) throws SQLException{

	        //String sql = "delete from stu where stuId = ?";
		System.out.println("���سɹ�");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ct = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd);
			stat = ct.createStatement();//����stat����  
		     ps = ct.prepareStatement("delete from student where ѧ�� = ?");
		     ps.setString(1,num);
		     ps.executeUpdate();
		     } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try {
					 if(rs!=null)
						 rs.close();
					 rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					 if(stat!=null)
						 stat.close();
					 stat=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					 if(ct!=null)
						 ct.close();
					 ct=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
		
	}
	void lookMessage(String num) throws SQLException{
		
        try {
			Class.forName("com.mysql.jdbc.Driver"); 

            //�������ݿ����� 

            Connection con = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd); 

            //������ѯ ������ 

            PreparedStatement ps = con.prepareStatement("select * from student where ѧ�� = '"+num+"'"); 

            //���ز�ѯ��� 
            ResultSet rs = ps.executeQuery();
            if(rs.next()==false){
            	JOptionPane.showMessageDialog(null, "���ź����ݿ�û���ҵ������Ϣ~~");
            }else{
                 rs = ps.executeQuery();
            	 while(rs.next()) { 

 	            	String []rowData = {rs.getString(1),rs.getString(2)
 	        				,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
 	        		 a.tableModel.addRow(rowData);

 	            }
            	 JOptionPane.showMessageDialog(null, "���ҵ�������Ϣ��~~");
            }
	           
		     } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try {
					 if(rs!=null)
						 rs.close();
					 rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					 if(stat!=null)
						 stat.close();
					 stat=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					 if(ct!=null)
						 ct.close();
					 ct=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
		
		}
}
