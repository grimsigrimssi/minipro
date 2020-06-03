package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PhoneApp {

    public static void main(String[] args) throws IOException{
    	
    	
    	InputStream in = new FileInputStream("./phoneDB.txt");
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir);
		
		
		List<Person> pList = new ArrayList<Person>();
		
    	Scanner sc = new Scanner(System.in);
    	Boolean run = true;
    	int menuNo; 
    	String name;
    	String hp;
    	String phone;
    	
    		
    	System.out.println("********************************");
    	System.out.println("*        전화번호 관리 프로그램                 *");
    	System.out.println("********************************");
    	
    	
    	while(run) {
    		System.out.println("");
    		System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
    		System.out.println("--------------------------------");
    		System.out.print(">메뉴번호:");
    		System.out.println("");
    		
    		menuNo = sc.nextInt();
    	
    		switch(menuNo) {
    		
    		case 1 : 			
    			System.out.println("<1.리스트>");
    			
    			InputStream in1 = new FileInputStream("./phoneDB.txt");
    			InputStreamReader ir1 = new InputStreamReader(in1);
    			BufferedReader br1= new BufferedReader(ir1);
    			
    			while(true) {
    				String str = br1.readLine();
    				if (str == null) {
    					break;
    				}
    				String[] strArray = str.split(",");	
    				
    				Person personData = new Person(strArray[0], strArray[1], strArray[2]);
    				
    				pList.add(personData);	
    			}
    									
    			for(int i=0; i<pList.size(); i++) {
    				System.out.print(i+1 + ".");
    				pList.get(i).showInfo();
    			}
    			
    			br.close();	
    			
    			break;
    			
    			
    		case 2 :
    			System.out.println("<2.등록>");
    			
    			System.out.print(">이름: ");
    			name = sc.next();
    			
    			System.out.print(">휴대전화: ");
    			hp = sc.next();
    			
    			System.out.print(">회사전화:");
    			phone = sc.next();
    			
    			System.out.println("[등록되었습니다.]");
    			
    			Person person = new Person(name, hp, phone);
    			
    			pList.add(person);
    			
    			OutputStream out = new FileOutputStream("./phoneDB.txt");
    			OutputStreamWriter ow = new OutputStreamWriter(out);
    			BufferedWriter bw = new BufferedWriter(ow);
    			
    			break;
    			
    			
    		case 3 :
    			System.out.println("<3.삭제>");
    			
    			System.out.print(">번호: ");
    			int delNum = sc.nextInt();
    			
    			InputStream in3 = new FileInputStream("./phoneDB.txt");
    			InputStreamReader ir3 = new InputStreamReader(in3);
    			BufferedReader br3= new BufferedReader(ir3);
    				
    			while(true) {	
    				String str = br3.readLine();
    				if (str == null) {
    					break;
    				}
    				
    				String[] strArray = str.split(",");	
    				
    				Person personData = new Person(strArray[0], strArray[1], strArray[2]);
    				
    				pList.add(personData);	
    			}
				
				Person p = pList.remove(delNum-1);
    		
    			System.out.println("[삭제되었습니다.]");
    			
    			OutputStream out3 = new FileOutputStream("./phoneDB.txt");
    			OutputStreamWriter ow3 = new OutputStreamWriter(out3);
    			BufferedWriter bw3 = new BufferedWriter(ow3);
    									
    			break;
    		
    		case 4 :
    			System.out.println("<4.검색>");
    			System.out.println(">번호: ");
    			String inputStr = sc.next();
    			
    			InputStream in4 = new FileInputStream("./phoneDB.txt");
    			InputStreamReader ir4 = new InputStreamReader(in4);
    			BufferedReader br4= new BufferedReader(ir4);
    			
    			
    			
    			
    			OutputStream out4 = new FileOutputStream("./phoneDB.txt");
    			OutputStreamWriter ow4 = new OutputStreamWriter(out4);
    			BufferedWriter bw4 = new BufferedWriter(ow4);
    			
    			break;
    		
    		case 5 :
    			System.out.println("********************************");
    	    	System.out.println("*            감사합니다                          *");
    	    	System.out.println("********************************");
    			run = false;
    			break;
    		
    		default :
    			System.out.println("다시 입력해주세요");	
    			break;
     		
    		}//switch
    	
    		
    	}//while
    	
    	
    	br.close();
    	sc.close();  	  	  	
    }    	
}