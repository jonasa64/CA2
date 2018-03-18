document.getElementById("btn").addEventListener("click", function () {
    GetPersonLivingIn();
});



function GetPersonLivingIn() {
    fetch("api/person/complete", {method: "get"}).then(function (response) {
        return response.json();
    }).then(function (data) {
        document.getElementById("display").innerHTML = data.lastName;
    });
}



document.getElementById("btn2").addEventListener("click", function () {
    GetAllZipCodes();
});


function GetAllZipCodes() {
//    fetch("http://localhost:8084/CA2/api/zip/all", {method: "get"}).then(function (response) {
//        return  response.text();
//    }).then(function (text) {
//        obj = JSON.parse(text);
//        document.getElementById("display2").innerHTML = obj.zipCode;
//    });


var url = "http://localhost:8084/CA2/api/zip/all";
var conf = {method: "get", headers: new Headers({'content-type': "application/json"})};
var promise = fetch(url, conf);
var error = false;
promise.then(function (response) {
    if (response.status >= 400) {
        error = true;
    }
    return response.json();
 
}).then(function (json) {
    if (error) {
        alert("startUp"+json.message);
    }
    originalJson = json;

    var html = "<table><tr><th>zipCode</th></tr>";
    for (var i = 0; i < json.length; i++) {
      
        html += "<tr><td>" + json[i].zips + "</td></tr>";
    }
    html += "</table>";
  
    document.getElementById("display2").innerHTML = html;
});



}


// edit person 
function editPerson(id) {
    fetch("api/person" + id, {method: "put"}).then(function (response) {
        response.json();
    }).then(function (data) {
        document.getElementById("edit").innerHTML = data.id;
    })
}

// delete person

function deletePerson(id) {
    fetch("api/person" + id, {method: "delete"}).then(function (response) {
        return response.json();
    }).then(function (data) {
        document.getElementById("delete").innerHTML = data.id;
    })
}

// get person by id 


// get person by phone 

// get all persons 
document.getElementById("btn0").addEventListener("click", function () {
    getAllPerson();
});

function getAllPerson() {


var url = "http://localhost:8084/CA2/api/person/complete";
var conf = {method: "get", headers: new Headers({'content-type': "application/json"})};
var promise = fetch(url, conf);
var error = false;
promise.then(function (response) {
    if (response.status >= 400) {
        error = true;
    }
    return response.json();
}).then(function (json) {
    if (error) {
        alert("startUp"+json.message);
    }
    originalJson = json;

    var html = "<table><tr><th>Firstname</th><th>Lastname</th><th>Address</th><th>Email</th><th>Phone</th></tr>";
    for (var i = 0; i < json.length; i++) {
        html += "<tr><td>" + json[i].firstName + "</td><td>" + json[i].lastName  + "</td><td>" + json[i].Address + "</td><td>" + json[i].Email  + "</td><td>" + json[i].Phones + "</td></tr>";
    }
    html += "</table>";
    document.getElementById("show").innerHTML = html;
});


}

    //Olle function, getAllPersons
    function getComplete() {
        var finaleUrl = "http://localhost:8084/CA2/api/person/complete";
        console.log(finaleUrl);

        var conf = {method: 'get'};
        var promise = fetch(finaleUrl, conf);
        promise.then(function (response) {
            return response.text();
        }).then(function (text) {
            obj = JSON.parse(text);

            if (obj.length > 1) {
                for (var i = 0; i < obj.length; i++) {
                    var tr = createNode('tr');
                    var tdName = createNode('td');
                    var tdSurname = createNode('td');
                    var tdGender = createNode('td');

                    tdName.innerHTML = obj[i].firstName;
                    tdSurname.innerHTML = obj[i].lastName;
                    tdGender.innerHTML = obj[i].Address;

                    append(tr, tdName);
                    append(tr, tdSurname);
                    append(tr, tdGender);
                    append(TBODY, tr);

                }
            } else
                insertTable.innerHTML = "<tr><td>" + obj.firstName + "</td><td>" + obj.lastName + "</td><td>" + obj.Address + "</td></tr>";
        });
    }




var userAdd = document.getElementById("userAdd");
userAdd.onclick = function () {
    var user = {
        firstName: document.getElementById("fName").value,
        lastName: document.getElementById("lName").value,
        Address: document.getElementById("Address"),
        Email: document.getElementById("Email"),
        phones: document.getElementById("phone").value
    };
    var error = false;
    var data = (JSON.stringify(user));

    var url = "http://localhost:8084/CA2/api/person/complete";
    var conf = {method: "post",
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
};











