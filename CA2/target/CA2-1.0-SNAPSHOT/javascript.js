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
 
 
 
 function showFrom(){
     document.getElementById("form").innerHTML = 
             "<form>" +
             "First Name: " + "<input type='input'>" + "<br>" + 
             "Last Name: " + "<input type='input>'" + "<br>" +
             "<button> Submit</button>" + 
             "</form>";
 }
 
 
 



