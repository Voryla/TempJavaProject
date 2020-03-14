import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenericClass<Integer> genericClass = new GenericClass<>();
        //不设置类型，默认就是Object
        GenericClass genericClass1 = new GenericClass<>();

        //泛型方法三个参数,没有得到控制所以任何类型都可以传入方法
        GenericFun genericFun = new GenericFun();
        int a = 3, b = 4;
        String c = "a";
        genericFun.GenFun(a, b, c);

        //泛型类 泛型参数方法
        GenericClassFun<Integer> GenericClassFun = new GenericClassFun<>();
        // GenericClassFun.GenFun(3,4,new Date());
        GenericClassFun.GenFun(3, 4, 5);

        //泛型类，泛型方法没有直接联系与控制
        GenericClassFunCover<Integer> genericClassFunCover = new GenericClassFunCover<>();
        genericClassFunCover.GenFun(3, 4, "3");

        //通过extend控制实例化对象和使用方法是的参数类型
        //ControlGenericClassFunCover<String> controlGenericClassFunCover=new ControlGenericClassFunCover();
        ControlGenericClassFunCover<Integer> controlGenericClassFunCover = new ControlGenericClassFunCover();
        ControlGenericClassFunCover controlGenericClassFunCover1 = new ControlGenericClassFunCover();
        controlGenericClassFunCover.GenFun("3", "4", "5");

        //通配符的使用
        GenericClassFun<? extends Integer> classFun;
        classFun = new GenericClassFun<Integer>();
    }
}

class GenericClass<T> {

}

class GenericFun {
    public <T> void GenFun(T a, T b, T c) {

    }
}

class GenericClassFun<T> {
    public void GenFun(T a, T b, T c) {

    }
}

class GenericClassFunCover<T> {
    public <T> void GenFun(T a, T b, T c) {

    }
    public <K> ArrayList<K> ge(K k){
        return new ArrayList<>();
    }
}

class ControlGenericClassFunCover<T extends Integer> {
    public <T extends String> void GenFun(T a, T b, T c) {

    }
}