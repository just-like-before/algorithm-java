package com.algorithm.basics.demo1;

public class StudentDaoProxy implements StudentDao {

    private StudentDao studentDao;

    public StudentDaoProxy(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent() {
        System.out.println("增加学生前");
        studentDao.addStudent();
    }

    @Override
    public void deleteStudent() {
        System.out.println("删除学生前");
        studentDao.deleteStudent();
    }
}
