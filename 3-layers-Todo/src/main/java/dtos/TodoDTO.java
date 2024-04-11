package dtos;

import java.util.Date;

public class TodoDTO {
	private Integer id;
    private String title;
    private Boolean completed;
    private Date createdAt;
    private Date updatedAt;
    
	public TodoDTO() {

	}


	public TodoDTO(String title) {
		
		this.title = title;
	
		
	}
	
	
	public TodoDTO(Integer id, String title) {
		
		this.id = id;
		this.title = title;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    

}
