package net.mingsoft.comment.entity;
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
 * Comments:评论实体类
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
public class CommentEntity extends BaseEntity {

	/**
	 * 评论ID
	 */
    private int commentId;
    
    /**
     * 父评论ID
     */
    private int commentCommentId;
    
    /**
     * 评论的内容
     */
    private String commentContent;

    /**
     * 评论时发布的图片
     */
    private String commentPicture;
    /**
     * 文件名称
     */
    private String commentFileName;
    /**
     * 文件路径
     */
    private String commentFilePath;

    /**
     * 评论时间
     */
    private Date commentTime = new Date();

    /**
     * 评论类型：1 匿名，2 公开
     */
    private int commentType;
    
    /**
     * 评论者ID
     */
    private int commentPeopleId;
    
    /**
     * 评价打分（-1至5分）
     */
    private int commentPoints;
    
    /**
     * 绑定basicId
     */
    private int commentBasicId;
    
    /**
     * 子评论的集合
     */
    private List<CommentEntity> childComment;
    
    /**
	 * 用户实体  不参与表字段结构
	 */
	private PeopleEntity commentPeople;
	
	
	/**
	 * 评论所属的appId
	 */
	private int commentAppId;
	
	/**
	 * 是否是匿名
	 */
	private boolean isAnonymous = false;
	
	/**
	 * 评论用户的详细信息实体 不参与表字段结构
	 */
	private PeopleUserEntity commentPeopleUser;
	
	
	public int getCommentAppId() {
		return commentAppId;
	}

	public void setCommentAppId(int commentAppId) {
		this.commentAppId = commentAppId;
	}

	public List<CommentEntity> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<CommentEntity> childComment) {
		this.childComment = childComment;
	}

	/**
     * 获取commentId
     * @return commentId
     */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * 设置commentId
	 * @param commentId
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	/**
	 * 获取commentCommentId
	 * @return commentCommentId
	 */
	public int getCommentCommentId() {
		return commentCommentId;
	}

	/**
	 * 设置commentCommentId
	 * @param commentCommentId
	 */
	public void setCommentCommentId(int commentCommentId) {
		this.commentCommentId = commentCommentId;
	}

	/**
	 * 获取commentContent
	 * @return commentContent
	 */
	public String getCommentContent() {
		return commentContent;
	}

	/**
	 * 设置commentContent
	 * @param commentContent
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	/**
	 * 获取commentPicture
	 * @return commentPicture
	 */
	public String getCommentPicture() {
		return commentPicture;
	}

	/**
	 * 设置commentPicture
	 * @param commentPicture
	 */
	public void setCommentPicture(String commentPicture) {
		this.commentPicture = commentPicture;
	}

	/**
	 * 获取commentTime
	 * @return commentTime
	 */
	public Date getCommentTime() {
		return commentTime;
	}

	/**
	 * 设置commentTime
	 * @param commentTime
	 */
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	/**
	 * 获取commentType
     * 评论类型：1 匿名，2 公开
	 * @return commentType
	 */
	public int getCommentType() {
		return commentType;
	}

	/**
	 * 设置commentType
     * 评论类型：1 匿名，2 公开
	 * @param commentType
	 */
	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}

	/**
	 * 获取commentPeopleId
	 * @return commentPeopleId
	 */
	public int getCommentPeopleId() {
		return commentPeopleId;
	}

	/**
	 * 设置commentPeopleId
	 * @param commentPeopleId
	 */
	public void setCommentPeopleId(int commentPeopleId) {
		this.commentPeopleId = commentPeopleId;
	}

	/**
	 * 获取commentPoints
	 * @return commentPoints
	 */
	public int getCommentPoints() {
		return commentPoints;
	}

	/**
	 * 设置commentPoints
	 * @param commentPoints
	 */
	public void setCommentPoints(int commentPoints) {
		this.commentPoints = commentPoints;
	}

	/**
	 * 获取commentBasicId
	 * @return commentBasicId
	 */
	public int getCommentBasicId() {
		return commentBasicId;
	}

	/**
	 * 设置commentBasicId
	 * @param commentBasicId
	 */
	public void setCommentBasicId(int commentBasicId) {
		this.commentBasicId = commentBasicId;
	}

	public PeopleEntity getCommentPeople() {
		return commentPeople;
	}

	public void setCommentPeople(PeopleEntity commentPeople) {
		this.commentPeople = commentPeople;
	}


	public PeopleUserEntity getCommentPeopleUser() {
		return commentPeopleUser;
	}

	public void setCommentPeopleUser(PeopleUserEntity commentPeopleUser) {
		this.commentPeopleUser = commentPeopleUser;
	}

	public String getCommentFileName() {
		return commentFileName;
	}

	public void setCommentFileName(String commentFileName) {
		this.commentFileName = commentFileName;
	}

	public String getCommentFilePath() {
		return commentFilePath;
	}

	public void setCommentFilePath(String commentFilePath) {
		this.commentFilePath = commentFilePath;
	}

	public boolean isAnonymous() {
		return isAnonymous;
	}

	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	public void setAnonymous(int isAnonymous) {
		this.isAnonymous = isAnonymous>0;
	}
}
