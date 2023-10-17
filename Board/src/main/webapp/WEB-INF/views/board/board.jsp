<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


    <!DOCTYPE html>
    <!-- URLs.jsp -->


    <html>

    <head>
        <meta charset="UTF-8">
        <title>게시판</title>
        <!-- 부트스트랩 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    </head>

    <!-- 	게시판 목록 -->
    <div id="boardListformDiv" class="container col-8">
        <table class="table caption-top">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">작성일</th>
                    <th scope="col">조회</th>
                    <th scope="col">좋아요</th>

                </tr>
            </thead>
            <tbody id="boardListForm">
                <!-- 게시판리스트 ajax로 구성 -->
            </tbody>
        </table>
        <!-- 		페이지네이션 바 -->
        <nav aria-label="Page navigation example">
            <ul id="pagenation" class="pagination justify-content-center">
                <li class="page-item disabled"><a class="page-link">Previous</a></li>


                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>

        <div id="boardBottombtn">
            <c:if test="${(loginUserInfo ne null)}">
                <c:if test="${(category ne 'notice') || (loginUserInfo.id eq 'admin')}">
                    <button class="boardWritebtn btn btn-info mb-3" type="button"
                        style="float:right;font-weight:700">글쓰기</button>
                </c:if>
            </c:if>
        </div>

    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script type="text/javascript">
        $.ajax({
            url: "api/board/list",
            type: "GET",
            success: function (boardList) {
                console.log(boardList);
                boardList.forEach(board => {

                    const isoDate = board.regDt.slice(0, -10);                    
                    const customFormat = isoDate.replace('T', '-');
                    $("#boardListForm").append(
                        "<tr>" +
                        "<td>" + board.id + "</td>" +
                        "<td>" + `<a href="/board/detail/`+board.id+`">`+board.title + "</a></td>" +
                        "<td>" + board.writerId + "</td>" +
                        "<td>" + customFormat + "</td>" +
                        "<td>" + "0" + "</td>" +
                        "<td>" + "0" + "</td>" +
                        "</tr>"


                    );
                });

                // 여기에 요청 성공 후 실행할 코드 추가
            },
            error: function (error) {
                console.log(error);
            }
        });
        function formatCustomDate(date) {
            const year = date.getFullYear();
            const month = (date.getMonth() + 1).toString().padStart(2, '0');
            const day = date.getDate().toString().padStart(2, '0');
            const hours = date.getHours().toString().padStart(2, '0');
            const minutes = date.getMinutes().toString().padStart(2, '0');

            return `${year}${month}${day} ${hours}:${minutes}`;
        }


        /*		$(".boardWritebtn").on("click",function(){
                    location.href="/worldcup/board/write.jsp?category=${category}&menu=write";
                });
                */




        /*		$("button[class^=\"boardDeletebtn\"]").on("click",function(){
                        $.ajax({
                            url : "/worldcup/board/delete?category="+category+"&"+category+"Idx="+$(this).val(),
                            type : "POST",
                            success : function(amount) {
                            alert("공지사항이 삭제되었습니다!");
                             location.reload();
                            },
                            error : function(error) {
                                console.log(error);
                            }
                        });
                });*/


    </script>
    </body>

    </html>