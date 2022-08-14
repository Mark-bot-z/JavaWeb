public class test {
    public static void main(String[] args) {
        String path = "/fruit.do";
        path = path.replace('/', ' ').trim().substring(0,path.indexOf(".do")-1);
        System.out.println(path);
    }
}
