package net.mingsoft.comment.action.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingsoft.base.action.BaseAction;
import com.mingsoft.base.entity.ListJson;
import com.mingsoft.base.filter.DateValueFilter;
import com.mingsoft.base.filter.DoubleValueFilter;
import com.mingsoft.util.PageUtil;
import com.mingsoft.util.StringUtil;

import net.mingsoft.basic.bean.ListBean;
import net.mingsoft.basic.util.BasicUtil;
import net.mingsoft.comment.biz.ICommentBiz;
import net.mingsoft.comment.constant.ModelCode;
import net.mingsoft.comment.entity.CommentEntity;

/**
 * 
 * 铭飞平台-评论插件
 * 
 * @author 铭飞开发团队
 * @version 版本号：100-000-000<br/>
 *          创建日期：2016年5月3日<br/>
 *          历史修订：<br/>
 */
@Controller("webComment")
@RequestMapping("/comment")
public class CommentAction extends BaseAction {

	/**
	 * 评论业务层
	 */
	@Autowired
	private ICommentBiz commentBiz;

	/**
	 * 文章评论列表
	 * @param commentBasicId
	 *            信息编号<br/>
	 *            pageNo 页码 <br/>
	 *            pageSize 一页数量 (可选)<br/>
 	 *			  <dt><span class="strong">返回</span></dt><br/>
	 *            { "list":[ {<br/>
	 *            commentContent: 内容<br/>
	 *            commentPeopleUser: [
	 *            	peopleUserIcon:用户头像<br/>
	 *            	peopleUserNickName:用户昵称<br/>
	 *            ]用户信息<br/>
	 *            } ]<br/>
	 *            "page":{"endRow": 2, <br/>
	 *            "firstPage": 1, <br/>
	 *            "hasNextPage": true存在下一页false不存在, <br/>
	 *            "hasPreviousPage": true存在上一页false不存在, <br/>
	 *            "isFirstPage": true是第一页false不是第一页, <br/>
	 *            "isLastPage": true是最后一页false不是最后一页, <br/>
	 *            "lastPage": 最后一页的页码, <br/>
	 *            "navigatePages": 导航数量，实现 1...5.6.7....10效果, <br/>
	 *            "navigatepageNums": []导航页码集合, <br/>
	 *            "nextPage": 下一页, <br/>
	 *            "pageNum": 当前页码, <br/>
	 *            "pageSize": 一页显示数量, <br/>
	 *            "pages": 总页数, <br/>
	 *            "prePage": 上一页, <br/>
	 *            "size": 总记录, <br/>
	 *            "startRow": , <br/>
	 *            "total":总记录数量}<br/>
	 *            }<br/
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public void list(@ModelAttribute CommentEntity comment,HttpServletRequest request, HttpServletResponse response) {
		if (comment==null || comment.getCommentBasicId() <= 0) {
			this.outJson(response, ModelCode.COMMENT, false);
		}
		BasicUtil.startPage();
		List list = commentBiz.query(comment);
		ListBean _list = new ListBean(list, BasicUtil.endPage(list));
		this.outJson(response, net.mingsoft.base.util.JSONArray.toJSONString(_list, new DoubleValueFilter(),new DateValueFilter("yyyy-MM-dd")));
		
	}

}
