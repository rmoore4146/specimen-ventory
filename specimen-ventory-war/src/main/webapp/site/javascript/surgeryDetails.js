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
            saveSurgery(this);
        });

        //Edit button delegate
        $("#pageContainer").delegate(".editButton", "click", function() {
            editSurgery(this);
        });

        //Delete button delegate
        $("#pageContainer").delegate(".deleteButton", "click", function() {
            deleteSurgery(this);
        });

        //Cancel button delegate
        $("#pageContainer").delegate(".cancelButton", "click", function() {
            cancelSurgery(this);
        });
    }
};

function saveSurgery(caller) {

    //TODO IMPLEMENT LATER

//    var $callerRow = $(caller);
//    var $currentTr = $callerRow.closest('tr');
//    var even = $currentTr.hasClass('even');
//    var $formInputs = $currentTr.find('input, select');
//    var $form = $('#updateSurgeryPrototype').clone();
//    $form.html($formInputs);
//    var data = $form.serialize();
//
//    $.ajax({
//        url: "updateSurgery",
//        type: "POST",
//        data: data,
//        dataType: 'html',
//        success: function(result) {
//            if (result.indexOf('error') == -1) {
//                var $resultHtml = $(result);
//                var $dataTable = getDataTable();
////                var position = $dataTable.fnGetPosition($currentTr[0]);
////                $dataTable.fnUpdate(position);
//                $currentTr.replaceWith($resultHtml);
//                updateRowStyling($resultHtml, even);
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

function editSurgery(caller) {
    toggleEditSurgery(caller.id);
}

function cancelSurgery(caller) {
    toggleEditSurgery(caller.id);
}

function deleteSurgery(caller) {

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