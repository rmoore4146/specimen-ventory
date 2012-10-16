$(function() {
    warning.initEvents();
});

var warning = {

    windowName: "_blank",
    windowSize: "width=500,height=700,scrollbars=yes",

    initEvents: function() {

        $('#bodyDiv').delegate(".continueButton", "click", function() {
            warning.continueOn();
        });
        $('#bodyDiv').delegate(".cancelButton", "click", function(event) {
            warning.cancel(event);
        });
        //make the warning box draggable
        $(function() {
            $( ".draggable" ).draggable();
        });
        $(function() {
            $( ".draggableContained" ).draggable({
                containment:"parent",
                axis:"x"
            });
        });
    },

    continueOn: function() {
//        common.postToForm("helloWorld", {'name': "Tom Haynsworth"}, false);
        common.getToForm("home", {}, false);
    },

    cancel: function(event) {

        warning.openDevilsWindow();
        warning.openGiantsWindow();
        warning.openYanksWindow();
        warning.openKnicksWindow();
        event.preventDefault();
    },

    openGiantsWindow: function() {

        var giantsUrl = $('#giantsUrl').val();
        window.open(giantsUrl, warning.windowName, warning.windowSize);
    },

    openDevilsWindow: function() {

        var devilsUrl = $('#devilsUrl').val();
        window.open(devilsUrl, warning.windowName, warning.windowSize);
    },

    openKnicksWindow: function() {

        var knicksUrl = $('#knicksUrl').val();
        window.open(knicksUrl, warning.windowName, warning.windowSize);
    },

    openYanksWindow: function() {

        var yanksUrl = $('#yanksUrl').val();
        window.open(yanksUrl, warning.windowName, warning.windowSize);
    }
};