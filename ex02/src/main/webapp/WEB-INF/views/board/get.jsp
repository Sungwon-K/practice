<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../includes/header.jsp" %>

		<!-- 컨텐츠 ----------------------->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                
                        <div class="panel-heading">
                            	Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

                           	
                        		<div class="form-group">
                        			<label>글번호</label>
                        			<input class="form-control" name='bno'
                        			value='<c:out value = "${board.bno}"/>'readonly="readonly">
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Title</label>
                        			<input class="form-control" name='title'
                        			value='<c:out value = "${board.title}"/>'readonly="readonly">
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Content</label>
                        			<textarea class="form-control" rows="3" name='content' readonly="readonly">
                        				<c:out value="${board.content}"/>
                        			</textarea>
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Writer</label>
                        			<input class="form-control" name='writer'
                        			value='<c:out value = "${board.writer}"/>'readonly="readonly">
                        		</div>
                        		
                        		<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
                        		<button type="reset" data-oper='list' class="btn bnt-default">List</button>
                        
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>          
        </div>
        <!-- 컨텐츠 -->
  
<%@ include file="../includes/footer.jsp" %>