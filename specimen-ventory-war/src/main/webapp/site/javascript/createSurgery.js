$(function () {
    createSurgery.initStyling();
    createSurgery.initEvents();
});

var createSurgery = {

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
    }
};

function saveSurgery() {

    var data = $('#surgeryForm').serialize();

    $.ajax({
        url: "createSurgery",
        type: "POST",
        data: data,
        dataType: 'html',
        success: function(result) {
            if (result.indexOf('error') == -1) {
                alert("Your surgery has been created successfully.");
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