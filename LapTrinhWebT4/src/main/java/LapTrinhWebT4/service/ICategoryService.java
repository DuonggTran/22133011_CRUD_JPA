package LapTrinhWebT4.service;

import java.util.List;

import LapTrinhWebT4.models.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel category);

	void edit(CategoryModel category);

	void delete(int id);

	CategoryModel get(int id);

	CategoryModel get(String name);

	List<CategoryModel> getAll();

	List<CategoryModel> findAll();

	CategoryModel findById(int id);

	void update(CategoryModel category);
}
