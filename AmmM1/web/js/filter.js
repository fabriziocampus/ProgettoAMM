/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function createElement(ut){
    var img = $("<img>")
            .attr("alt","Foto Profilo")
            .attr("src",ut.urlimg);
    var name = $("<h2>").html(ut.nome);
    var link = $("<a>")
            .attr("href", "index.html?user="+ut.id)
            .html("Link al Profilo");
    
    var userData = $("<div>")
            .attr("class","userData")
            .append(name)
            .append(link);
    var profilePic = $("<div>")
            .attr("class","profilePic")
            .append(img);
    
    
    return $("<div>")
            .attr("class","user")
            .append(profilePic)
            .append(userData);
}

function stateSuccess(data){
    var userListPage = $("#usersList");
    
    $(userListPage).empty();
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#search").click(function(){
        
        var wantedUt = $("#searchField")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                nomeUtente: wantedUt
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});
