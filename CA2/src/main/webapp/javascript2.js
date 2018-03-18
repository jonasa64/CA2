

document.getElementById("btn").addEventListener("click",function(){
    showContactInfo();
});


function showContactInfo(){
    fetch("api/emp/all",{method:"get"}).then(function(json){
        document.getElementById("display").innerHTML = "";
        
        var rows = "";
        
        
        for(var i = 0; i < json.persons; i++){
            rows += '<tr>';
                        rows += '<td>' + json.persons[i].firstName + '</td>';
                        rows += '<td>' + json.persons[i].lastName + '</td>';
                        rows += '<td>' + json.persons[i].Phone + '</td>';
                        rows += '<td>' + json.persons[i].email + '</td>';
                        rows += '</tr>';
        }
        
        document.getElementById("display").innerHTML = rows;
    });
}