package useReflex;

public class Use {
    public static void main(String[] args) throws Exception{
        Iphone iphone = new Iphone();
        Class ipones = iphone.getClass();
        ipones=new Iphone().getClass();


        Class noIphone = Iphone.class;
        Iphone newIphone= (Iphone) noIphone.getConstructor().newInstance();
        newIphone.youIphone();


        //��Ҫ�������
        Class iphoneForName = Class.forName("useReflex.Iphone");
        //��Classת��ΪĿ�����ķ���
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