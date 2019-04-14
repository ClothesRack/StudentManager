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
	//定义连接数据库的变量
    Statement stat = null;
    Connection ct = null;
    ResultSet rs = null;//数据库结果集的数据表
    PreparedStatement ps = null;
	GetRowMessage(StudentUi a) {
		this.a = a;
	}
	void GetRow() throws SQLException{
       
        String sql = "select * from student";
	System.out.println("加载成功");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ct = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd);
		stat = ct.createStatement();//创建stat对象  

	    rs = stat.executeQuery(sql);//查询结果
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
		System.out.println("加载成功");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			ct = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd);
		     ps = ct.prepareStatement("update student set 姓名=?,学号=?,专业=?,班级=?,手机号码=?,家庭住址=?,性别=? where 学号='"+num+"'");
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
		System.out.println("加载成功");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ct = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd);
			stat = ct.createStatement();//创建stat对象  
		     ps = ct.prepareStatement("delete from student where 学号 = ?");
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

            //创建数据库连接 

            Connection con = DriverManager.getConnection(DAO.url,DAO.user,DAO.passwd); 

            //创建查询 “请求” 

            PreparedStatement ps = con.prepareStatement("select * from student where 学号 = '"+num+"'"); 

            //返回查询结果 
            ResultSet rs = ps.executeQuery();
            if(rs.next()==false){
            	JOptionPane.showMessageDialog(null, "很遗憾数据库没有找到相关信息~~");
            }else{
                 rs = ps.executeQuery();
            	 while(rs.next()) { 

 	            	String []rowData = {rs.getString(1),rs.getString(2)
 	        				,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
 	        		 a.tableModel.addRow(rowData);

 	            }
            	 JOptionPane.showMessageDialog(null, "查找到数据信息啦~~");
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
