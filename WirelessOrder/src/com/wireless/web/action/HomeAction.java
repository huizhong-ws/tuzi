/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.wireless.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.wireless.entity.Usertbl;
import com.wireless.web.forms.UserForm;
import com.wirelsee.web.service.UserService;

/** 
 * MyEclipse Struts
 * Creation date: 08-26-2013
 * 
 * XDoclet definition:
 * @struts.action path="/home" name="userForm" scope="request" validate="true"
 */
public class HomeAction extends DispatchAction {
private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//��������
	public ActionForward grzx(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub
		return mapping.findForward("grzx");
	}
	//��ҳ
	public ActionForward home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub
		return mapping.findForward("home");
	}
	//���ĸ�������
	public ActionForward updUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub
		//��ȡ��������
		Usertbl user=new Usertbl();
		user.setId(userForm.getUid());
		user.setUsername(userForm.getUname());
		user.setName(userForm.getName());
		user.setGender(userForm.getGender());
		user.setPermission(userForm.getPermission());
		user.setRemark(userForm.getRemark());
		//�����ݿ��������
		if(userService.updUser(user)){
			request.getSession().setAttribute("user", user);
//			System.out.println("upd yes");
		}else{
//			System.out.println("upd failure");
		};
		return mapping.findForward("grzx");
	}
	//��������
	public ActionForward updUserPwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub
		//��ȡ��������
		Usertbl user=new Usertbl();
		user.setId(userForm.getUid());
		user.setPassword(userForm.getPassword());
		System.out.println(user.getId()+" --"+user.getPassword());
		//�����ݿ��������
		if(userService.updUserPwd(user)){
//			request.getSession().setAttribute("user", user);
			System.out.println("upd pwd yes");
		}else{
			System.out.println("upd pwd failure");
		};
		return mapping.findForward("grzx");
	} 
}