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
			System.out.println("�����ļ�·��:");
			String fileName=sc.next();
			fh.readFile(fileName);
			caozuo();
			break;
		}
		case 2:{
			System.out.println("�����ļ�����:");
			String content=sc.next();
			System.out.println("�����ļ�·��:");
			String fileName=sc.next();
			fh.writeFile(content, fileName);
			caozuo();
			break;
		}
		case 3:{
			System.out.println("����Ҫɾ���ļ�·��:");
			String fileName=sc.next();
			fh.fileDelete(fileName);
			caozuo();
			break;
		}
		case 4:{
			System.out.println("����Ŀ¼·��:");
			String fileName=sc.next();
			System.out.println("�����ļ�����:");
			String type=sc.next();
			fh.searchByType(fileName, type);
			caozuo();
			break;
		}
		case 5:{
			System.out.println("�����һ���ļ�·��:");
			String fileName1=sc.next();
			System.out.println("����ڶ����ļ�·��:");
			String fileName2=sc.next();
			System.out.println("����Ŀ���ļ�·��:");
			String fileName3=sc.next();
			fh.fileLink(fileName1, fileName2,fileName3);
			caozuo();
			break;
		}
		case 6:{
			return;
		}
		default:{
			System.out.println("��������!");
		}
		}
	}
	public static void menu(){
		System.out.println("��ѡ�����в��������:");
		System.out.println("1(��ȡ�ļ�)");
		System.out.println("2(д���ļ�)");
		System.out.println("3(ɾ���ļ�)");
		System.out.println("4(����ָ��Ŀ¼�µ�ָ�������ļ�)");
		System.out.println("5(���������ļ�)");
		System.out.println("6(�˳�)");
	}
}
