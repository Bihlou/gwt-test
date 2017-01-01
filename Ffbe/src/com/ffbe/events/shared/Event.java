package com.ffbe.events.shared;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

	private static final long serialVersionUID = 5231309839384616499L;
	
	private int idEvent;
	private String name;
	private Date dateBegin;
	private Date dateEnd;
	
	public Event(){}

	public Event(int idEvent, String name, Date dateBegin, Date dateEnd) {
		super();
		this.idEvent = idEvent;
		this.name = name;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
}
