package WorkStudy;

import java.util.Scanner;

public class Laboratory<String> {
    private String name;
    private int room;

    static double great = 20; //得优的补助
    static double good = Math.ceil(great*0.75); //良的补助价格
    static double pass = Math.ceil(great*0.5); //及格的补助价格
    private int[] score = new int[18];

    public Laboratory(String name,int room){  //使用默认的补助价格
        this.name = name;
        this.room = room;
    }


    public void setRoom(int room) { this.room = room; }
    public void setName(String name) {
        this.name = name;
    }
    public void setscore(int[] a){ this.score = a; }
    //每一个实验室打分
    public void setScore() {
        try {
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
        catch (NumberFormatException e){
            System.out.println("数据结构异常");
        }
        catch (Exception e){
            System.out.println("异常");
        }
    }

    public String getName() {
        return name;
    }
    public int[] getScore(){
        return score;
    }

}
