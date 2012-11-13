$(function () {
    surgeryList.initStyling();
});


var surgeryList = {

    initStyling:function () {
        var oTable = $('#surgeryTable').dataTable({
            "bJQueryUI": true,
            "sPaginationType": "full_numbers"
        });

        $('.surgeryButton').button();
    }
};