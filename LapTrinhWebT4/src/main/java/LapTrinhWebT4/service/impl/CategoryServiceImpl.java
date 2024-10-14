package LapTrinhWebT4.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import LapTrinhWebT4.models.CategoryModel;
import LapTrinhWebT4.service.ICategoryService;
import LapTrinhWebT4.dao.ICategoryDao;
import LapTrinhWebT4.dao.impl.CategoryDaoImpl;

public class CategoryServiceImpl implements ICategoryService{
	ICategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
		
	}

	@Override
	public void edit(CategoryModel category) {
		CategoryModel oldCategory = categoryDao.get(category.getCategoryid());
		oldCategory.setCategoryname(category.getCategoryname());
		if (category.getCategoryimages() != null) {
		// XOA ANH CU DI
		String fileName = oldCategory.getCategoryimages();
		final String dir = "E:\\upload";
		File file = new File(dir + "/category" + fileName);
		if (file.exists()) {
		file.delete();
		}
		oldCategory.setCategoryimages(category.getCategoryimages());
		}
		categoryDao.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = categoryDao.findById(id);
		if(cate !=null) {
			categoryDao.delete(id);
		}
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public CategoryModel get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<CategoryModel> getAll() {
		return categoryDao.getAll();

	}


	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return categoryDao.findById(id);
	}
	public void update (CategoryModel category) {
		CategoryModel existingCategory = categoryDao.findById(category.getCategoryid());
	    if (existingCategory != null) {
	        if (category.getCategoryname() != null && !category.getCategoryname().isEmpty()) {
	            existingCategory.setCategoryname(category.getCategoryname());
	        }
	        if (category.getCategoryimages() != null && !category.getCategoryimages().isEmpty()) {
	            existingCategory.setCategoryimages(category.getCategoryimages());
	        }
	        existingCategory.setStatus(category.getStatus());
	        categoryDao.update(existingCategory);
	    }
	}

	public List<CategoryModel> findByCategoryName(String keyword) {
		return categoryDao.findByCategoryName(keyword);
	}
	public static void main(String[] args) {
		ICategoryService user = new CategoryServiceImpl();
		List<CategoryModel> list = new ArrayList<>();
		list = user.findAll();
		System.out.print(list);
	}
}
