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

///////////////////////////////////////////////////////////////
// Collections
///////////////////////////////////////////////////////////////

// each - idiomatic iterator
_.each({
    one: 1,
    two: 2,
    three: 3
}, function(num, key) {
    console.log(num, key);
});

// map
result = _.map([1, 2, 3], function(num) {
    return num * 3;
});
console.log('_.map([1, 2, 3], function(num){ return num * 3; }) =', result);

result = _.map({
    one: 1,
    two: 2,
    three: 3
}, function(num, key) {
    return num * 3;
});
console.log('_.map({one : 1, two : 2, three : 3}, function(num, key){ return num * 3; }) = ', result);

// reduce aka (inject, foldl)
result = _.reduce([1, 2, 3], function(memo, num) {
    return memo + num;
}, 0);
console.log('_.reduce([1, 2, 3], function(memo, num){ return memo + num; }, 0) =', result);

// reduceRight (aka foldr)
result = _.reduceRight([
    [0, 1],
    [2, 3],
    [4, 5]
], function(a, b) {
    return a.concat(b);
}, []);
console.log(' _.reduceRight([[0, 1], [2, 3], [4, 5]], function(a, b) { return a.concat(b); }, []) =', result);

// find (aka detect) - returns first
result = _.find([1, 2, 3, 4, 5, 6], function(num) {
    return num % 2 == 0;
});
console.log('_.find([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; }) =', result);

// filter (aka select) -- returns all 
result = _.filter([1, 2, 3, 4, 5, 6], function(num) {
    return num % 2 == 0;
});
console.log(' _.filter([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; }) =', result);

// where -- returns all values
result = _.where(stooges, {
    name: 'moe'
});
console.log(JSON.stringify(result));

// findWhere - returns first value
result = _.findWhere(stooges, {
    name: 'moe'
});
console.log(result);

// opposite of filter
result = _.reject([1, 2, 3, 4, 5, 6], function(num) {
    return num % 2 == 0;
});
console.log('_.reject([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; }) =', result);

// returns true if all the values in the list is a truthy
result = _.every([true, 1, null, 'yes'], _.identity);
console.log("_.every([true, 1, null, 'yes'], _.identity) =", result);

// returns true if any of the values in the list is a truthy
result = _.some([null, 0, 'yes', false]);
console.log("_.some([null, 0, 'yes', false]) = ", result);

// contains aka include
result = _.contains([1, 2, 3], 3);
console.log('_.contains([1, 2, 3], 3) = ', result);

// call on method on each element in the list
result = _.invoke([
    [5, 1, 7],
    [3, 2, 1]
], 'sort');
console.log("_.invoke([[5, 1, 7], [3, 2, 1]], 'sort') = ", JSON.stringify(result));

// extract a list of property values - most common use case of map
result = _.pluck(stooges, 'name');
console.log("_.pluck(stooges, 'name') = ", result);

// max
result = _.max([10, 5, 100, 2, 1000]);
console.log('_.max([10, 5, 100, 2, 1000]) = ', result);

// min
result = _.min([10, 5, 100, 2, 1000]);
console.log('_.min([10, 5, 100, 2, 1000]) = ', result);

// sortBy a comparator
result = _.sortBy([1, 2, 3, 4, 5, 6], function(num) {
    return Math.sin(num);
});
console.log('_.sortBy([1, 2, 3, 4, 5, 6], function(num){ return Math.sin(num); }) = ', result);
result = _.sortBy(stooges, 'age');
console.log("_.sortBy(stooges, 'age') = ", JSON.stringify(result));

// split the collection into sets based on some grouping function
result = _.groupBy([1.3, 2.1, 2.4], function(num) {
    return Math.floor(num);
});
console.log('_.groupBy([1.3, 2.1, 2.4], function(num){ return Math.floor(num); }) = ', JSON.stringify(result));

result = _.countBy([1, 2, 3, 4, 5], function(num) {
    return num % 2 == 0 ? 'even' : 'odd';
});
console.log("_.countBy([1, 2, 3, 4, 5], function(num) { return num % 2 == 0 ? 'even' : 'odd'; }) = ", result);

// shuffle
result = _.shuffle([1, 2, 3, 4, 5, 6]);
console.log('_.shuffle([1, 2, 3, 4, 5, 6]) =', result);

// create an array form list -- useful for transmuting arguments object
result = (function() {
    return _.toArray(arguments);
})(1, 2, 3, 4);
console.log('(function(){ return _.toArray(arguments);})(1, 2, 3, 4) =', result);

result = _.size({
    one: 1,
    two: 2,
    three: 3
});
console.log('_.size({one : 1, two : 2, three : 3}) = ', result);

///////////////////////////////////////////////////////////////
// Arrays
///////////////////////////////////////////////////////////////

// first (like head / take)
result = _.first([5, 4, 3, 2, 1]);
console.log('_.first([5, 4, 3, 2, 1]) = ', result);

result = _.initial([5, 4, 3, 2, 1]);
console.log('_.initial([5, 4, 3, 2, 1]) = ', result);

result = _.last([5, 4, 3, 2, 1]);
console.log('_.last([5, 4, 3, 2, 1]) = ', result);

// rest (like tail / drop)
result = _.rest([5, 4, 3, 2, 1]);
console.log('_.rest([5, 4, 3, 2, 1]) =', result);

