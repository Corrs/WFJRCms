package net.mingsoft.comment.biz;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mingsoft.base.biz.IBaseBiz;
import com.mingsoft.base.entity.BaseEntity;
import com.mingsoft.util.PageUtil;

import net.mingsoft.comment.bean.CommentSumeryBean;
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
 * Comments:评论业务层，接口，继承IBaseBiz
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
public interface ICommentBiz extends IBaseBiz {
	
	CommentSumeryBean sumery(CommentEntity comment);
	
	/**
	 *保持评论
	 * @param comment
	 */
	int saveComment(CommentEntity comment);
}
