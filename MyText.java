public class MyText {
    public static void main(String[] args) {
        /*随机生成6位数子*/
        int code = (int)(Math.random()*1000000);
        //email 收件人邮箱      code验证码
        boolean fasong = EmailUtil.fasong("xxxxxxxxx@qq.com", code);
    }
}
