function myFunc(id){
    //alert(id)
    $.ajax({
        url: '/student/getOne/'+id,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function(resp) {
            console.log(resp)
           $("#id1").val(resp.id);
            $("#studentName").val(resp.name);
           // $("#depName").val(resp.depName);
            // $("#batchName1").val(resp.batchName);
            $("select #depId").val(resp.depId);
            $("select #batchId").val(resp.batchId);
            $('#myModal').modal('show');
        },
        error: function(err) {
            console.log(err);
        }
    });
}

$(document).ready(function() {

    $.ajax({
        url: '/student/getAll',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function(resp) {
            console.log(resp);

            $.each(resp, function(i, item) {
                var row = `<tr>
                                 <td>${i+1}</td>
                                 <td>${item.name}</td>
                                 <td>${item.depName}</td>
                                 <td>${item.batchName}</td>
                                 <td>${item.semesterName}</td>
                                 <td class="td-actions text-right">
                                     <button type="button" rel="tooltip" id="mybutton" onclick="myFunc('${item.id}')" class="btn btn-success">
                                     <i class="material-icons">edit</i>
                                     </button>
                                     <button type="button" rel="tooltip" class="btn btn-danger">
                                     <i class="material-icons">close</i>
                                     </button>
                                 </td>
                        </tr>`;
                $(".table-body").append(row);
            });
        },
        error: function(err) {
            console.log(err);
        }
    });
    $("#semesterId").change(function(){
        var id =  $(this).val();
      //  alert(id)
        $.ajax({
            type: 'GET',
            url: "/student/getCourse/" + id,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function(data){
                var slctSubcat=$('#courseId'), option="";
                slctSubcat.empty();
                 option = ' <option value="-1" selected label="--Select--"/>';
                for(var i=0; i<data.length; i++){
                    option += "<option value='"+data[i].id + "'>"+data[i].name + "</option>";
                }
                slctSubcat.append(option);
            },
            error:function(){
                alert("error");
            }

        });
    });
    $(".form").on('submit', function(e) {
        e.preventDefault();
        var data = JSON.stringify($(this).serializeObject());
        var url = '/student/save';
        console.log(data)
        $.ajax({
            data: data,
            url: url,
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function(resp) {
                console.log(resp);
                var row = `<tr><td>${$(".table-body tr").length+1}</td>
                                 <td>${resp.name}</td>
                                 <td>${resp.depName}</td>
                                 <td>${resp.batchName}</td>
                                 <td>${resp.semesterName}</td>
                                 <td class="td-actions text-right">
                                     <button type="button" rel="tooltip" class="btn btn-success">
                                     <i class="material-icons">edit</i>
                                     </button>
                                     <button type="button" rel="tooltip" class="btn btn-danger">
                                     <i class="material-icons">close</i>
                                     </button>
                                 </td>
                                 </tr>`;
                $(".table-body").append(row);
                $("input").val("");
            },
            error: function(err) {
                console.log(err);
            }
        });
    });

    $(".form1").on('submit', function(e) {
        e.preventDefault();
        var data = JSON.stringify($(this).serializeObject());
        var url = '/student/update';
        $.ajax({
            data: data,
            url: url,
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function(resp) {
                console.log("after update")
                console.log(resp)
                $("#editModel").modal('hide');
                $(".table-body tr").remove();
                $.each(resp, function(i, item) {
                    //serialNo = 0;
                    serialNo += 1;
                    var row = `<tr>
                                 <td>${serialNo}</td>
                                 <td>${item.name}</td>
                                 <td>${item.depName}</td>
                                 <td>${item.batchName}</td>
                                 <td>${item.semesterName}</td>
                                 <td class="td-actions text-right">
                                     <button type="button" rel="tooltip" id="mybutton" onclick="myFunc('${item.id}')" class="btn btn-success">
                                     <i class="material-icons">edit</i>
                                     </button>
                                     <button type="button" rel="tooltip" class="btn btn-danger">
                                     <i class="material-icons">close</i>
                                     </button>
                                 </td>
                        </tr>`;
                    $(".table-body").append(row);
                });
            },
            error: function(err) {
                console.log(err);
            }
        });
    });


    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
});
