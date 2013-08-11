$(function() {
    $('.example-countries .twitter-typeahead').typeahead({
        name: 'countries',
        prefetch: 'countries.json',
        limit: 10
    });

    $('.example-twitter-oss .twitter-typeahead').typeahead({
        name: 'twitter-oss',
        prefetch: 'repos.json',
        template: [
            '<p class="repo-name"><strong>{{name}}</strong></p>',
            '<p class="repo-description">{{description}}</p>'
        ].join(''),
        engine: Hogan
    });
});