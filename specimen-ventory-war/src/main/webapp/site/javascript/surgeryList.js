$(function () {
    surgeryList.initStyling();
    surgeryList.initEvents();
});


var surgeryList = {

    initStyling:function () {

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

        //zero config jquery buttons
        $('.surgeryButton').button();
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

}

function editSurgeryRow(caller) {
    toggleEditSurgeryRow(caller.id);
}

function cancelSurgeryRow(caller) {
    toggleEditSurgeryRow(caller.id);
}

function deleteSurgeryRow(caller) {

}

function toggleEditSurgeryRow(rowId) {
    var surgeryID = encodeURIComponent(rowId.substring((rowId.lastIndexOf('-')+1)));

    var $hidden = $('[id$=' + surgeryID + '][class~="edit"]');
    var $visible = $('[id$=' + surgeryID + '][class~="nonEdit"]');
    $hidden.show().removeClass("edit").addClass("nonEdit");
    $visible.hide().removeClass("nonEdit").addClass("edit");
}