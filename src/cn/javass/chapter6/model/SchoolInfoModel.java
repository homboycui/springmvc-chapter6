package cn.javass.chapter6.model;

public class SchoolInfoModel {

	//学校名称
	private String schoolName;
	//学校类型：高中、中专、大学
	private String schoolType;
	//专业
	private String specialty;

	public SchoolInfoModel() {

	}
	/*当父类中重写了构造函数必须重写默认构造函数public SchoolInfoModel(String schoolType, String schoolName, String specialty)时
     * 那么必须重写默认构造函数，否则子类中会报错。
     * 或者在子类的构造函数中，需要调用父类的构造函数，见cn.javass.chapter6.model.SchoolInfoModelChild。
     * */
	public SchoolInfoModel(String schoolName, String schoolType, String specialty) {
		this.schoolName = schoolName;
		this.schoolType = schoolType;
		this.specialty = specialty;
	}

	public String getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	@Override
	public String toString() {
		return "SchoolInfoModel [schoolType=" + schoolType + ", schoolName="
				+ schoolName + ", specialty=" + specialty + "]";
	}
	
	
	
}
