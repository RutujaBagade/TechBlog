<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page  import="com.techblog.entities.Message" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Paqe</title>

        <!--css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="Css/Mystyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background{
                clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
            }
        </style>

    </head>
    <body>
     <!--navbar-->
        <%@ include  file="Normal_NavBar.jsp" %>
         <main class="d-flex align-items-center primary-background banner-background" style="height: 70vh">
        <div class="container">
                <div class="row">
                    <div class="col-md-4 offset-md-4">
                         <div class="card">
                       <div class="card-header primary-background text-white text-center">
                                <span class="fa fa-user-plus fa-3x"></span>
                                <br>
                                <p>Login here</p>
                            </div>
                         <%
                                Message m = (Message) session.getAttribute("msg");
                                if (m != null) {
                            %>
                            <div class="alert <%= m.getCssClass() %>" role="alert">
                                <%= m.getContent() %>
                            </div> 


                            <%        
                                    session.removeAttribute("msg");
                                }
                            %>
                           <div class="card-body">
                           <form action="LoginServlet" method="post">
							  <div class="form-group">
							    <label for="exampleInputEmail1">Email address</label>
							    <input type="email" name="email"  required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
							    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputPassword1">Password</label>
							    <input type="password"  name="password" required class="form-control" id="exampleInputPassword1" placeholder="Password">
							  </div>
							  <div class="container  text-center">
							  <button type="submit" class="btn btn-primary">Submit</button>
							  </div>
							</form>
                          </div>


                        </div>



                    </div>


                </div>

            </div>
</main>
</body>
</html>