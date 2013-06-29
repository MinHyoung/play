BOT_NAME = 'linkedin'

SPIDER_MODULES = ['linkedin.spiders']
NEWSPIDER_MODULE = 'linkedin.spiders'

ITEM_PIPELINES = [
    'linkedin.pipelines.LinkedinPipeline'
]

DOWNLOAD_DELAY = 0.25    # 250 msec delay
# Crawl responsibly by identifying yourself (and your website) on the user-agent
#USER_AGENT = 'linked (+http://www.yourdomain.com)'
