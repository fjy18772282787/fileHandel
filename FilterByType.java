package com.dingli.io;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByType implements FilenameFilter {
	private String type;
	public FilterByType(String type) {
		super();
		this.type = type;
	}
	@Override
	public boolean accept(File file, String type1) {
		// TODO Auto-generated method stub
		return type1.endsWith(this.type);
	}

}
