package net.mingsoft.comment.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mingsoft.base.entity.BaseEntity;
import com.mingsoft.basic.action.BaseAction;
import com.mingsoft.basic.constant.Const;
import com.mingsoft.basic.constant.e.CookieConstEnum;
import com.mingsoft.util.PageUtil;

import net.mingsoft.basic.bean.ListBean;
import net.mingsoft.basic.util.BasicUtil;
import net.mingsoft.comment.biz.ICommentBiz;
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
 * Comments:后台评论管理，继承BasicAction
 * </p>
 *  
 * <p>
 * Create Date:2014-8-21
 * </p>
 *
 * <p>
 * Modification history:
 * </p>
 */
@Controller
@RequestMapping("/${managerPath}/comment")
public class CommentAction extends BaseAction {
	
	/**
	 * 评论业务层
	 */
	@Autowired
	private ICommentBiz commentBiz;
	
	/**
	 * 评论列表路径
	 */
	private final static String PAGE_URL = "/manager/comment/list.do";

	/**
	 * 指定文章的评论列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@ModelAttribute CommentEntity comment,HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		BasicUtil.startPage();
		List list = commentBiz.query(comment);
		BasicUtil.endPage(list);
		model.addAttribute("listComment", list);
		return view("/comment/comment");
	}
	
	/**
	 * 删除评论
	 * @param commentId 评论ID
	 * @param request 请求
	 * @param response 响应
	 */
	@RequestMapping("/{commentId}/delete")
	@ResponseBody
	public int delete(@PathVariable int commentId, HttpServletRequest request) {
		int pageNo = 1;
		if (commentId != 0) {
			commentBiz.deleteEntity(commentId);
			//判断当前页码
			this.getHistoryPageNoByCookie(request);
		}
		return pageNo;
	}
	
	/**
	 * 删除评论
	 * @param commentId 评论ID
	 * @param request 请求
	 * @param response 
	 * @param response 响应
	 */
	@RequestMapping("{commentId}/reply")
	@ResponseBody
	public void reply(@ModelAttribute CommentEntity comment,@PathVariable int commentId, HttpServletRequest request, HttpServletResponse response) {
		//根据评论id查找评论实体
		CommentEntity sonComment = (CommentEntity) this.commentBiz.getEntity(commentId);
		if(sonComment!=null){
				comment.setCommentCommentId(sonComment.getCommentId());
				comment.setCommentBasicId(sonComment.getCommentBasicId());
				comment.setCommentPeopleId(sonComment.getCommentPeopleId());
				this.commentBiz.saveEntity(comment);
				// 获取cookie
				String cookie =this.getCookie(request, CookieConstEnum.BACK_COOKIE);
				this.outJson(response, null, true,String.valueOf(cookie));
				
		}
	}
	
	@RequestMapping("{commentId}/queryByParentCommentId")
	public void queryByParentCommentId(@ModelAttribute  CommentEntity comment, HttpServletRequest request, HttpServletResponse response){
		List listComment = this.commentBiz.query(comment);
		this.outJson(response,JSONObject.toJSONStringWithDateFormat(listComment,"YYYY-MM-dd hh:mm:ss"));
	}
	
}
