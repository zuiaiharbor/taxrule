
<%@ page import="com.taxapp.RuleInfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ruleInfo.label', default: 'RuleInfo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ruleInfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create">新建</g:link></li>
			</ul>
		</div>
		<div id="list-ruleInfo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'ruleInfo.title.label', default: '标题')}" />
					
<%--						<g:sortableColumn property="content" title="${message(code: 'ruleInfo.content.label', default: 'Content')}" />--%>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'ruleInfo.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="imageData" title="${message(code: 'ruleInfo.imageData.label', default: 'Image Data')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'ruleInfo.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="year" title="${message(code: 'ruleInfo.year.label', default: 'Year')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ruleInfoInstanceList}" status="i" var="ruleInfoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ruleInfoInstance.id}">${fieldValue(bean: ruleInfoInstance, field: "title")}</g:link></td>
					
<%--						<td>${fieldValue(bean: ruleInfoInstance, field: "content")}</td>--%>
					
						<td><g:formatDate date="${ruleInfoInstance.dateCreated}" format="yyyy-MM-dd"/></td>
					
						<td>${fieldValue(bean: ruleInfoInstance, field: "imageData")}</td>
					
						<td><g:formatDate date="${ruleInfoInstance.lastUpdated}" format="yyyy-MM-dd"/></td>
					
						<td>${fieldValue(bean: ruleInfoInstance, field: "year")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ruleInfoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