// compact - remove all falsy values (0, null, false, "", undefined, NaN)
result = _.compact([0, 1, false, 2, '', null, undefined, 3]);
console.log('_.compact([0, 1, false, 2, "", null, undefined, 3]) = ', result);

// flatten a nested array
result = _.flatten([1, [2],
    [3, [
        [4]
    ]]
]);
console.log('_.flatten([1, [2], [3, [[4]]]]) =', result);
result = _.flatten([1, [2],
    [3, [
        [4]
    ]]
], true);
console.log('_.flatten([1, [2], [3, [[4]]]], true) = ', result);

// same as difference
result = _.without([1, 2, 1, 0, 3, 1, 4], 0, 1);
console.log('_.without([1, 2, 1, 0, 3, 1, 4], 0, 1) =', result);

// union
result = _.union([1, 2, 3], [101, 2, 1, 10], [2, 1]);
console.log('_.union([1, 2, 3], [101, 2, 1, 10], [2, 1]) =', result);

// intersection
result = _.intersection([1, 2, 3], [101, 2, 1, 10], [2, 1]);
console.log('_.intersection([1, 2, 3], [101, 2, 1, 10], [2, 1]) =', result);

// difference
result = _.difference([1, 2, 3, 4, 5], [5, 2, 10]);
console.log('_.difference([1, 2, 3, 4, 5], [5, 2, 10]) =', result);

// duplicate-free version of an array using === to test object equality
result = _.uniq([1, 2, 1, 3, 1, 4]);
console.log('_.uniq([1, 2, 1, 3, 1, 4]) =', result);

// zip it
result = _.zip(['moe', 'larry', 'curly'], [30, 40, 50], [true, false, false])
console.log("_.zip(['moe', 'larry', 'curly'], [30, 40, 50], [true, false, false]) =", JSON.stringify(result));

// converts an array into object
result = _.object(['moe', 'larry', 'curly'], [30, 40, 50]);
console.log("_.object(['moe', 'larry', 'curly'], [30, 40, 50]) =", JSON.stringify(result));
result = _.object([
    ['moe', 30],
    ['larry', 40],
    ['curly', 50]
]);
console.log("_.object([['moe', 30], ['larry', 40], ['curly', 50]]) =", JSON.stringify(result));

// indexOf
console.log('_.indexOf([1, 2, 3], 2) =', _.indexOf([1, 2, 3], 2));
// lastIndexOf
console.log('_.lastIndexOf([1, 2, 3, 1, 2, 3], 2) =', _.lastIndexOf([1, 2, 3, 1, 2, 3], 2));

// index to insert at to maintain sorted order
result = _.sortedIndex([10, 20, 30, 40, 50], 35);
console.log(result);
result = _.sortedIndex(stooges, {
    name: 'larry',
    age: 22
}, 'age');
console.log(result);

// create a list of integers
console.log('_.range(10) =', _.range(10));
console.log('_.range(1, 10) =', _.range(1, 10));
console.log('_.range(1, 10, 2) =', _.range(1, 10, 2));
console.log('_.range(0) =', _.range(0));

///////////////////////////////////////////////////////////////
// Functions
///////////////////////////////////////////////////////////////

// bind a function to the object
var func = function(greeting) {
    return greeting + ': ' + this.name
};
func = _.bind(func, {
    name: 'moe'
}, 'hi');
console.log(func());

// partially apply a function
var add = function(a, b) {
    return a + b;
};
add5 = _.partial(add, 5);
console.log('add5(10) =', add5(10));

// memoize a function by caching computed results
var fibonacci = _.memoize(function(n) {
    return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);
});
console.log('fibonacci(10) =', fibonacci(10));

// delay a invokation of a method
_.delay(_.bind(console.log, console), 1000, 'logged later')

// defer invoking a funciton until the current stack has been cleared
_.defer(function() {
    console.log('deferred');
});

// throttle - call a function at the most one every wait millisecs
// debounce - 
// once -

// after - creates a version of a function that will be run after that first has
// run count # of times

// wraps first function inside of the wrapper function
var hello = function(name) {
    return "hello: " + name;
};
hello = _.wrap(hello, function(func) {
    return "before, " + func("moe") + ", after";
});
console.log(hello());

// compose a list of functions where each function consumes the
// return value of the function that follows
var greet = function(name) {
    return "hi: " + name;
};
var exclaim = function(statement) {
    return statement + "!!!!";
};
var welcome = _.compose(exclaim, greet);
console.log(welcome('moe'));

// does the object contain the given key
result = _.has({
    a: 1,
    b: 2,
    c: 3
}, "b");
console.log(result);

result = _.isBoolean(null);
console.log('_.isBoolean(null) =', result);

result = _.isDate(new Date());
console.log('_.isDate(new Date()) =', result);

result = _.isRegExp(/moe/);
console.log('_.isRegExp(/moe/) =', result);

result = _.isNaN(NaN);
console.log('_.isNan(NaN) =', result);
result = _.isNaN(undefined);
console.log('_.isNan(undefined) =', result);

result = _.isNull(null);
console.log('_.isNull(null) =', result);
result = _.isNull(undefined);
console.log('_.isNull(undefined) =', result);

result = _.isUndefined(window.missingVariable);
console.log('_.isUndefined(window.missingVariable) =', result);

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