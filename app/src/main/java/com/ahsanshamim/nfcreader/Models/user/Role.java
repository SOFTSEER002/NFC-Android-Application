package com.ahsanshamim.nfcreader.Models.user;

import com.google.gson.annotations.SerializedName;

public class Role {
    @SerializedName("roleId")
    public int roleId;
    @SerializedName("roleName")
    public String roleName;
    @SerializedName("roleDisplayName")
    public String roleDisplayName;
    @SerializedName("isAssigned")
    public boolean isAssigned;
    @SerializedName("inheritedFromOrganizationUnit")
    public boolean inheritedFromOrganizationUnit;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDisplayName() {
        return roleDisplayName;
    }

    public void setRoleDisplayName(String roleDisplayName) {
        this.roleDisplayName = roleDisplayName;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public boolean isInheritedFromOrganizationUnit() {
        return inheritedFromOrganizationUnit;
    }

    public void setInheritedFromOrganizationUnit(boolean inheritedFromOrganizationUnit) {
        this.inheritedFromOrganizationUnit = inheritedFromOrganizationUnit;
    }
}
