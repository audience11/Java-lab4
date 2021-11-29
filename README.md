## 一、实验目的
1. 掌握Java中类的定义；
2. 掌握static、final等修饰符的用法；
3. 了解异常的使用方法，并在程序中根据输入情况做异常处理。

## 二、实验内容
&emsp;&emsp;<i>某学校为了给学生提供勤工俭学机会，选派了部分学生参与实验室的卫生清洁工作。
每个学生被分配若干间实验室，视实验室的清洁打分情况给予劳务补贴。</i>

&emsp;&emsp;例如：学生“张三”负责了“计算机网络实验室”、“组成原理实验室”的清洁情况，每周被检查。
在某次检查中，“计算机网络实验室”卫生得“优”，“组成原理实验室”卫生得“及格”，一次“优”按x元记录补助，一次“及格”按y元记录补助。
1. 设计系统中的类（如学生、实验室等等）；
2. 一学期按18周计；
3. 每个学生负责的实验室数量不一定相同；
4. 对学期勤工俭学收入和纳税进行统计，求得实际收入；
5. 国家最新纳税标准（系数），属于某一时期的特定固定值，与实例化对象没有关系，考虑如何用staticfinal修饰定义。
6. 根据处理情况，要在程序中考虑做异常处理。

## 三、实验过程
1. 给出类：实验室（Laboratory）,学生（Student）。设置构造函数，定义属性。
Laboratory类的属性：不同等级补助价格great,good,pass，实验室名称name，房间号room，实验室评分表score。
Student类的属性：姓名name,学号id,补助价格money,实验室列表labs。
2. 实例化学生和实验室。给学生实验室函数add_lab，将实验室分配给不同的同学。
3. 设置评分机制，在评分时用到了异常处理（try-catch）。
4. 设置计算学生收入的函数cal_money，通过学生打扫的实验室，将实验室每周的分数都分别按照分数等级计算每周能获得的工资。
5. 设置一个税率类Tax，用到了final，了解到了fianal的用法。
6. 设置税后收入函数cal_tax，计算税后所得收入。

## 四、主要代码
1. 实例化Laboratory类，在其中添加属于整个类的属性，价格补助。
```java
public class Lab {
    static double great = 20; 
    static double good = Math.ceil(great * 0.75); 
    static double pass = Math.ceil(great * 0.5); 
}
```
2. 给学生打扫的实验室打分
```java
    public void setScore() {
        Scanner in = new Scanner(System.in);
        System.out.println("请打分");
        for (int i = 0; i < 18; i++) {
            System.out.println("第" + (i + 1) + "周:");
            score[i] = in.nextInt();
            if(score[i]>0 & score[i]<=10){
                continue;
            }
            else{
                System.out.println("输入错误");
                break;
            }
        }
    }
```

3. 异常处理。
```java
   public void setScore() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("请打分");
            //int[] a = new int[18];
            for (int i = 0; i < 18; i++) {
                System.out.println("第" + (i + 1) + "周:");
                score[i] = in.nextInt();
                if(score[i]>0 & score[i]<=10){
                    continue;
                }
                else{
                    System.out.println("输入错误");
                    break;
                }
            }
        }
        catch (NumberFormatException e){
            System.out.println("数据结构异常");
        }
        catch (Exception e){
            System.out.println("异常");
        }
    }
```

4. cal_money函数，通过学生的实验室列表，将实验室每周的分数都分别按照分数等级计算每周能获得的工资。
```java
    public void cal_money(){
        int[] a = new int[18];

        for (int i = 0;i< labs.length;i++){
            if (labs[i] == null){
                continue;
            }
            else {
                double m = 0;
                System.out.println(labs[i].getName() + "收入统计：");
                a = labs[i].getScore();
                for(int j=0;j<18;j++){
                    
                    if(a[j]>0 & a[j]<=5){
                        m = m + Laboratory.pass;
                    }
                    else if(a[j]>7 & a[j]<=10){ 
                        m = m + Laboratory.great }
                    else if(a[j]>5 & a[j]<=7){  
                        m = m + Laboratory.good;
                    }
                }
                System.out.println(m);
                money = m + money;
            }
        }
        System.out.println(this.name + "的总共收入" + money);
}
```

5. 创建类Tax，用来放税率，了解final。
```java
public class Tax {
    public static final double tax = 0.03;
    public static final double taxmax = 0.05;
    public static final double taxmin = 0.01;
}
```

6.cal_tax函数，根据相应利率，计算税后所得。
```java
    public void cal_tax(){
        if(money<=200){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.taxmin)));
        }
        else if(money>200 & money<=400){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.tax)));
        }
        else if(money>400){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.taxmax)));
        }
    }
```
## 五、流程图
![](https://github.com/haaix/Java-lab4/blob/main/img/%E6%B5%81%E7%A8%8B%E5%9B%BE.png)
## 六、运行截图
![](https://github.com/haaix/Java-lab4/blob/main/img/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C.png)
## 七、实验感想
&emsp;&emsp;通过本次实验,熟悉掌握了Java的异常机制,try catch的执行过程。
通过new一个数组,从而通过数组的下标取出内容，当下标不合法时就会出现数组下标越界异常。
通过catch捕获异常,并对异常作出处理。同时也了解到了static以及final的使用。

