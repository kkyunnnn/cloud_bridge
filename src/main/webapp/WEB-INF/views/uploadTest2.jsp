<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h1>Spring 4 MVC - File Upload Example</h1>
                    <form method="post" action="uploadBinaryToImg" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="file1">File Input 1</label>
                            <input type="file" name="file" id="file1">
                        </div>
                        <button type="submit" class="btn btn-success">Submit</button><input type="button" value="홈으로" onclick="javascript:location.href='/'">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>