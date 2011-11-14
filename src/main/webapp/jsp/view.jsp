<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<script type="text/javascript">
   function keepSession() {
      eXo.session.itvInit();
   }
</script>
<c:if test="${sessionAlive == 'always'}">
   <c:set var="msg1">The session has been kept by Portal</c:set>
   <c:set var="msg2">Session is always kept regardless of the portlet want or not</c:set>
</c:if>
<c:if test="${sessionAlive == 'ondemand'}">
   <c:set var="msg1">The session can be kept by application</c:set>
   <c:set var="msg2">Session will be kept if you click the 'Keep Session' button</c:set>
</c:if>
<c:if test="${sessionAlive == 'never'}">
   <c:set var="msg1">The session will timeout normally, even if an application require to keep session</c:set>
   <c:set var="msg2">If you click 'Keep Session' button, the session still timeout normally</c:set>
</c:if>
<p>
<h3><c:out value="${msg1}" /></h3>
<i><c:out value="${msg2}" /></i>
</p>
<input type="button" value="Keep Session" onclick="keepSession()" />
<br />
<p><i>Click the button to execute this JavaScript command</i>
<br />
<h4>eXo.session.itvInit();</h4>