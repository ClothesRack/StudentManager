package com.cn;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;



class ThreadMenu extends Thread{
	MyFrame aFrame;
	Icon head = new ImageIcon("image\\head.png");

	ThreadMenu(MyFrame aFrame){
		this.aFrame=aFrame;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		/*try {
			sleep(3300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		while(true){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aFrame.flag=aFrame.test.login.getflag();
			if(aFrame.flag){
				aFrame.LoginMenu.setIcon(head);
				aFrame.LoginMenu.setText("^���ã�"+aFrame.test.login.textfield.getText());
				//aFrame.LoginMenu.setEnabled(false);
				aFrame.exitMenu.setEnabled(true);
				aFrame.ChangeMenu.setEnabled(true);
				aFrame.imessage.setEnabled(true);
			}
			else {
				aFrame.LoginMenu.setEnabled(true);
				aFrame.LoginMenu.setIcon(null);
				aFrame.exitMenu.setEnabled(false);
				aFrame.ChangeMenu.setEnabled(false);
				aFrame.imessage.setEnabled(false);
			}
			//aFrame.test.addIdfream.add(aFrame.test.addIdfream.panel);
			if(aFrame.exit)stop();
			System.out.println(aFrame.flag);
		}
		
	}
}
public class TestFream {
	public static void main(String[] args) { 
		MyFrame MyWindow = new MyFrame();
		ThreadMenu flagmenu = new ThreadMenu(MyWindow);
		flagmenu.start();
		if(judeFileExists(new File("sendfile.ini")))
		read("sendfile.ini");
		
	}
	static void SiteInit(JFrame MyWindow,int width,int height){
		//�õ�ϵͳ���һ������
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		//��ȡ��Ļ�ֱ���
		Dimension a = toolkit.getScreenSize();
		int x = (int)a.getWidth();
		int y = (int )a.getHeight();
		MyWindow.setBounds((x-width)/2, (y-height)/2, width, height);
		MyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//MyWindow.setVisible(true);
	}
	
	
	public static String read(String filePath){  
        BufferedReader br = null;  
        String line =null;  
        //StringBuffer buf = new StringBuffer();  
        
        
        
        try {  
            //�����ļ�·����������������  
            br = new BufferedReader(new FileReader(filePath));//filePath����aaa.txt�ļ�  
            String str = "";  
              
            //ѭ����ȡ�ļ���ÿһ�У�����Ҫ�޸ĵ��н����޸ģ����뻺�������  
             while ((line = br.readLine()) != null) {  
                 //�������򽫶���ո�תΪһ���ո�  
                 str=line+"\r\n";  
                 String[] dictionary =  str.split("\\s+");
                 String id = dictionary[0];
                 String passworld=dictionary[1];
                 AddbuttonAction.user.add(new User(id,passworld));
                 System.out.println(AddbuttonAction.user);  
             }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally {  
             if (br != null) {// �ر���  
                   try {  
                       br.close();  
                   } catch (IOException e) {  
                         br = null;  
                }  
             }  
        }  
        return null;  
    } 
	public static boolean judeFileExists(File file) {
		
		        if (file.exists()) {
		            System.out.println("file exists");
		            return true;
		        } else {
		            System.out.println("file not exists, create it ...");
		            return false;
		             /*try {
		                 file.createNewFile();
		             } catch (IOException e) {
		                 // TODO Auto-generated catch block
		                 e.printStackTrace();
		             }*/
		         }
		 
		     }

      
}
