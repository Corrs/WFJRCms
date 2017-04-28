package net.mingsoft.comment.biz.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingsoft.base.biz.impl.BaseBizImpl;
import com.mingsoft.base.dao.IBaseDao;
import com.mingsoft.base.entity.BaseEntity;
import com.mingsoft.util.PageUtil;

import net.mingsoft.comment.bean.CommentSumeryBean;
import net.mingsoft.comment.biz.ICommentBiz;
import net.mingsoft.comment.dao.ICommentDao;
import net.mingsoft.comment.entity.CommentEntity;

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
 * Comments:评论业务层实现类，继承BaseBizImpl，实现ICommentBiz
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
@Service("commentBiz")
public class CommentBizImpl extends BaseBizImpl implements ICommentBiz {
	
	/**
	 * 评论持久化层
	 */ 
	private ICommentDao commentDao;
	
	/**
	 * 获取commentDao
	 * @return commentDao
	 */
	public ICommentDao getCommentDao() {
		return commentDao;
	}

	/**
	 * 设置commentDao
	 * @param commentDao
	 */
	@Autowired
	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}

	/**
	 * 获取commentDao
	 */
	@Override
	protected IBaseDao getDao() {
		return commentDao;
	}

	@Override
	public int saveComment(CommentEntity comment) {
		// TODO Auto-generated method stub
		this.commentDao.saveEntity(comment);
		return saveEntity(comment);
	}

	@Override
	public CommentSumeryBean sumery(CommentEntity comment) {
		// TODO Auto-generated method stub
		return commentDao.sumery(comment);
	};
	
	
	
}
