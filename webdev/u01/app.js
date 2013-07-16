var result;
var stooges = [{
    name: 'curly',
    age: 25
}, {
    name: 'moe',
    age: 21
}, {
    name: 'larry',
    age: 23
}];

// extract a list of property values - most common use case of map
result = _.pluck(stooges, 'name');
console.log(result);

// does the object contain the given key
result = _.has({
    a: 1,
    b: 2,
    c: 3
}, "b");
console.log(result);

result = _.isBoolean(null);
console.log('_.isBoolean(null) = ' + result);

result = _.isDate(new Date());
console.log('_.isDate(new Date()) = ' + result);

result = _.isRegExp(/moe/);
console.log('_.isRegExp(/moe/) = ' + result);

result = _.isNaN(NaN);
console.log('_.isNan(NaN) = ' + result);
result = _.isNaN(undefined);
console.log('_.isNan(undefined) = ' + result);

result = _.isNull(null);
console.log('_.isNull(null) = ' + result);
result = _.isNull(undefined);
console.log('_.isNull(undefined) = ' + result);

result = _.isUndefined(window.missingVariable);
console.log('_.isUndefined(window.missingVariable) = ' + result);

// identity function - used as underscore's default iterator
var moe = {
    name: 'moe'
};
result = moe === _.identity(moe);
console.log(result);

// invokes the given iterator n times
result = _.times(3, function(n) {
    return 'hello world' + ' [' + n + ']';
});
console.log(result);

// rand
result = _.random(0, 100);
console.log(result);

// extend underscore with your own utility function
_.mixin({
    capitalize: function(string) {
        return string.charAt(0)
            .toUpperCase() + string.substring(1)
            .toLowerCase();
    }
});
result = _("fabio")
    .capitalize();
console.log(result);

// generate a globally-unique id for client-side models or DOM elements
result = _.uniqueId('contact_');
console.log(result);

// escape
result = _.escape('Curly, Larray & Moe');
console.log(result);

// oppostie of escape
result = _.unescape('Curly, Larray &amp; Moe');
console.log(result);

// name property value invoked or returned
var object = {
    cheese: 'crumpets',
    stuff: function() {
        return 'nonsense';
    }
};
result = _.result(object, 'cheese');
console.log(result);
result = _.result(object, 'stuff');
console.log(result);

// chaining - Underscore used in either an object-oriented or functional style
result = _.map([1, 2, 3], function(n) {
    return n * 2;
});
console.log(result);
result = _([1, 2, 3])
    .map(function(n) {
        return n * 2;
    });
console.log(result);

var lyrics = [{
    line: 1,
    words: "I'm a lumberjack and I'm okay"
}, {
    line: 2,
    words: "I sleep all night and I work all day"
}, {
    line: 3,
    words: "He's a lumberjack and he's okay"
}, {
    line: 4,
    words: "He sleeps all night and he works all day"
}];
result = _.chain(lyrics)
    .map(function(line) {
        return line.words.split(' ');
    })
    .flatten()
    .reduce(function(counts, word) {
        counts[word] = (counts[word] || 0) + 1;
        return counts;
    }, {})
    .value()
console.log(result);

// calling chain() will cause all the future methods to return a wrapped
// object until value() is used
var youngest = _.chain(stooges)
    .sortBy(function(stooge) {
        return stooge.age;
    })
    .map(function(stooge) {
        return stooge.name + ' is ' + stooge.age;
    })
    .first()
    .value();
console.log(youngest);

// extracts the value of a wrapped object
result = _([1, 2, 3])
    .value();
console.log(result);