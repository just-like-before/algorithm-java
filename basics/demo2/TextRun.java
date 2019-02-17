package com.algorithm.basics.demo2;

public class TextRun {

    public static void main(String[] args) {

        StudentDaoImp studentDaoImp = new StudentDaoImp();
        StudentDaoProxy studentDaoProxy = new StudentDaoProxy();
        StudentDao studentDao = (StudentDao) studentDaoProxy.bind(studentDaoImp);
        studentDao.addStudent();
    }
}
