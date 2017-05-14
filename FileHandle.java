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
	//读文件函数
	//输入要读取文件的文件名
	public boolean readFile(String fileName){
		//创建给定路径的文件
		File file=new File(fileName);
		BufferedReader bufr=null;
		if(!file.isFile()){//文件不存在
			System.out.println("您要读取的文件不存在");
			return false;
		}else{//文件存在，输出文件内容
			System.out.println("文件内容如下：");
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
						bufr.close();//关流
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("读取成功！");
			return true;
		}
		
	}
	//写文件函数
	//输入要写入文件的内容，并制定文件名，见输入内容写到指定文件中
	//content为写入内容，fileName为指定文件名
	public boolean writeFile(String content,String fileName){
		//创建给定路径的文件
		File file=new File(fileName);
		BufferedWriter bufw=null;
		if(file.exists()){//文件已经存在
			System.out.println("该文件已经存在");
			return false;
		}else{//文件不存在，则将内容写入文件
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
			System.out.println("写入成功!");
			return true;
		}
	}
	//文件删除函数
	//给出删除文件路径
	public void fileDelete(String fileName){
		//创建指定文件
		File file=new File(fileName);
		if(!file.exists()){//文件不存在
			System.out.println("文件不存在，删除不成功!");
		}else{//文件存在
			boolean b=file.delete();
			if(b){
				System.out.println("文件删除成功");
			}else{//文件删除失败
				System.out.println("文件删除不成功!");
			}
		}
	}
	//在指定文件目录中搜索指定类型文件
	public void searchByType(String fileName,String type){
		File file=new File(fileName);
		if(!file.exists()){//文件不存在
			System.out.println("该文件不存在!");
			return ;
		}else{//文件存在，但不是目录
			if(!file.isDirectory()){
				System.out.println("您的输入有误，请输入搜索目录");
				return;
			}else{
				//根据指定类型过滤文件
//				System.out.println(fileName+" "+type);
				File[] fileArr=file.listFiles(new FilterByType(type));
				System.out.println("该类型的文件有"+fileArr.length+"个");
				System.out.println("分别是:");
				for(File ff:fileArr){
					System.out.println(ff.getName());
				}
			}
		}
	}
	//连接两个文件，并将其写入到指定文件中
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
						System.out.println("该文件已经存在!无法写入");
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
			System.out.println("连接成功!");
			}else{
				System.out.println("您输入的路径至少有一个不存在");
			}
		}
		


}
