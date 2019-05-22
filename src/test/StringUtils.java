package test;


public class StringUtils {

  public static void util_zh(String str, String str2) {
    str = str.toLowerCase();
    String result = str.replaceAll(" ", "_");
    System.out.println("zf_mpeople_" + result + "=" + str2);
    System.out.println("${zf_mpeople_" + result + "?default('')}");
  }

  public static void util_en(String str) {

    String self = str.substring(0, 11);//自定义
    int flag = str.indexOf("=");
    String pre = str.substring(11, flag + 1);
    String back = pre.substring(0, 1).toUpperCase()
        .concat(pre.substring(1, pre.length() - 1).replaceAll("_", " "));
    System.out.println(self + pre + back);
  }


  public static void main(String[] args) {
//        util_zh(
//"Select at least one piece of data","至少选择一条数据");
//        util_en("");
//    List<String> list = new ArrayList<>();

//    list.add("zf_mpeople_user_state=用户状态");
//    list.add("zf_mpeople_in_the_class=所在班级");
//    list.add("zf_mpeople_the_password_is_6-20_characters_long=密码长度为6-20个字符");
//    list.add("zf_mpeople_loding=中...");
//    list.add("zf_mpeople_user_base_information_table_management=用户基础信息表管理");
//    list.add("zf_mpeople_account=账号");
//    list.add("zf_mpeople_please_enter_the_user_account=请输入用户账号");
//    list.add("zf_mpeople_real_name=真实姓名");
//    list.add("zf_mpeople_please_enter_your_real_name=请输入真实姓名");
//    list.add("zf_mpeople_not_audit=未审核");
//    list.add("zf_mpeople_the_approved=已审核");
//    list.add("zf_mpeople_review_the_status=审核状态");
//    list.add("zf_mpeople_registration_time=注册时间");
//    list.add("zf_mpeople_audit=审核");
//    list.add("zf_mpeople_user_data_deletion=用户数据删除");
//    list.add("zf_mpeople_delete=删除");
//    list.add("zf_mpeople_delete_this_user=删除此用户");
//    list.add("zf_mpeople_review_the_success=审核成功");
//    list.add("zf_mpeople_audit_failure=审核失败");
//    list.add("zf_mpeople_is_reviewing=正在审核");
//    list.add("zf_mpeople_please_select_the_record_to_delete=请选择需要删除的记录");
//    list.add("zf_mpeople_deleting=正在删除");
//    list.add("zf_mpeople_delete_the_success=删除成功");
//    list.add("zf_mpeople_delete_failed=删除失败");
//    list.add("zf_mpeople_select_at_least_one_piece_of_data=至少选择一条数据");
//
//    for (int i = 0; i < list.size(); i++) {
//      util_en(list.get(i));
//    }
//      String regex = "[a-zA-Z0-9\\u4E00-\\u9FA5\\uf900-\\ufa2d·s]{2,12}";
//      String name = "wang·xiao";
//    boolean matches = name.matches(regex);
//    System.out.println(matches);

  }
}
