package com.example.trade.entity;



public class Student {
    /**学号 */
   private int id;
    /**姓名 */
   private String name;
   /**性别 */
   private String sex;
    /** 年龄*/
   private int age;
    /**家庭住址 */
   private String home;
    /**学历 */
   private String education;
    /** 导师*/
   private String tutor;
    /** 专业*/
   private String major;
    /** 学院*/
   private String school;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", home='" + home + '\'' +
                ", education='" + education + '\'' +
                ", tutor='" + tutor + '\'' +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
