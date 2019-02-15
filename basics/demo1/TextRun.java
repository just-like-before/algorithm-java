package com.algorithm.basics.demo1;

public class TextRun {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDaoImp();
        StudentDaoProxy studentDaoProxy = new StudentDaoProxy(studentDao);
        studentDaoProxy.addStudent();
    }
}
