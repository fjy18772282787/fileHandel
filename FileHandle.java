package com.dingli.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.SequenceInputStream;

public class FileHandle {
	//���ļ�����
	//����Ҫ��ȡ�ļ����ļ���
	public boolean readFile(String fileName){
		//��������·�����ļ�
		File file=new File(fileName);
		BufferedReader bufr=null;
		if(!file.isFile()){//�ļ�������
			System.out.println("��Ҫ��ȡ���ļ�������");
			return false;
		}else{//�ļ����ڣ�����ļ�����
			System.out.println("�ļ��������£�");
			System.out.println();
			try {
			bufr=new BufferedReader(new FileReader(fileName));
			String str=null;
			while((str=bufr.readLine())!=null){
				System.out.println(str);
			}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(bufr!=null){
					try {
						bufr.close();//����
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("��ȡ�ɹ���");
			return true;
		}
		
	}
	//д�ļ�����
	//����Ҫд���ļ������ݣ����ƶ��ļ���������������д��ָ���ļ���
	//contentΪд�����ݣ�fileNameΪָ���ļ���
	public boolean writeFile(String content,String fileName){
		//��������·�����ļ�
		File file=new File(fileName);
		BufferedWriter bufw=null;
		if(file.exists()){//�ļ��Ѿ�����
			System.out.println("���ļ��Ѿ�����");
			return false;
		}else{//�ļ������ڣ�������д���ļ�
			try {
				bufw=new BufferedWriter(new FileWriter(fileName));
				bufw.write(content, 0, content.length());
				bufw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(bufw!=null){
					try {
						bufw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("д��ɹ�!");
			return true;
		}
	}
	//�ļ�ɾ������
	//����ɾ���ļ�·��
	public void fileDelete(String fileName){
		//����ָ���ļ�
		File file=new File(fileName);
		if(!file.exists()){//�ļ�������
			System.out.println("�ļ������ڣ�ɾ�����ɹ�!");
		}else{//�ļ�����
			boolean b=file.delete();
			if(b){
				System.out.println("�ļ�ɾ���ɹ�");
			}else{//�ļ�ɾ��ʧ��
				System.out.println("�ļ�ɾ�����ɹ�!");
			}
		}
	}
	//��ָ���ļ�Ŀ¼������ָ�������ļ�
	public void searchByType(String fileName,String type){
		File file=new File(fileName);
		if(!file.exists()){//�ļ�������
			System.out.println("���ļ�������!");
			return ;
		}else{//�ļ����ڣ�������Ŀ¼
			if(!file.isDirectory()){
				System.out.println("����������������������Ŀ¼");
				return;
			}else{
				//����ָ�����͹����ļ�
//				System.out.println(fileName+" "+type);
				File[] fileArr=file.listFiles(new FilterByType(type));
				System.out.println("�����͵��ļ���"+fileArr.length+"��");
				System.out.println("�ֱ���:");
				for(File ff:fileArr){
					System.out.println(ff.getName());
				}
			}
		}
	}
	//���������ļ���������д�뵽ָ���ļ���
	public void fileLink(String fileName1,String fileName2,String fileName3){
			File file1=new File(fileName1);
			File file2=new File(fileName2);
			File file3=new File(fileName3);
			FileOutputStream fo=null;
			FileInputStream f1=null;
			FileInputStream f2 = null;
			if(file1.exists()&&file2.exists()){
				try {
					if(file3.exists()){
						System.out.println("���ļ��Ѿ�����!�޷�д��");
						return ;
					}else{
						fo=new FileOutputStream(file3);
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
				f1 = new FileInputStream(file1);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				f2 = new FileInputStream(file2);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SequenceInputStream sis=new SequenceInputStream(f1, f2);
			byte[] b=new byte[1024];
			try {
				int len=0;
				while((len=sis.read(b))!=-1){
					fo.write(b, 0, len);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if(fo!=null){
					try {
						fo.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(f1!=null){
					try {
						f1.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(f2!=null){
					try {
						f2.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("���ӳɹ�!");
			}else{
				System.out.println("�������·��������һ��������");
			}
		}
		


}
