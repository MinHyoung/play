## webdev

- play with web development - js, css, html
- *terminology*
 - j* : js code
 - c* : css code
 - b* : boostrap code
 - s* : snippet

## bootstrap

- direct download links aka cdn for twitter bootstrap from http://www.bootstrapcdn.com/

```html
<!-- Complete CSS (Responsive, With Icons) -->
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">

<!-- Complete CSS (Without Icons) -->
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery.js"></script>
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
```

- icons by glyphicons: http://twitter.github.io/bootstrap/base-css.html#icons
- glyphicons: http://glyphicons.com/

## references

- css: http://ethanmarcotte.com/
- css tricks: http://css-tricks.com/
- media queries: http://mediaqueri.es/
- screen resolution tool test: https://quirktools.com/screenfly/
- adobe inspect:  http://html.adobe.com/edge/inspect/
- chrome inspector:
- firebug:
- responsive resource: http://bradfrost.github.io/this-is-responsive/
- treehouse reference website: http://www.smellslikebakin.com/
- responsive images: http://adaptive-images.com/
- responsive typography: http://fittextjs.com/, http://letteringjs.com/
- reponsive videos: http://fitvidsjs.com/
- style tiles: http://styletil.es/
- mobile first: Mobile First by Luke Wroblewski
- why cdn: http://encosia.com/3-reasons-why-you-should-let-google-host-jquery-for-you/

## notes

- smellslikebakin1 is built on a total width of 1000px; these pixels were dived up evenly into 12-column grid; each column is 65 px wide with a gutter of 20px between them
- 3 Pillars:
 - Content (HTML)
 - Style (CSS)
 - Behavior (Javascript)
- framework makes it easy to build applications
- Images: vector graphics, svg, raster
- jquery methods can be chained together to add behavior or manipulate the same element

## snippets

```js

// hide a page element
$('#myElement').hide()

// add a first level header before the element called #myElement
#('#myElement').before("<h1>Hello</h1>")

// invoke a click handler
$('#myElement').click(handler)

anonymous function
handler = function() {/* code *?};

```
