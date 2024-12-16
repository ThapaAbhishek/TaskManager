//package com.TaskManager.TaskManager.Security;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//
//public class CustomAuthentication extends AbstractAuthenticationToken {
//
//    private final Object principal;
//
//    public CustomAuthentication(Object principal) {
//        super(null);
//        this.principal = principal;
//        setAuthenticated(true);
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return this.principal;
//    }
//}
//
