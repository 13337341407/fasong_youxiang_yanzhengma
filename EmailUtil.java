import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailUtil {
	//email 收件人邮箱      code验证码
	public static boolean fasong(String email,int code) {
		boolean b = false;
		try {
			Properties properties = new Properties();
			// 以下不用修改
	        properties.put("mail.transport.protocol", "smtp");// 连接协议
	        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
	        properties.put("mail.smtp.port", 465);// 端口号
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接    一般都不用
	        properties.put("mail.debug", "true");// 设置是否显示dedug信息true会在控制台显示相关信息
	        // 得到会话对象
	        Session session = Session.getInstance(properties);
	        // 获取邮件对象
	        Message message = new MimeMessage(session);
	        // 设置发件人邮箱地址(自己的邮箱，要和连接自己的邮箱账号的user对应)
	        message.setFrom(new InternetAddress("xxxxxxxxx@qq.com"));
	        // 设置收件人邮箱地址
//	        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("708848391@qq.com")});
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));//一个收件人
	        // 设置邮件标题
	        message.setSubject("用户注册");
	        // 设置邮件内容
	        message.setText("您的验证码为："+code);
	        // 得到邮差对象
	        Transport transport = session.getTransport();
	        // 连接自己的邮箱账号  user:自己的邮箱   password: 密码为qq邮箱的stmp服务后得到的客户端授权码
	        transport.connect("xxxxxxxxx@qq.com", "xxxxxxxxxxx");//
	        // 发送邮件
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        b = true;
		} catch (Exception e) {
			//e.printStackTrace();  打印异常信息
			System.out.println("邮箱验证码发送失败");
			b = false;
		}
		return b;
	}
}
