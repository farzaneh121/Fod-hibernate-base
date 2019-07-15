package main.java.tags;

import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TableTag extends BodyTagSupport {
	Collection<?> list;

	@Override
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	@Override
	public void setBodyContent(BodyContent b) {
		super.setBodyContent(b);
	}

	@Override
	public void doInitBody() throws JspException {
		super.doInitBody();
	}

	@Override
	public int doAfterBody() throws JspException {
		return super.doAfterBody();
	}

	@Override
	public void release() {
		super.release();
	}

	@Override
	public BodyContent getBodyContent() {
		return super.getBodyContent();
	}

	@Override
	public JspWriter getPreviousOut() {
		return super.getPreviousOut();
	}

}
