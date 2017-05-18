package com.ms.service;

import java.util.List;

import com.ms.pojo.Stype;

public interface StypeService {
		
	List<Stype> queryStypeByTypeId(int typeId);
}
