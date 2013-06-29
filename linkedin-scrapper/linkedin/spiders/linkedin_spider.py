from collections import defaultdict
from linkedin.items import LinkedinItem
from scrapy.spider import BaseSpider
from scrapy.selector import HtmlXPathSelector

class LinkedinSpider(BaseSpider):
    name = "linkedin"
    allowed_domains = ["linkedin.com"]
    start_urls = [
    "http://www.linkedin.com/in/tomasztunguz",
    "http://www.linkedin.com/in/satishdharmaraj",
    "http://www.linkedin.com/pub/timothy-haley/3/235/71",
    "http://www.linkedin.com/pub/manju-rajashekhar/3/457/484",
    "http://www.linkedin.com/in/nikhilraghavan",
    ]

    def parse(self, response):
        hxs = HtmlXPathSelector(response)
        item = LinkedinItem()
        user = defaultdict(list)

        user['name'] = hxs.select('//title/text()').re(r'(.+)\s+\|\s+LinkedIn')[0].strip()

        # schools
        schools = hxs.select('//dd[@class="summary-education"]/ul/li')
        for school in schools:
            s = school.select('text()').extract()[0].strip()
            user['school'].append(s)
        # more schools
        schools = hxs.select('//div[@name="education"]')
        for school in schools:
            s = school.select('text()').extract()[0].strip()
            user['school'].append(s)

        # current positions
        currents = hxs.select('//ul[@class="current"]/li')
        for current in currents:
            c1 = current.select('text()').extract()[0].strip()
            c2 = " at "
            c3_1 = current.select('a/span[@class="org summary"]/text()').extract()
            if len(c3_1) == 0:
                c3_1 = current.select('text()').extract()
            c3 = c3_1[0].strip() if len(c3_1) > 0 else ""
            user['current'].append(c1 + c2 + c3)

        # past positions
        pasts = hxs.select('//ul[@class="past"]/li')
        for past in pasts:
            p1 = past.select('text()').extract()[0].strip()
            p2 = " at "
            p3_1 = past.select('a/span[@class="org summary"]/text()').extract()
            if len(p3_1) != 0:
                p3 = p3_1[0].strip()
            else:
                p3_1 = past.select('text()').extract()
                if len(p3_1) > 1:
                    p3 = p3_1[1].strip()
                else:
                    p3 = ""
            user['past'].append(p1 + p2 + p3)

        item['user'] = user
        return item
