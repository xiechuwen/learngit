package com.ms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.FileDao;
import com.ms.pojo.File;
import com.ms.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	FileDao fileDao;
	
	@Override
	public boolean addFile(File file) {
		File result=fileDao.save(file);
		if(result!=null)
			return true;
		return false;
	}

}
