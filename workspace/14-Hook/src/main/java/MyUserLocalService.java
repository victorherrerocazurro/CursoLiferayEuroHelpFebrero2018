import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceWrapper;

public class MyUserLocalService extends UserLocalServiceWrapper {

	public MyUserLocalService(UserLocalService userLocalService) {
		super(userLocalService);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<User> getUsers(int start, int end) throws SystemException {
		if ((end - start)> 10){
			throw new SystemException("N esta permitido paginar mas de 10 usuarios");
		} else {		
			return super.getUsers(start, end);
		}
	}
}
