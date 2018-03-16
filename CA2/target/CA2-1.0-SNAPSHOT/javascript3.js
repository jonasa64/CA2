var  url = "";
var conf = {};
var promise = fetch(url, conf);
var error = false;
promise.then(function(response){
    if(response.status >= 400){
        error = true;
    }
    return response.json();
}).then(function(json){
    if(error){
        alert("startup" + json.message);
    }
     originalJson = json;
     var html = "<table><tr><th>NAME</th><th>DESCRIPTION</th><th>CVR</th><th>NUMEMPLOYEES</th><th>MARKETVALUE</th></tr>";
     
     for(var i = 0; i < json.length; i++){
         html += "<tr><td>" +json[i].name + "</td><td>" + json[i].description + "</td><td>" + json[i].cvr + "</td><td>" 
                 + json[i].numEmployees + "</td><td>" + json[i].marketValue[i] + "</td></tr>"  
     }
     
       html += "</table>";
       
       document.getElementById("tblbody").innerHTML = html;
     
});

function refresh() {
    location.reload();
}


var companieAdd = document.getElementById("companieAdd");

companieAdd.onclick = function() {
var user = {
    name: document.getElementById("name").value,
    description : document.getElementById("description").value,
    numEmployees : document.getElementById("numEmployees").value,
    marketValue : document.getElementById("marketValue").value
   };
   
   
   var error = false;
   var data = (JSON.stringify(user));
   
   var url = "";
     var conf = {method: 'post',
        body: data,
        headers: new Headers({'content-type': 'application/json'})
    };
    
     var promise = fetch(url, conf);
    promise.then(function (response) {
        if (response.status >= 400) {
            error = true;
        }
        return response.json();
    }).then(function (json) {
        if (error) {
            alert(json.message);
        }
    });
    
 }
 
 
 
 function getInfo(cvr){
    var compaine = {
    name: document.getElementById("name").value,
    description : document.getElementById("description").value,
    numEmployees : document.getElementById("numEmployees").value,
    marketValue : document.getElementById("marketValue").value
   }; 
   
   
    var error = false;
   var data = (JSON.stringify(compaine));
   
   
   var url = "" + cvr;
     var conf = {method: 'get',
        body: data,
        headers: new Headers({'content-type': 'application/json'})
    };
    
    
    var promise = fetch(url, conf);
    promise.then(function (response) {
        if (response.status >= 400) {
            error = true;
        }
        return response.json();
    }).then(function (json) {
        if (error) {
            alert(json.message);
        }
    });
    
 }
    
    
    
     
 function edit(phone){
    var compaine = {
    name: document.getElementById("name").value,
    description : document.getElementById("description").value,
    numEmployees : document.getElementById("numEmployees").value,
    marketValue : document.getElementById("marketValue").value
   }; 
   
   
    var error = false;
   var data = (JSON.stringify(compaine));
   
   
   var url = "" + phone;
     var conf = {method: 'put',
        body: data,
        headers: new Headers({'content-type': 'application/json'})
    };
    
    
    var promise = fetch(url, conf);
    promise.then(function (response) {
        if (response.status >= 400) {
            error = true;
        }
        return response.json();
    }).then(function (json) {
        if (error) {
            alert(json.message);
        }
    });
    
    refresh();
    
}

 


