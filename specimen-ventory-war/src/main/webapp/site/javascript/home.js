$(function() {
    home.initStyling();
});


var home = {

    initStyling: function() {

        <!--In order to use a jQuery accordian inside a jQuery tab-->
        <!--... you must activate the accordian first.-->
        $(function() {
            $( ".accordion" ).accordion();
        });

        $(function() {
            $( ".tabs" ).tabs().find( ".ui-tabs-nav" ).sortable({ axis: "x" });;
        });

        $(function () {
            $("#datepicker").datepicker();
        });
    }
};