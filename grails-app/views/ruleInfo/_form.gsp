<%@ page import="com.taxapp.RuleInfo" %>

<resource:richTextEditor type="full" /> 

<div class="fieldcontain ${hasErrors(bean: ruleInfoInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="ruleInfo.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${ruleInfoInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ruleInfoInstance, field: 'imageData', 'error')} ">
	<label for="imageData">
		<g:message code="ruleInfo.imageData.label" default="Image Data" />
		
	</label>
	<input type="file" id="imageData" name="imageData" />
</div>

<div class="fieldcontain ${hasErrors(bean: ruleInfoInstance, field: 'year', 'error')} ">
	<label for="year">
		<g:message code="ruleInfo.year.label" default="Year" />
		
	</label>
	<g:textField name="year" value="${ruleInfoInstance?.year}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ruleInfoInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="ruleInfo.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
<%--	<g:textField name="content" required="" value="${ruleInfoInstance?.content}"/>--%>
	<richui:richTextEditor name="content" value="${ruleInfoInstance?.content}" width="200" height="500" />
</div>

