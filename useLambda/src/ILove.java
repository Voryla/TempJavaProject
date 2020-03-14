public class ILove implements Love{
    @Override
    public String whoLove(String boy, String girl) {
        return boy+girl;
    }
}
class IPlace implements Place{
    @Override
    public void ILove(String boy, String girl, int years) {
        System.out.println("I love place");
    }
}
