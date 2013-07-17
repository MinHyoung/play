$(function() {
  var availableTags = [
  "ActionScript",
  "AppleScript",
  "Asp",
  "BASIC",
  "C",
  "C++",
  "Clojure",
  "COBOL",
  "ColdFusion",
  "Erlang",
  "Fortran",
  "Groovy",
  "Haskell",
  "Java",
  "JavaScript",
  "Lisp",
  "Perl",
  "PHP",
  "Python",
  "Ruby",
  "Scala",
  "Scheme"
  ];

  $("#tags").autocomplete({
    source: availableTags
  });

  $("input[type=submit], a, button")
  .button()
  .click(function(event) {
    event.preventDefault();
  });

});
