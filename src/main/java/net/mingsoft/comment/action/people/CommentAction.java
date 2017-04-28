/**
 * 
 */
package net.mingsoft.comment.action.people;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mingsoft.people.action.BaseAction;
import com.mingsoft.people.entity.PeopleEntity;

import net.mingsoft.comment.biz.ICommentBiz;
import net.mingsoft.comment.constant.ModelCode;
import net.mingsoft.comment.entity.CommentEntity;

/**
 * 铭飞MS平台-评论插件
 * 
 * @author 铭飞开发团队
 * @version 版本号：100-000-000<br/>
 *          创建日期：2016年5月3日<br/>
 *          历史修订：<br/>
 */
@Controller("peopleComment")
@RequestMapping("/people/comment")
public class CommentAction extends BaseAction {

	/**
	 * 评论业务层
	 */
	@Autowired
	private ICommentBiz commentBiz;

	/**
	 * 发布评论
	 * 
	 * @param rand_code
	 *            验证码
	 * @param comment
	 *            用户信息<br/>
	 *            <i>comment 参数包含字段信息参考：</i><br/>
	 *            commentBasicId 信息编号<br/>
	 *            commentCommentId 父评论id(可选)<br/>
	 *            commentContent 评论内容 <br/>
	 *            commentPicture 评论图片 (可选)<br/>
	 *            commentPoints 评论分数 (可选)<br/>
	 *            <dt><span class="strong">返回</span></dt><br/>
	 *            {code:"错误编码",<br/>
	 *            result:"true｜false",<br/>
	 *            resultMsg:"错误信息", <br/>
	 *            }
	 * 
	 */
	@RequestMapping("/save")
	@ResponseBody
	public void save(@ModelAttribute CommentEntity comment, HttpServletRequest request, HttpServletResponse response) {
		if (!this.checkRandCode(request)) {
			this.outJson(response, ModelCode.COMMENT, false, this.getResString("err.error", this.getResString("rand.code")));
			return;
		}
		if (comment == null) {
			this.outJson(response, false);
			return;
		}

		// 加载用户ID
		comment.setCommentPeopleId(this.getPeopleBySession(request).getPeopleId());
		this.commentBiz.saveEntity(comment);
		this.outJson(response, ModelCode.COMMENT, true, JSONObject.toJSONString(comment));
	}

}
