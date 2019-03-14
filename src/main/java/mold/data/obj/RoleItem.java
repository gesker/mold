package mold.data.obj;

import java.util.Comparator;

public class RoleItem {

    public static Comparator<RoleItem> COMPARE_BY_ROLEID = new Comparator<RoleItem>() {
        @Override
        public int compare(RoleItem a, RoleItem b) {
            return a.roleId.compareTo(b.roleId); // sort ascending
        }
    };
    public static Comparator<RoleItem> COMPARE_BY_ROLENAME = new Comparator<RoleItem>() {
        @Override
        public int compare(RoleItem a, RoleItem b) {
            return a.roleName.compareTo(b.roleName); // sort ascending
        }
    };
    private String roleId;
    private String roleName;

    public RoleItem(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }


}
