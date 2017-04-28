package net.mingsoft.comment.aop;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mingsoft.basic.aop.BaseAop;
import com.mingsoft.basic.biz.IBasicBiz;

import net.mingsoft.comment.entity.CommentEntity;

/**
 * 铭飞评论插件
 * @author 铭飞开发团队
 * @version 
 * 版本号：100-000-000<br/>
 * 创建日期：2017年2月16日<br/>
 * 历史修订：<br/>
 */

@Component
@Aspect
public class CommentAop extends BaseAop {

	@Resource(name="basicBiz")
	private IBasicBiz baicBiz;
	
	@Pointcut("execution(* net.mingsoft.comment.biz.impl.CommentBizImpl.saveComment(..))")
	public void save() {
	}

	/**
	 * 报错评论时需要更新基础信息的评论数量
	 * @param jp
	 * @return
	 * @throws Throwable
	 */
	@Around("save()")
	public Object save(ProceedingJoinPoint jp) throws Throwable {
		CommentEntity comment = this.getType(jp, CommentEntity.class,true);
		Object obj = jp.proceed();
		if(comment.getCommentBasicId() > 0) {
			baicBiz.updateHit(comment.getCommentBasicId());
		}
		return obj;
	}
}
