package net.mingsoft.comment.bean;
import java.util.Date;
import java.util.List;

import org.dom4j.tree.BaseElement;

import com.mingsoft.base.entity.BaseEntity;
import com.mingsoft.basic.entity.BasicEntity;
import com.mingsoft.people.entity.PeopleEntity;
import com.mingsoft.people.entity.PeopleUserEntity;

/**
 * 
 * 
 * <p>
 * <b>铭飞CMS-铭飞内容管理系统</b>
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2014 - 2015
 * </p>
 * 
 * <p>
 * Company:景德镇铭飞科技有限公司
 * </p>
 * 
 * @author 姓名：张敏
 * 
 * @version 300-001-001
 * 
 * <p>
 * 版权所有 铭飞科技
 * </p>
 *  
 * <p>
 * Comments:评论统计总计
 * </p>
 *  
 * <p>
 * Create Date:2014-8-25
 * </p>
 *
 * <p>
 * Modification history:
 * </p>
 */
public class CommentSumeryBean {
	private int commentPointsCount;
	private int commentCount;
	public int getCommentPointsCount() {
		return commentPointsCount;
	}
	public void setCommentPointsCount(int commentPointsCount) {
		this.commentPointsCount = commentPointsCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
}
