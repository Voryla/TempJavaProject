package useReflex;

public class Use {
    public static void main(String[] args) throws Exception{
        Iphone iphone = new Iphone();
        Class ipones = iphone.getClass();
        ipones=new Iphone().getClass();


        Class noIphone = Iphone.class;
        Iphone newIphone= (Iphone) noIphone.getConstructor().newInstance();
        newIphone.youIphone();


        //需要掌握这个
        Class iphoneForName = Class.forName("useReflex.Iphone");
        //将Class转化为目标对象的方法
        Iphone newIphone2= (Iphone) iphoneForName.getConstructor().newInstance();
        newIphone2.youIphone();
    }

}

class Iphone {
    public Iphone() {
        System.out.println("ok");
    }
    public void youIphone(){
        System.out.println("you have a new Iphone");
    }
}