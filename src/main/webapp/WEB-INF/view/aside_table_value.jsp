<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <%-- ${vilage.response.body.items.fsctItems} --%>
   
   <!-- TMX(낮 최고기온)는 11시에 나옴 --> 
   <!-- TMN(아침 최저기온)는 02시에 나옴 --> 
    <table border = 1 class="table table-hover">
	 
    	 <c:forEach items="${vilage.response.body.items.fsctItems}" var="fsctItem">
            <tr>       
            <td width = 150>발표일자</td>                     	                         
             <td width = 150>${fsctItem.baseDate}</td>  
             <td width = 150>발표시각</td>                     	                         
             <td width = 150>
         		 ${fsctItem.baseTime}
             </td>                                                                                            
            </tr>
           
            <tr>
            <td width = 150>자료구분문자</td>
            <td width = 150>         
              <c:if test= "${fsctItem.category eq 'POP'}" >
               <c:out value ="강수확률"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'PTY'}" >
               <c:out value ="강수형태"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'R06'}" >
               <c:out value ="6시간 강수량"/>
              </c:if>
                <c:if test= "${fsctItem.category eq 'S06'}" >
               <c:out value ="6시간 신적설"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'REH'}" >
               <c:out value ="습도"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'SKY'}" >
               <c:out value ="하늘상태"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'T3H'}" >
               <c:out value ="3시간기온"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'TMN'}" >
               <c:out value ="아침 최저 기온"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'TMX'}" >
               <c:out value ="낮 최고 기온"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'UUU'}" >
               <c:out value ="풍속"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'VVV'}" >
               <c:out value ="풍속"/>
              </c:if>
              <c:if test= "${fsctItem.category eq 'VEC'}" >
               <c:out value ="풍향"/>
              </c:if>                	
            </td>
             <td width = 150>예보 값</td>
            <td width = 150>
            <c:if test= "${fsctItem.category eq 'POP' || fsctItem.category eq 'REH'}" >
               <c:out value ="${fsctItem.fcstValue}%"/>
            </c:if>
           
             <c:if test= "${fsctItem.category eq 'T3H' || fsctItem.category eq 'TMX' || fsctItem.category eq 'TMN'}" >
               <c:out value ="${fsctItem.fcstValue}℃"/>
            </c:if>
            
             <c:if test= "${fsctItem.category eq 'UUU' || fsctItem.category eq 'VVV' || fsctItem.category eq 'VEC' }" >
               <c:out value ="${fsctItem.fcstValue} m/s"/>
            </c:if>
            <br/> <!-- 확인용 -->${fsctItem.fcstValue}
          
            
            
            
            </td>
            </tr>         
            <tr>
            <td width = 150>x좌표</td>
            <td width = 150>${fsctItem.nx}</td>
            <td width = 150>y좌표</td>
            <td width = 150>${fsctItem.ny}</td>
            </tr>
           
     </c:forEach>   
    
    </table>