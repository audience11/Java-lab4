package WorkStudy;

public class Testing {

    public static void main(String args[]) throws Exception{

        Laboratory[] labs = new Laboratory[5];
        Laboratory lab1 = new Laboratory("计算机网络实验室",1);
        labs[0] = lab1;
        Laboratory lab2 = new Laboratory("组成原理实验室",2);
        labs[1] = lab2;
        Laboratory lab3 = new Laboratory("大学生创新实验室", 3);
        labs[2] = lab3;
        Laboratory lab4 = new Laboratory("大学物理实验室", 4);
        labs[3] = lab4;

        //实例化学生
        Student stu1 = new Student("张三",1);
        Student stu2 = new Student("李四",2);
        Student stu3 = new Student("王五",3);

        //给学生分配实验室
        stu1.add_lab(lab1);
        stu1.add_lab(lab2);
        stu2.add_lab(lab3);
        stu3.add_lab(lab4);

        lab1.setScore();
        lab2.setScore();
        lab3.setScore();
        lab4.setScore();

//        int[] a = {9,7,6,8,5,8,5,7,6,5,9,9,9,7,8,9,7,8} ;
//        int[] b = {9,7,9,8,9,8,9,7,9,7,9,8,9,7,8,9,7,8} ;
//        int[] c = {9,7,6,8,5,8,5,7,7,9,8,8,9,8,8,9,7,9} ;
//        lab1.setscore(a);
//        lab2.setscore(b);
//        lab3.setscore(c);
//        lab4.setscore(b);

        //算钱,算税后
        stu1.cal_money();
        stu1.cal_tax();
        stu2.cal_money();
        stu2.cal_tax();
        stu3.cal_money();
        stu3.cal_tax();
    }
}
