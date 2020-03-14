public class Going {
    public static void main(String[] args){
        Love love=(a,b)->a+b;
        System.out.println(love.whoLove("z","m"));

        Love love1=new ILove();
        love1=(a,b)->a+b+"3";
        System.out.println(love1.whoLove("w","n"));

        Place place=new IPlace();
        place.ILove("zwk","mmr",3);
        place=(a,b,c)->{
            System.out.println(a+b+"相处时间："+c);
        };
        place.ILove("zwk","mmr",3);
    }
}
