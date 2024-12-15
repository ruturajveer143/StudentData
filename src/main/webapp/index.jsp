<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.Helper.FactoryProvider"%>
<%@page import="com.Entitys.*" %>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.query.Query"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    
    <link href="<%= request.getContextPath() %>/CSS/style.css" rel="stylesheet"/>
</head>
<body>
    <div class="square-box">
        <!-- Navigation Buttons -->
        <div class="mb-4 d-flex justify-content-between">
           <a class="btn btn-primary btn-lm" href="<%= request.getContextPath() %>/">Home  <i class="fas fa-home"></i></a>
           <a class="btn btn-danger btn-lm" href="<%= request.getContextPath() %>/about.jsp">About  <i class="fas fa-info-circle"></i></a>
        
           
        </div>

        <!-- Form -->
        <h2 id ="h2" class="mb-3 text-center">ADD Student</h2>
        <form id="studentForm" action="SaveStudentServlet" method="post">
            <div class="mb-3">
                <label for="studentName" class="form-label">Student Name</label>
                <input type="text" name="studentName" id="name" class="form-control" placeholder="Enter name" required>
            </div>
            <div class="mb-3">
                <label for="studentAge" class="form-label">Age</label>
                <input type="text" name="studentAge" id="age" class="form-control" placeholder="Enter age" required>
            </div>
            <div class="mb-3">
                <label for="studentLocation" class="form-label">Location</label>
                <input type="text" name="studentLocation" id="location" class="form-control" placeholder="Enter location" required>
            </div>
            <button type="submit" id="btnSubmit" class="btn btn-success w-100">Add Student <i class="fas fa-plus-circle"></i></button>
        </form>

        <!-- Students List -->
        <h5 class="mt-4 text-center">Students List</h5>
        <a class="btn btn-warning btn-lm" href="<%= request.getContextPath() %>/DownloadPDFServlet"> Download PDF <i class="fas fa-file-pdf"></i></a>
        
        <div class="table-responsive">
            <table class="table table-bordered table-hover text-center">
                <thead class="table-dark">
                    <tr>
                        <th>@Id</th>
                        <th>Date</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Location</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    Session s1 = FactoryProvider.getFactory().openSession();
                    Query q = s1.createQuery("from StudentData");
                    List<StudentData> list = q.list();
                    
                    for (StudentData sd : list) {
                    %>
                        <tr>
                            <td><%=sd.getId() %></td>
                            <td><%=sd.getAddedDate() %></td>
                            <td><%=sd.getName() %></td>
                            <td><%=sd.getAge() %></td>
                            <td><%=sd.getLocation() %></td>
                            <td>
                                <a href="javascript:void(0);" class="btn btn-warning btn-sm me-2" onclick="editData(<%= sd.getId() %>, '<%= sd.getName() %>', '<%= sd.getAge() %>', '<%= sd.getLocation() %>')">Edit  <i class="fas fa-edit"></i></a>
                                <a href="DeleteData?st_id=<%=sd.getId() %>" class="btn btn-danger btn-sm">Delete <i class="fas fa-trash-alt"></i></a>
                            </td>
                        </tr>
                    <% } 
                    s1.close();
                    %>
                </tbody>
            </table>
        </div>

    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

   <script type="text/javascript">
function editData(id, name, age, location) {
    document.getElementById('btnSubmit').style.display = 'none';
    
    
    document.getElementById('h2').innerHTML ="UPDATE";
	document.getElementById('name').value = name;
    document.getElementById('age').value = age;
    document.getElementById('location').value = location;
    
    
    let existingButton = document.getElementById('updateButton');
    
    if (!existingButton) {
        let updateButton = document.createElement('button');
        updateButton.type = 'submit';
        updateButton.className = 'btn btn-success w-100';
        updateButton.innerHTML = 'Update Student';
        updateButton.id = 'updateButton';
        
        updateButton.onclick = function () {
        	let name = document.getElementById('name').value;
           let age =  document.getElementById('age').value;
           let location = document.getElementById('location').value;
           
           document.getElementById('studentForm').action = "EditData?st_id="+id+"&name="+name+"&age="+age+"&location="+location;
           document.getElementById('studentForm').method = "POST";
        
       
    }
    
   
       let form = document.getElementById('studentForm');
       form.appendChild(updateButton);
    }
    
}
</script>

</body>
</html>