document.getElementById("btn").addEventListener("click",function(){
   GetPersonLivingIn(); 
});



function GetPersonLivingIn(){
    fetch("api/person/complete" , { method: "get"}).then(function(response){
        return response.json();
    }).then(function  (data) {
        document.getElementById("display").innerHTML = data.lastName;
    });
 }
 
 
 
 document.getElementById("btn2").addEventListener("click",function(){
     GetAllZipCodes();
 });
 
 
 function GetAllZipCodes(){
     fetch("api/zip/all",{ method : get}).then(function(response){
         return  response.json();
     }).then(function (data){
         document.getElementById("display2").innerHTML = data.lastName;
     });
 }
 
 
 // edit person 
 function editPerson(id){
     fetch("api/person" + id , { method: "put"}).then(function (response){
         response.json();
     }).then(function(data){
         document.getElementById("edit").innerHTML = data.id;
     })
 }
 
 // delete person
 
 function deletePerson(id){
     fetch("api/person"+id,{method:"delete"}).then(function (response){
         return response.json();
     }).then(function(data){
         document.getElementById("delete").innerHTML = data.id;
     })
 }
 
 // get person by id 

 
 // get person by phone 
 
 // get all persons 
 document.getElementById("btn0").addEventListener("click",function(){
     getAllPerson();
 });
 
 function getAllPerson(){
     fetch("api/person",{method:"get"}).then(function(json){
        document.getElementById("show").innerHTML = "";
        
        var rows = "";
        
        
        for(var i = 0; i < json.persons; i++){
            rows +='<tr>';
                    
                   rows += '<td>' + persons[i].firstName + '</td>';
                   rows += '<td>' + persons[i].lastName + '</td>';
                   rows +=  '<td>' + persons[i].phone + '</td>';
                   rows += '<td>' + persons[i].email + '</td>';
                    
                    '<tr>' ;
        }
        
        document.getElementById("show").innerHTML = rows;
        
     })
 }
 
 
 // get all persons by zipcode
 
 
 
 
 
 function showFrom(){
     document.getElementById("form").innerHTML = 
             "<form>" +
             "First Name: " + "<input type='input'>" + "<br>" + 
             "Last Name: " + "<input type='input>'" + "<br>" +
             "<button> Submit</button>" + 
             "</form>";
 }
 
 
 



