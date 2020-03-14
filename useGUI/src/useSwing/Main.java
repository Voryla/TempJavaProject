package useSwing;


public class Main {
    public static void main(String[] args){
        CustomUI customUI=new CustomUI("swing");
        customUI.setSize(500,300,500,300);
        customUI.addButton("选择文件",40,30);
        customUI.addScrollPane();
        customUI.setVisible(true);
    }
}
