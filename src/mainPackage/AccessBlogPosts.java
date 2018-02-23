package mainPackage;
import java.sql.*;
import java.util.*;

public class AccessBlogPosts {
	
	Connection conn = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public void connectToDB() throws Exception{
		try {
			conn = ConnectionManager.getConnection();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String readAuthor(String author) throws Exception{
		String autor = "";
		statement = conn.createStatement();
		resultSet = statement.executeQuery("SELECT author FROM tbl_post where author='" + author + "'" );
		while (resultSet.next()) {
			autor = resultSet.getString("author");
		}
		return autor;
	}
	
	public String[] readPostFromAuthor(String author) throws Exception {
		
		List<String> post = new ArrayList<String>();
		statement = conn.createStatement();
		resultSet = statement.executeQuery("SELECT body FROM tbl_post WHERE author='" + author + "'");
		
		while (resultSet.next()) {
			post.add(resultSet.getString("body"));
		}
		
		String[] arrPost = new String[post.size()];
		arrPost = post.toArray(arrPost);
		
		return arrPost;
	}
	
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	
	public void insertPost(String author, String body, String title) throws Exception {
		statement = conn.createStatement();
		statement.execute("INSERT INTO tbl_post(author, body, title) VALUES('" + author + "' ,'" + body + "', '" + author + "')");
	}
	
	public void updatePost(String body,Integer postID, String author ) throws Exception {
		statement = conn.createStatement();
		
		statement.executeUpdate("UPDATE tbl_post SET body='" + body + "' WHERE id='" + postID + "'");
		
		
		
	}
}
