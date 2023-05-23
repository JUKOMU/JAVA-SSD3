package Experiment5;

import java.util.Calendar;

import static Experiment5.Student.Grade1;

class Student extends Person{
    public static final String Grade1 = "大一";
    public static final String Grade2 = "大二";
    public static final String Grade3 = "大三";
    public static final String Grade4 = "大四";

    private String grade = null;

    public Student(String name, String TEL, String grade) {
        this.name = name;
        this.TEL = TEL;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student类：" +
                "姓名为'" + name + '\'' +
                ", 电话为'" + TEL + '\'' +
                ", 年级为" + grade;
    }

    public void displayObject() {
        System.out.println("to " + this.name+": 请按时交实验报告");
    }
}
class MyDate{
    private Integer year;
    private Integer month;
    private Integer day;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
        Calendar cal = Calendar.getInstance();
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH)+1;
        this.day = cal.get(Calendar.DATE);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

class Employee extends Person{
    private Integer salary=null;
    private MyDate employ_date;

    public Employee() {
        this.employ_date = new MyDate();
    }

    public Employee(String name, String TEL, Integer salary) {
        this.name = name;
        this.TEL = TEL;
        this.salary = salary;
        this.employ_date = new MyDate();
    }

    public void setEmploy_date(Integer year, Integer month, Integer day) {
        this.employ_date = new MyDate(year, month, day);
    }

    @Override
    public String toString() {
        return "Employee类：" +
                "姓名为'" + name + '\'' +
                ", 电话为'" + TEL + '\'' +
                ", 工资为" + salary +
                ", 受雇日期为" + employ_date.getYear() + "年" + employ_date.getMonth() + "月" + employ_date.getDay() + "日" ;
    }
    public void displayObject() {
        System.out.println("to " + this.name + ": 请按时上班");
    }
}

class test{
    public static void m1(Person p){
        System.out.println(p.getName());
    }
    public static void m2(Person p){
        System.out.println(p.toString());
    }
    public static void m3(Person p){
        if (p instanceof Student){
            ((Student) p).displayObject();
        }
        else if (p instanceof Employee) {
            ((Employee) p).displayObject();
        }
    }


}
public class Person {
    public String name;
    public String TEL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public Person() {
    }

    public Person(String name, String TEL) {
        this.name = name;
        this.TEL = TEL;
    }

    @Override
    public String toString() {
        return "Person类：" +
                "姓名为'" + name + '\'' +
                ", 电话为'" + TEL + '\'' ;
    }

    public static void main(String[] args) {
        Person person = new Person("Reimu", "12345678901");
        Student student = new Student("Marisa", "12345678911", Grade1);
        Employee employee = new Employee("Flandre", "12345678111", 10000);
        test.m1(person);
        test.m1(student);
        test.m1(employee);
        test.m2(person);
        test.m2(student);
        test.m2(employee);
        test.m3(person);
        test.m3(student);
        test.m3(employee);
    }
}

