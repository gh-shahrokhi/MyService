package serviceToInvoke;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import src.MySessionBean;
import src.entity.Employee;

@WebService
@Stateless
public class Invoker {
	
	@WebMethod
	@EJB (mappedName = "src/MySessionBean")//(lookup ="ejb:/MyEjbProject//MySessionBean!src.MySessionBeanRemote")
//	@Inject
	public String nameOfId(Long id){

		try {
			MySessionBean bean = new MySessionBean();
			Employee emp = new Employee();
			emp = bean.findEmployeeById(id);
			// System.out.println("the name of this id = "+ emp.getFirstName());
			return emp.getFirstName();
		} catch (Exception e) {
			e.printStackTrace();
			return "null";
		}
	}

}