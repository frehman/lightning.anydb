package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@Table(name="document")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String url;

	public Document() {
	}


	@Id
	@Column(unique=true, nullable=false, length=12)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(length=18)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}