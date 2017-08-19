package haibao.com.api.data.param.school;

/**
 * Created by Administrator on 2016/12/19 0019.
 */

public class UpdataLogParams {
    public int  handel_type;//执行类型 1 版本升级，2 补丁脚本
    public int handel_type_id;// 版本ID
    public int  is_success;//是否成功执行 0 不成功，1 成功
    public String fail_desc;//不成功的原因
    public int arrival_at;//版本更新到达或补丁到达时间戳
}
