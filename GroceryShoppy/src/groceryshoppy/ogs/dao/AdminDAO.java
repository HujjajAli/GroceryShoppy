package groceryshoppy.ogs.dao;

import groceryshoppy.ogs.entity.Admin;

public interface AdminDAO {

	int validateAdmin(String username,String password);
	boolean saveAdmin(Admin admin);
	Admin getAdminByUsername(String username);
}
