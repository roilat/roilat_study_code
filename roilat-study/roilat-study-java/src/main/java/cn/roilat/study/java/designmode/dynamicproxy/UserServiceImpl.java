package cn.roilat.study.java.designmode.dynamicproxy;

public class UserServiceImpl implements UserService {

	@Override
	public String getName(int id) {
		System.out.println("------getName------");  
        return "Tom";
	}

	@Override
	public int getAge(int id) {
		System.out.println("------getAge------");  
        return 10;
	}

}
