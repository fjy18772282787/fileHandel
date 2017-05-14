package com.dingli.io;

import java.util.Scanner;

public class App {
	private static FileHandle fh=new FileHandle();
	private static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		caozuo();

	}
	public static void caozuo(){
		menu();
		int select=sc.nextInt();
		switch(select){
		case 1:{
			System.out.println("输入文件路径:");
			String fileName=sc.next();
			fh.readFile(fileName);
			caozuo();
			break;
		}
		case 2:{
			System.out.println("输入文件内容:");
			String content=sc.next();
			System.out.println("输入文件路径:");
			String fileName=sc.next();
			fh.writeFile(content, fileName);
			caozuo();
			break;
		}
		case 3:{
			System.out.println("输入要删除文件路径:");
			String fileName=sc.next();
			fh.fileDelete(fileName);
			caozuo();
			break;
		}
		case 4:{
			System.out.println("输入目录路径:");
			String fileName=sc.next();
			System.out.println("输入文件类型:");
			String type=sc.next();
			fh.searchByType(fileName, type);
			caozuo();
			break;
		}
		case 5:{
			System.out.println("输入第一个文件路径:");
			String fileName1=sc.next();
			System.out.println("输入第二个文件路径:");
			String fileName2=sc.next();
			System.out.println("输入目的文件路径:");
			String fileName3=sc.next();
			fh.fileLink(fileName1, fileName2,fileName3);
			caozuo();
			break;
		}
		case 6:{
			return;
		}
		default:{
			System.out.println("输入有误!");
		}
		}
	}
	public static void menu(){
		System.out.println("请选择下列操作的序号:");
		System.out.println("1(读取文件)");
		System.out.println("2(写入文件)");
		System.out.println("3(删除文件)");
		System.out.println("4(搜索指定目录下的指定类型文件)");
		System.out.println("5(连接两个文件)");
		System.out.println("6(退出)");
	}
}
