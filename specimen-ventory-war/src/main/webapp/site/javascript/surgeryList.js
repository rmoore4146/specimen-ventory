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
                { "sType": "string", "bVisible": true, "mDataProp": "animalId", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "procedure", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "notes", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "surgeon", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "start", "bSortable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "end", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "date", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "anesthesiaType", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "anesthesiaDose", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "analgesiaType", "bSortable": true, "bSearchable": true},
                { "sType": "string", "bVisible": true, "mDataProp": "analgesiaDose", "bSortable": false, "bSearchable": true},
                { "bVisible": true, "bSortable": false, "bSearchable": false,  "sWidth": "110px"}
            ]
        } );
    },


    initEvents:function () {

        //Save button delegate
        $("#pageContainer").delegate(".saveButton", "click", function() {
            saveSurgeryRow(this);
        });

        //Edit button delegate
        $("#pageContainer").delegate(".editButton", "click", function() {
            editSurgeryRow(this);
        });

        //Delete button delegate
        $("#pageContainer").delegate(".deleteButton", "click", function() {
            deleteSurgeryRow(this);
        });

        //Cancel button delegate
        $("#pageContainer").delegate(".cancelButton", "click", function() {
            cancelSurgeryRow(this);
        });
    }
};

function saveSurgeryRow(caller) {

    var $callerRow = $(caller);
    var $currentTr = $callerRow.closest('tr');
    var even = $currentTr.hasClass('even');
    var $formInputs = $currentTr.find('input, select');
    var $form = $('#updateSurgeryPrototype').clone();
    $form.html($formInputs);
    var data = $form.serialize();

    $.ajax({
        url: "updateSurgery",
        type: "POST",
        data: data,
        dataType: 'html',
        success: function(result) {
            if (result.indexOf('error') == -1) {
                var $resultHtml = $(result);
                var $dataTable = getDataTable();
//                var position = $dataTable.fnGetPosition($currentTr[0]);
//                $dataTable.fnUpdate(position);
                $currentTr.replaceWith($resultHtml);
                updateRowStyling($resultHtml, even);
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

function editSurgeryRow(caller) {
    toggleEditSurgeryRow(caller.id);
}

function cancelSurgeryRow(caller) {
    toggleEditSurgeryRow(caller.id);
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

function updateRowStyling(row, isEven) {
    row.find('.surgeryButton').button();
    row.find('[id^="specimenDateInput"]').datepicker();
    if(isEven) {
        row.addClass('even');
    } else {
        row.addClass('odd');
    }

}

function toggleEditSurgeryRow(rowId) {
    var surgeryID = encodeURIComponent(rowId.substring((rowId.lastIndexOf('-')+1)));

    var $hidden = $('[id$=' + surgeryID + '][class~="edit"]');
    var $visible = $('[id$=' + surgeryID + '][class~="nonEdit"]');
    $hidden.show().removeClass("edit").addClass("nonEdit");
    $visible.hide().removeClass("nonEdit").addClass("edit");
}

function getDataTable() {
    var $table = $('#surgeryTable');
    return $table.dataTable();

}