package com.algorithm.basics.demo2;

public class StudentDaoImp implements StudentDao {


    @Override
    public void addStudent() {
        System.out.println("增加学生");
    }

    @Override
    public void deleteStudent() {
        System.out.println("删除学生");
    }
}
