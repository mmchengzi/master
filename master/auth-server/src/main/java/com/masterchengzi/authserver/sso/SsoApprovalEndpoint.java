package com.masterchengzi.authserver.sso;

import org.apache.catalina.util.ParameterMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@SessionAttributes("authorizationRequest")
public class SsoApprovalEndpoint {

	@RequestMapping("/oauth/confirm_access")
	public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {
		String template = createTemplate(model, request);
		if (request.getAttribute("_csrf") != null) {
			model.put("_csrf", request.getAttribute("_csrf"));
		}
		return new ModelAndView(new SsoSpelView(template), model);
	}

	protected String createTemplate(Map<String, Object> model, HttpServletRequest request) {
		//解决从登录跳转到授权 和 应用之间跳转授权 form表单内action值相同 导致无法完成授权的问题
		if((request.getParameterMap()) instanceof ParameterMap){
			this.DENIAL="<form id='denialForm' name='denialForm' action='${path}/oauth/authorize' method='post' style='display: inline-block;margin-left: 15px; ' ><input name='user_oauth_approval' value='false' type='hidden'/>%csrf%<label><input class='sub' name='deny' value='取消' type='submit' /></label></form>";
			this.TEMPLATE="<html><head><style type='text/css'>.sub{width: 100px;background: grey;color: #fff;transition: all 1s;}.sub:hover{background-color: #FFF;color: black;transition: all 1s;transition: all 1s;}"
					+"</style></head><body style='background-color: #eee;'><div style='text-align: center; margin-top: 35px;'><h1>认证授权</h1>"
					+ "<p>你确定授权应用 '【${authorizationRequest.clientId}】' 登录并访问你的信息?</p>"
					+ "<form id='confirmationForm' name='confirmationForm' action='${path}/oauth/authorize' method='post' style='display: inline-block;margin-right: 15px;  ' ><input name='user_oauth_approval' value='true' type='hidden'/>%csrf%%scopes%<label><input class='sub' name='authorize' value='确定' type='submit' /></label></form>"
					+ "%denial%</div></body></html>";
		}else{
			this.DENIAL="<form id='denialForm' name='denialForm' action='/oauth/authorize' method='post' style='display: inline-block;margin-left: 15px; ' ><input name='user_oauth_approval' value='false' type='hidden'/>%csrf%<label><input class='sub' name='deny' value='取消' type='submit' /></label></form>";
			this.TEMPLATE="<html><head><style type='text/css'>.sub{width: 100px;background: grey;color: #fff;transition: all 1s;}.sub:hover{background-color: #FFF;color: black;transition: all 1s;}"
					+"</style></head><body style='background-color: #eee;'><div style='text-align: center; margin-top: 35px;'><h1>认证授权</h1>"
					+ "<p>你确定授权应用 '【${authorizationRequest.clientId}】' 登录并访问你的信息?</p>"
					+ "<form id='confirmationForm' name='confirmationForm' action='/oauth/authorize' method='post' style='display: inline-block;margin-right: 15px;  ' ><input name='user_oauth_approval' value='true' type='hidden'/>%csrf%%scopes%<label><input class='sub' name='authorize' value='确定' type='submit' /></label></form>"
					+ "%denial%</div></body></html>";
		}

		String template = TEMPLATE;
		if (model.containsKey("scopes") || request.getAttribute("scopes") != null) {
			template = template.replace("%scopes%", createScopes(model, request)).replace("%denial%", "");
		}
		else {
			template = template.replace("%scopes%", "").replace("%denial%", DENIAL);
		}
		if (model.containsKey("_csrf") || request.getAttribute("_csrf") != null) {
			template = template.replace("%csrf%", CSRF);
		}
		else {
			template = template.replace("%csrf%", "");
		}
		return template;
	}

	private CharSequence createScopes(Map<String, Object> model, HttpServletRequest request) {
		StringBuilder builder = new StringBuilder("<ul>");
		@SuppressWarnings("unchecked")
		Map<String, String> scopes = (Map<String, String>) (model.containsKey("scopes") ? model.get("scopes") : request
				.getAttribute("scopes"));
		for (String scope : scopes.keySet()) {
			String approved = "true".equals(scopes.get(scope)) ? " checked" : "";
			String denied = !"true".equals(scopes.get(scope)) ? " checked" : "";
			String value = SCOPE.replace("%scope%", scope).replace("%key%", scope).replace("%approved%", approved)
					.replace("%denied%", denied);
			builder.append(value);
		}
		builder.append("</ul>");
		return builder.toString();
	}

	private static String CSRF = "<input type='hidden' name='${_csrf.parameterName}' value='${_csrf.token}' />";

	private  String DENIAL = "<form id='denialForm' name='denialForm' action='/oauth/authorize' method='post' style='display: inline-block;margin-left: 15px; ' ><input name='user_oauth_approval' value='false' type='hidden'/>%csrf%<label><input class='sub' name='deny' value='取消' type='submit' /></label></form>";

	//    private static String TEMPLATE = "<html><body><div style='display:none;'><h1>OAuth Approval</h1>"
//            + "<p>Do you authorize '${authorizationRequest.clientId}' to access your protected resources?</p>"
//            + "<form id='confirmationForm' name='confirmationForm' action='${path}/oauth/authorize' method='post'><input name='user_oauth_approval' value='true' type='hidden'/>%csrf%%scopes%<label><input name='authorize' value='Authorize' type='submit'/></label></form>"
//            + "%denial%</div><script>document.getElementById('confirmationForm').submit()</script></body></html>";
	private  String TEMPLATE = "<html><head><style type='text/css'>.sub{width: 100px;background: grey;color: #fff;}.sub:hover{background-color: #FFF;color: black;}"
			+"</style></head><body style='background-color: #eee;'><div style='text-align: center; margin-top: 35px;'><h1>认证授权</h1>"
			+ "<p>你确定授权应用 '【${authorizationRequest.clientId}】' 登录并访问你的信息?</p>"
			+ "<form id='confirmationForm' name='confirmationForm' action='/oauth/authorize' method='post' style='display: inline-block;margin-right: 15px;  ' ><input name='user_oauth_approval' value='true' type='hidden'/>%csrf%%scopes%<label><input class='sub' name='authorize' value='确定' type='submit' /></label></form>"
			+ "%denial%</div></body></html>";


	private static String SCOPE = "<li><div class='form-group'>%scope%: <input type='radio' name='%key%'"
			+ " value='true'%approved%>Approve</input> <input type='radio' name='%key%' value='false'%denied%>Deny</input></div></li>";



}