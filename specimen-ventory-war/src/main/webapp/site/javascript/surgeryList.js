$(function () {
    surgeryList.initStyling();
    surgeryList.initEvents();
});


var surgeryList = {

    initStyling:function () {

        //zero config jquery buttons
        $('.surgeryButton').button();

        //jquery datepicker init
        $('[id^="specimenDateInput"]').datepicker();

        // Datatable styling
        //
        // - bJQueryUI flag enable ThemeRoller support
        // - sPaginationType is simple pagination flag
        // - aoColumns defines all the columns
        var oTable = $('#surgeryTable').dataTable({
            "bJQueryUI": true,
            "sPaginationType": "full_numbers",
            "aoColumns": [
                { "sType": "html", "bVisible": true, "mDataProp": "animalId", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "procedure", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "surgeryTypes", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "notes", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "surgeon", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "start", "bSortable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "end", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "date", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "anesthesiaType", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "anesthesiaDose", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "analgesiaType", "bSortable": true, "bSearchable": true},
                { "sType": "html", "bVisible": true, "mDataProp": "analgesiaDose", "bSortable": true, "bSearchable": true},
                { "bVisible": true, "bSortable": false, "bSearchable": false,  "sWidth": "110px"}
            ]
        } );
    },


    initEvents:function () {

        //Edit button delegate
        $("#pageContainer").delegate(".editButton", "click", function() {
            editSurgeryRow(this);
        });

        //Delete button delegate
        $("#pageContainer").delegate(".deleteButton", "click", function() {
            deleteSurgeryRow(this);
        });
    }
};

function editSurgeryRow(caller) {
    var $caller = $(caller);
    var callerId = $caller.attr('id');
    var surgeryId = callerId.split("-")[1];
//    var map = {'surgeryId': surgeryId};
    common.getToForm("jhou/surgeryDetails/" + surgeryId);
}


function deleteSurgeryRow(caller) {
    var $callerRow = $(caller);
    var $currentTr = $callerRow.closest('tr');
    var even = $currentTr.hasClass('even');
    var $formInputs = $currentTr.find('input, select');
    var $form = $('#updateSurgeryPrototype').clone();
    $form.html($formInputs);
    var data = $form.serialize();

    $.ajax({
        url: "deleteSurgery",
        type: "POST",
        data: data,
        dataType: 'html',
        success: function(result) {
            if (result.indexOf('error') == -1) {
                var $dataTable = getDataTable();
                var position = $dataTable.fnGetPosition($currentTr[0]);
                $dataTable.fnDeleteRow(position);
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

function getDataTable() {
    var $table = $('#surgeryTable');
    return $table.dataTable();

}