## Concepts

- Scrappy Engine
- Scheduler
- Downloader
- Middleware (Downloader Middlewares, Spider Middlewares)
- Spiders
- Items (scraped items)
- Item Pipeline
- Request
- Response
- Selectors
- Feed Exports (json | csv | xml | ..)
- Signals
- Contracts

- scrapy.contrib.spiders.Spider
 - BaseSpider
 - CrawlSpider
 - XMLFeedSpider
 - CSVFeedSpider
 - SitemapSpider
 start_urls = []
 start_requests()
 parse() - default calllback for Requests; generates more Request or Item or an iterable of both
 name - spider

## Notes

## References

- docs: http://doc.scrapy.org/en/latest/index.html
- dirbot: https://github.com/scrapy/dirbot
- snippets: http://snipplr.com/all/tags/scrapy/
