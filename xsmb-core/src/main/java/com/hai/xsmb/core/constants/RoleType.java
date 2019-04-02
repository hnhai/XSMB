package com.hai.xsmb.core.constants;

import org.apache.commons.lang3.StringUtils;

public enum RoleType {
    ROLE_ADMIN("Quản lý"), ROLE_USER("Người dùng");

    private String vietnamese;

    RoleType(String vietnamese) {this.vietnamese = vietnamese;}

    public static RoleType getRoleType(String role){
        try {
            return RoleType.valueOf(role);
        }
        catch (Exception e){
            return null;
        }
    }

    public static RoleType find(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        RoleType[] roleTypes = RoleType.values();
        for (RoleType roleType : roleTypes) {
            if (name.equals(roleType.toString()) || name.equals(roleType.vietnamese)) {
                return roleType;
            }
        }
        return null;
    }

    public String getVietnamese() {
        return vietnamese;
    }
}
