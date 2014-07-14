
<%@ page import="com.taxapp.RuleInfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ruleInfo.label', default: 'RuleInfo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<resource:richTextEditor type="simple" />
	</head>
	<body>
		<a href="#show-ruleInfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-ruleInfo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ruleInfo">
			
				<g:if test="${ruleInfoInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="ruleInfo.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${ruleInfoInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ruleInfoInstance?.content}">
				<li class="fieldcontain">
					<span id="content-label" class="property-label"><g:message code="ruleInfo.content.label" default="Content" /></span>
<%--						<span class="property-value" aria-labelledby="content-label"><g:fieldValue bean="${ruleInfoInstance}" field="content"/></span>--%>
<%--					<richui:richTextEditor name="content" value="${ruleInfoInstance?.content}" width="300" height="400" />--%>
					<richui:richTextEditor name="content" value="${fieldValue(bean:ruleInfoInstance,field:'content').decodeHTML()}" width="200" height="600"/>
				</li>
				</g:if>
			
				<g:if test="${ruleInfoInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="ruleInfo.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${ruleInfoInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ruleInfoInstance?.imageData}">
				<li class="fieldcontain">
					<span id="imageData-label" class="property-label"><g:message code="ruleInfo.imageData.label" default="Image Data" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ruleInfoInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="ruleInfo.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${ruleInfoInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ruleInfoInstance?.year}">
				<li class="fieldcontain">
					<span id="year-label" class="property-label"><g:message code="ruleInfo.year.label" default="Year" /></span>
					
						<span class="property-value" aria-labelledby="year-label"><g:fieldValue bean="${ruleInfoInstance}" field="year"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${ruleInfoInstance?.id}" />
					<g:link class="edit" action="edit" id="${ruleInfoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
