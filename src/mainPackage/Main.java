package mainPackage;
import java.sql.*;
import java.util.Arrays;

import com.mysql.jdbc.MysqlDefs;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AccessBlogPosts db = new AccessBlogPosts();
		db.connectToDB();
		
		String[] post = db.readPostFromAuthor("luchito");
		//db.insertPost("luchito", "nada de body", "java");
		db.updatePost("body desde java", 5, "sin autor");
		
		db.close();
		
		for (int i = 0; i < post.length; i++) {
			System.out.println(post[i]);
		}
		
	}

}
