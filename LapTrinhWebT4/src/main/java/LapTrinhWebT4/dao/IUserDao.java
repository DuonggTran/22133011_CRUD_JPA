package LapTrinhWebT4.dao;

import java.util.List;

import LapTrinhWebT4.models.UserModel;

public interface IUserDao {
		List<UserModel> findAll();
		
		UserModel findByID (int id);
		
		void insert (UserModel user);

		UserModel findByUserName(String username);
		
		UserModel get(String username);

		boolean checkExistUsername(String username);

		boolean checkExistEmail(String email);

		boolean checkExistPhone(String phone);

		void changePassword(String username, String password);
		
		public boolean updateUserInfo(UserModel user) ;
		
}
