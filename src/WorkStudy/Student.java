package WorkStudy;

public class Student<String> {
    private String name;
    private int id;
    private double money; //全部补助
    private int i; //实验室数量
    private Laboratory[] labs = new Laboratory[18];

    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    //给学生添加实验室
    public void add_lab(Laboratory lab){
        labs[i] = lab;
        i++;
    }

    //计算全部所得钱数
    public void cal_money(){
        int[] a = new int[18];

        for (int i = 0;i< labs.length;i++){
            if (labs[i] == null){
                continue;
            }
            else {
                double m = 0;
                System.out.println(labs[i].getName() + "收入统计：");
                a = labs[i].getScore(); //分数数组
                for(int j=0;j<18;j++){

                    if(a[j]>0 & a[j]<=5){ //5分一下及格
                        m = m + Laboratory.pass;
                    }
                    else if(a[j]>7 & a[j]<=10){ //7分以上优秀
                        m = m + Laboratory.great;
                    }
                    else if(a[j]>5 & a[j]<=7){  //其余良好
                        m = m + Laboratory.good;
                    }

                }
                System.out.println(m);
                money = m + money;
            }
        }
        System.out.println(this.name + "的总共收入" + money);
    }


    //算税收
    public void cal_tax(){
        if(money<=200){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Tax.taxmin))+"\n");
        }
        else if(money>300 & money<=400){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Tax.tax))+"\n");
        }
        else if(money>400){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Tax.taxmax))+"\n");
        }
    }
}
