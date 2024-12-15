<!DOCTYPE html>
<%@page import="javax.naming.Context"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="CSS/style.css" rel="stylesheet"/>
</head>
<body>
    <div class="square-box">
        <!-- Navigation Buttons -->
        <div class="mb-4 d-flex justify-content-between">
           <a class="btn btn-primary btn-lm" href="<%= request.getContextPath() %>/">Home</a>
           <a class="btn btn-danger btn-lm" href="<%= request.getContextPath() %>/about.jsp">About</a>
           
        </div>

        <div class="container py-5">
        <!-- Project Title -->
        <div class="text-center mb-4">
            <h1 class="display-6 text-primary">Student Record CRUD Project</h1>
            <p class="lead text-danger">A complete web application for managing student records with CRUD functionality and PDF generation.</p>
        </div>

        <!-- Project Description -->
        <div class="card shadow-sm p-4">
            <h3 class="text-info">Overview</h3>
            <p>This project allows users to create, read, update, and delete student records. The application uses Java Servlets and Hibernate ORM for database interaction. Users can manage student details like name, age, and location, and generate PDF reports of the student data using iText.</p>

            <h3 class="text-info">Technology Stack</h3>
            <p>The backend of this project is built using <strong>Java Servlets</strong> and <strong>Hibernate</strong> for data persistence. The frontend is created using <strong>HTML</strong>, <strong>CSS</strong>, <strong>Bootstrap</strong> for responsive design, and <strong>JavaScript</strong> with <strong>DOM</strong> manipulation for dynamic content updates. <strong>iText</strong> library is used for generating PDFs with a dynamic student report that can be downloaded by the user.</p>
            
        </div>

        <!-- Footer Section -->
        <div class="footer text-center mt-5 p-3 bg-dark text-white">
            <p>Project created by <strong><a href="https://ruturajveer143.github.io/profile/" target="_blank" class="text-primary">Ruturaj Veer</a></strong></p>
            <p>References: 
                <a href="https://www.javatpoint.com" target="_blank" class="text-warning">Javatpoint</a> |
                <a href="https://www.youtube.com/@LearnCodeWithDurgesh" target="_blank" class="text-warning">YouTube (Durgesh Code)</a>
            </p>
        </div>
    </div>
       

       
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
