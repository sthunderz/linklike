<h1>Link Like</h1>

<g:form name="linkCreateForm" url="[action:'create']">
  Title: <g:textField name="title"/><br/>
  URL: <g:textField name="url"/><br/>
  <input type="submit" value="Add new link"/>
</g:form>
<hr>

<ul>
  <% if(links.size() == 0) { %>
    <li>No links</li>
  <% } else { %>
    <% for(link in links) { %>
      <g:form name="linkCreateForm" url="[action:'vote']">
        <li><%= link.title %></li>
        <g:hiddenField name="title" value="${link.title}"/>
        <g:hiddenField name="url" value="${link.url}"/>
        <input type="submit" value="vote"/>
        <%= link.votenumber %>
      </g:form>
    <% } %> 
  <% } %>
</ul>

