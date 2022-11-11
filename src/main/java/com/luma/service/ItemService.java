package com.luma.service;

import java.util.List;

import com.luma.dto.ItemListDto;
import com.luma.entity.ItemEntity;

public interface ItemService {

	List<String> getAllCategories();

	List<String> getItemMakeByCategory(String category);

	List<ItemEntity> getItemByCategoryAndMake(String category, String make);

	List<ItemListDto> getItemsByEmpId(String employeeId);

}