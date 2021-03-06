package com.four.qa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

/**
 * @author Tiaoyu
 * @date 2016/6/17
 */
@Entity
@Proxy(lazy = false)
@Table(name = "Answer")
@XmlRootElement(name = "Answer")
public class Answer {

	@Column(name = "ID", nullable = false)
	@Id
	@GeneratedValue(generator = "MODEL_ANSWER_ID_GENERATOR")
	@GenericGenerator(name = "MODEL_ANSWER_ID_GENERATOR", strategy = "native")
	private String ID;

	@Column(name = "ascontent", nullable = false)
	private String ascontent;

	@Column(name = "astime", nullable = false)
	private Date astime;

	@ManyToOne(targetEntity = Question.class, fetch = FetchType.LAZY)
	@Cascade(CascadeType.LOCK)
	@JoinColumn(name = "QID", referencedColumnName = "ID")
	private Question QID;

	public Answer() {
		super();
	}

	public Answer(String iD, String ascontent, Date astime, Question qID) {
		super();
		ID = iD;
		this.ascontent = ascontent;
		this.astime = astime;
		QID = qID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAscontent() {
		return ascontent;
	}

	public void setAscontent(String ascontent) {
		this.ascontent = ascontent;
	}

	public Date getAstime() {
		return astime;
	}

	public void setAstime(Date astime) {
		this.astime = astime;
	}

	public Question getQID() {
		return QID;
	}

	public void setQID(Question qID) {
		QID = qID;
	}

	@Override
	public String toString() {
		return "Answer [ID=" + ID + ", ascontent=" + ascontent + ", astime=" + astime + ", QID=" + QID + "]";
	}


}
