<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>인덱스를 만들어 보자</title>

    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
	

</head>
<body>
	<%@ include file="../include/header.jsp" %>
    <!--게시판-->
    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form>
                            <div>
                                <label>DATE</label>
                                <p>2019-12-12</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='##' readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='##'>
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='##'>
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='##'></textarea>
                            </div>

                            <button type="button" class="btn btn-dark">목록</button>    
                            <button type="button" class="btn btn-primary">변경</button>
                            <button type="button" class="btn btn-info">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
        
        <%@ include file="../include/footer.jsp" %>
</body>
</html>