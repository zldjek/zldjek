package dto;

import java.util.*;

/*
create table order_info(
num int auto_increment primary key,
name varchar(50) not null,
price int not null,
quan varchar(50) not null,
file varchar(100) not null,
content varchar(500) not null,
Date date
);
 */
public class OrderDTO {
	private int num;
	private String name;
	private String price;
	private String quan;
	private String file;
	private String content;
	private Date date;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
