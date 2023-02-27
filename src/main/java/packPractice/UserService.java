package packPractice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;


@Controller
public class UserService 
{
	private static List<UserBean> users = new ArrayList<>();

	private static int usersCount = 3;

	static {
		users.add(new UserBean("Prakash",11));
		users.add(new UserBean("Suriya",12));
		users.add(new UserBean("Rakesh",13));
	}

	public List<UserBean> findAll() {
		return users;
	}

	public UserBean save(UserBean user) {
//		if (user.getPassword() == 0) {
//			user.setPassword(++usersCount);
//		}
		users.add(user);
		return user;
	}

	public UserBean findOne(String username) {
		for (UserBean user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public UserBean deleteByUsername(String username) {
		Iterator<UserBean> iterator = users.iterator();
		while (iterator.hasNext()) {
			UserBean user = iterator.next();
			if (user.getUsername().equals(username)) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
