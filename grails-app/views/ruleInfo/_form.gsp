<%@ page import="com.taxapp.RuleInfo" %>



<div class="fieldcontain ${hasErrors(bean: ruleInfoInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="ruleInfo.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${ruleInfoInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ruleInfoInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="ruleInfo.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="content" cols="40" rows="5" maxlength="40960" required="" value="${ruleInfoInstance?.content}"/>
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

