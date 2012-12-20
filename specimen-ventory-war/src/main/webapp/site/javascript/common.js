var contextPath = "";

var common = {

    basePath:'specimen-ventory/',


    initEvents: function() {
        //do span binding
        $("#pageContainer").delegate(".createSpan", "click", function() {
            common.getToForm("specimen-ventory/createSurgery");
        });
        $("#pageContainer").delegate(".listSpan", "click", function() {
            common.getToForm("specimen-ventory/surgeryList")
        });
    },

    postToForm:function (uri, map, newWindowBoolean) {
        $('#defaultForm').remove();
        if (newWindowBoolean) {
            $('<form name="defaultForm" action="' + contextPath + uri + '" method="POST" target="_blank" id="defaultForm"></form>').appendTo(document.body);
        } else {
            $('<form name="defaultForm" action="' + contextPath + uri + '" method="POST" id="defaultForm"></form>').appendTo(document.body);
        }
        if (map != null) {
        $.each(map, function (key, value) {
            var decodedValue = value;
            if (value != null) {
                decodedValue = decodeURI(value);
            }
            $('<input type="hidden" name="' + key + '" id="' + key + '" value="' + decodedValue + '"/>').appendTo("#defaultForm");
        });
        }
        $('#defaultForm').submit();
    },

    getToForm:function (uri, map, newWindowBoolean) {
        $('#defaultForm').remove();
        if (newWindowBoolean) {
            $('<form name="defaultForm" action="' + contextPath + uri + '" method="GET" target="_blank" id="defaultForm"></form>').appendTo(document.body);
        } else {
            $('<form name="defaultForm" action="' + contextPath + uri + '" method="GET" id="defaultForm"></form>').appendTo(document.body);
        }
        if (map != null) {
            $.each(map, function (key, value) {
                var decodedValue = value;
                if (value != null) {
                    decodedValue = decodeURI(value);
                }
                $('<input type="hidden" name="' + key + '" id="' + key + '" value="' + decodedValue + '"/>').appendTo("#defaultForm");
            });
        }
        $('#defaultForm').submit();
    }
};

function getContextPath() {
    return "${pageContext.request.contextPath}";
}