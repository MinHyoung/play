$(function() {
    var bondObjs = {};

    // get the data to populate the typeahead (plus an id value)
    var throttledRequest = _.debounce(function(query, process) {
        // process argument is a callback exepcting an array of values (trings) to display
        $.ajax({
            url: 'bonds.json',
            type: 'get',
            dataType: 'json',
            cache: false,
            success: function(data) {
                // reset these containers every time the user searches
                // because we're potentially getting entirely different results from the api
                bondObjs = {};

                // using underscore.js for a functional approach at looping over the returned data.
                _.each(data, function(item, ix, list) {
                    // for each iteration of this loop the "item" argument contains
                    // 1 bond object from the array in our json, such as:
                    // { "id":7, "name":"Pierce Brosnan" }

                    // save the selected item keyed by item name
                    bondObjs[item.name] = item;
                });

                // send the array of results to bootstrap for display
                process(_.pluck(bondObjs, 'name'));
            }
        });
    }, 300);

    $('.bondTypeahead').focus();

    $('.bondTypeahead').typeahead({
        source: function(query, process) {
            // here we pass the query and process the callback arguments to the throttled function
            throttledRequest(query, process);
        },
        updater: function(selectedName) {
            // save the id value into the hidden field
            $('#bondId').val(bondObjs[selectedName].id);
            // return the string you want to go into the textbox (the name)
            return selectedName;
        },
        // matcher: function(item) {
        //     // does this.query match item?
        //     return true;
        // },
        highlighter: function(item) {
            var bond = bondObjs[item];
            var html = [];
            html.push('<div class="typeahead_wrapper">');
            html.push('<img class="typeahead_photo" src="' + bond.photo + '" />');
            html.push('<div class="typeahead_labels">');
            html.push('<div class="typeahead_primary">' + bond.name + '</div>');
            html.push('<div class="typeahead_secondary">' + bond.films[0] + '</div>');
            html.push('</div>');
            html.push('</div>');

            return html.join('');
        },
    });
});