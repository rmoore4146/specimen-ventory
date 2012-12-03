$(function () {
    surgeryDetails.initStyling();
    surgeryDetails.initEvents();
});


var surgeryDetails = {

    initStyling:function () {

        //zero config jquery buttons
        $('.surgeryButton').button();

        //jquery datepicker init
        $('[id^="specimenDateInput"]').datepicker();

    },


    initEvents:function () {

        //Save button delegate
        $("#pageContainer").delegate(".saveButton", "click", function() {
            saveSurgery();
        });

        //Edit button delegate
        $("#pageContainer").delegate(".editButton", "click", function() {
            editSurgery();
        });

        //Delete button delegate
        $("#pageContainer").delegate(".deleteButton", "click", function() {
            deleteSurgery();
        });

        //Cancel button delegate
        $("#pageContainer").delegate(".cancelButton", "click", function() {
            cancelSurgery();
        });
    }
};

function saveSurgery() {

    var data = $('#surgeryForm').serialize();

    $.ajax({
        url: "updateSurgeryDetails",
        type: "POST",
        data: data,
        dataType: 'html',
        success: function(result) {
            if (result.indexOf('error') == -1) {
                var $resultHtml = $(result);
                $('#pageContainer').find('ul').replaceWith($resultHtml);
                surgeryDetails.initStyling();
            }
            else {
                alert(result);
            }
        },
        error: function(result) {
            alert("An undisclosed error has occurred. Update failed.");
        }
    });
}

function editSurgery() {
    toggleEditSurgery();
}

function cancelSurgery() {
    toggleEditSurgery();
}

function deleteSurgery() {

    //TODO IMPLEMENT ME
//    var $callerRow = $(caller);
//    var $currentTr = $callerRow.closest('tr');
//    var even = $currentTr.hasClass('even');
//    var $formInputs = $currentTr.find('input, select');
//    var $form = $('#updateSurgeryPrototype').clone();
//    $form.html($formInputs);
//    var data = $form.serialize();
//
//    $.ajax({
//        url: "deleteSurgery",
//        type: "POST",
//        data: data,
//        dataType: 'html',
//        success: function(result) {
//            if (result.indexOf('error') == -1) {
//                var $dataTable = getDataTable();
//                var position = $dataTable.fnGetPosition($currentTr[0]);
//                $dataTable.fnDeleteRow(position);
//            }
//            else {
//                alert(result);
//            }
//        },
//        error: function(result) {
//            alert("An undisclosed error has occurred. Update failed.");
//        }
//    });
}

function toggleEditSurgery() {
    var $hidden = $('[class~="edit"]');
    var $visible = $('[class~="nonEdit"]');
    $hidden.show().removeClass("edit").addClass("nonEdit");
    $visible.hide().removeClass("nonEdit").addClass("edit");
}