package cn.javass.chapter6.model;

/**
 * @author cfl
 * @createTime 18-4-11 下午2:12
 * @ddescription
 * @email homboy_cui@163.com
 */
public class SchoolInfoModelChild extends SchoolInfoModel{
    /*当父类中重写了构造函数必须重写默认构造函数public SchoolInfoModel(String schoolType, String schoolName, String specialty)时
    * 那么必须重写默认构造函数，否则子类中会报错。
    * 或者在子类的构造函数中，需要调用父类的构造函数，如下：
    * */
//    public SchoolInfoModelChild(String schoolType, String schoolName, String specialty) {
//        super(schoolType, schoolName, specialty);
//    }
}
