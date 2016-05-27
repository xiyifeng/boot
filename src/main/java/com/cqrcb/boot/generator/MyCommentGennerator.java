package com.cqrcb.boot.generator;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class MyCommentGennerator implements CommentGenerator {

	@Override
	public void addClassComment(InnerClass arg0, IntrospectedTable arg1) {

	}

	@Override
	public void addClassComment(InnerClass arg0, IntrospectedTable arg1,
			boolean arg2) {

	}

	@Override
	public void addComment(XmlElement arg0) {

	}

	@Override
	public void addConfigurationProperties(Properties arg0) {

	}

	@Override
	public void addEnumComment(InnerEnum arg0, IntrospectedTable arg1) {

	}

	@Override
	public void addFieldComment(Field arg0, IntrospectedTable arg1) {

	}

	@Override
	public void addFieldComment(Field field,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (introspectedColumn.getRemarks() != null
				&& !introspectedColumn.getRemarks().equals("")) {
			field.addJavaDocLine("/**");
			try {
				field.addJavaDocLine(" * " + new String(introspectedColumn.getRemarks().getBytes("utf8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			field.addJavaDocLine(" */");
		}
	}

	@Override
	public void addGeneralMethodComment(Method arg0, IntrospectedTable arg1) {

	}

	@Override
	public void addGetterComment(Method arg0, IntrospectedTable arg1,
			IntrospectedColumn arg2) {

	}

	@Override
	public void addJavaFileComment(CompilationUnit arg0) {

	}

	@Override
	public void addRootComment(XmlElement arg0) {

	}

	@Override
	public void addSetterComment(Method arg0, IntrospectedTable arg1,
			IntrospectedColumn arg2) {

	}

}
